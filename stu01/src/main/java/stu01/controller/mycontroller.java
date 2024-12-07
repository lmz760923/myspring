package stu01.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import stu01.model.User;
import stu01.service.UserDaoImpl;

@RestController
@RequestMapping("/users")
public class mycontroller {
	@Value("${spring.datasource.driver-class-name}")
    private String name;
	@Autowired
	@Qualifier("userDao")
	private	UserDaoImpl userdao;
	

	
	@PostMapping("/insert")
	public ResponseEntity<User> insert(@RequestBody User u) throws SQLException {
		System.out.println("u.getName:"+u.getName());
		System.out.println("property driver name:"+name);
		userdao.insert(u);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	@GetMapping("/select")

	public ResponseEntity<List<User>>select(){
		List<User> li_u;
		try {
			li_u=this.userdao.select();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return ResponseEntity.status(HttpStatus.OK).body(li_u);
		
	}
	
	@PostMapping("/login")
	
	public ResponseEntity<User>login(User u,HttpServletRequest request,HttpServletResponse response ){
		
		if (request.getSession().getAttribute("uname")==null) {request.getSession().setAttribute("uname", "lmz");}
		
		User ur;
		ur=this.userdao.login(u);
		
		System.out.println(u);
		System.out.println(request.getSession().getAttribute("uname"));
		return ResponseEntity.status(HttpStatus.OK).body(ur);

		
		
	}
	
	@GetMapping("/select/{id}")
	public ResponseEntity<User>getById(@PathVariable(name="id") Integer userid,HttpServletRequest request,HttpServletResponse response){
		User ur;
		try {
			ur = this.userdao.getById(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(ur);
		
	}

}
