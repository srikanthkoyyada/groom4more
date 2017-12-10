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
/*    */ @ResultPath("/jsp/prodigy")
/*    */ @Results({@org.apache.struts2.convention.annotation.Result(name="success", location="prodigies-form.jsp"), @org.apache.struts2.convention.annotation.Result(name="input", location="login.jsp"), @org.apache.struts2.convention.annotation.Result(name="error", location="login.jsp")})
/*    */ public class ProdigyLoginValidateAction
/*    */   extends ActionSupport
/*    */   implements ModelDriven<User>, SessionAware
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String username;
/*    */   private String password;
/*    */   private SessionMap<String, Object> userSession;
/* 30 */   User user = new User();
/* 31 */   User userObject = new User();
/* 32 */   UserService userService = new UserServiceImpl();
/*    */   
/*    */   @Action("prodigylogin-validate")
/*    */   public String execute() throws SQLException {
/* 36 */     if (this.userService.validateUser(this.user))
/*    */     {
/* 38 */       this.userObject = this.userService.getUserDetails(this.user.getUsername());
/*    */       
/* 40 */       this.userSession.put("user", this.userObject);
/* 41 */       return "success";
/*    */     }
/*    */     
/* 44 */     addActionError("Invalid Credentials");
/* 45 */     return "error";
/*    */   }
/*    */   
/*    */ 
/*    */   @RequiredStringValidator(message="Please enter your username.")
/*    */   public String getUsername()
/*    */   {
/* 52 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setUsername(String username) {
/* 56 */     this.username = username;
/*    */   }
/*    */   
/*    */   @RequiredStringValidator(message="Please enter your password.")
/*    */   public String getPassword() {
/* 61 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 65 */     this.password = password;
/*    */   }
/*    */   
/*    */   public User getModel() {
/* 69 */     return this.user;
/*    */   }
/*    */   
/*    */   public void setSession(Map<String, Object> map)
/*    */   {
/* 74 */     this.userSession = ((SessionMap)map);
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\ProdigyLoginValidateAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */