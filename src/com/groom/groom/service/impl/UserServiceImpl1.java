/*    */ package com.groom.service.impl;
/*    */ 
/*    */ import com.groom.bean.User;
/*    */ import com.groom.bean.UserActivation;
/*    */ import com.groom.dao.UserDAO;
/*    */ import com.groom.dao.impl.UserDAOImpl;
/*    */ import com.groom.service.UserService;
/*    */ import java.sql.SQLException;
/*    */ 
/*    */ public class UserServiceImpl
/*    */   implements UserService
/*    */ {
/* 13 */   UserDAO dao = new UserDAOImpl();
/*    */   
/*    */   public boolean validateUser(User user) throws SQLException
/*    */   {
/* 17 */     return this.dao.validateUser(user);
/*    */   }
/*    */   
/*    */   public int registerUser(User user)
/*    */     throws SQLException
/*    */   {
/* 23 */     return this.dao.registerUser(user);
/*    */   }
/*    */   
/*    */   public String isUsernameAvailable(String username)
/*    */     throws SQLException
/*    */   {
/* 29 */     if (this.dao.isUsernameExist(username)) {
/* 30 */       return "NO";
/*    */     }
/* 32 */     return "YES";
/*    */   }
/*    */   
/*    */   public String isMailAvailable(String mail) throws SQLException
/*    */   {
/* 37 */     if (this.dao.isMailExist(mail)) {
/* 38 */       return "NO";
/*    */     }
/* 40 */     return "YES";
/*    */   }
/*    */   
/*    */   public String isPhoneNumberAvailable(String phone) throws SQLException
/*    */   {
/* 45 */     if (this.dao.isPhoneNumberExist(phone)) {
/* 46 */       return "NO";
/*    */     }
/* 48 */     return "YES";
/*    */   }
/*    */   
/*    */   public User getUserDetails(String username)
/*    */     throws SQLException
/*    */   {
/* 54 */     return this.dao.getUserDetails(username);
/*    */   }
/*    */   
/*    */   public User getUserForgotPwdDetails(String userNameMail)
/*    */     throws SQLException
/*    */   {
/* 60 */     return this.dao.getUserForgotPwdDetails(userNameMail);
/*    */   }
/*    */   
/*    */   public User getUserDetails(int userid)
/*    */     throws SQLException
/*    */   {
/* 66 */     return this.dao.getUserDetails(userid);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean saveUserActivationRecord(UserActivation userActivation)
/*    */     throws SQLException
/*    */   {
/* 73 */     return this.dao.saveUserActivationRecord(userActivation);
/*    */   }
/*    */   
/*    */   public boolean activateUser(String aCode)
/*    */     throws SQLException
/*    */   {
/* 79 */     return this.dao.activateUser(aCode);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean updateUserSubjectPoints(String subject, int userid, int points)
/*    */     throws SQLException
/*    */   {
/* 86 */     return this.dao.updateUserSubjectPoints(subject, userid, points);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean updateUserTotalPoints(int userid, int points)
/*    */     throws SQLException
/*    */   {
/* 93 */     return this.dao.updateUserTotalPoints(userid, points);
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\service\impl\UserServiceImpl1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */