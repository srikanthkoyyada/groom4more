/*    */ package com.groom.interceptor;
/*    */ 
/*    */ import com.groom.bean.User;
/*    */ import com.opensymphony.xwork2.ActionContext;
/*    */ import com.opensymphony.xwork2.ActionInvocation;
/*    */ import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.struts2.ServletActionContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoginInterceptor
/*    */   extends AbstractInterceptor
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public String intercept(ActionInvocation invocation)
/*    */     throws Exception
/*    */   {
/* 23 */     Map<String, Object> session = invocation.getInvocationContext()
/* 24 */       .getSession();
/* 25 */     String actionName = invocation.getInvocationContext().getName();
/* 26 */     HttpServletRequest request = ServletActionContext.getRequest();
/* 27 */     String queryString = request.getQueryString();
/* 28 */     session.put("savedUrl", actionName + (
/* 29 */       queryString == null ? "" : new StringBuilder("?").append(queryString).toString()));
/*    */     
/* 31 */     User user = (User)session.get("user");
/*    */     
/* 33 */     if (user == null)
/*    */     {
/* 35 */       return "login";
/*    */     }
/* 37 */     return invocation.invoke();
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\interceptor\LoginInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */