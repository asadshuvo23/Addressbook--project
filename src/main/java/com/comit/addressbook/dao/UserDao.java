package com.comit.addressbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.comit.users.bean.UserBean;

@Component
public class UserDao {
	
//	List<UserBean> users;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbcTemplate=new JdbcTemplate(jdbc);
	}
	
//	public UserDao() {
//		this.users = new ArrayList<UserBean>();
//		users.add (new UserBean("John","Elbert","john@gmail.com",123098098,888889887,"Manager", "IT",12010));
//	}
	public List<UserBean> listUsers() {
		return jdbcTemplate.query("select * from addressbook", new RowMapper<UserBean>() {
			 
			@Override
			public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserBean userBean= new UserBean(
						rs.getString("FIRST_NAME"),
						rs.getString("LAST_NAME"),
						rs.getString("EMAIL_ADDRESS"),
						rs.getString("OFFICE_PHONE"),
						rs.getString("MOBILE"),
						rs.getString("DESIGNATION"),
						rs.getString("DEPARTMENT"),
						rs.getString("EMPLOYEE_ID")
						);
				return userBean;
			}
			
		 });
	}	
	
	public UserBean getUser(String id) {
		List<UserBean> userBeans = jdbcTemplate.query("select * from addressbook where EMPLOYEE_ID = "+ id, new RowMapper<UserBean>() {
			 
			@Override
			public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserBean userBean= new UserBean(
						rs.getString("FIRST_NAME"),
						rs.getString("LAST_NAME"),
						rs.getString("EMAIL_ADDRESS"),
						rs.getString("OFFICE_PHONE"),
						rs.getString("MOBILE"),
						rs.getString("DESIGNATION"),
						rs.getString("DEPARTMENT"),
						rs.getString("EMPLOYEE_ID")
						);
				return userBean;
			}
			
		 });
		
		if(userBeans.size()>0) {
			return userBeans.get(0);
		}else {
			return new UserBean();
		}
	}
	
	public int addUser(UserBean userBean) {
		 return jdbcTemplate.update("insert into addressbook (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS,OFFICE_PHONE,MOBILE,DESIGNATION,DEPARTMENT) " + "values(?, ?, ?, ?, ?, ?, ?, ?)",
		            new Object[] {
		            		userBean.getEmployeeId(), userBean.getFirstName(), userBean.getLastName(), userBean.getEmailAdress(),
		            		userBean.getOfficePhone(),userBean.getMobile(),userBean.getDesignation(),userBean.getDepartment()
		            });
	}
	
	public int updateUser(UserBean userBean) {
        return jdbcTemplate.update("update addressbook " + " set FIRST_NAME = ?, LAST_NAME = ?, EMAIL_ADDRESS = ?, OFFICE_PHONE = ?, MOBILE = ?, DESIGNATION = ?, DEPARTMENT = ? " + " where EMPLOYEE_ID = ?",
            new Object[] {
            		userBean.getFirstName(), userBean.getLastName(), userBean.getEmailAdress(), userBean.getOfficePhone(),userBean.getMobile(),
            		userBean.getDesignation(),userBean.getDepartment(),
            		userBean.getEmployeeId()
            });
    }

	
	  public int deleteById(long id) {
	        return jdbcTemplate.update("delete from addressbook where EMPLOYEE_ID=?", new Object[] {
	            id
	        });
	    }
	  
	  public List<UserBean> listuserbyName(String firstName) {
			return jdbcTemplate.query("select * from addressbook where FIRST_NAME= '"+firstName+"'", new RowMapper<UserBean>() {
				 
				@Override
				public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
					UserBean userBean= new UserBean(
							rs.getString("FIRST_NAME"),
							rs.getString("LAST_NAME"),
							rs.getString("EMAIL_ADDRESS"),
							rs.getString("OFFICE_PHONE"),
							rs.getString("MOBILE"),
							rs.getString("DESIGNATION"),
							rs.getString("DEPARTMENT"),
							rs.getString("EMPLOYEE_ID")
							);
					return userBean;
				}
				
			 });
		}	
}



