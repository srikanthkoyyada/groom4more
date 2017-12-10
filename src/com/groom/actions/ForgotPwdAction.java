/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.bean.User;
/*    */ import com.groom.service.UserService;
/*    */ import com.groom.service.impl.UserServiceImpl;
/*    */ import com.groom.util.GroomUtil;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ import org.apache.struts2.convention.annotation.ParentPackage;
/*    */ 
/*    */ 
/*    */ 
/*    */ @ParentPackage("json-default")
/*    */ public class ForgotPwdAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String forgotpwdinput;
/*    */   private String forgotpwdStstus;
/* 21 */   UserService userService = new UserServiceImpl();
/*    */   
/*    */ 
/*    */   @Action(value="forgot-pwd", results={@org.apache.struts2.convention.annotation.Result(name="success", type="json"), @org.apache.struts2.convention.annotation.Result(name="input", location="/jsp/forgotpassword.jsp")})
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 28 */     User user = this.userService.getUserForgotPwdDetails(getForgotpwdinput());
/* 29 */     if (user.getMail() != null) {
/* 30 */       String mailBody = GroomUtil.buidForgotPwdMail(user.getPassword());
/* 31 */       boolean isMailSent = GroomUtil.sendMail("bojja@groom4more.com", user.getMail(), 
/* 32 */         "Password for Groom4More Account", mailBody, 
/* 33 */         "Groom4More Password");
/* 34 */       if (isMailSent)
/* 35 */         setForgotpwdStstus("Password sent to your mail");
/*    */     } else {
/* 37 */       setForgotpwdStstus("Invalid or Email/Username not registered with us"); }
/* 38 */     return "success";
/*    */   }
/*    */   
/*    */   @RequiredStringValidator(message="Please enter your username/mail.")
/*    */   public String getForgotpwdinput()
/*    */   {
/* 44 */     return this.forgotpwdinput;
/*    */   }
/*    */   
/*    */   public void setForgotpwdinput(String forgotpwdinput) {
/* 48 */     this.forgotpwdinput = forgotpwdinput;
/*    */   }
/*    */   
/*    */   public String getForgotpwdStstus() {
/* 52 */     return this.forgotpwdStstus;
/*    */   }
/*    */   
/*    */   public void setForgotpwdStstus(String forgotpwdStstus) {
/* 56 */     this.forgotpwdStstus = forgotpwdStstus;
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\ForgotPwdAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */