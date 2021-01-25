package com.example.exchage.entity;

import javax.persistence.*;

@Table(name="dimage")
@Entity
public class ImageEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name = "areaname")
	private String areaname;

	@Column(name = "dimageurl")
	private String dimageurl;

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

	public String getDimageurl() {
		return dimageurl;
	}

	public void setDimageurl(String dimageurl) {
		this.dimageurl = dimageurl;
	}
}
