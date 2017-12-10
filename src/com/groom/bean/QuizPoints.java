/*     */ package com.groom.bean;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.sql.Date;
/*     */ import java.sql.Time;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QuizPoints
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private int u_id;
/*     */   private int points;
/*     */   private String cateogry;
/*     */   private Time time;
/*     */   private String questionIds;
/*     */   private int topicid;
/*     */   private Date testDate;
/*     */   private String answers;
/*     */   private int totalAttempted;
/*     */   private int wrongAnswers;
/*     */   
/*     */   public int getWrongAnswers()
/*     */   {
/*  31 */     return this.wrongAnswers;
/*     */   }
/*     */   
/*     */   public void setWrongAnswers(int wrongAnswers) {
/*  35 */     this.wrongAnswers = wrongAnswers;
/*     */   }
/*     */   
/*     */   public int getTotalAttempted() {
/*  39 */     return this.totalAttempted;
/*     */   }
/*     */   
/*     */   public void setTotalAttempted(int totalAttempted) {
/*  43 */     this.totalAttempted = totalAttempted;
/*     */   }
/*     */   
/*     */   public String getAnswers() {
/*  47 */     return this.answers;
/*     */   }
/*     */   
/*     */   public void setAnswers(String answers) {
/*  51 */     this.answers = answers;
/*     */   }
/*     */   
/*     */   public Date getTestDate() {
/*  55 */     return this.testDate;
/*     */   }
/*     */   
/*     */   public void setTestDate(Date testDate) {
/*  59 */     this.testDate = testDate;
/*     */   }
/*     */   
/*     */   public int getTopicid() {
/*  63 */     return this.topicid;
/*     */   }
/*     */   
/*     */   public void setTopicid(int topicid) {
/*  67 */     this.topicid = topicid;
/*     */   }
/*     */   
/*     */   public String getQuestionIds() {
/*  71 */     return this.questionIds;
/*     */   }
/*     */   
/*     */   public void setQuestionIds(String questionIds) {
/*  75 */     this.questionIds = questionIds;
/*     */   }
/*     */   
/*     */   public int getU_id() {
/*  79 */     return this.u_id;
/*     */   }
/*     */   
/*     */   public void setU_id(int u_id) {
/*  83 */     this.u_id = u_id;
/*     */   }
/*     */   
/*     */   public int getPoints() {
/*  87 */     return this.points;
/*     */   }
/*     */   
/*     */   public void setPoints(int points) {
/*  91 */     this.points = points;
/*     */   }
/*     */   
/*     */   public String getCateogry() {
/*  95 */     return this.cateogry;
/*     */   }
/*     */   
/*     */   public void setCateogry(String cateogry) {
/*  99 */     this.cateogry = cateogry;
/*     */   }
/*     */   
/*     */   public Time getTime() {
/* 103 */     return this.time;
/*     */   }
/*     */   
/*     */   public void setTime(Time time) {
/* 107 */     this.time = time;
/*     */   }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\bean\QuizPoints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */