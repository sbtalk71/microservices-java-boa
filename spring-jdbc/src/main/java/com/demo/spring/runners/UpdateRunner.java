package com.demo.spring.runners;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;

@Component
public class UpdateRunner implements CommandLineRunner{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		
	int updateCount=jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement("insert into emp(empno,name,address,salary) values(?,?,?,?)");
				pst.setInt(1, 120);
				pst.setString(2, "Veera");
				pst.setString(3, "Pune");
				pst.setDouble(4, 56000);
				return pst;
			}
		});
	System.out.println("Updated Rows : "+updateCount);
		
	}
}
