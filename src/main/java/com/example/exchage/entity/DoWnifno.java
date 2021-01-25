package com.example.exchage.entity;

import javax.persistence.*;

/**
 * 动态的回复
 */
@Table(name="downinfo")
@Entity
public class DoWnifno {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "dmid")
    private int mid;

    @Column(name = "username")
    private String username;

    @Column(name = "dcomment")
    private String dcomment;

    @Column(name = "dtime")
    private String dtime;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDcomment() {
        return dcomment;
    }

    public void setDcomment(String dcomment) {
        this.dcomment = dcomment;
    }
}
