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
/*     */ @Action(value="quiz-submit", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/quizSubmission.jsp"), @org.apache.struts2.convention.annotation.Result(name="invalid.token", location="/jsp/quizzes.jsp")})
/*     */ public class ExamSubmit
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
/*  71 */     int notAttempted = 0;
/*  72 */     for (int i = 1; i <= quizSize; i++) {
/*  73 */       questionIds.append(this.request.getParameter("qno" + i));
/*  74 */       if (i < quizSize) {
/*  75 */         questionIds.append(",");
/*     */       }
/*     */     }
/*  78 */     Map<Integer, String> answers = this.quizService.getQuizAnswers(
/*  79 */       questionIds.toString(), this.request.getParameter("category"));
/*     */     
/*  81 */     for (int i = 1; i <= quizSize; i++) {
/*  82 */       if (this.request.getParameter("q" + i) != null) {
/*  83 */         this.userAnswers.append(this.request.getParameter("q" + i).toString());
/*  84 */         attempted++;
/*  85 */         int keyValue = 
/*  86 */           Integer.parseInt(this.request.getParameter("qno" + i));
/*  87 */         this.attemptQuesIds.add(Integer.valueOf(keyValue));
/*  88 */         if (((String)answers.get(Integer.valueOf(keyValue))).equals(this.request.getParameter("q" + i))) {
/*  89 */           this.correctAttemptedQuesIds.add(Integer.valueOf(keyValue));
/*  90 */           correct++;
/*     */         } else {
/*  92 */           incorrect++;
/*     */         }
/*  94 */       } else { this.userAnswers.append("X");
/*  95 */         notAttempted++;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 100 */     String timeRemaining = this.request.getParameter("timetaken");
/* 101 */     System.out.println("time remaining is:::" + timeRemaining.trim());
/* 102 */     QuizPoints quizPoints = new QuizPoints();
/* 103 */     User user = (User)this.session.getAttribute("user");
/* 104 */     quizPoints.setU_id(user.getUserId());
/* 105 */     quizPoints.setPoints(correct);
/* 106 */     quizPoints.setCateogry(this.request.getParameter("category"));
/* 107 */     quizPoints.setAnswers(this.userAnswers.toString());
/* 108 */     quizPoints
/* 109 */       .setTopicid(Integer.parseInt(this.request.getParameter("topicid")));
/* 110 */     quizPoints.setQuestionIds(questionIds.toString());
/*     */     
/* 112 */     quizPoints.setTestDate(GroomUtil.convertStringtoSqlDate(this.request
/* 113 */       .getParameter("testDate")));
/* 114 */     Time timeTaken = GroomUtil.getSqlTimeDiff("00:40:00", 
/* 115 */       timeRemaining.trim());
/*     */     
/* 117 */     quizPoints.setTime(timeTaken);
/* 118 */     this.userService.updateUserSubjectPoints(quizPoints.getCateogry(), 
/* 119 */       user.getUserId(), correct);
/* 120 */     this.userService.updateUserTotalPoints(user.getUserId(), correct);
/* 121 */     this.quizService.saveQuizPoints(quizPoints);
/* 122 */     if (!this.attemptQuesIds.isEmpty()) {
/* 123 */       this.quizService.incrementQuestionsAttemptedCount(this.attemptQuesIds, 
/* 124 */         quizPoints.getCateogry());
/*     */     }
/* 126 */     if (!this.correctAttemptedQuesIds.isEmpty()) {
/* 127 */       this.quizService.incrementCorrectQuestionsAttemptedCount(
/* 128 */         this.correctAttemptedQuesIds, quizPoints.getCateogry());
/*     */     }
/* 130 */     setTotalQuestionsAttempted(attempted);
/* 131 */     setCorrectAnswers(correct);
/*     */     
/* 133 */     return "success";
/*     */   }
/*     */   
/*     */   public void setServletRequest(HttpServletRequest request)
/*     */   {
/* 138 */     this.request = request;
/*     */   }
/*     */   
/*     */   public HttpServletRequest getServletRequest() {
/* 142 */     return this.request;
/*     */   }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\ExamSubmit1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */