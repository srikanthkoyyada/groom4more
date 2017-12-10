/*     */ package com.groom.actions;
/*     */ 
/*     */ import com.groom.bean.User;
/*     */ import com.groom.dao.AdminDAO;
/*     */ import com.groom.dao.impl.AdminDAOImpl;
/*     */ import com.groom.service.UserService;
/*     */ import com.groom.service.impl.UserServiceImpl;
/*     */ import com.opensymphony.xwork2.ActionSupport;
/*     */ import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
/*     */ import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
/*     */ import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
/*     */ import java.io.PrintStream;
/*     */ import org.apache.struts2.convention.annotation.Action;
/*     */ import org.apache.struts2.convention.annotation.Results;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Results({@org.apache.struts2.convention.annotation.Result(name="input", location="/admin/uploadVideo.jsp"), @org.apache.struts2.convention.annotation.Result(name="success", location="/admin/success.jsp"), @org.apache.struts2.convention.annotation.Result(name="error", location="/admin/uploadVideo.jsp")})
/*     */ public class uploadVideoAction
/*     */   extends ActionSupport
/*     */ {
/*     */   private int standard;
/*     */   private String subject;
/*     */   private String title;
/*     */   private String description;
/*     */   private String url;
/*  34 */   User user = new User();
/*  35 */   UserService userService = new UserServiceImpl();
/*     */   
/*     */   @Action("uploadVideo")
/*     */   public String execute() throws Exception
/*     */   {
/*  40 */     AdminDAO adminDAO = new AdminDAOImpl();
/*  41 */     if (adminDAO.saveVideoURL(this.standard, this.subject, this.title, this.description, this.url)) {
/*  42 */       System.out.println("Action : " + this.url);
/*  43 */       return "success";
/*     */     }
/*     */     
/*  46 */     addActionError("There is a problem with submission. Please try again later");
/*  47 */     return "error";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequiredFieldValidator(message="Standard Required")
/*     */   public int getStandard()
/*     */   {
/*  55 */     return this.standard;
/*     */   }
/*     */   
/*     */   public void setStandard(int standard) {
/*  59 */     this.standard = standard;
/*     */   }
/*     */   
/*     */ 
/*     */   @RequiredStringValidator(message="Subject Required")
/*     */   public String getSubject()
/*     */   {
/*  66 */     return this.subject;
/*     */   }
/*     */   
/*     */   public void setSubject(String subject) {
/*  70 */     this.subject = subject;
/*     */   }
/*     */   
/*     */   @StringLengthFieldValidator(maxLength="250", minLength="20", message="length shoulb be between 250 and 20", trim=false)
/*     */   @RequiredStringValidator(message=" Description Required")
/*     */   public String getDescription() {
/*  76 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/*  80 */     this.description = description;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Video URL Required")
/*     */   public String getUrl()
/*     */   {
/*  86 */     return this.url;
/*     */   }
/*     */   
/*     */   @StringLengthFieldValidator(maxLength="50", minLength="5", message="length shoulb be between 50 and 5", trim=false)
/*     */   @RequiredStringValidator(message="Tile Required")
/*     */   public void setUrl(String url) {
/*  92 */     this.url = url;
/*     */   }
/*     */   
/*     */   public String getTitle() {
/*  96 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/* 100 */     this.title = title;
/*     */   }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\uploadVideoAction1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */