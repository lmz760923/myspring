package stu01.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import stu01.Application;
import stu01.model.User;
@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest(classes=Application.class)
@WebAppConfiguration
@TestPropertySource("classpath:application.yml")
public class mycontrollerTest {
   
   @Value("${spring.datasource.driver-class-name}")
    private String name;
   @Autowired JdbcTemplate jdbcTemplate;
	@Test
	public void testInsert() {
		//fail("Not yet implemented");
		
		User user=new User(100, name, name, 100);
		user.setId(1008);
		user.setName("xyz");
		user.setNumber(100);
		user.setPassword("abc");
		System.out.println("jdbcTemplate:"+this.jdbcTemplate);
		//jdbcTemplate.update("insert into user(id,name,password,number) values(?,?,?,?)", user.getId(),user.getName(),user.getPassword(),user.getNumber());
		
		
		System.out.println("name:"+name);
		System.out.println("testtesttest-------------------------------------");
	}
	

}
