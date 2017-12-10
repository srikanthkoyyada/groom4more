/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.bean.QuizQuestionDetails;
/*    */ import com.groom.service.QuizService;
/*    */ import com.groom.service.impl.QuizServiceImpl;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.struts2.ServletActionContext;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ import org.apache.struts2.convention.annotation.InterceptorRefs;
/*    */ import org.apache.struts2.convention.annotation.ParentPackage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @InterceptorRefs({@org.apache.struts2.convention.annotation.InterceptorRef("loginstack"), @org.apache.struts2.convention.annotation.InterceptorRef("token")})
/*    */ @ParentPackage("default")
/*    */ @Action(value="quiz", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/tests/quiz.jsp"), @org.apache.struts2.convention.annotation.Result(name="invalid.token", location="/index.jsp")})
/*    */ public class QuizQuestionsAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private List<QuizQuestionDetails> questionsList;
/* 31 */   QuizService quizService = new QuizServiceImpl();
/* 32 */   HttpServletRequest request = ServletActionContext.getRequest();
/*    */   private String category;
/*    */   private String topicid;
/*    */   private String testDate;
/*    */   private int quizSize;
/*    */   private int testTime;
/*    */   
/*    */   public String execute() throws Exception
/*    */   {
/* 41 */     setQuestionsList(this.quizService.getQuizDetails(getCategory(), Integer.parseInt(getTopicid())));
/* 42 */     setQuizSize(getQuestionsList().size());
/* 43 */     setTopicid(getTopicid());
/* 44 */     if (getQuestionsList().size() > 0)
/* 45 */       setTestTime(((QuizQuestionDetails)getQuestionsList().get(0)).getTest_time());
/* 46 */     return "success";
/*    */   }
/*    */   
/*    */   public List<QuizQuestionDetails> getQuestionsList() {
/* 50 */     return this.questionsList;
/*    */   }
/*    */   
/*    */   public void setQuestionsList(List<QuizQuestionDetails> questionsList) {
/* 54 */     this.questionsList = questionsList;
/*    */   }
/*    */   
/*    */   public String getCategory() {
/* 58 */     return this.category;
/*    */   }
/*    */   
/*    */   public void setCategory(String category) {
/* 62 */     this.category = category;
/*    */   }
/*    */   
/*    */   public String getTopicid() {
/* 66 */     return this.topicid;
/*    */   }
/*    */   
/*    */   public void setTopicid(String topicid) {
/* 70 */     this.topicid = topicid;
/*    */   }
/*    */   
/*    */   public String getTestDate() {
/* 74 */     return this.testDate;
/*    */   }
/*    */   
/*    */   public void setTestDate(String testDate) {
/* 78 */     this.testDate = testDate;
/*    */   }
/*    */   
/*    */   public int getQuizSize() {
/* 82 */     return this.quizSize;
/*    */   }
/*    */   
/*    */   public void setQuizSize(int quizSize) {
/* 86 */     this.quizSize = quizSize;
/*    */   }
/*    */   
/*    */   public int getTestTime() {
/* 90 */     return this.testTime;
/*    */   }
/*    */   
/*    */   public void setTestTime(int testTime) {
/* 94 */     this.testTime = testTime;
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\QuizQuestionsAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */