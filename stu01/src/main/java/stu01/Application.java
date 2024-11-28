package stu01;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class Application {
public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
}

@GetMapping("/index")
public String index() {
	return "layui/index";
}

}