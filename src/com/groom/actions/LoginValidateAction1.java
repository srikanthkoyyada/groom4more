/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.bean.User;
/*    */ import com.groom.dao.UserDAO;
/*    */ import com.groom.dao.impl.UserDAOImpl;
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
/*    */ @ResultPath("/jsp")
/*    */ @Results({@org.apache.struts2.convention.annotation.Result(name="success", location="logged.jsp"), @org.apache.struts2.convention.annotation.Result(name="input", location="login.jsp"), @org.apache.struts2.convention.annotation.Result(name="error", location="login.jsp")})
/*    */ public class LoginValidateAction
/*    */   extends ActionSupport
/*    */   implements ModelDriven<User>, SessionAware
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String username;
/*    */   private String password;
/*    */   private SessionMap<String, Object> userSession;
/* 32 */   User user = new User();
/* 33 */   User userObject = new User();
/* 34 */   UserService userService = new UserServiceImpl();
/*    */   
/*    */   @Action("login-validate")
/*    */   public String execute() throws SQLException {
/* 38 */     if (this.userService.validateUser(this.user))
/*    */     {
/* 40 */       this.userObject = this.userService.getUserDetails(this.user.getUsername());
/* 41 */       UserDAO userDAO = new UserDAOImpl();
/* 42 */       userDAO.incLoginCount(this.user.getUsername());
/* 43 */       this.userSession.put("user", this.userObject);
/* 44 */       return "success";
/*    */     }
/*    */     
/*    */ 
/* 48 */     addActionError("Invalid Credentials");
/* 49 */     return "error";
/*    */   }
/*    */   
/*    */ 
/*    */   @RequiredStringValidator(message="Please enter your username.")
/*    */   public String getUsername()
/*    */   {
/* 56 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setUsername(String username) {
/* 60 */     this.username = username;
/*    */   }
/*    */   
/*    */   @RequiredStringValidator(message="Please enter your password.")
/*    */   public String getPassword() {
/* 65 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 69 */     this.password = password;
/*    */   }
/*    */   
/*    */   public User getModel() {
/* 73 */     return this.user;
/*    */   }
/*    */   
/*    */   public void setSession(Map<String, Object> map)
/*    */   {
/* 78 */     this.userSession = ((SessionMap)map);
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\LoginValidateAction1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */