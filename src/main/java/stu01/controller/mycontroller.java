package stu01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import stu01.model.User;
import stu01.service.UserDaoImpl;

@Controller
@RequestMapping("/users")
@ResponseBody
public class mycontroller {
	@Value("${spring.datasource.driver-class-name}")
    private String name;
	@Autowired
	private	UserDaoImpl userdao;
	@RequestMapping("/insert")
	
	public ResponseEntity<User> insert(User u) {
		System.out.println("u.getName:"+u.getName());
		System.out.println("property driver name:"+name);
		userdao.insert(u);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	@RequestMapping("/select")
	public ResponseEntity<List<User>>select(){
		List<User> li_u;
		li_u=this.userdao.select();
		return ResponseEntity.status(HttpStatus.OK).body(li_u);
		
	}

}
