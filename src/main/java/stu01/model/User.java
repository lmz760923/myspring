package stu01.model;

public class User {
	private int id;
	private String name;
	private String password;
	private int number;
	public User(int id,String name,String password,int number) {
		this.id=id;
		this.name=name;
		this.password=password;
		this.number=number;
	}
	public User() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	

}
