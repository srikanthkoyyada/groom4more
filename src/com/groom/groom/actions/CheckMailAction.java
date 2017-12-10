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
/*    */ public class CheckMailAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 18 */   HttpServletRequest request = ServletActionContext.getRequest();
/* 19 */   UserService userService = new UserServiceImpl();
/*    */   private String isMailAvailable;
/*    */   
/*    */   public String getIsMailAvailable() {
/* 23 */     return this.isMailAvailable;
/*    */   }
/*    */   
/*    */   public void setIsMailAvailable(String isMailAvailable) {
/* 27 */     this.isMailAvailable = isMailAvailable;
/*    */   }
/*    */   
/*    */   @Action(value="checkMail", results={@org.apache.struts2.convention.annotation.Result(name="success", type="json")})
/*    */   public String checkMail()
/*    */     throws Exception
/*    */   {
/* 34 */     String mail = this.request.getParameter("mail");
/* 35 */     setIsMailAvailable(this.userService.isMailAvailable(mail));
/* 36 */     return "success";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\CheckMailAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */