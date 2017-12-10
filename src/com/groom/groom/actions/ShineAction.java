/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.service.AdminService;
/*    */ import com.groom.service.impl.AdminServiceImpl;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import org.apache.struts2.convention.annotation.Action;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Action(value="shine", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/shine-results.jsp")})
/*    */ public class ShineAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 26 */   AdminService adminService = new AdminServiceImpl();
/*    */   
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 32 */     return "success";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\ShineAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */