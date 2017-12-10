/*     */ package com.groom.actions;
/*     */ 
/*     */ import com.groom.bean.QuizQuestionDetails;
/*     */ import com.groom.service.AdminService;
/*     */ import com.groom.service.impl.AdminServiceImpl;
/*     */ import com.opensymphony.xwork2.ActionSupport;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Map;
/*     */ import org.apache.struts2.convention.annotation.Action;
/*     */ import org.apache.struts2.convention.annotation.ParentPackage;
/*     */ import org.apache.struts2.dispatcher.SessionMap;
/*     */ import org.apache.struts2.interceptor.SessionAware;
/*     */ 
/*     */ 
/*     */ @ParentPackage("json-default")
/*     */ public class UpdateQuestionToTopicAction
/*     */   extends ActionSupport
/*     */   implements SessionAware
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  22 */   AdminService adminService = new AdminServiceImpl();
/*     */   private String subject;
/*     */   private String qid;
/*     */   private String option1;
/*     */   private String option2;
/*     */   private String option3;
/*     */   private String option4;
/*     */   private String answer;
/*     */   private String explanation;
/*     */   private String question;
/*     */   private String result;
/*     */   private SessionMap<String, Object> session;
/*     */   
/*     */   public String getResult()
/*     */   {
/*  37 */     return this.result;
/*     */   }
/*     */   
/*     */   public String getQid() {
/*  41 */     return this.qid;
/*     */   }
/*     */   
/*     */   public void setQid(String qid) {
/*  45 */     this.qid = qid;
/*     */   }
/*     */   
/*     */   public void setResult(String result) {
/*  49 */     this.result = result;
/*     */   }
/*     */   
/*     */   public String getQuestion() {
/*  53 */     return this.question;
/*     */   }
/*     */   
/*     */   public void setQuestion(String question) {
/*  57 */     this.question = question;
/*     */   }
/*     */   
/*     */   @Action(value="update-question-by-id", results={@org.apache.struts2.convention.annotation.Result(type="json", params={"contentType", "application/json", "root", "result"})})
/*     */   public String addQuestion()
/*     */     throws SQLException
/*     */   {
/*  64 */     String fileName = null;
/*  65 */     String user = null;
/*     */     
/*  67 */     if (this.session.get("admin") != null) {
/*  68 */       user = this.session.get("admin").toString();
/*     */     } else {
/*  70 */       this.result = "logout";
/*  71 */       return "success";
/*     */     }
/*  73 */     System.out.println("getQid()::" + getQid());
/*  74 */     QuizQuestionDetails questionDetails = new QuizQuestionDetails();
/*  75 */     questionDetails.setQuestion(getQuestion());
/*  76 */     questionDetails.setOption_a(getOption1());
/*  77 */     questionDetails.setOption_b(getOption2());
/*  78 */     questionDetails.setOption_c(getOption3());
/*  79 */     questionDetails.setOption_d(getOption4());
/*  80 */     questionDetails.setAnswer(getAnswer());
/*  81 */     questionDetails.setExplanation(getExplanation());
/*  82 */     questionDetails.setQ_id(Integer.parseInt(getQid()));
/*     */     
/*  84 */     boolean isQuestionAdded = this.adminService.updateQuestion(questionDetails, getSubject(), user);
/*  85 */     if (isQuestionAdded) {
/*  86 */       this.result = "Question updated successfully";
/*  87 */       return "success";
/*     */     }
/*  89 */     this.result = "Error while updating question..! Please try again";
/*  90 */     return "success";
/*     */   }
/*     */   
/*     */   public String getSubject()
/*     */   {
/*  95 */     return this.subject;
/*     */   }
/*     */   
/*     */   public void setSubject(String subject) {
/*  99 */     this.subject = subject;
/*     */   }
/*     */   
/*     */   public String getOption1() {
/* 103 */     return this.option1;
/*     */   }
/*     */   
/*     */   public void setOption1(String option1) {
/* 107 */     this.option1 = option1;
/*     */   }
/*     */   
/*     */   public String getOption2() {
/* 111 */     return this.option2;
/*     */   }
/*     */   
/*     */   public void setOption2(String option2) {
/* 115 */     this.option2 = option2;
/*     */   }
/*     */   
/*     */   public String getOption3() {
/* 119 */     return this.option3;
/*     */   }
/*     */   
/*     */   public void setOption3(String option3) {
/* 123 */     this.option3 = option3;
/*     */   }
/*     */   
/*     */   public String getOption4() {
/* 127 */     return this.option4;
/*     */   }
/*     */   
/*     */   public void setOption4(String option4) {
/* 131 */     this.option4 = option4;
/*     */   }
/*     */   
/*     */   public String getAnswer() {
/* 135 */     return this.answer;
/*     */   }
/*     */   
/*     */   public void setAnswer(String answer) {
/* 139 */     this.answer = answer;
/*     */   }
/*     */   
/*     */   public String getExplanation() {
/* 143 */     return this.explanation;
/*     */   }
/*     */   
/*     */   public void setExplanation(String explanation) {
/* 147 */     this.explanation = explanation;
/*     */   }
/*     */   
/*     */   public void setSession(Map<String, Object> map)
/*     */   {
/* 152 */     this.session = ((SessionMap)map);
/*     */   }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\UpdateQuestionToTopicAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */