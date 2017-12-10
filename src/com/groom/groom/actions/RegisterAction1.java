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
/*  38 */   User user = new User();
/*  39 */   UserService userService = new UserServiceImpl();
/*     */   
/*     */   public void validate() {
/*  42 */     if (!this.user.getPassword().equals(this.user.getCpassword()))
/*  43 */       addActionError("Password Mismatch");
/*     */   }
/*     */   
/*     */   @Action("user-registeration")
/*     */   public String execute() throws Exception {
/*  48 */     int userid = this.userService.registerUser(this.user);
/*  49 */     if (userid != 0) {
/*  50 */       UserActivation userActivation = new UserActivation();
/*  51 */       userActivation.setActivationKey(GroomUtil.getActivationCode());
/*  52 */       userActivation.setUserId(userid);
/*  53 */       if (this.userService.saveUserActivationRecord(userActivation)) {
/*  54 */         String from = "bojja@groom4jee.com";
/*     */         
/*  56 */         String bodyText = GroomUtil.buidRegistrationMail(this.user, userActivation.getActivationKey());
/*  57 */         String mailTitle = "Groom4jee Registration";
/*  58 */         GroomUtil.sendMail(from, this.user.getMail(), "Welome to Groom4jee", 
/*  59 */           bodyText, mailTitle);
/*  60 */         return "success";
/*     */       }
/*     */     } else {
/*  63 */       addActionError("There is a problem with user registration.Please try again later");
/*  64 */       return "error";
/*     */     }
/*  66 */     return null;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Username required")
/*     */   @RegexFieldValidator(message="should start with alphabet and only dot,underscore,dash are allowed", regex="^[a-zA-Z][a-zA-Z0-9._-]+$")
/*     */   @StringLengthFieldValidator(trim=true, minLength="8", maxLength="15", message="length shoulb be between 8 and 15")
/*     */   public String getUsername() {
/*  73 */     return this.username;
/*     */   }
/*     */   
/*     */   public void setUsername(String username) {
/*  77 */     this.username = username;
/*     */   }
/*     */   
/*     */   @StringLengthFieldValidator(maxLength="15", minLength="8", message="length shoulb be between 8 and 15", trim=false)
/*     */   @RequiredStringValidator(message="Enter Password")
/*     */   public String getPassword() {
/*  83 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/*  87 */     this.password = password;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Enter Confirm Password")
/*     */   public String getCpassword() {
/*  92 */     return this.cpassword;
/*     */   }
/*     */   
/*     */   public void setCpassword(String cpassword) {
/*  96 */     this.cpassword = cpassword;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="First Name required")
/*     */   @StringLengthFieldValidator(trim=true, minLength="3", maxLength="30", message="length shoulb be between 3 and 30")
/*     */   @RegexFieldValidator(message="only alphabets allowed", regex="^[a-zA-Z]+$")
/*     */   public String getFirstname() {
/* 103 */     return this.firstname;
/*     */   }
/*     */   
/*     */   public void setFirstname(String firstname) {
/* 107 */     this.firstname = firstname;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Last Name required")
/*     */   @StringLengthFieldValidator(trim=true, minLength="1", maxLength="15", message="length shoulb be between 1 and 15")
/*     */   @RegexFieldValidator(message="only alphabets allowed", regex="^[a-zA-Z]+$")
/*     */   public String getLastname() {
/* 114 */     return this.lastname;
/*     */   }
/*     */   
/*     */   public void setLastname(String lastname) {
/* 118 */     this.lastname = lastname;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Email required")
/*     */   @EmailValidator(message="invalid email")
/*     */   public String getMail() {
/* 124 */     return this.mail;
/*     */   }
/*     */   
/*     */   public void setMail(String mail) {
/* 128 */     this.mail = mail;
/*     */   }
/*     */   
/*     */   @StringLengthFieldValidator(maxLength="10", minLength="10", message="length shoulb be 10 only", trim=false)
/*     */   @RequiredStringValidator(message="Enter Moblie Number")
/*     */   @RegexFieldValidator(message="only numbers allowed", regex="^[0-9]+$")
/*     */   public String getMobile() {
/* 135 */     return this.mobile;
/*     */   }
/*     */   
/*     */   public void setMobile(String mobile) {
/* 139 */     this.mobile = mobile;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Select Country")
/*     */   public String getCountry() {
/* 144 */     return this.country;
/*     */   }
/*     */   
/*     */   public void setCountry(String country) {
/* 148 */     this.country = country;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Select State")
/*     */   public String getState() {
/* 153 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(String state) {
/* 157 */     this.state = state;
/*     */   }
/*     */   
/*     */   @StringLengthFieldValidator(minLength="3", message="enter atleast 3 letters", trim=false)
/*     */   @RequiredStringValidator(message="Enter City")
/*     */   @RegexFieldValidator(message="only alphabets allowed", regex="^[a-zA-Z]+$")
/*     */   public String getCity() {
/* 164 */     return this.city;
/*     */   }
/*     */   
/*     */   public void setCity(String city) {
/* 168 */     this.city = city;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Class studying required")
/*     */   public String getStandard() {
/* 173 */     return this.standard;
/*     */   }
/*     */   
/*     */   public void setStandard(String standard) {
/* 177 */     this.standard = standard;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Enter your school name")
/*     */   @StringLengthFieldValidator(minLength="4", maxLength="30", message="school name length should be in between 4-30", trim=false)
/*     */   public String getSchool() {
/* 183 */     return this.school;
/*     */   }
/*     */   
/*     */   public void setSchool(String school) {
/* 187 */     this.school = school;
/*     */   }
/*     */   
/*     */ 
/*     */   public User getModel()
/*     */   {
/* 193 */     return this.user;
/*     */   }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\RegisterAction1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */