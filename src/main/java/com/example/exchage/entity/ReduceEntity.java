package com.example.exchage.entity;

import javax.persistence.*;

@Table(name="dreduce")
@Entity
public class ReduceEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	/**
	 *  优惠的六个模块
	 */
	@Column(name = "dmoudle")
	private String dmoudle;
	/**
	 * 图片地址
	 */
	@Column(name = "dimgurl")
	private String dimgurl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDmoudle() {
		return dmoudle;
	}

	public void setDmoudle(String dmoudle) {
		this.dmoudle = dmoudle;
	}

	public String getDimgurl() {
		return dimgurl;
	}

	public void setDimgurl(String dimgurl) {
		this.dimgurl = dimgurl;
	}
}
