package com.shoppingmall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.shoppingmall.dao.*;
import com.shoppingmall.pojo.*;

@Controller
public class MainController {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	CustomerRegDao customerRegDao = (CustomerRegDao) ctx.getBean("customerRegDao");
	StoreRegistrationDao storeRegistrationDao = (StoreRegistrationDao) ctx.getBean("storeRegistrationDao");
	AccountantDao accountantDao = (AccountantDao) ctx.getBean("accountantDao");
	AdminDao adminDao = (AdminDao) ctx.getBean("adminDao");

	@RequestMapping(value = "/login.do")
	public ModelAndView logincheck(@ModelAttribute("user1") UserBean user, HttpServletRequest request) {
		UserBean loguser = null;
		StoreRegistration sr = null;
		HttpSession session = null;
		ModelAndView model = new ModelAndView();
		String userrole = user.getUserRole();
		if (userrole != null) {
			if (userrole.equals("Customer")) {

				loguser = customerRegDao.checkLoginUser(user.getUname(), user.getPwd(), user.getUserRole());

				if (loguser != null) {
					session = request.getSession();
					user.setFtname(loguser.getFtname());
					/*
					 * user.setAddr1(loguser.getAddr1());
					 * user.setAddr2(loguser.getAddr2());
					 * user.setCity(loguser.getCity());
					 * user.setState(loguser.getState());
					 * user.setCountry(loguser.getCountry());
					 * user.setZip(loguser.getZip());
					 * user.setMobile(loguser.getMobile());
					 * user.setUname(loguser.getUname());
					 */
					model.addObject("msg", "Hi " + user.getFtname() + " You are Successfully Logged In");
					model.setViewName("customerLogin");
					session.setAttribute("customer", loguser);

				} else {
					model.addObject("msgFailure", "Sorry, Please Login With Proper Credentials");
					model.setViewName("login");
				}

			} else if (userrole.equals("Store Manager")) {

				sr = storeRegistrationDao.checkStoreManager(user.getUname(), user.getPwd());

				if (sr != null) {
					session = request.getSession();

					sr.setUname(sr.getUname());
					System.out.println(sr.getUname());
					System.out.println(sr.getPwd());
					model.addObject("msg", "Hi " + sr.getUname() + "  you are succesfully logged in");
					model.setViewName("storeManagerLogin");
					session.setAttribute("storeManager", sr);

				} else {
					model.addObject("msgFailure", "Sorry, Please Login With Proper Credentials");
					model.setViewName("login");
				}

			} else if (userrole.equals("Admin")) {

				loguser = adminDao.checkAdmin(user.getUname(), user.getPwd());

				if (loguser != null) {
					session = request.getSession();

					System.out.println(loguser.getUname());
					System.out.println(loguser.getPwd());
					model.addObject("msg", "Hi Admin you are succesfully logged in");
					model.setViewName("adminLogin");
					session.setAttribute("Admin", loguser);

				} else {
					model.addObject("msgFailure", "Sorry, Please Login With Proper Credentials");
					model.setViewName("login");
				}
			} else if (userrole.equals("Accountant")) {

				loguser = customerRegDao.checkLoginUser(user.getUname(), user.getPwd(), user.getUserRole());

				if (loguser != null) {
					session = request.getSession();
					user.setFtname(loguser.getFtname());

					System.out.println(loguser.getUname());
					System.out.println(loguser.getPwd());
					model.addObject("msg", "Hi " + user.getFtname() + " You are Successfully Logged In ");
					model.setViewName("accountantLogin");
					session.setAttribute("Accountant", loguser);

				} else {
					model.addObject("msgFailure", "Sorry, Please Login With Proper Credentials");
					model.setViewName("login");
				}
			}

		} else
			model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/getCustomer.do")
	public ModelAndView editprofile(@ModelAttribute("user1") UserBean user, HttpServletRequest request) {

		UserBean userBean = (UserBean) request.getSession().getAttribute("customer");
		System.out.println(userBean);

		ModelAndView model = new ModelAndView();

		if (userBean == null) {
			return new ModelAndView("login");
		} else {
			user.setUname(userBean.getUname());
			user.setMobile(userBean.getMobile());
			user.setAddr1(userBean.getAddr1());
			user.setAddr2(userBean.getAddr2());
			user.setCity(userBean.getCity());
			user.setState(userBean.getState());
			user.setCountry(userBean.getCountry());
			user.setZip(userBean.getZip());
			user.setFtname(userBean.getFtname());
			user.setPwd(userBean.getPwd());

			model.addObject("updateMessage", "Hi " + user.getFtname() + " Please update using below fields ");

			model.setViewName("updateCust");

		}
		return model;
	}
	
	@RequestMapping(value = "/updateCustomer.do", method = RequestMethod.POST)
	public ModelAndView updateCustomer(@ModelAttribute("updatecustomer") UserBean updatecustomer) {

		ModelAndView model = new ModelAndView("customerLogin");
		int i = customerRegDao.updateCustomer(updatecustomer);
		if (i > 0) {
			model.addObject("msg", " your details are successfully updated ");
		} else {
			model.addObject("msg", " Sorry Problem During Registration");
		}
		return model;
	}

	@RequestMapping(value = "/getStoreNames.do")
	public ModelAndView getStoreNames(@ModelAttribute("product") Product product, HttpServletRequest request) {
		UserBean userBean = (UserBean) request.getSession().getAttribute("customer");
		List<Product> storelist = null;
		ModelAndView model = new ModelAndView();
		if (userBean == null) {
			return new ModelAndView("login");
		} else {

			storelist = storeRegistrationDao.getStoreNames();
			model.addObject("storelist", storelist);
			model.setViewName("orderByStore");

			model.addObject("msg", "Please select a store name to get store products");
		}

		return model;
	}

	@RequestMapping(value = "/completeOrder.do")
	public ModelAndView orderByProduct(@ModelAttribute("user1") UserBean user, HttpServletRequest request) {

		ModelAndView model = new ModelAndView("customerLogin");
		model.addObject("msg", "Order Sucessfully Placed");

		return model;
	}

	@RequestMapping(value = "/getComplaintForm.do")
	public ModelAndView sendComplaint(@ModelAttribute("user1") UserBean user, HttpServletRequest request) {

		UserBean userBean = (UserBean) request.getSession().getAttribute("customer");
		List<Product> storelist = null;
		ModelAndView model = new ModelAndView();
		if (userBean == null) {
			return new ModelAndView("login");
		} else {

			storelist = storeRegistrationDao.getStoreNames();
			model.addObject("storelist", storelist);
			model.setViewName("sendComplaint");

			model.addObject("msg", "Please select a store name to get store products");
		}

		return model;
	}

	@RequestMapping(value = "/registerComplaint.do", method = RequestMethod.POST)
	public ModelAndView saveFeedback(@ModelAttribute UserBean user, HttpServletRequest request) {

		UserBean userBean = (UserBean) request.getSession().getAttribute("customer");
		ModelAndView model = new ModelAndView();
		if (userBean == null) {
			return new ModelAndView("login");
		} else {
			user.setUname(userBean.getUname());
			user.setFtname(userBean.getFtname());
			model.setViewName("sendComplaint");
			customerRegDao.saveFeedback(user);

			model.addObject("msgfeedback", "Hi " + user.getFtname() + " Thanks for your Feedback..!");
		}

		return model;
	}

	@RequestMapping(value = "/registerCustomer.do", method = RequestMethod.POST)
	public ModelAndView customerRegistar(@Valid @ModelAttribute("cregistar") UserBean cregistar, BindingResult result) {

		UserBean ckuser = null;

		ModelAndView model = new ModelAndView();

		if (result.hasErrors()) {
			model = new ModelAndView("registerCust");
			model.addObject("msgFailure",
					" User name must be between 6 and 10 with combination of alphabets and numbers");
			return model;
		} else {

			ckuser = customerRegDao.checkUser(cregistar.getUname(), cregistar.getEmail());
			if (ckuser == null) {
				model = new ModelAndView("login");
				cregistar.setUserRole("Customer");

				int i = customerRegDao.saveCustomer(cregistar);
				if (i > 0) {
					model.addObject("msg",
							" Hi " + cregistar.getFtname() + " Your Registration Completed, Please Login ");

				}
				return model;
			} else {
				model = new ModelAndView("registerCust");
				model.addObject("msgFailure",
						" Sorry user name and email already exists please try with different user name or email");
				// model.setViewName("register");

				return model;
			}

		}
	}

	// ADMIN registering customer
	@RequestMapping(value = "/registerCustomerByAdmin.do", method = RequestMethod.POST)
	public ModelAndView registerCustomerByAdmin(@Valid @ModelAttribute("cregistar") UserBean cregistar,
			BindingResult result) {

		UserBean ckuser = null;

		ModelAndView model = new ModelAndView();

		if (result.hasErrors()) {
			model = new ModelAndView("registerCustomerByAdmin");
			model.addObject("msgFailure",
					" User name must be between 6 and 10 with combination of alphabets and numbers");
			return model;
		} else {

			ckuser = customerRegDao.checkUser(cregistar.getUname(), cregistar.getEmail());
			if (ckuser == null) {
				model = new ModelAndView("adminLogin");
				cregistar.setUserRole("Customer");

				int i = customerRegDao.saveCustomer(cregistar);
				if (i > 0) {
					model.addObject("msg", " Hi Admin You have successfully added a customer ");

				}
				return model;
			} else {
				model = new ModelAndView("adminLogin");
				model.addObject("msg",
						" Sorry admin, user name and email already exists please try with different user name or email");

				return model;
			}

		}
	}

	// ADMIN registering Accountant
	@RequestMapping(value = "/registerAccountant.do", method = RequestMethod.POST)
	public ModelAndView registerAccountant(@Valid @ModelAttribute("cregistar") UserBean cregistar,
			BindingResult result) {

		UserBean ckuser = null;

		ModelAndView model = new ModelAndView();

		if (result.hasErrors()) {
			model = new ModelAndView("addAccountant");
			model.addObject("msgFailure",
					" User name must be between 6 and 10 with combination of alphabets and numbers");
			return model;
		} else {

			ckuser = customerRegDao.checkUser(cregistar.getUname(), cregistar.getEmail());
			if (ckuser == null) {
				model = new ModelAndView("adminLogin");
				cregistar.setUserRole("Accountant");

				int i = customerRegDao.saveCustomer(cregistar);
				if (i > 0) {
					model.addObject("msg", " Hi Admin You have successfully added an accountant  ");

				}
				return model;
			} else {
				model = new ModelAndView("adminLogin");
				model.addObject("msg",
						" Sorry admin, user name and email already exists please try with different user name or email");

				return model;
			}

		}
	}

	@RequestMapping(value = "/registerStore.do", method = RequestMethod.POST)
	public ModelAndView storeRegistar(@ModelAttribute("sregistar") StoreRegistration sregistar) {

		ModelAndView model = new ModelAndView("login");
		int i = storeRegistrationDao.saveStoreDetails(sregistar);
		if (i > 0)
			model.addObject("msg", " Hi " + sregistar.getUname() + " your store is successfully registred With "
					+ sregistar.getStrname() + " name ");
		else
			model.addObject("msg", " Sorry Problem During Registration");
		return model;
	}

	@RequestMapping(value = "/registerStoreByAdmin.do", method = RequestMethod.POST)
	public ModelAndView registerStoreByAdmin(@ModelAttribute("sregistar") StoreRegistration sregistar) {

		ModelAndView model = new ModelAndView("adminLogin");
		int i = storeRegistrationDao.saveStoreDetails(sregistar);
		if (i > 0)
			model.addObject("msg",
					" Hi Admin you successfully registred a atore With " + sregistar.getStrname() + " name ");
		else
			model.addObject("msg", " Sorry Problem During Registration");
		return model;
	}

	

	@RequestMapping(value = "/getUpdateProductPage.do")
	public ModelAndView getUpdateProductPage(@ModelAttribute("product") Product product, HttpServletRequest request) {
		StoreRegistration strBean = (StoreRegistration) request.getSession().getAttribute("storeManager");
		List<Product> productlist = null;
		ModelAndView model = new ModelAndView();
		if (strBean == null) {
			return new ModelAndView("login");
		} else {

			productlist = storeRegistrationDao.getProductsByStore(strBean);
			model.addObject("productlist", productlist);
			model.setViewName("updateProduct");

			model.addObject("msg", "Please select a Product to update");
		}

		return model;
	}
	


	@RequestMapping(value = "/updateProduct.do", method = RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute("product") Product product, HttpServletRequest request) {
		Product pr = null;
		StoreRegistration strBean = (StoreRegistration) request.getSession().getAttribute("storeManager");
		ModelAndView model = new ModelAndView();
		if (strBean == null) {
			return new ModelAndView("login");
		} else {

			product.setStrid(strBean.getStoreId());
			product.setStrname(strBean.getStrname());

			pr = storeRegistrationDao.getProductDetails(product);
			product.setProductName(pr.getProductName());
			product.setProductPrice(pr.getProductPrice());
			product.setProductQuantity(pr.getProductQuantity());
			product.setProductDescription(pr.getProductDescription());
			product.setProductId(pr.getProductId());
			model.setViewName("updateProduct1");

			model.addObject("msg", "Please update Products here");
		}

		return model;
	}

	@RequestMapping(value = "/saveupdatedProduct.do", method = RequestMethod.POST)
	public ModelAndView saveupdatedProduct(@ModelAttribute("product") Product product, HttpServletRequest request) {

		StoreRegistration strBean = (StoreRegistration) request.getSession().getAttribute("storeManager");
		product.setStrname(strBean.getStrname());
		ModelAndView model = new ModelAndView("addProduct");
		int i = storeRegistrationDao.saveupdatedProduct(product);
		if (i > 0) {
			model.addObject("msg", " your product is successfully updated ");
		} else {
			model.addObject("msg", " Sorry Problem during update");
		}
		return model;
	}

	@RequestMapping(value = "/getDeleteProductPage.do")
	public ModelAndView getDeleteProductPage(@ModelAttribute("product") Product product, HttpServletRequest request) {
		StoreRegistration strBean = (StoreRegistration) request.getSession().getAttribute("storeManager");
		List<Product> productlist = null;
		ModelAndView model = new ModelAndView();
		if (strBean == null) {
			return new ModelAndView("login");
		} else {

			productlist = storeRegistrationDao.getProductsByStore(strBean);
			model.addObject("productlist", productlist);
			model.setViewName("deleteProduct");

			model.addObject("msg", "Please select a Product to delete");
		}

		return model;
	}

	@RequestMapping(value = "/deleteProduct.do", method = RequestMethod.POST)
	public ModelAndView deleteProduct(@ModelAttribute("product") Product product, HttpServletRequest request) {

		StoreRegistration strBean = (StoreRegistration) request.getSession().getAttribute("storeManager");
		product.setStrname(strBean.getStrname());
		product.setStrid(strBean.getStoreId());
		ModelAndView model = new ModelAndView("addProduct");
		int i = storeRegistrationDao.deleteProduct(product);
		if (i > 0) {
			model.addObject("msg", " your product is successfully deleted ");
		} else {
			model.addObject("msg", " Sorry Problem during update");
		}
		return model;
	}

	@RequestMapping(value = "/addproduct1.do")
	public ModelAndView getAddProduct(@ModelAttribute("product") Product product, HttpServletRequest request) {

		StoreRegistration strBean = (StoreRegistration) request.getSession().getAttribute("storeManager");
		ModelAndView model = new ModelAndView();
		if (strBean == null) {
			return new ModelAndView("login");
		} else {

			product.setStrid(strBean.getStoreId());
			product.setStrname(strBean.getStrname());
			model.setViewName("addProduct");

			model.addObject("msg", "Please add your Products here");
		}

		return model;
	}

	@RequestMapping(value = "/saveProduct.do", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Product product, HttpServletRequest request) {

		ModelAndView model = new ModelAndView("addProduct");
		int i = storeRegistrationDao.addProduct(product);
		if (i > 0) {
			model.addObject("msg", " your product is successfully added ");
		} else {
			model.addObject("msg", " Sorry Problem During adding product please try again");
		}
		return model;

	}
	
	@RequestMapping(value = "/getstoreOrders.do")
	public ModelAndView getstoreOrders( HttpServletRequest request) {

		StoreRegistration sr = (StoreRegistration) request.getSession().getAttribute("storeManager");
		List<OrderDetails> viewAllOrdersByStoreManager = null;
		ModelAndView model = new ModelAndView();
		if (sr == null) {
			return new ModelAndView("login");
		} else {

			viewAllOrdersByStoreManager = storeRegistrationDao.viewOrdersByStoreManager(sr);
			model.addObject("viewAllOrdersByStoreManager", viewAllOrdersByStoreManager);

			model.setViewName("viewAllOrdersByStoreManager");

			model.addObject("msg", "Orders from all customers");
		}

		return model;
	}

	@RequestMapping(value = "/getstoredetails.do")
	public ModelAndView getstoredetails(@ModelAttribute("strBean") StoreRegistration strBean,
			HttpServletRequest request) {

		StoreRegistration sr = (StoreRegistration) request.getSession().getAttribute("storeManager");
		ModelAndView model = new ModelAndView();
		if (strBean == null) {
			return new ModelAndView("login");
		} else {

			strBean.setStoreId(sr.getStoreId());
			strBean.setStrname(sr.getStrname());
			strBean.setUname(sr.getUname());
			strBean.setPwd(sr.getPwd());
			strBean.setStrType(sr.getStrType());
			strBean.setBaddr(sr.getBaddr());
			strBean.setBphn(sr.getBphn());
			strBean.setBmobile(sr.getBmobile());
			strBean.setBemail(sr.getBemail());
			model.setViewName("updateStoreDetails");

			model.addObject("msg",
					"You can only update contact information Here..! If you want to update more plz contact Admin");
		}

		return model;

	}

	@RequestMapping(value = "/updateStoreDetails.do", method = RequestMethod.POST)
	public ModelAndView updateStoreDetails(@ModelAttribute("storeDetailsUpdate") StoreRegistration storeDetailsUpdate,
			HttpServletRequest request) {

		ModelAndView model = new ModelAndView("storeManagerLogin");
		int i = storeRegistrationDao.updateStoreDetails(storeDetailsUpdate);
		if (i > 0) {
			model.addObject("msg", " your store details are successfully updated ");
		} else {
			model.addObject("msg", " Sorry Problem during update");
		}
		return model;
	}
	
	@RequestMapping(value = "/getAccountant.do")
	public ModelAndView getAccountant(@ModelAttribute("user1") UserBean user, HttpServletRequest request) {

		UserBean userBean = (UserBean) request.getSession().getAttribute("Accountant");
		System.out.println(userBean);

		ModelAndView model = new ModelAndView();

		if (userBean == null) {
			return new ModelAndView("login");
		} else {
			user.setUname(userBean.getUname());
			user.setMobile(userBean.getMobile());
			user.setAddr1(userBean.getAddr1());
			user.setAddr2(userBean.getAddr2());
			user.setCity(userBean.getCity());
			user.setState(userBean.getState());
			user.setCountry(userBean.getCountry());
			user.setZip(userBean.getZip());
			user.setFtname(userBean.getFtname());
			user.setPwd(userBean.getPwd());

			model.addObject("updateMessage", "Hi " + user.getFtname() + " Please update using below fields ");

			model.setViewName("updateAccountant");

		}
		return model;
	}
	
	// Order View by accountant
	@RequestMapping(value = "/ordersByAccountant.do")
	public ModelAndView ordersByAccountant(@ModelAttribute("user") UserBean user, HttpServletRequest request) {

		UserBean userBean = (UserBean) request.getSession().getAttribute("Accountant");
		List<OrderDetails> viewAllOrdersByAccountant = null;
		ModelAndView model = new ModelAndView();
		if (userBean == null) {
			return new ModelAndView("login");
		} else {

			viewAllOrdersByAccountant = adminDao.viewAllOrdersByAdmin();
			model.addObject("viewAllOrdersByAccountant", viewAllOrdersByAccountant);

			model.setViewName("viewAllOrdersByAccountant");

			model.addObject("msg", "Orders from all customers");
		}

		return model;
	}
	
	@RequestMapping(value = "/updateAccountant.do", method = RequestMethod.POST)
	public ModelAndView updateAccountant(@ModelAttribute("updatecustomer") UserBean updatecustomer) {

		ModelAndView model = new ModelAndView("accountantLogin");
		int i = customerRegDao.updateCustomer(updatecustomer);
		if (i > 0) {
			model.addObject("msg", " your details are successfully updated ");
		} else {
			model.addObject("msg", " Sorry Problem During Registration");
		}
		return model;
	}
	
	@RequestMapping(value = "/viewFeedbackByAccountant.do")
	public ModelAndView viewFeedbackByAccountant(@ModelAttribute("product") Product product, HttpServletRequest request) {

		UserBean userBean = (UserBean) request.getSession().getAttribute("Accountant");
		List<UserBean> feedbacklist = null;
		ModelAndView model = new ModelAndView();
		if (userBean == null) {
			return new ModelAndView("login");
		} else {

			feedbacklist = accountantDao.viewFeedbackByAccountant();
			model.addObject("feedbacklist", feedbacklist);
			model.setViewName("viewFeedbackByAcc");

			model.addObject("msg", "Customer Feedback/Complaint for different stores");
		}

		return model;
	}
	
	// Admin view feedback
	@RequestMapping(value = "/viewFeedbackByAdmin.do")
	public ModelAndView viewFeedbackByAdmin(@ModelAttribute("user") UserBean user, HttpServletRequest request) {

		UserBean userBean = (UserBean) request.getSession().getAttribute("Admin");
		List<UserBean> feedbacklist = null;
		ModelAndView model = new ModelAndView();
		if (userBean == null) {
			return new ModelAndView("login");
		} else {

			feedbacklist = accountantDao.viewFeedbackByAccountant();
			model.addObject("feedbacklist", feedbacklist);
			model.setViewName("viewFeedbackByAdmin");

			model.addObject("msg", "Customer Feedback/Complaint for different stores");
		}

		return model;
	}
	

	
	@RequestMapping(value = "/viewProductsByAdmin.do")
	public ModelAndView viewProductsByAdmin(@ModelAttribute("user") UserBean user, HttpServletRequest request) {

		UserBean userBean = (UserBean) request.getSession().getAttribute("Admin");
		List<Product> productListForAdmin = null;
		ModelAndView model = new ModelAndView();
		if (userBean == null) {
			return new ModelAndView("login");
		} else {

			productListForAdmin = adminDao.productListForAdmin();
			model.addObject("productListForAdmin", productListForAdmin);

			model.setViewName("viewProductsByAdmin");

			model.addObject("msg", "Products from all stores");
		}

		return model;
	}
	@RequestMapping(value = "/viewAllOrdersByAdmin.do")
	public ModelAndView viewAllOrdersByAdmin(@ModelAttribute("user") UserBean user, HttpServletRequest request) {

		UserBean userBean = (UserBean) request.getSession().getAttribute("Admin");
		List<OrderDetails> viewAllOrdersByAdmin = null;
		ModelAndView model = new ModelAndView();
		if (userBean == null) {
			return new ModelAndView("login");
		} else {

			viewAllOrdersByAdmin = adminDao.viewAllOrdersByAdmin();
			model.addObject("viewAllOrdersByAdmin", viewAllOrdersByAdmin);

			model.setViewName("viewAllOrdersByAdmin");

			model.addObject("msg", "Orders from all customers");
		}

		return model;
	}
	@RequestMapping(value = "/orderByStore.do")
	public ModelAndView viewProductsByCustomer(@ModelAttribute("product") Product product, HttpServletRequest request) {

		UserBean userBean = (UserBean) request.getSession().getAttribute("customer");
		List<Product> productListForCustomer = null;
		ModelAndView model = new ModelAndView();
		if (userBean == null) {
			return new ModelAndView("login");
		} else {

			productListForCustomer = customerRegDao.productListForCustomer(product);
			model.addObject("productListForCustomer", productListForCustomer);

			model.setViewName("viewProductsByCustomer");

			model.addObject("msg", "Products from selected stores");
		}

		return model;
	}
	@RequestMapping(value = "/getAccountants.do")
	public ModelAndView getAccountants(@ModelAttribute("user") UserBean user, HttpServletRequest request) {
		UserBean userBean = (UserBean) request.getSession().getAttribute("Admin");
		List<UserBean> genericList = null;
		ModelAndView model = new ModelAndView();
		if (userBean == null) {
			return new ModelAndView("login");
		} else {
			user.setUserRole("Accountant");
			genericList = adminDao.getGenericlist(user);
			model.addObject("genericList", genericList);
			model.setViewName("deleteAccountantByAdmin");

			model.addObject("msg", "Please select a Accountant to delete");
		}

		return model;
	}

	@RequestMapping(value = "/deleteAccountant.do", method = RequestMethod.POST)
	public ModelAndView deleteAccountant(@ModelAttribute("user") UserBean user, HttpServletRequest request) {

		
		ModelAndView model = new ModelAndView("adminLogin");
		int i = adminDao.deleteGenericUser(user);
		if (i > 0) {
			model.addObject("msg", " Hi Admin you have successfully deleted an Accountant with username  "+ user.getUname());
		} else {
			model.addObject("msg", " Sorry Problem during delete");
		}
		return model;
	}
	
	@RequestMapping(value = "/getCustomers.do")
	public ModelAndView getCustomers(@ModelAttribute("user") UserBean user, HttpServletRequest request) {
		UserBean userBean = (UserBean) request.getSession().getAttribute("Admin");
		List<UserBean> genericList = null;
		ModelAndView model = new ModelAndView();
		if (userBean == null) {
			return new ModelAndView("login");
		} else {
			user.setUserRole("Customer");
			genericList = adminDao.getGenericlist(user);
			model.addObject("genericList", genericList);
			model.setViewName("deleteCustomerByAdmin");

			model.addObject("msg", "Please select a Customer to delete");
		}

		return model;
	}

	@RequestMapping(value = "/deleteCustomer.do", method = RequestMethod.POST)
	public ModelAndView deleteCustomer(@ModelAttribute("user") UserBean user, HttpServletRequest request) {

		
		ModelAndView model = new ModelAndView("adminLogin");
		int i = adminDao.deleteGenericUser(user);
		if (i > 0) {
			model.addObject("msg", " Hi Admin you have successfully deleted Customer with username  "+ user.getUname());
		} else {
			model.addObject("msg", " Sorry Problem during delete");
		}
		return model;
	}
	
	@RequestMapping(value = "/getStoreNamesForAdmin.do")
	public ModelAndView getStoreNamesForAdmin(@ModelAttribute("user") UserBean user, HttpServletRequest request) {
		UserBean userBean = (UserBean) request.getSession().getAttribute("Admin");
		List<StoreRegistration> storeList = null;
		ModelAndView model = new ModelAndView();
		if (userBean == null) {
			return new ModelAndView("login");
		} else {
			
			storeList = adminDao.getStorelist();
			model.addObject("storeList", storeList);
			model.setViewName("deleteStoreByAdmin");

			model.addObject("msg", "Please select a store name to delete");
		}

		return model;
	}

	@RequestMapping(value = "/deleteStore.do", method = RequestMethod.POST)
	public ModelAndView deleteStoreManager(@ModelAttribute("sr") StoreRegistration sr, HttpServletRequest request) {

		
		ModelAndView model = new ModelAndView("adminLogin");
		
		int j = adminDao.deleteProducts(sr);
		int i = adminDao.deleteStore(sr);
		if (i > 0) {
			if(j>0)
			model.addObject("msg", " Hi Admin you have successfully deleted Store with storename  "+ sr.getStrname()+" and also products associated to it.");
			else
				model.addObject("msg", " Hi Admin you have successfully deleted Store with storename  "+ sr.getStrname());
		} else {
			model.addObject("msg", " Sorry Problem during delete");
		}
		return model;
	}

	@RequestMapping(value = "/logout.do")
	public ModelAndView getAdmissionForm(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("login");
		HttpSession session = request.getSession();
		//session.removeAttribute("customer");
		session.invalidate();
		System.out.println(session);
		model.addObject("logoutMsg", "Your are sucessfully logged out");
		return model;

	}
	
	

}
