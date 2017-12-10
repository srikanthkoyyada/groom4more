/*    */ package com.groom.actions;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts2.ServletActionContext;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ 
/*    */ public class URLRedirectAction extends com.opensymphony.xwork2.ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   @Action(value="login", results={@org.apache.struts2.convention.annotation.Result(location="/jsp/login.jsp")})
/*    */   public String login() throws Exception
/*    */   {
/* 15 */     return "success";
/*    */   }
/*    */   
/*    */   @Action(value="register", results={@org.apache.struts2.convention.annotation.Result(location="/jsp/registration.jsp")})
/* 19 */   public String register() throws Exception { return "success"; }
/*    */   
/*    */   @Action(value="fgtpwd", results={@org.apache.struts2.convention.annotation.Result(location="/jsp/forgotpassword.jsp")})
/*    */   public String forgotPwd() throws Exception {
/* 23 */     return "success";
/*    */   }
/*    */   
/*    */   @Action(value="activate", results={@org.apache.struts2.convention.annotation.Result(location="/jsp/activation.jsp")})
/* 27 */   public String activateUser() throws Exception { return "success"; }
/*    */   
/*    */ 
/*    */   @Action(value="invalid-activation", results={@org.apache.struts2.convention.annotation.Result(location="/jsp/invalid-activation.jsp")})
/* 31 */   public String invalidUserActivation() throws Exception { return "success"; }
/*    */   
/*    */   @Action(value="admin", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/admin/admin-login.jsp"), @org.apache.struts2.convention.annotation.Result(name="error", location="/admin/admin-landing.jsp")})
/*    */   public String adminPage() throws Exception {
/* 35 */     if (ServletActionContext.getRequest().getSession().getAttribute("admin") != null) {
/* 36 */       return "error";
/*    */     }
/* 38 */     return "success";
/*    */   }
/*    */   
/*    */   @Action(value="submit-prodigy", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/prodigy/login.jsp"), @org.apache.struts2.convention.annotation.Result(name="error", location="/jsp/prodigy/prodigies-form.jsp")})
/* 42 */   public String submitUserProdigy() throws Exception { if (ServletActionContext.getRequest().getSession().getAttribute("user") != null) {
/* 43 */       return "error";
/*    */     }
/* 45 */     return "success";
/*    */   }
/*    */   
/*    */   @Action(value="add-test", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/admin/add-test.jsp"), @org.apache.struts2.convention.annotation.Result(name="error", location="/admin/admin-login.jsp")})
/*    */   public String addTest() throws Exception {
/* 50 */     if (ServletActionContext.getRequest().getSession().getAttribute("admin") != null) {
/* 51 */       return "success";
/*    */     }
/* 53 */     return "error";
/*    */   }
/*    */   
/*    */   @Action(value="admin-landing", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/admin/admin-landing.jsp"), @org.apache.struts2.convention.annotation.Result(name="error", location="/admin/admin-login.jsp")})
/* 57 */   public String addLanding() throws Exception { if (ServletActionContext.getRequest().getSession().getAttribute("admin") != null) {
/* 58 */       return "success";
/*    */     }
/* 60 */     return "error";
/*    */   }
/*    */   
/*    */   @Action(value="select-edit-test", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/admin/select-edit-test.jsp"), @org.apache.struts2.convention.annotation.Result(name="error", location="/admin/admin-login.jsp")})
/* 64 */   public String EditTest() throws Exception { if (ServletActionContext.getRequest().getSession().getAttribute("admin") != null) {
/* 65 */       return "success";
/*    */     }
/* 67 */     return "error";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\URLRedirectAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */