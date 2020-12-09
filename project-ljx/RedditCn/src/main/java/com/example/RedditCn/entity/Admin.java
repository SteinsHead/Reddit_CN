package com.example.RedditCn.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 管理员实体类
 * **/
@Entity
@EntityListeners(AuditingEntityListener.class)

public class Admin {
    //用户id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("adminId")
    @Column(name = "aid")
    private int aid;

    //用户名
    @JsonProperty("adminName")
    @Column(name = "aname")
    private String aname;

    //账号
    @JsonProperty("adminAccount")
    @Column(name = "aaccount")
    private String aaccount;

    //用户密码
    @JsonIgnore
    @Column(name = "adminPassword")
    private String apassword;

    //用户手机号
    @JsonIgnore
    @Column(name = "adminPhone")
    private String aphone;

    //用户邮箱
    @JsonIgnore
    @Column(name = "adminemail")
    private String aemail;

    //用户许可
    @JsonProperty("adminPermission")
    @Column(name = "apermission")
    private String apermission;

    //头像
    @JsonProperty("adminPhoto")
    @Column(name = "aphoto")
    private String aphoto;

    protected Admin() {

    }

    public Admin(String aName, String aAccount, String aPassword, String aPhoto) {
        this.aname = aName;
        this.aaccount = aAccount;
        this.apassword = aPassword;
        this.aphoto = aPhoto;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<String, Object>());
        jsonObject.put("aId", aid);
        jsonObject.put("aName", aname);
        jsonObject.put("aAccount", aaccount);
        jsonObject.put("aPermission", apermission);
        jsonObject.put("aPhoto", aphoto);
        return jsonObject.toJSONString();
    }

    public String toString(String jsonName, Object jsonString) {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<String, Object>());
        jsonObject.put("aId", aid);
        jsonObject.put("aName", aname);
        jsonObject.put("aAccount", aaccount);
        jsonObject.put("aPermission", apermission);
        jsonObject.put("aPhoto", aphoto);
        jsonObject.put(jsonName, jsonString);
        return jsonObject.toJSONString();
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getUname() {
        return aname;
    }

    public void setUname(String aname) {
        this.aname = aname;
    }

    public String getAaccount() {
        return aaccount;
    }

    public void setAaccount(String uaccount) { this.aaccount = aaccount; }

    public String getUpassword() {
        return apassword;
    }

    public void setApassword(String upassword) {
        this.apassword = upassword;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public String getAemail() { return aemail; }

    public void setAemail(String aemail) { this.aemail = aemail; }

    public String getApermission() {
        return apermission;
    }

    public void setApermission(String apermission) {
        this.apermission = apermission;
    }

    public String getAphoto() {
        return aphoto;
    }

    public void setAphoto(String aphoto) {
        this.aphoto = aphoto;
    }

}
