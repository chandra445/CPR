package com.shoppingmall.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shoppingmall.pojo.UserBean;

public class CustomerCheckRowMapper implements RowMapper {
	public UserBean mapRow(ResultSet rs, int line) throws SQLException {
		if(rs==null) return null;
		UserBean ub=new UserBean();
		ub.setCheckUser(rs.getString(1));
		ub.setCheckEmail(rs.getString(2));
	      return ub;
	}

}
