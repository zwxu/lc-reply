package com.ustc.zwxu.lc.reply.web.view;

import java.io.Serializable;

public class DbUser implements Serializable{

    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.id
	 * @mbggenerated  Fri Apr 22 16:35:49 CST 2016
	 */
	private Integer id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.username
	 * @mbggenerated  Fri Apr 22 16:35:49 CST 2016
	 */
	private String username;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.count
	 * @mbggenerated  Fri Apr 22 16:35:49 CST 2016
	 */
	private Integer count;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.password
	 * @mbggenerated  Fri Apr 22 16:35:49 CST 2016
	 */
	private String password;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.access
	 * @mbggenerated  Fri Apr 22 16:35:49 CST 2016
	 */
	private Integer access;


	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.id
	 * @return  the value of user.id
	 * @mbggenerated  Fri Apr 22 16:35:49 CST 2016
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.id
	 * @param id  the value for user.id
	 * @mbggenerated  Fri Apr 22 16:35:49 CST 2016
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.username
	 * @return  the value of user.username
	 * @mbggenerated  Fri Apr 22 16:35:49 CST 2016
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.username
	 * @param username  the value for user.username
	 * @mbggenerated  Fri Apr 22 16:35:49 CST 2016
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.count
	 * @return  the value of user.count
	 * @mbggenerated  Fri Apr 22 16:35:49 CST 2016
	 */
	public Integer getCount() {
		return count;
	}


	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.count
	 * @param count  the value for user.count
	 * @mbggenerated  Fri Apr 22 16:35:49 CST 2016
	 */
	public void setCount(Integer count) {
		this.count = count;
	}


	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.password
	 * @return  the value of user.password
	 * @mbggenerated  Fri Apr 22 16:35:49 CST 2016
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.password
	 * @param password  the value for user.password
	 * @mbggenerated  Fri Apr 22 16:35:49 CST 2016
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.access
	 * @return  the value of user.access
	 * @mbggenerated  Fri Apr 22 16:35:49 CST 2016
	 */
	public Integer getAccess() {
		return access;
	}


	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.access
	 * @param access  the value for user.access
	 * @mbggenerated  Fri Apr 22 16:35:49 CST 2016
	 */
	public void setAccess(Integer access) {
		this.access = access;
	}


	

	
}