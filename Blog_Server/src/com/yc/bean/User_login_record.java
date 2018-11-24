package com.yc.bean;

import java.sql.Timestamp;

public class User_login_record {
     private Long id;
     private Long userId;
     private String loginIp;
     private Timestamp time;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "User_login_record [id=" + id + ", userId=" + userId + ", loginIp=" + loginIp + ", time=" + time + "]";
	}
	public User_login_record(Long id, Long userId, String loginIp, Timestamp time) {
		super();
		this.id = id;
		this.userId = userId;
		this.loginIp = loginIp;
		this.time = time;
	}
}
