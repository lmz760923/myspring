package stu01.service;
import java.util.List;
import java.util.Map;

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
		return jdbcTemplate.query(selectsql,new BeanPropertyRowMapper<User>(User.class));

	}
	
	public User login(User u) {
		return u;
		
	}
	
	public User getById(Integer userid) {
		String selectsql="select * from user where id=?";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(selectsql, userid);
		if (list.size()>0) {
			return new User((int)list.get(0).get("id"),(String)list.get(0).get("name"),(String)list.get(0).get("password"),(int)list.get(0).get("number"));
		}
		return null;
		
	}

}
