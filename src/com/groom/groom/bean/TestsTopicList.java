/*    */ package com.groom.bean;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TestsTopicList
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private int topicId;
/*    */   private String topicName;
/*    */   private int topicClass;
/*    */   private String testDate;
/*    */   private String isStudentAttempted;
/*    */   private String questionIdsList;
/*    */   private String isKeyAndResultAvailable;
/*    */   
/*    */   public String getIsKeyAndResultAvailable()
/*    */   {
/* 25 */     return this.isKeyAndResultAvailable;
/*    */   }
/*    */   
/*    */   public void setIsKeyAndResultAvailable(String isKeyAndResultAvailable) {
/* 29 */     this.isKeyAndResultAvailable = isKeyAndResultAvailable;
/*    */   }
/*    */   
/*    */   public String getQuestionIdsList() {
/* 33 */     return this.questionIdsList;
/*    */   }
/*    */   
/*    */   public void setQuestionIdsList(String questionIdsList) {
/* 37 */     this.questionIdsList = questionIdsList;
/*    */   }
/*    */   
/*    */   public int getTopicId() {
/* 41 */     return this.topicId;
/*    */   }
/*    */   
/*    */   public void setTopicId(int topicId) {
/* 45 */     this.topicId = topicId;
/*    */   }
/*    */   
/*    */   public String getTopicName() {
/* 49 */     return this.topicName;
/*    */   }
/*    */   
/*    */   public void setTopicName(String topicName) {
/* 53 */     this.topicName = topicName;
/*    */   }
/*    */   
/*    */   public int getTopicClass() {
/* 57 */     return this.topicClass;
/*    */   }
/*    */   
/*    */   public void setTopicClass(int topicClass) {
/* 61 */     this.topicClass = topicClass;
/*    */   }
/*    */   
/*    */   public String getTestDate() {
/* 65 */     return this.testDate;
/*    */   }
/*    */   
/*    */   public void setTestDate(String testDate) {
/* 69 */     this.testDate = testDate;
/*    */   }
/*    */   
/*    */   public String getIsStudentAttempted() {
/* 73 */     return this.isStudentAttempted;
/*    */   }
/*    */   
/*    */   public void setIsStudentAttempted(String isStudentAttempted) {
/* 77 */     this.isStudentAttempted = isStudentAttempted;
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\bean\TestsTopicList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */