/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.service.AdminService;
/*    */ import com.groom.service.impl.AdminServiceImpl;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
/*    */ import java.sql.SQLException;
/*    */ import java.util.HashMap;
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
/*    */ @ResultPath("/admin")
/*    */ @Results({@org.apache.struts2.convention.annotation.Result(name="success", location="admin-landing.jsp"), @org.apache.struts2.convention.annotation.Result(name="input", location="admin-login.jsp"), @org.apache.struts2.convention.annotation.Result(name="error", location="admin-login.jsp")})
/*    */ public class AdminLoginValidateAction
/*    */   extends ActionSupport
/*    */   implements SessionAware
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String username;
/*    */   private String password;
/*    */   private SessionMap<String, Object> adminSession;
/*    */   private HashMap<Integer, String> category;
/* 31 */   AdminService adminService = new AdminServiceImpl();
/*    */   
/*    */   @Action("admin-login-validate")
/*    */   public String execute() throws SQLException {
/* 35 */     if (this.adminSession.get("admin") != null) {
/* 36 */       setCategory(this.adminService.getTestCategories());
/*    */       
/* 38 */       return "success";
/*    */     }
/* 40 */     if (this.adminService.validateAdmin(getUsername(), getPassword())) {
/* 41 */       setCategory(this.adminService.getTestCategories());
/* 42 */       this.adminSession.put("admin", getUsername());
/* 43 */       return "success";
/*    */     }
/* 45 */     addActionError("Invalid Credentials");
/* 46 */     return "error";
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public HashMap<Integer, String> getCategory()
/*    */   {
/* 55 */     return this.category;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setCategory(HashMap<Integer, String> category)
/*    */   {
/* 61 */     this.category = category;
/*    */   }
/*    */   
/*    */ 
/*    */   @RequiredStringValidator(message="Please enter your username.")
/*    */   public String getUsername()
/*    */   {
/* 68 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setUsername(String username) {
/* 72 */     this.username = username;
/*    */   }
/*    */   
/*    */   @RequiredStringValidator(message="Please enter your password.")
/*    */   public String getPassword() {
/* 77 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 81 */     this.password = password;
/*    */   }
/*    */   
/*    */   public void setSession(Map<String, Object> map)
/*    */   {
/* 86 */     this.adminSession = ((SessionMap)map);
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\AdminLoginValidateAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */