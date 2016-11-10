package com.shoppingmall.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.shoppingmall.dao.rowmapper.*;
import com.shoppingmall.pojo.OrderDetails;
import com.shoppingmall.pojo.Product;
import com.shoppingmall.pojo.StoreRegistration;
import com.shoppingmall.pojo.UserBean;

public class AdminDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public UserBean checkAdmin(String uname, String pwd) {
		UserBean cr = null;
		// List<User> userList = new ArrayList<User>();
		String sql = "select uname,pwd from admin where uname= '" + uname + "' and pwd= '" + pwd + "'";
		System.out.println("query=======" + sql);
		try {
			cr = (UserBean) jdbcTemplate.queryForObject(sql, new Object[] {}, new AdminCheckRowMapper());
		} catch (Exception ex) {
			ex.getMessage();
		}

		return cr;
	}

	public List<UserBean> getGenericlist(UserBean user) {
		List<UserBean> genericList = new ArrayList<UserBean>();

		String sql = "select uname from USERBEAN where userrole=?";
		System.out.println("query=======" + sql);
		try {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Map> rows = jdbcTemplate.queryForList(sql, new Object[] { user.getUserRole() });
			for (Map row : rows) {
				UserBean ub = new UserBean();
				ub.setUname((String) row.get("uname"));
				genericList.add(ub);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}

		return genericList;
	}

	public int deleteGenericUser(UserBean user) {
		int status = 0;
		try {
			String query = "delete from USERBEAN where uname=?";
			status = jdbcTemplate.update(query, new Object[] { user.getUname() });
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	public List<StoreRegistration> getStorelist() {
		List<StoreRegistration> storeList = new ArrayList<StoreRegistration>();

		String sql = "select strname from StoreRegistration";
		System.out.println("query=======" + sql);
		try {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Map> rows = jdbcTemplate.queryForList(sql, new Object[] {});
			for (Map row : rows) {
				StoreRegistration sl = new StoreRegistration();
				sl.setStrname((String) row.get("strname"));
				storeList.add(sl);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}

		return storeList;
	}

	public int deleteStore(StoreRegistration sr) {
		int status = 0;
		try {
			String query = "delete from StoreRegistration where strname=?";
			status = jdbcTemplate.update(query, new Object[] { sr.getStrname() });
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	public int deleteProducts(StoreRegistration sr) {
		int status = 0;
		try {
			String query = "delete from product where strname=?";
			status = jdbcTemplate.update(query, new Object[] { sr.getStrname() });
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	public List<Product> productListForAdmin() {
		List<Product> product = new ArrayList<Product>();

		String sql = "select * from Product";
		System.out.println("query=======" + sql);
		try {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Map> rows = jdbcTemplate.queryForList(sql, new Object[] {});
			for (Map row : rows) {
				Product pr = new Product();
				Double price = Double.parseDouble((String) row.get("productprice"));
				BigDecimal quantity = (BigDecimal) row.get("productquantity");
				pr.setStrname((String) row.get("strname"));
				pr.setProductId((String) row.get("productid"));
				pr.setProductName((String) row.get("productname"));
				pr.setProductPrice(price);
				pr.setProductQuantity(quantity.intValue());
				pr.setProductDescription((String) row.get("productdescription"));

				product.add(pr);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}

		return product;
	}

	public List<OrderDetails> viewAllOrdersByAdmin() {
		List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();

		String sql = "SELECT bill.ordid,bill.custid,bill.uname,bill.bill,bill.ORDERDATE, custorder.strname, "
				+ "custorder.pname, custorder.price, custorder.qty, custorder.totprice FROM bill "
				+ "INNER JOIN custorder ON bill.ordid=custorder.ordid";
		System.out.println("query=======" + sql);
		try {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Map> rows = jdbcTemplate.queryForList(sql, new Object[] {});
			for (Map row : rows) {
				OrderDetails od = new OrderDetails();
				BigDecimal bill,price,quantity,totalprice;
				bill=(BigDecimal) row.get("bill");
				price=(BigDecimal) row.get("price");
				quantity=(BigDecimal)row.get("qty");
				totalprice=(BigDecimal)row.get("totprice");
				od.setOrdid((String)row.get("ordid"));
				od.setCustid((String)row.get("custid"));
				od.setUname((String) row.get("uname"));
				od.setStrname((String) row.get("strname"));
				od.setProductName((String) row.get("pname"));
				od.setOrderDate((Date) row.get("orderdate"));
				od.setQuantity(quantity.intValue() );
				od.setBill(bill.doubleValue());
				od.setPrice(price.doubleValue());
				
				od.setTotalPriceForProduct(totalprice.doubleValue());
				
				

				orderDetails.add(od);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}

		return orderDetails;
	}

}
