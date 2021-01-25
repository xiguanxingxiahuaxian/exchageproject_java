package com.example.exchage.entity;

import javax.persistence.*;

@Table(name="dcomment")
@Entity
public class CommentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name = "areaname")
	private String areaname;

	@Column(name = "dcomment")
	private String dcomment;

	@Column(name = "dwho")
	private String dwho;

	@Column(name = "dtime")
	private String dtime;



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

	public String getDcomment() {
		return dcomment;
	}

	public void setDcomment(String dcomment) {
		this.dcomment = dcomment;
	}

	public String getDwho() {
		return dwho;
	}

	public void setDwho(String dwho) {
		this.dwho = dwho;
	}

	public String getDtime() {
		return dtime;
	}

	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
}
