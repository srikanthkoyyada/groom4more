/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.sql.SQLException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts2.ServletActionContext;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ import org.apache.struts2.convention.annotation.Results;
/*    */ 
/*    */ 
/*    */ @Results({@org.apache.struts2.convention.annotation.Result(name="success", location="/index.jsp")})
/*    */ public class LogoutAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   @Action("logout")
/*    */   public String execute()
/*    */     throws SQLException
/*    */   {
/* 22 */     HttpSession session = ServletActionContext.getRequest().getSession(
/* 23 */       false);
/* 24 */     if ((session != null) && (session.getAttribute("user") != null)) {
/* 25 */       session.invalidate();
/*    */     }
/* 27 */     return "success";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\LogoutAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */