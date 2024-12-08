package stu01;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication
public class Application {
public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
}

@GetMapping("/index")
public String index(Model model,HttpSession session) {
	if (session.getAttribute("user")!=null) {
	model.addAttribute("user",session.getAttribute("user"));
	
	}
	else {
		model.addAttribute("user", "游客");
		return "redirect:/login";
	}
	return "layui/index";
}

@GetMapping("/login")
public ModelAndView getlogin(){
	ModelAndView mav= new ModelAndView();
	mav.setViewName("layui/login");
	return mav;
}

@PostMapping("/login")
@ResponseBody
public ResponseEntity<String> postlogin(@RequestParam(name="user") String usr,@RequestParam String password, HttpServletRequest request){
	    if (usr.equals("lmz")) {
		HttpSession ss=request.getSession(true);
		ss.setAttribute("user",usr);
		ss.setAttribute("login", true);
		return ResponseEntity.status(HttpStatus.OK).body("success");
		
	    }
	    else
	    {
	    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("login fail");
	    }
	
}

@GetMapping("logout")
public ModelAndView logout(HttpSession session) {
	session.invalidate();
	ModelAndView mv=new ModelAndView();
	mv.setStatus(HttpStatus.OK);
	mv.setViewName("/layui/login");
	return mv;
}

}