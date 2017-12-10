/*     */ package com.groom.actions;
/*     */ 
/*     */ import com.groom.bean.QuizPoints;
/*     */ import com.groom.bean.User;
/*     */ import com.groom.service.QuizService;
/*     */ import com.groom.service.UserService;
/*     */ import com.groom.service.impl.QuizServiceImpl;
/*     */ import com.groom.service.impl.UserServiceImpl;
/*     */ import com.groom.util.GroomUtil;
/*     */ import com.opensymphony.xwork2.ActionSupport;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Time;
/*     */ import java.text.ParseException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ import org.apache.struts2.convention.annotation.Action;
/*     */ import org.apache.struts2.convention.annotation.InterceptorRefs;
/*     */ import org.apache.struts2.convention.annotation.ParentPackage;
/*     */ import org.apache.struts2.interceptor.ServletRequestAware;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @InterceptorRefs({@org.apache.struts2.convention.annotation.InterceptorRef("loginstack"), @org.apache.struts2.convention.annotation.InterceptorRef("token")})
/*     */ @ParentPackage("default")
/*     */ @Action(value="quiz-engg-submit", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/tests/quizSubmission.jsp"), @org.apache.struts2.convention.annotation.Result(name="invalid.token", location="/jsp/tests/tests.jsp")})
/*     */ public class IITExamSubmit
/*     */   extends ActionSupport
/*     */   implements ServletRequestAware
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  39 */   HttpServletRequest request = ServletActionContext.getRequest();
/*  40 */   HttpSession session = ServletActionContext.getRequest().getSession(false);
/*  41 */   QuizService quizService = new QuizServiceImpl();
/*  42 */   UserService userService = new UserServiceImpl();
/*     */   int totalQuestionsAttempted;
/*     */   int correctAnswers;
/*  45 */   List<Integer> attemptQuesIds = new ArrayList();
/*  46 */   List<Integer> correctAttemptedQuesIds = new ArrayList();
/*  47 */   StringBuffer userAnswers = new StringBuffer();
/*     */   
/*     */   public int getTotalQuestionsAttempted() {
/*  50 */     return this.totalQuestionsAttempted;
/*     */   }
/*     */   
/*     */   public void setTotalQuestionsAttempted(int totalQuestionsAttempted) {
/*  54 */     this.totalQuestionsAttempted = totalQuestionsAttempted;
/*     */   }
/*     */   
/*     */   public int getCorrectAnswers() {
/*  58 */     return this.correctAnswers;
/*     */   }
/*     */   
/*     */   public void setCorrectAnswers(int correctAnswers) {
/*  62 */     this.correctAnswers = correctAnswers;
/*     */   }
/*     */   
/*     */   public String execute() throws SQLException, ParseException {
/*  66 */     StringBuilder questionIds = new StringBuilder();
/*  67 */     int quizSize = Integer.parseInt(this.request.getParameter("quizsize"));
/*  68 */     int attempted = 0;
/*  69 */     int correct = 0;
/*  70 */     int incorrect = 0;
/*  71 */     int marks = 0;
/*  72 */     int notAttempted = 0;
/*  73 */     for (int i = 1; i <= quizSize; i++) {
/*  74 */       questionIds.append(this.request.getParameter("qno" + i));
/*  75 */       if (i < quizSize) {
/*  76 */         questionIds.append(",");
/*     */       }
/*     */     }
/*  79 */     Map<Integer, String> answers = this.quizService.getQuizAnswers(
/*  80 */       questionIds.toString(), this.request.getParameter("category"));
/*     */     
/*  82 */     for (int i = 1; i <= quizSize; i++) {
/*  83 */       if (this.request.getParameter("q" + i) != null) {
/*  84 */         this.userAnswers.append(this.request.getParameter("q" + i).toString());
/*  85 */         attempted++;
/*  86 */         int keyValue = 
/*  87 */           Integer.parseInt(this.request.getParameter("qno" + i));
/*  88 */         this.attemptQuesIds.add(Integer.valueOf(keyValue));
/*  89 */         if (((String)answers.get(Integer.valueOf(keyValue))).equals(this.request.getParameter("q" + i))) {
/*  90 */           this.correctAttemptedQuesIds.add(Integer.valueOf(keyValue));
/*  91 */           correct++;
/*     */         } else {
/*  93 */           incorrect++;
/*     */         }
/*  95 */       } else { this.userAnswers.append("X");
/*  96 */         notAttempted++;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 101 */     String timeRemaining = this.request.getParameter("timetaken");
/* 102 */     System.out.println("time remaining is:::" + timeRemaining.trim());
/* 103 */     QuizPoints quizPoints = new QuizPoints();
/* 104 */     User user = (User)this.session.getAttribute("user");
/* 105 */     quizPoints.setU_id(user.getUserId());
/*     */     
/* 107 */     int negativeMarks = 0;
/* 108 */     if (this.request.getParameter("division") == "2") {
/* 109 */       negativeMarks = incorrect / 4;
/*     */     }
/* 111 */     if (this.request.getParameter("division") == "4") {
/* 112 */       negativeMarks = incorrect / 2;
/*     */     }
/* 114 */     marks = correct - negativeMarks;
/*     */     
/* 116 */     System.out.println(this.request.getParameter("category").toString());
/* 117 */     System.out.println(this.request.getParameter("division").toString());
/* 118 */     System.out.println("Correct Answers: " + correct);
/* 119 */     System.out.println("Incorrect Answers: " + incorrect);
/* 120 */     System.out.println("Marks: " + marks);
/*     */     
/* 122 */     quizPoints.setPoints(marks);
/* 123 */     quizPoints.setCateogry(this.request.getParameter("category"));
/* 124 */     quizPoints.setAnswers(this.userAnswers.toString());
/* 125 */     quizPoints
/* 126 */       .setTopicid(Integer.parseInt(this.request.getParameter("topicid")));
/* 127 */     quizPoints.setQuestionIds(questionIds.toString());
/*     */     
/* 129 */     quizPoints.setTestDate(GroomUtil.convertStringtoSqlDate(this.request
/* 130 */       .getParameter("testDate")));
/* 131 */     Time timeTaken = GroomUtil.getSqlTimeDiff("00:40:00", 
/* 132 */       timeRemaining.trim());
/*     */     
/* 134 */     quizPoints.setTime(timeTaken);
/* 135 */     this.userService.updateUserSubjectPoints(quizPoints.getCateogry(), 
/* 136 */       user.getUserId(), correct);
/* 137 */     this.userService.updateUserTotalPoints(user.getUserId(), correct);
/* 138 */     this.quizService.saveQuizPoints(quizPoints);
/* 139 */     if (!this.attemptQuesIds.isEmpty()) {
/* 140 */       this.quizService.incrementQuestionsAttemptedCount(this.attemptQuesIds, 
/* 141 */         quizPoints.getCateogry());
/*     */     }
/* 143 */     if (!this.correctAttemptedQuesIds.isEmpty()) {
/* 144 */       this.quizService.incrementCorrectQuestionsAttemptedCount(
/* 145 */         this.correctAttemptedQuesIds, quizPoints.getCateogry());
/*     */     }
/* 147 */     setTotalQuestionsAttempted(attempted);
/* 148 */     setCorrectAnswers(correct);
/*     */     
/* 150 */     return "success";
/*     */   }
/*     */   
/*     */   public void setServletRequest(HttpServletRequest request)
/*     */   {
/* 155 */     this.request = request;
/*     */   }
/*     */   
/*     */   public HttpServletRequest getServletRequest() {
/* 159 */     return this.request;
/*     */   }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\IITExamSubmit.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */