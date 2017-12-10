/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.bean.User;
/*    */ import com.groom.service.UserService;
/*    */ import com.groom.service.impl.UserServiceImpl;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import com.opensymphony.xwork2.ModelDriven;
/*    */ import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
/*    */ import java.sql.SQLException;
/*    */ import java.util.Map;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ import org.apache.struts2.convention.annotation.ResultPath;
/*    */ import org.apache.struts2.convention.annotation.Results;
/*    */ import org.apache.struts2.dispatcher.SessionMap;
/*    */ import org.apache.struts2.interceptor.SessionAware;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ResultPath("/jsp")
/*    */ @Results({@org.apache.struts2.convention.annotation.Result(name="input", location="login.jsp"), @org.apache.struts2.convention.annotation.Result(name="error", location="login.jsp"), @org.apache.struts2.convention.annotation.Result(name="success", location="/${redirectPage}/")})
/*    */ public class LoginValidateAction
/*    */   extends ActionSupport
/*    */   implements ModelDriven<User>, SessionAware
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String username;
/*    */   private String password;
/*    */   private String redirectPage;
/*    */   private SessionMap<String, Object> userSession;
/* 38 */   User user = new User();
/* 39 */   User userObject = new User();
/* 40 */   UserService userService = new UserServiceImpl();
/*    */   
/*    */   @Action("login-validate")
/*    */   public String execute() throws SQLException
/*    */   {
/* 45 */     if (this.userService.validateUser(this.user))
/*    */     {
/* 47 */       this.userObject = this.userService.getUserDetails(this.user.getUsername());
/*    */       
/* 49 */       this.userSession.put("user", this.userObject);
/* 50 */       return "success";
/*    */     }
/*    */     
/* 53 */     addActionError("Invalid Credentials");
/* 54 */     return "error";
/*    */   }
/*    */   
/*    */ 
/*    */   @RequiredStringValidator(message="Please enter your username.")
/*    */   public String getUsername()
/*    */   {
/* 61 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setUsername(String username) {
/* 65 */     this.username = username;
/*    */   }
/*    */   
/*    */   @RequiredStringValidator(message="Please enter your password.")
/*    */   public String getPassword() {
/* 70 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 74 */     this.password = password;
/*    */   }
/*    */   
/*    */   public User getModel() {
/* 78 */     return this.user;
/*    */   }
/*    */   
/*    */   public void setSession(Map<String, Object> map)
/*    */   {
/* 83 */     this.userSession = ((SessionMap)map);
/*    */   }
/*    */   
/*    */   public String getRedirectPage() {
/* 87 */     return this.redirectPage;
/*    */   }
/*    */   
/*    */   public void setRedirectPage(String redirectPage) {
/* 91 */     this.redirectPage = redirectPage;
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\LoginValidateAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */