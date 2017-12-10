/*     */ package com.groom.bean;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.sql.Date;
/*     */ 
/*     */ 
/*     */ public class User
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private int userId;
/*     */   private String username;
/*     */   private String password;
/*     */   private String cpassword;
/*     */   private String firstname;
/*     */   private String lastname;
/*     */   private String mail;
/*     */   private String mobile;
/*     */   private String country;
/*     */   private String state;
/*     */   private String city;
/*     */   private Date date_registered;
/*     */   private String standard;
/*     */   private String school;
/*     */   private String refText;
/*     */   
/*     */   public String getStandard()
/*     */   {
/*  29 */     return this.standard;
/*     */   }
/*     */   
/*     */   public void setStandard(String standard) {
/*  33 */     this.standard = standard;
/*     */   }
/*     */   
/*     */   public String getSchool() {
/*  37 */     return this.school;
/*     */   }
/*     */   
/*     */   public void setSchool(String school) {
/*  41 */     this.school = school;
/*     */   }
/*     */   
/*     */   public Date getDate_registered() {
/*  45 */     return this.date_registered;
/*     */   }
/*     */   
/*     */   public void setDate_registered(Date date_registered) {
/*  49 */     this.date_registered = date_registered;
/*     */   }
/*     */   
/*     */   public int getUserId() {
/*  53 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(int userId) {
/*  57 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public String getUsername() {
/*  61 */     return this.username;
/*     */   }
/*     */   
/*     */   public void setUsername(String username) {
/*  65 */     this.username = username;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/*  69 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/*  73 */     this.password = password;
/*     */   }
/*     */   
/*     */   public String getCpassword() {
/*  77 */     return this.cpassword;
/*     */   }
/*     */   
/*     */   public void setCpassword(String cpassword) {
/*  81 */     this.cpassword = cpassword;
/*     */   }
/*     */   
/*     */   public String getFirstname() {
/*  85 */     return this.firstname;
/*     */   }
/*     */   
/*     */   public void setFirstname(String firstname) {
/*  89 */     this.firstname = firstname;
/*     */   }
/*     */   
/*     */   public String getLastname() {
/*  93 */     return this.lastname;
/*     */   }
/*     */   
/*     */   public void setLastname(String lastname) {
/*  97 */     this.lastname = lastname;
/*     */   }
/*     */   
/*     */   public String getMail() {
/* 101 */     return this.mail;
/*     */   }
/*     */   
/*     */   public void setMail(String mail) {
/* 105 */     this.mail = mail;
/*     */   }
/*     */   
/*     */   public String getMobile() {
/* 109 */     return this.mobile;
/*     */   }
/*     */   
/*     */   public void setMobile(String mobile) {
/* 113 */     this.mobile = mobile;
/*     */   }
/*     */   
/*     */   public String getCountry() {
/* 117 */     return this.country;
/*     */   }
/*     */   
/*     */   public void setCountry(String country) {
/* 121 */     this.country = country;
/*     */   }
/*     */   
/*     */   public String getState() {
/* 125 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(String state) {
/* 129 */     this.state = state;
/*     */   }
/*     */   
/*     */   public String getCity() {
/* 133 */     return this.city;
/*     */   }
/*     */   
/*     */   public void setCity(String city) {
/* 137 */     this.city = city;
/*     */   }
/*     */   
/*     */   public String getRefText() {
/* 141 */     return this.refText;
/*     */   }
/*     */   
/*     */   public void setRefText(String refText) {
/* 145 */     this.refText = refText;
/*     */   }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\bean\User.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */