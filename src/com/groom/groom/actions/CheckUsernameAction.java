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
/*    */ public class CheckUsernameAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 18 */   HttpServletRequest request = ServletActionContext.getRequest();
/* 19 */   UserService userService = new UserServiceImpl();
/*    */   private String isUsernameAvailable;
/*    */   
/*    */   public String getIsUsernameAvailable() {
/* 23 */     return this.isUsernameAvailable;
/*    */   }
/*    */   
/*    */   public void setIsUsernameAvailable(String isUsernameAvailable) {
/* 27 */     this.isUsernameAvailable = isUsernameAvailable;
/*    */   }
/*    */   
/*    */   @Action(value="checkUsername", results={@org.apache.struts2.convention.annotation.Result(name="success", type="json")})
/*    */   public String checkUsername() throws Exception {
/* 32 */     String username = this.request.getParameter("username");
/* 33 */     setIsUsernameAvailable(this.userService.isUsernameAvailable(username));
/* 34 */     return "success";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\CheckUsernameAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */