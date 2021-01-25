package com.example.exchage.entity;

import javax.persistence.*;

@Table(name="dorder")
@Entity
public class OrdEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name = "areaname")
	private String areaname;

	@Column(name = "username")
	private String username;

	@Column(name = "dprice")
	private String dprce;

	@Column(name = "dtime")
	private String dtime;

	//下订单 取消订单 完成订单  修改时间
	@Column(name = "dorderstate")
	private String dorderstate;

	public String getDorderstate() {
		return dorderstate;
	}

	public void setDorderstate(String dorderstate) {
		this.dorderstate = dorderstate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDprce() {
		return dprce;
	}

	public void setDprce(String dprce) {
		this.dprce = dprce;
	}

	public String getDtime() {
		return dtime;
	}

	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
}
