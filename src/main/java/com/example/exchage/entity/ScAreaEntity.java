package com.example.exchage.entity;

import javax.persistence.*;

@Table(name="tareasc")
@Entity
public class ScAreaEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name = "areaname")
	private String areaname;

	@Column(name = "dlatitude")
	private String dlatitude;

	@Column(name = "dlongtude")
	private String dlongtude;

	//门类
	@Column(name = "dselect")
	private String dselect;

	//门类
	@Column(name = "username")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDselect() {
		return dselect;
	}

	public void setDselect(String dselect) {
		this.dselect = dselect;
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

	public String getDlatitude() {
		return dlatitude;
	}

	public void setDlatitude(String dlatitude) {
		this.dlatitude = dlatitude;
	}

	public String getDlongtude() {
		return dlongtude;
	}

	public void setDlongtude(String dlongtude) {
		this.dlongtude = dlongtude;
	}
}
