package stu01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import stu01.model.User;
@Service
public class UserDaoImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int insert(User user) {
		System.out.println("jdbcTemplate:"+this.jdbcTemplate);
		String insertsql="insert into user(id,name,password,number) values(?,?,?,?)";
		return jdbcTemplate.update(insertsql,user.getId(),user.getName(),user.getPassword(),user.getNumber());
	
		
	}
	public List<User>select(){
		String selectsql="select id,name,password,number from user";
		return jdbcTemplate.query(selectsql,new BeanPropertyRowMapper<>(User.class));

		
	}

}
