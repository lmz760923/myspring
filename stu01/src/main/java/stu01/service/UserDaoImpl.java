package stu01.service;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import stu01.model.User;
@Repository("userDao")
public class UserDaoImpl {
	@Resource(name="datasource")
	private DriverManagerDataSource ds;
	
	
	public int insert(User user) throws SQLException {
		int rows;
		Connection jdbc_conn;
		jdbc_conn=ds.getConnection();
    	jdbc_conn.setAutoCommit(false);
		CallableStatement cst=jdbc_conn.prepareCall("insert into user(id,name,password,number) values(?,?,?,?)");
		cst.setLong(1, 1009);
		cst.setString(2, user.getName());
		cst.setString(3, user.getPassword());
		cst.setLong(4, user.getNumber());
		rows=cst.executeUpdate();
	
		jdbc_conn.commit();
		jdbc_conn.close();
		return rows;
		
	}
	public List<User>select() throws SQLException {
		Connection jdbc_conn;
		jdbc_conn=ds.getConnection();
		String selectsql="select id,name,password,number from user";
		Statement st;
		ResultSet rs;
		List<User> lst=new ArrayList<>();
		try {
		st=jdbc_conn.createStatement();
		rs=st.executeQuery(selectsql);
		while (rs.next())
		{
			lst.add(new User(rs.getInt("id"),rs.getString("name"),rs.getString("password"),rs.getInt("number")));
		}
		}
		catch(SQLException e)
		{
			return null;
		}
		return lst;

	}
	
	public User login(User u) {
		return u;
		
	}
	
	public User getById(Integer userid) throws SQLException {
		Connection jdbc_conn;
		jdbc_conn=ds.getConnection();
		String selectsql="select * from user where id=?";
		PreparedStatement pst;
		ResultSet rst;
		try {
			pst=jdbc_conn.prepareStatement(selectsql);
			pst.setInt(1, userid);
			rst=pst.executeQuery();
		
		if (rst.getRow()>0) {
			jdbc_conn.close();
			return new User((int)rst.getInt("id"),(String)rst.getString("name"),(String)rst.getString("password"),(int)rst.getInt("number"));
		}
		
		} catch (SQLException e) {
			
			return null;
		}
		
		return null;
		
	}

}
