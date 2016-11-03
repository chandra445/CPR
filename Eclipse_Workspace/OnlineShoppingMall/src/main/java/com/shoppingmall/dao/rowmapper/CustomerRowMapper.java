package com.shoppingmall.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shoppingmall.pojo.UserBean;

public class CustomerRowMapper implements RowMapper {

	public UserBean mapRow(ResultSet rs, int line) throws SQLException {
		if(rs==null) return null;
		UserBean user=new UserBean();
	    user.setUname(rs.getString(1));
	    user.setFtname(rs.getString(2));
	    user.setMobile(rs.getLong(3));
	    user.setAddr1(rs.getString(4));
	    user.setAddr2(rs.getString(5));
	    user.setCity(rs.getString(6));
	    user.setState(rs.getString(7));
	    user.setCountry(rs.getString(8));
	    user.setZip(rs.getString(9));
	    user.setPwd(rs.getString(10));
	    user.setCustid(rs.getString(11).toString());
	    
	      return user;
	}

}
