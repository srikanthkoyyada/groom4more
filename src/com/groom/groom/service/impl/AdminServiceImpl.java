/*    */ package com.groom.service.impl;
/*    */ 
/*    */ import com.groom.bean.QuizQuestionDetails;
/*    */ import com.groom.bean.Shine;
/*    */ import com.groom.dao.AdminDAO;
/*    */ import com.groom.dao.impl.AdminDAOImpl;
/*    */ import com.groom.service.AdminService;
/*    */ import java.sql.Date;
/*    */ import java.sql.SQLException;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ 
/*    */ public class AdminServiceImpl
/*    */   implements AdminService
/*    */ {
/* 16 */   AdminDAO dao = new AdminDAOImpl();
/*    */   
/*    */   public boolean addSubjectTopic(String subject, String topicName, int standard, Date testDate, int test_category_id, String test_by, int test_time)
/*    */     throws SQLException
/*    */   {
/* 21 */     return this.dao.addSubjectTopic(subject, topicName, standard, testDate, test_category_id, test_by, test_time);
/*    */   }
/*    */   
/*    */   public HashMap<Integer, String> getTopics(String subject)
/*    */     throws SQLException
/*    */   {
/* 27 */     return this.dao.getTopics(subject);
/*    */   }
/*    */   
/*    */   public HashMap<Integer, String> getTopicsByStandard(String subject, int standard, int division)
/*    */     throws SQLException
/*    */   {
/* 33 */     return this.dao.getTopicsByStandard(subject, standard, division);
/*    */   }
/*    */   
/*    */   public HashMap<String, String> getCategoryByStandard(int standard)
/*    */     throws SQLException
/*    */   {
/* 39 */     return this.dao.getCategoryByStandard(standard);
/*    */   }
/*    */   
/*    */   public int getMaxID(String subject)
/*    */     throws SQLException
/*    */   {
/* 45 */     return this.dao.getMaxID(subject);
/*    */   }
/*    */   
/*    */   public boolean saveQuestion(QuizQuestionDetails questionDetails, String subject, String user)
/*    */     throws SQLException
/*    */   {
/* 51 */     return this.dao.saveQuestion(questionDetails, subject, user);
/*    */   }
/*    */   
/*    */   public List<String> getShineResultNames() throws SQLException
/*    */   {
/* 56 */     return this.dao.getShineResultNames();
/*    */   }
/*    */   
/*    */   public Shine getUserResults(int standard, String school_code, String roll_number)
/*    */     throws SQLException
/*    */   {
/* 62 */     return this.dao.getUserResults(standard, school_code, roll_number);
/*    */   }
/*    */   
/*    */   public HashMap<Integer, String> getTestCategories()
/*    */     throws SQLException
/*    */   {
/* 68 */     return this.dao.getTestCategories();
/*    */   }
/*    */   
/*    */   public boolean validateAdmin(String username, String password) throws SQLException
/*    */   {
/* 73 */     return this.dao.validateAdmin(username, password);
/*    */   }
/*    */   
/*    */   public boolean updateQuestion(QuizQuestionDetails questionDetails, String subject, String user)
/*    */     throws SQLException
/*    */   {
/* 79 */     return this.dao.updateQuestion(questionDetails, subject, user);
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\service\impl\AdminServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */