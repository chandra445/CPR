package com.shoppingmall.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.shoppingmall.dao.rowmapper.*;
import com.shoppingmall.pojo.Product;
import com.shoppingmall.pojo.UserBean;

public class AccountantDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public UserBean checkAccountant(String uname, String pwd) {
		UserBean cr = null;
		// List<User> userList = new ArrayList<User>();
		String sql = "select uname,pwd from accountantRegistration where uname= '"
				+ uname + "' and pwd= '" + pwd + "'";
		System.out.println("query=======" + sql);
		try {
			cr = (UserBean) jdbcTemplate.queryForObject(sql, new Object[] {}, new AccountantCheckRowMapper());
		} catch (Exception ex) {
			ex.getMessage();
		}

		return cr;
	}

	public List<UserBean> viewFeedbackByAccountant() {
		List<UserBean> fb = new ArrayList<UserBean>();

		String sql = "select * from feedback";
		System.out.println("query=======" + sql);
		try {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Map> rows = jdbcTemplate.queryForList(sql, new Object[] {});
			for (Map row : rows) {
				UserBean ub = new UserBean();
				Date date=(Date) row.get("feedbackDate");
				
				ub.setUname((String) row.get("uname"));
				ub.setFeedback((String)row.get("feedback"));
				ub.setFeedbackDate(date.toString());
				ub.setStrname((String) row.get("strname"));
				
				fb.add(ub);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}

		return fb;
	}

	
}

