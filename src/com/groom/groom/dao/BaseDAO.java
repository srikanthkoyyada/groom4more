/*    */ package com.groom.dao;
/*    */ 
/*    */ import javax.naming.Context;
/*    */ import javax.naming.NamingException;
/*    */ 
/*    */ public class BaseDAO
/*    */ {
/*    */   public static javax.sql.DataSource ds;
/*    */   
/*    */   static
/*    */   {
/*    */     try
/*    */     {
/* 14 */       Context initCtx = new javax.naming.InitialContext();
/* 15 */       Context envCtx = (Context)initCtx.lookup("java:comp/env");
/* 16 */       ds = (javax.sql.DataSource)envCtx.lookup("jdbc/mydb");
/*    */     }
/*    */     catch (NamingException e) {
/* 19 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\dao\BaseDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */