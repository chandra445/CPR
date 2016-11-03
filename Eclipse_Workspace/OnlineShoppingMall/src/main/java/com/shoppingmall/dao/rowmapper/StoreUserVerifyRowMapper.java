package com.shoppingmall.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shoppingmall.pojo.*;

public class StoreUserVerifyRowMapper implements RowMapper {
	public StoreRegistration mapRow(ResultSet rs, int line) throws SQLException {
		if(rs==null) return null;
		StoreRegistration user=new StoreRegistration();
		user.setStrname(rs.getString(1));
		user.setStoreId(rs.getString(2));
		user.setUname(rs.getString(3));
		user.setPwd(rs.getString(4));
		user.setStrType(rs.getString(5));
		user.setBaddr(rs.getString(6));
		user.setBphn(rs.getString(7));
		user.setBmobile(rs.getString(8));
		user.setBemail(rs.getString(9));
	    
	    
	      return user;
	}
}
