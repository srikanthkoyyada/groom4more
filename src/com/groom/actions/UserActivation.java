/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.service.UserService;
/*    */ import com.groom.service.impl.UserServiceImpl;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.sql.SQLException;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ import org.apache.struts2.convention.annotation.ResultPath;
/*    */ import org.apache.struts2.convention.annotation.Results;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ResultPath("/jsp")
/*    */ @Results({@org.apache.struts2.convention.annotation.Result(name="success", location="activation.jsp"), @org.apache.struts2.convention.annotation.Result(name="error", location="invalid-activation.jsp")})
/*    */ public class UserActivation
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String acode;
/*    */   
/*    */   public String getAcode()
/*    */   {
/* 24 */     return this.acode;
/*    */   }
/*    */   
/*    */   public void setAcode(String acode) {
/* 28 */     this.acode = acode;
/*    */   }
/*    */   
/* 31 */   UserService userService = new UserServiceImpl();
/*    */   
/*    */   @Action("user-activation")
/*    */   public String execute() throws SQLException
/*    */   {
/* 36 */     if (this.userService.activateUser(getAcode())) {
/* 37 */       return "success";
/*    */     }
/*    */     
/* 40 */     return "error";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\UserActivation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */