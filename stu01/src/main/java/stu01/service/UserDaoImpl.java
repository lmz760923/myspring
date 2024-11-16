package stu01.service;

import java.util.ArrayList;
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
		//String selectsql="select id,name,password,number from user";
	
		List<User> list=new ArrayList<User>();
		User u=new User(1001,"zz","pass",1000);
		list.add(u);
		return list;
		//return jdbcTemplate.query(selectsql,new BeanPropertyRowMapper<>(User.class));

		
	}
	
	public User login(User u) {
		return u;
		
	}

}
