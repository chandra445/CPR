package com.shoppingmall.dao;

import com.shoppingmall.dao.rowmapper.*;
import com.shoppingmall.pojo.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class StoreRegistrationDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveStoreDetails(StoreRegistration sr) {

		String sql = "INSERT INTO StoreRegistration (strname,uname,pwd,strcat,baddr,bphn,bmobile,bemail) VALUES (?, ?, ?, ?, ?, ?,?,?)";

		return jdbcTemplate.update(sql, new Object[] { sr.getStrname(), sr.getUname(), sr.getPwd(), sr.getStrType(),
				sr.getBaddr(), sr.getBphn(), sr.getBmobile(), sr.getBemail() });

	}

	public StoreRegistration checkStoreManager(String uname, String upass) {
		StoreRegistration sr = null;
		// List<User> userList = new ArrayList<User>();
		String sql = "select * from StoreRegistration where uname= '" + uname + "' and pwd= '" + upass + "'";
		System.out.println("query=======" + sql);
		try {
			sr = (StoreRegistration) jdbcTemplate.queryForObject(sql, new Object[] {}, new StoreUserVerifyRowMapper());
		} catch (Exception ex) {
			ex.getMessage();
		}

		return sr;
	}

	public int addProduct(Product product) {

		return jdbcTemplate.update("{call ADDPRODUCT (?,?,?,?,?,?)}",
				new Object[] { product.getStrid(), product.getStrname(), product.getProductName(),
						product.getProductPrice(), product.getProductQuantity(), product.getProductDescription() });

	}

	public int saveupdatedProduct(Product product) {
		int status = 0;
		try {
			String query = "update product set productprice=?,productquantity=?,productdescription=? "
					+ "where strid=? and strname=? and productname=?";
			status = jdbcTemplate.update(query,
					new Object[] { product.getProductPrice(), product.getProductQuantity(),
							product.getProductDescription(), product.getStrid(), product.getStrname(),
							product.getProductName() });
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	public Product getProductDetails(Product product) {
		Product pr = null;
		// List<User> userList = new ArrayList<User>();
		String sql = "select Productname,productprice,productquantity,productdescription,productid from product where strid='"
				+ product.getStrid() + "' and strname='" + product.getStrname() + "' and productname='"
				+ product.getProductName() + "'";
		System.out.println("query=======" + sql);
		try {
			pr = (Product) jdbcTemplate.queryForObject(sql, new Object[] {}, new ProductDetailsRowMapper());
		} catch (Exception ex) {
			ex.getMessage();
		}

		return pr;
	}

	public List<Product> getProductsByStore(StoreRegistration sr) {
		List<Product> pr = new ArrayList<Product>();

		String sql = "select Productname from product where strid='" + sr.getStoreId() + "' and strname='"
				+ sr.getStrname() + "'";
		System.out.println("query=======" + sql);
		try {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Map> rows = jdbcTemplate.queryForList(sql, new Object[] {});
			for (Map row : rows) {
				Product product = new Product();
				product.setProductName((String) row.get("productName"));
				pr.add(product);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}

		return pr;
	}

	public int deleteProduct(Product product) {
		int status = 0;
		try {
			String query = "delete from product where strid=? and strname=? and productname=?";
			status = jdbcTemplate.update(query,
					new Object[] { product.getStrid(), product.getStrname(), product.getProductName() });
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	public int updateStoreDetails(StoreRegistration sr) {
		int status = 0;
		try {
			String query = "update storeregistration set pwd=?,strcat=?,baddr=?,bphn=?,bmobile=? "
					+ "where storeid=? and strname=?";
			status = jdbcTemplate.update(query, new Object[] { sr.getPwd(), sr.getStrType(), sr.getBaddr(),
					sr.getBphn(), sr.getBmobile(), sr.getStoreId(), sr.getStrname() });
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	public List<Product> getStoreNames() {
		List<Product> pr = new ArrayList<Product>();

		String sql = "select distinct strname from product";
		System.out.println("query=======" + sql);
		try {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Map> rows = jdbcTemplate.queryForList(sql, new Object[] {});
			for (Map row : rows) {
				Product product = new Product();
				product.setStrname((String) row.get("strname"));
				pr.add(product);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}

		return pr;
	}

	public List<OrderDetails> viewOrdersByStoreManager(StoreRegistration sr) {
		List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();

		String sql = "SELECT bill.ordid,bill.custid,bill.uname,bill.bill,bill.ORDERDATE, custorder.strname, "
				+ "custorder.pname, custorder.price, custorder.qty, custorder.totprice FROM bill "
				+ "INNER JOIN custorder ON bill.ordid=custorder.ordid where strname=?";
		System.out.println("query=======" + sql);
		try {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Map> rows = jdbcTemplate.queryForList(sql, new Object[] {sr.getStrname()});
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
