package com.example.exchage.entity;

import javax.persistence.*;

/**
 * 发表的动态
 */
@Table(name="dmessage")
@Entity
public class DMessage {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "ownmessage")
    private String ownmessage;

    @Column(name = "dresponse")
    private String dresponse;

    @Column(name = "dtime")
    private String dtime;


  /*  private List<DoWnifno> dresponsecontent;

    public List<DoWnifno> getDresponsecontent() {
        return dresponsecontent;
    }

    public void setDresponsecontent(List<DoWnifno> dresponsecontent) {
        this.dresponsecontent = dresponsecontent;
    }
*/
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

    public String getOwnmessage() {
        return ownmessage;
    }

    public void setOwnmessage(String ownmessage) {
        this.ownmessage = ownmessage;
    }

    public String getDresponse() {
        return dresponse;
    }

    public void setDresponse(String dresponse) {
        this.dresponse = dresponse;
    }

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime;
    }
}
