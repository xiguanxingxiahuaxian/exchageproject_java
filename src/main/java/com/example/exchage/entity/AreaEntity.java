package com.example.exchage.entity;

import javax.persistence.*;

@Table(name="tarea")
@Entity
public class AreaEntity {

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


	/**
	 * 是否有优惠  1打折 2不打折
	 */
	@Column(name = "dreduction")
	private String dreduction;

	@Column(name = "dpreprice")
	private String dpreprice;

	@Column(name = "dreductprice")
	private String dreductprice;

	public String getDselect() {
		return dselect;
	}

	public void setDselect(String dselect) {
		this.dselect = dselect;
	}

	public String getDreduction() {
		return dreduction;
	}

	public void setDreduction(String dreduction) {
		this.dreduction = dreduction;
	}

	public String getDpreprice() {
		return dpreprice;
	}

	public void setDpreprice(String dpreprice) {
		this.dpreprice = dpreprice;
	}

	public String getDreductprice() {
		return dreductprice;
	}

	public void setDreductprice(String dreductprice) {
		this.dreductprice = dreductprice;
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
