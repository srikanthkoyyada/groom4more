/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.bean.QuizQuestionDetails;
/*    */ import com.groom.service.QuizService;
/*    */ import com.groom.service.impl.QuizServiceImpl;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.sql.SQLException;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ import org.apache.struts2.convention.annotation.Results;
/*    */ import org.apache.struts2.dispatcher.SessionMap;
/*    */ import org.apache.struts2.interceptor.SessionAware;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Results({@org.apache.struts2.convention.annotation.Result(name="success", location="/admin/edit-test.jsp"), @org.apache.struts2.convention.annotation.Result(name="input", location="/admin/edit-test.jsp"), @org.apache.struts2.convention.annotation.Result(name="error", location="/admin/admin-login.jsp")})
/*    */ public class EditTestByTopic
/*    */   extends ActionSupport
/*    */   implements SessionAware
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 25 */   QuizService quizService = new QuizServiceImpl();
/*    */   private String subject;
/*    */   private String topic;
/*    */   private SessionMap<String, Object> session;
/*    */   private List<QuizQuestionDetails> quizQuestionDetailsList;
/*    */   
/*    */   public List<QuizQuestionDetails> getQuizQuestionDetailsList()
/*    */   {
/* 33 */     return this.quizQuestionDetailsList;
/*    */   }
/*    */   
/*    */   public void setQuizQuestionDetailsList(List<QuizQuestionDetails> quizQuestionDetailsList) {
/* 37 */     this.quizQuestionDetailsList = quizQuestionDetailsList;
/*    */   }
/*    */   
/*    */   public String getSubject() {
/* 41 */     return this.subject;
/*    */   }
/*    */   
/*    */   public void setSubject(String subject) {
/* 45 */     this.subject = subject;
/*    */   }
/*    */   
/*    */   public String getTopic() {
/* 49 */     return this.topic;
/*    */   }
/*    */   
/*    */   public void setTopic(String topic) {
/* 53 */     this.topic = topic;
/*    */   }
/*    */   
/*    */   public void setSession(Map<String, Object> map)
/*    */   {
/* 58 */     this.session = ((SessionMap)map);
/*    */   }
/*    */   
/*    */   @Action("get-questions-of-topic")
/*    */   public String getQuestions() throws SQLException
/*    */   {
/* 64 */     if (this.session.get("admin") != null) {
/* 65 */       setSubject(getSubject());
/* 66 */       setQuizQuestionDetailsList(this.quizService.getQuizDetails(getSubject(), Integer.parseInt(getTopic())));
/*    */       
/* 68 */       return "success";
/*    */     }
/*    */     
/* 71 */     return "error";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\EditTestByTopic.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */