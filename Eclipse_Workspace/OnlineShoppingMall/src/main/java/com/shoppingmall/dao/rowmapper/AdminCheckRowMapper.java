package com.shoppingmall.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shoppingmall.pojo.UserBean;

public class AdminCheckRowMapper implements RowMapper {
	public UserBean mapRow(ResultSet rs, int line) throws SQLException {
		if(rs==null) return null;
		UserBean ub=new UserBean();
		ub.setUname(rs.getString(1));
		ub.setPwd(rs.getString(2));
	      return ub;
	}

}
