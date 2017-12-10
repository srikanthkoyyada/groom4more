/*     */ package com.groom.actions;
/*     */ 
/*     */ import com.groom.bean.QuizPoints;
/*     */ import com.groom.bean.QuizQuestionDetails;
/*     */ import com.groom.bean.User;
/*     */ import com.groom.bean.UserRankBean;
/*     */ import com.groom.service.QuizService;
/*     */ import com.groom.service.impl.QuizServiceImpl;
/*     */ import com.opensymphony.xwork2.ActionSupport;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ import org.apache.struts2.convention.annotation.Action;
/*     */ import org.apache.struts2.convention.annotation.InterceptorRefs;
/*     */ import org.apache.struts2.convention.annotation.ParentPackage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @InterceptorRefs({@org.apache.struts2.convention.annotation.InterceptorRef("loginstack")})
/*     */ @ParentPackage("default")
/*     */ @Action(value="key", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/key.jsp")})
/*     */ public class TestKeyAction
/*     */   extends ActionSupport
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private List<QuizQuestionDetails> questionsList;
/*  31 */   QuizService quizService = new QuizServiceImpl();
/*  32 */   HttpServletRequest request = ServletActionContext.getRequest();
/*     */   
/*  34 */   HttpSession session = ServletActionContext.getRequest().getSession(false);
/*     */   
/*     */   private String category;
/*     */   private String topicid;
/*     */   private QuizPoints quizPoints;
/*     */   private UserRankBean userRankBean;
/*     */   private UserRankBean userCityRank;
/*     */   private UserRankBean userStateRank;
/*     */   private int totlaQuestions;
/*     */   
/*     */   public int getTotlaQuestions()
/*     */   {
/*  46 */     return this.totlaQuestions;
/*     */   }
/*     */   
/*     */   public void setTotlaQuestions(int totlaQuestions) {
/*  50 */     this.totlaQuestions = totlaQuestions;
/*     */   }
/*     */   
/*     */   public UserRankBean getUserCityRank() {
/*  54 */     return this.userCityRank;
/*     */   }
/*     */   
/*     */   public void setUserCityRank(UserRankBean userCityRank) {
/*  58 */     this.userCityRank = userCityRank;
/*     */   }
/*     */   
/*     */   public UserRankBean getUserStateRank() {
/*  62 */     return this.userStateRank;
/*     */   }
/*     */   
/*     */   public void setUserStateRank(UserRankBean userStateRank) {
/*  66 */     this.userStateRank = userStateRank;
/*     */   }
/*     */   
/*     */   public String execute() throws Exception {
/*  70 */     User user = (User)this.session.getAttribute("user");
/*     */     
/*  72 */     setQuestionsList(this.quizService.getQuizKey(getCategory(), 
/*  73 */       Integer.parseInt(getTopicid()), user.getUserId()));
/*  74 */     setQuizPoints(this.quizService.getTopicScore(getCategory(), 
/*  75 */       Integer.parseInt(getTopicid()), user.getUserId(), getQuestionsList().size()));
/*     */     
/*  77 */     setUserRankBean(this.quizService.getUserRankInSubjectTopic(getCategory(), 
/*  78 */       user.getUserId(), Integer.parseInt(getTopicid())));
/*  79 */     System.out.println("category for city wise rank" + getCategory());
/*  80 */     setUserCityRank(this.quizService.getUserRankInSubjectTopicbyLocation(
/*  81 */       getCategory(), user.getUserId(), 
/*  82 */       Integer.parseInt(getTopicid()), "CITY", user.getCity()));
/*  83 */     System.out.println("category for state wise rank" + getCategory());
/*  84 */     setUserStateRank(this.quizService.getUserRankInSubjectTopicbyLocation(
/*  85 */       getCategory(), user.getUserId(), 
/*  86 */       Integer.parseInt(getTopicid()), "STATE", user.getState()));
/*     */     
/*  88 */     return "success";
/*     */   }
/*     */   
/*     */   public List<QuizQuestionDetails> getQuestionsList() {
/*  92 */     return this.questionsList;
/*     */   }
/*     */   
/*     */   public void setQuestionsList(List<QuizQuestionDetails> questionsList) {
/*  96 */     this.questionsList = questionsList;
/*     */   }
/*     */   
/*     */   public String getCategory() {
/* 100 */     return this.category;
/*     */   }
/*     */   
/*     */   public void setCategory(String category) {
/* 104 */     this.category = category;
/*     */   }
/*     */   
/*     */   public String getTopicid() {
/* 108 */     return this.topicid;
/*     */   }
/*     */   
/*     */   public void setTopicid(String topicid) {
/* 112 */     this.topicid = topicid;
/*     */   }
/*     */   
/*     */   public UserRankBean getUserRankBean() {
/* 116 */     return this.userRankBean;
/*     */   }
/*     */   
/*     */   public void setUserRankBean(UserRankBean userRankBean) {
/* 120 */     this.userRankBean = userRankBean;
/*     */   }
/*     */   
/*     */   public QuizPoints getQuizPoints() {
/* 124 */     return this.quizPoints;
/*     */   }
/*     */   
/*     */   public void setQuizPoints(QuizPoints quizPoints) {
/* 128 */     this.quizPoints = quizPoints;
/*     */   }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\TestKeyAction1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */