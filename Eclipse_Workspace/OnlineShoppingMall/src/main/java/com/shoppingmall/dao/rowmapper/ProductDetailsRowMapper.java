package com.shoppingmall.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shoppingmall.pojo.Product;

public class ProductDetailsRowMapper implements RowMapper {
	public Product mapRow(ResultSet rs, int line) throws SQLException {
		if(rs==null) return null;
		Product pr=new Product();
		pr.setProductName(rs.getString(1));
		pr.setProductPrice(rs.getDouble(2));
		pr.setProductQuantity(rs.getInt(3));
		pr.setProductDescription(rs.getString(4));
		pr.setProductId(rs.getString(5));
	      return pr;
	}
}
