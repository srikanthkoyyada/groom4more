/*     */ package com.groom.bean;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QuizQuestionDetails
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private int q_id;
/*     */   private String question;
/*     */   private String option_a;
/*     */   private String option_b;
/*     */   private String option_c;
/*     */   private String option_d;
/*     */   private String answer;
/*     */   private String image_name;
/*     */   private String explanation;
/*     */   private int topicid;
/*     */   private int no_of_attempts;
/*     */   private int no_of_correct_answers;
/*     */   private String userAnswer;
/*     */   private String test_by;
/*     */   private int test_time;
/*     */   
/*     */   public int getTest_time()
/*     */   {
/*  30 */     return this.test_time;
/*     */   }
/*     */   
/*     */   public void setTest_time(int test_time) {
/*  34 */     this.test_time = test_time;
/*     */   }
/*     */   
/*     */   public String getTest_by() {
/*  38 */     return this.test_by;
/*     */   }
/*     */   
/*     */   public void setTest_by(String test_by) {
/*  42 */     this.test_by = test_by;
/*     */   }
/*     */   
/*     */   public String getUserAnswer() {
/*  46 */     return this.userAnswer;
/*     */   }
/*     */   
/*     */   public void setUserAnswer(String userAnswer) {
/*  50 */     this.userAnswer = userAnswer;
/*     */   }
/*     */   
/*     */   public int getNo_of_attempts() {
/*  54 */     return this.no_of_attempts;
/*     */   }
/*     */   
/*     */   public void setNo_of_attempts(int no_of_attempts) {
/*  58 */     this.no_of_attempts = no_of_attempts;
/*     */   }
/*     */   
/*     */   public int getNo_of_correct_answers() {
/*  62 */     return this.no_of_correct_answers;
/*     */   }
/*     */   
/*     */   public void setNo_of_correct_answers(int no_of_correct_answers) {
/*  66 */     this.no_of_correct_answers = no_of_correct_answers;
/*     */   }
/*     */   
/*     */   public int getTopicid() {
/*  70 */     return this.topicid;
/*     */   }
/*     */   
/*     */   public void setTopicid(int topicid) {
/*  74 */     this.topicid = topicid;
/*     */   }
/*     */   
/*     */   public int getQ_id() {
/*  78 */     return this.q_id;
/*     */   }
/*     */   
/*     */   public void setQ_id(int q_id) {
/*  82 */     this.q_id = q_id;
/*     */   }
/*     */   
/*     */   public String getQuestion() {
/*  86 */     return this.question;
/*     */   }
/*     */   
/*     */   public void setQuestion(String question) {
/*  90 */     this.question = question;
/*     */   }
/*     */   
/*     */   public String getOption_a() {
/*  94 */     return this.option_a;
/*     */   }
/*     */   
/*     */   public void setOption_a(String option_a) {
/*  98 */     this.option_a = option_a;
/*     */   }
/*     */   
/*     */   public String getOption_b() {
/* 102 */     return this.option_b;
/*     */   }
/*     */   
/*     */   public void setOption_b(String option_b) {
/* 106 */     this.option_b = option_b;
/*     */   }
/*     */   
/*     */   public String getOption_c() {
/* 110 */     return this.option_c;
/*     */   }
/*     */   
/*     */   public void setOption_c(String option_c) {
/* 114 */     this.option_c = option_c;
/*     */   }
/*     */   
/*     */   public String getOption_d() {
/* 118 */     return this.option_d;
/*     */   }
/*     */   
/*     */   public void setOption_d(String option_d) {
/* 122 */     this.option_d = option_d;
/*     */   }
/*     */   
/*     */   public String getAnswer() {
/* 126 */     return this.answer;
/*     */   }
/*     */   
/*     */   public void setAnswer(String answer) {
/* 130 */     this.answer = answer;
/*     */   }
/*     */   
/*     */   public String getImage_name() {
/* 134 */     return this.image_name;
/*     */   }
/*     */   
/*     */   public void setImage_name(String image_name) {
/* 138 */     this.image_name = image_name;
/*     */   }
/*     */   
/*     */   public String getExplanation() {
/* 142 */     return this.explanation;
/*     */   }
/*     */   
/*     */   public void setExplanation(String explanation) {
/* 146 */     this.explanation = explanation;
/*     */   }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\bean\QuizQuestionDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */