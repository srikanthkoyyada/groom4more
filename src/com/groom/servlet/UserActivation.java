/*    */ package com.groom.servlet;
/*    */ 
/*    */ import com.groom.service.UserService;
/*    */ import com.groom.service.impl.UserServiceImpl;
/*    */ import java.io.IOException;
/*    */ import java.sql.SQLException;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
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
/*    */ public class UserActivation
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 30 */     String url = request.getRequestURI();
/* 31 */     String activatioCode = url.substring(url.lastIndexOf('/') + 1, url.length());
/*    */     
/* 33 */     UserService service = new UserServiceImpl();
/*    */     try {
/* 35 */       if (service.activateUser(activatioCode)) {
/* 36 */         response.sendRedirect(request.getContextPath() + "/activate");
/*    */       }
/*    */       else {
/* 39 */         response.sendRedirect(request.getContextPath() + "/invalid-activation");
/*    */       }
/*    */     }
/*    */     catch (SQLException e) {
/* 43 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {}
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\servlet\UserActivation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */