package com.demo.spring.runners;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

@Component
public class QueryRunner implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		
		jdbcTemplate.query("select * from emp", new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				
				System.out.println(rs.getInt("EMPNO")+" "+rs.getString("NAME")+" "+rs.getString("ADDRESS")+" "+rs.getDouble("SALARY"));
				
			}
		});
		
		
		JdbcClient jdbcClient=JdbcClient.create(jdbcTemplate);
		
		List<Map<String, Object>> rowList= jdbcClient.sql("select * from emp").query().listOfRows();
		
		for(Map<String, Object> map:rowList) {
			System.out.println(map);
		}

		
		jdbcClient.sql("select * from emp").query(new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				
				System.out.println(rs.getInt("EMPNO")+" "+rs.getString("NAME")+" "+rs.getString("ADDRESS")+" "+rs.getDouble("SALARY"));
				
			}
		});
	}

}
