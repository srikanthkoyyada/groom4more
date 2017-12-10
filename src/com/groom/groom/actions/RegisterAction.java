/*     */ package com.groom.actions;
/*     */ 
/*     */ import com.groom.bean.User;
/*     */ import com.groom.bean.UserActivation;
/*     */ import com.groom.service.UserService;
/*     */ import com.groom.service.impl.UserServiceImpl;
/*     */ import com.groom.util.GroomUtil;
/*     */ import com.opensymphony.xwork2.ActionSupport;
/*     */ import com.opensymphony.xwork2.ModelDriven;
/*     */ import com.opensymphony.xwork2.validator.annotations.EmailValidator;
/*     */ import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
/*     */ import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
/*     */ import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
/*     */ import org.apache.struts2.convention.annotation.Action;
/*     */ import org.apache.struts2.convention.annotation.Results;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Results({@org.apache.struts2.convention.annotation.Result(name="input", location="/jsp/registration.jsp"), @org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/welcome.jsp"), @org.apache.struts2.convention.annotation.Result(name="error", location="/jsp/registration.jsp")})
/*     */ public class RegisterAction
/*     */   extends ActionSupport
/*     */   implements ModelDriven<User>
/*     */ {
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
/*     */   private String standard;
/*     */   private String school;
/*     */   private String refText;
/*  39 */   User user = new User();
/*  40 */   UserService userService = new UserServiceImpl();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Action("user-registeration")
/*     */   public String execute()
/*     */     throws Exception
/*     */   {
/*  49 */     int userid = this.userService.registerUser(this.user);
/*  50 */     if (userid != 0) {
/*  51 */       UserActivation userActivation = new UserActivation();
/*  52 */       userActivation.setActivationKey(GroomUtil.getActivationCode());
/*  53 */       userActivation.setUserId(userid);
/*  54 */       if (this.userService.saveUserActivationRecord(userActivation)) {
/*  55 */         String from = "bojja@groom4more.com";
/*     */         
/*  57 */         String bodyText = GroomUtil.buidRegistrationMail(this.user, userActivation.getActivationKey());
/*  58 */         String mailTitle = "Registration at Dharshanth Technologies";
/*  59 */         GroomUtil.sendMail(from, this.user.getMail(), "Welome ", 
/*  60 */           bodyText, mailTitle);
/*  61 */         return "success";
/*     */       }
/*     */     } else {
/*  64 */       addActionError("There is a problem with user registration.Please try again later");
/*  65 */       return "error";
/*     */     }
/*  67 */     return null;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Username required")
/*     */   @RegexFieldValidator(message="should start with alphabet and only dot,underscore,dash are allowed", regex="^[a-zA-Z][a-zA-Z0-9._-]+$")
/*     */   @StringLengthFieldValidator(trim=true, minLength="8", maxLength="15", message="length shoulb be between 8 and 15")
/*     */   public String getUsername() {
/*  74 */     return this.username;
/*     */   }
/*     */   
/*     */   public void setUsername(String username) {
/*  78 */     this.username = username;
/*     */   }
/*     */   
/*     */   @StringLengthFieldValidator(maxLength="15", minLength="8", message="length shoulb be between 8 and 15", trim=false)
/*     */   @RequiredStringValidator(message="Enter Password")
/*     */   public String getPassword() {
/*  84 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/*  88 */     this.password = password;
/*     */   }
/*     */   
/*     */   public String getCpassword()
/*     */   {
/*  93 */     return this.cpassword;
/*     */   }
/*     */   
/*     */   public void setCpassword(String cpassword) {
/*  97 */     this.cpassword = cpassword;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="First Name required")
/*     */   @StringLengthFieldValidator(trim=true, minLength="3", maxLength="30", message="length shoulb be between 3 and 30")
/*     */   @RegexFieldValidator(message="only alphabets allowed", regex="^[a-zA-Z]+$")
/*     */   public String getFirstname() {
/* 104 */     return this.firstname;
/*     */   }
/*     */   
/*     */   public void setFirstname(String firstname) {
/* 108 */     this.firstname = firstname;
/*     */   }
/*     */   
/*     */   @StringLengthFieldValidator(trim=true, minLength="1", maxLength="15", message="length shoulb be between 1 and 15")
/*     */   @RegexFieldValidator(message="only alphabets allowed", regex="^[a-zA-Z]+$")
/*     */   public String getLastname()
/*     */   {
/* 115 */     return this.lastname;
/*     */   }
/*     */   
/*     */   public void setLastname(String lastname) {
/* 119 */     this.lastname = lastname;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Email required")
/*     */   @EmailValidator(message="invalid email")
/*     */   public String getMail() {
/* 125 */     return this.mail;
/*     */   }
/*     */   
/*     */   public void setMail(String mail) {
/* 129 */     this.mail = mail;
/*     */   }
/*     */   
/*     */   @StringLengthFieldValidator(maxLength="10", minLength="10", message="length shoulb be 10 only", trim=false)
/*     */   @RequiredStringValidator(message="Enter Moblie Number")
/*     */   @RegexFieldValidator(message="only numbers allowed", regex="^[0-9]+$")
/*     */   public String getMobile() {
/* 136 */     return this.mobile;
/*     */   }
/*     */   
/*     */   public void setMobile(String mobile) {
/* 140 */     this.mobile = mobile;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Select Country")
/*     */   public String getCountry() {
/* 145 */     return this.country;
/*     */   }
/*     */   
/*     */   public void setCountry(String country) {
/* 149 */     this.country = country;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Select State")
/*     */   public String getState() {
/* 154 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(String state) {
/* 158 */     this.state = state;
/*     */   }
/*     */   
/*     */   @StringLengthFieldValidator(minLength="3", message="enter atleast 3 letters", trim=false)
/*     */   @RequiredStringValidator(message="Enter City")
/*     */   @RegexFieldValidator(message="only alphabets allowed", regex="^[a-zA-Z]+$")
/*     */   public String getCity() {
/* 165 */     return this.city;
/*     */   }
/*     */   
/*     */   public void setCity(String city) {
/* 169 */     this.city = city;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Class studying required")
/*     */   public String getStandard() {
/* 174 */     return this.standard;
/*     */   }
/*     */   
/*     */   public void setStandard(String standard) {
/* 178 */     this.standard = standard;
/*     */   }
/*     */   
/*     */   @StringLengthFieldValidator(minLength="4", maxLength="30", message="school name length should be in between 4-30", trim=false)
/*     */   public String getSchool()
/*     */   {
/* 184 */     return this.school;
/*     */   }
/*     */   
/*     */   public void setSchool(String school) {
/* 188 */     this.school = school;
/*     */   }
/*     */   
/*     */ 
/*     */   public User getModel()
/*     */   {
/* 194 */     return this.user;
/*     */   }
/*     */   
/*     */   public String getRefText() {
/* 198 */     return this.refText;
/*     */   }
/*     */   
/*     */   public void setRefText(String refText) {
/* 202 */     this.refText = refText;
/*     */   }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\RegisterAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */