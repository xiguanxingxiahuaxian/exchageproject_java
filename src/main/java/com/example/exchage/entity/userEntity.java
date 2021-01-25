package com.example.exchage.entity;

import javax.persistence.*;
import java.io.Serializable;


@Table(name="user")
@Entity

public class userEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="username_")
	private String username_;

	@Column(name="pwd_")
	private String pwd_;

	@Column(name="status_")
	private String status_;

	@Column(name="describe_")
	private String describe_;

	@Column(name="type_")
	private String type_;

	@Column(name="tel")
	private String tel;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername_() {
		return username_;
	}

	public void setUsername_(String username_) {
		this.username_ = username_;
	}

	public String getPwd_() {
		return pwd_;
	}

	public void setPwd_(String pwd_) {
		this.pwd_ = pwd_;
	}

	public String getStatus_() {
		return status_;
	}

	public void setStatus_(String status_) {
		this.status_ = status_;
	}

	public String getDescribe_() {
		return describe_;
	}

	public void setDescribe_(String describe_) {
		this.describe_ = describe_;
	}

	public String getType_() {
		return type_;
	}

	public void setType_(String type_) {
		this.type_ = type_;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
