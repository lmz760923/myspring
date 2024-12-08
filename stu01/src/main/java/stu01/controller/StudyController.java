package stu01.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/")
public class StudyController {

	@GetMapping("register.php")
	public ResponseEntity<User[]> responseRegister(@RequestParam(name="firstname") String first,@RequestParam(name="lastname") String last,@RequestParam(name="photos") MultipartFile[] files,HttpServletRequest request) {
		ArrayList<String> filenames=new ArrayList<String>();
		String headname;
		for(MultipartFile file:files) {
			filenames.add(file.getOriginalFilename());
			try {
				file.transferTo(Path.of(file.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Enumeration<String> headernames=request.getHeaderNames();
		while (headernames.hasMoreElements()) {
			headname=headernames.nextElement();
			System.out.println(headname+":"+request.getHeader(headname));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new User[] {new User(first,last,filenames)}) ;
		
	}
	
	@PostMapping("register.php")
	public ResponseEntity<User[]> getresponseRegister(@RequestParam(name="firstname") String first,@RequestParam(name="lastname") String last,@RequestParam(name="photos") MultipartFile[] files,HttpServletRequest request) {
		ArrayList<String> filenames=new ArrayList<String>();
		String headname;
		for(MultipartFile file:files) {
			filenames.add(file.getOriginalFilename());
			try {
				file.transferTo(Path.of(file.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Enumeration<String> headernames=request.getHeaderNames();
		while (headernames.hasMoreElements()) {
			headname=headernames.nextElement();
			System.out.println(headname+":"+request.getHeader(headname));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new User[] {new User(first,last,filenames)}) ;
		
	}
	
	public static class User{
		User(String first,String last,ArrayList<String> filenames){
			this.first=first;
			this.last=last;
			this.filenames=filenames;
		}
		public String getFirst() {
			return first;
		}
		public void setFirst(String first) {
			this.first = first;
		}
		public String getLast() {
			return last;
		}
		public void setLast(String last) {
			this.last = last;
		}
		String first;
		String last;
		ArrayList<String> filenames;
		public ArrayList<String> getFilenames() {
			return filenames;
		}
		public void setFilenames(ArrayList<String> filenames) {
			this.filenames = filenames;
		}
	}

}
