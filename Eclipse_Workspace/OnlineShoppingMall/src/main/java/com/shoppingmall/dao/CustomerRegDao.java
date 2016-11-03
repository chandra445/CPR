package com.shoppingmall.dao;

import com.shoppingmall.dao.rowmapper.CustomerCheckRowMapper;
import com.shoppingmall.dao.rowmapper.CustomerRowMapper;
import com.shoppingmall.pojo.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerRegDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveCustomer(UserBean cr) {

		return jdbcTemplate.update("{call insertUserBean (?,?,?,?,?,?,?,?,?,?,?,?,?,?)}",
				new Object[] { cr.getFtname(), cr.getLtname(), cr.getUname(), cr.getPwd(), cr.getMobile(),
						cr.getEmail(), cr.getBday(), cr.getAddr1(), cr.getAddr2(), cr.getCity(), cr.getState(),
						cr.getCountry(), cr.getZip(),cr.getUserRole() });

	}

	public UserBean checkLoginUser(String uname, String upass, String urole) {
		UserBean cr = null;
		// List<User> userList = new ArrayList<User>();
		String sql = "select uname,ftname,mobile,addr1,addr2,city,state,country,zip,pwd,userid from USERBEAN where uname= '"
				+ uname + "' and pwd= '" + upass + "'";
		System.out.println("query=======" + sql);
		try {
			cr = (UserBean) jdbcTemplate.queryForObject(sql, new Object[] {}, new CustomerRowMapper());
		} catch (Exception ex) {
			ex.getMessage();
		}

		return cr;
	}

	public UserBean checkUser(String uname, String email) {
		UserBean cr = null;
		// List<User> userList = new ArrayList<User>();
		String sql = "select uname, ftname from USERBEAN where uname= '" + uname + "' and email= '" + email
				+ "'";
		System.out.println("query=======" + sql);
		try {
			cr = (UserBean) jdbcTemplate.queryForObject(sql, new Object[] {}, new CustomerCheckRowMapper());
		} catch (Exception ex) {
			ex.getMessage();
		}

		return cr;
	}

	public int updateCustomer(UserBean cr) {
		int status = 0;
		try {
			String query = "update USERBEAN set pwd=?,mobile=?, addr1=?, addr2=?, city=?, state=?,country=?,zip=? "
					+ "where uname=?";
			status = jdbcTemplate.update(query, new Object[] { cr.getPwd(), cr.getMobile(), cr.getAddr1(),
					cr.getAddr2(), cr.getCity(), cr.getState(), cr.getCountry(), cr.getZip(), cr.getUname() });
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	public int saveFeedback(UserBean cr) {
		return jdbcTemplate.update("{call insertfeedback (?,?,?)}", new Object[] { cr.getUname(), cr.getFeedback(),cr.getStrname() });
	}

	public List<Product> productListForCustomer(Product pt) {
		List<Product> product = new ArrayList<Product>();

		String sql = "select * from Product where strname=?";
		System.out.println("query=======" + sql);
		try {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Map> rows = jdbcTemplate.queryForList(sql, new Object[] {pt.getStrname()});
			for (Map row : rows) {
				Product pr = new Product();
				Double price = Double.parseDouble((String) row.get("productprice"));
				BigDecimal quantity =  (BigDecimal) row.get("productquantity");
				pr.setStrname((String) row.get("strname"));
				pr.setProductId((String) row.get("productid"));
				pr.setProductName((String) row.get("productname"));
				pr.setProductPrice(price);
				pr.setProductQuantity(quantity.intValue() );
				pr.setProductDescription((String) row.get("productdescription"));
				pr.setStrid((String)row.get("strid"));
				
				product.add(pr);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}

		return product;
	}

}
