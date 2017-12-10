/*     */ package com.groom.service.impl;
/*     */ 
/*     */ import com.groom.bean.QuizPoints;
/*     */ import com.groom.bean.QuizQuestionDetails;
/*     */ import com.groom.bean.SubjectAnalysisBean;
/*     */ import com.groom.bean.TestsTopicList;
/*     */ import com.groom.bean.UserRankBean;
/*     */ import com.groom.dao.QuizDAO;
/*     */ import com.groom.dao.impl.QuizDAOImpl;
/*     */ import com.groom.service.QuizService;
/*     */ import java.sql.SQLException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class QuizServiceImpl
/*     */   implements QuizService
/*     */ {
/*  18 */   QuizDAO dao = new QuizDAOImpl();
/*     */   
/*     */ 
/*     */   public List<QuizQuestionDetails> getQuizDetails(String category, int topicid)
/*     */     throws SQLException
/*     */   {
/*  24 */     return this.dao.getQuizDetails(category, topicid);
/*     */   }
/*     */   
/*     */ 
/*     */   public Map<Integer, String> getQuizAnswers(String questionIds, String category)
/*     */     throws SQLException
/*     */   {
/*  31 */     return this.dao.getQuizAnswers(questionIds, category);
/*     */   }
/*     */   
/*     */   public boolean saveQuizPoints(QuizPoints quizPoints)
/*     */     throws SQLException
/*     */   {
/*  37 */     return this.dao.saveQuizPoints(quizPoints);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean getTestsAttemptedByUserStaus(int userid, String category)
/*     */     throws SQLException
/*     */   {
/*  44 */     return this.dao.getTestsAttemptedByUserStaus(userid, category);
/*     */   }
/*     */   
/*     */   public List<TestsTopicList> getTestTopics(int userid, String category, int standard, int test_category_id)
/*     */     throws SQLException
/*     */   {
/*  50 */     return this.dao.getTestTopics(userid, category, standard, test_category_id);
/*     */   }
/*     */   
/*     */   public boolean incrementQuestionsAttemptedCount(List<Integer> qids, String category)
/*     */     throws SQLException
/*     */   {
/*  56 */     return this.dao.incrementQuestionsAttemptedCount(qids, category);
/*     */   }
/*     */   
/*     */   public boolean incrementCorrectQuestionsAttemptedCount(List<Integer> qids, String category)
/*     */     throws SQLException
/*     */   {
/*  62 */     return this.dao.incrementCorrectQuestionsAttemptedCount(qids, category);
/*     */   }
/*     */   
/*     */   public List<QuizQuestionDetails> getQuizKey(String category, int topicid, int userid)
/*     */     throws SQLException
/*     */   {
/*  68 */     return this.dao.getQuizKey(category, topicid, userid);
/*     */   }
/*     */   
/*     */   public QuizPoints getTopicScore(String category, int topicid, int userid, int total_questions)
/*     */     throws SQLException
/*     */   {
/*  74 */     return this.dao.getTopicScore(category, topicid, userid, total_questions);
/*     */   }
/*     */   
/*     */ 
/*     */   public UserRankBean getUserRankInSubjectTopic(String subject, int user_id, int topic_id)
/*     */     throws SQLException
/*     */   {
/*  81 */     return this.dao.getUserRankInSubjectTopic(subject, user_id, topic_id);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public UserRankBean getUserRankInSubjectTopicbyLocation(String subject, int user_id, int topic_id, String locationType, String location)
/*     */     throws SQLException
/*     */   {
/*  89 */     return this.dao.getUserRankInSubjectTopicbyLocation(subject, user_id, topic_id, locationType, location);
/*     */   }
/*     */   
/*     */   public SubjectAnalysisBean getUserSubjectWiseAnalysis(int user_id, int standard)
/*     */     throws SQLException
/*     */   {
/*  95 */     return this.dao.getUserSubjectWiseAnalysis(user_id, standard);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SubjectAnalysisBean getUserSubjectWiseAnalysisByLocation(int user_id, int standard, String locationType, String location)
/*     */     throws SQLException
/*     */   {
/* 103 */     return this.dao.getUserSubjectWiseAnalysisByLocation(user_id, standard, locationType, location);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<TestsTopicList> getTestTopicsByCategory(int userId, String category, int division, int test_category_id)
/*     */     throws SQLException
/*     */   {
/* 110 */     return this.dao.getTestTopicsByCategory(userId, category, division, test_category_id);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<TestsTopicList> getTestTopicsByBoard(int userId, String category, int standard, int division)
/*     */     throws SQLException
/*     */   {
/* 117 */     return this.dao.getTestTopicsByBoard(userId, category, standard, division);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<TestsTopicList> getSampleTestTopics(int userId, String category, int test_category_id, int standard)
/*     */     throws SQLException
/*     */   {
/* 124 */     return this.dao.getSampleTestTopics(userId, category, test_category_id, standard);
/*     */   }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\service\impl\QuizServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */