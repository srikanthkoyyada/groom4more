/*    */ package com.groom.service.impl;
/*    */ 
/*    */ import com.groom.dao.MiscDAO;
/*    */ import com.groom.dao.impl.MiscDAOImpl;
/*    */ import com.groom.service.MiscService;
/*    */ import java.sql.SQLException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MiscServiceImpl
/*    */   implements MiscService
/*    */ {
/* 14 */   MiscDAO dao = new MiscDAOImpl();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int addprodigy(String username, String teamname, String school, String teamdetails, String city, String email, String phone, String theme, String title, String idea)
/*    */     throws SQLException
/*    */   {
/* 22 */     return this.dao.addprodigy(username, teamname, school, teamdetails, city, email, phone, theme, title, idea);
/*    */   }
/*    */   
/*    */   public boolean voteProdigyEntry(String votinguser, int id)
/*    */     throws SQLException
/*    */   {
/* 28 */     return this.dao.voteProdigyEntry(votinguser, id);
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\service\impl\MiscServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */