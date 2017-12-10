/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.service.UserService;
/*    */ import com.groom.service.impl.UserServiceImpl;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.struts2.ServletActionContext;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ import org.apache.struts2.convention.annotation.ParentPackage;
/*    */ 
/*    */ 
/*    */ 
/*    */ @ParentPackage("json-default")
/*    */ public class CheckPhoneNUmberAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 18 */   HttpServletRequest request = ServletActionContext.getRequest();
/* 19 */   UserService userService = new UserServiceImpl();
/*    */   private String isPhoneNumberAvailable;
/*    */   
/*    */   public String getIsPhoneNumberAvailable() {
/* 23 */     return this.isPhoneNumberAvailable;
/*    */   }
/*    */   
/*    */   public void setIsPhoneNumberAvailable(String isPhoneNumberAvailable) {
/* 27 */     this.isPhoneNumberAvailable = isPhoneNumberAvailable;
/*    */   }
/*    */   
/*    */   @Action(value="checkPhone", results={@org.apache.struts2.convention.annotation.Result(name="success", type="json")})
/*    */   public String checkPhone() throws Exception
/*    */   {
/* 33 */     String phone = this.request.getParameter("phone");
/* 34 */     setIsPhoneNumberAvailable(this.userService.isPhoneNumberAvailable(phone));
/* 35 */     return "success";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\CheckPhoneNUmberAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */