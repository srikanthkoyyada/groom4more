/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.bean.TestsTopicList;
/*    */ import com.groom.bean.User;
/*    */ import com.groom.service.QuizService;
/*    */ import com.groom.service.impl.QuizServiceImpl;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts2.ServletActionContext;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ import org.apache.struts2.convention.annotation.InterceptorRefs;
/*    */ import org.apache.struts2.convention.annotation.ParentPackage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @InterceptorRefs({@org.apache.struts2.convention.annotation.InterceptorRef("loginstack")})
/*    */ @ParentPackage("default")
/*    */ @Action(value="start-test-category", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/tests/start-test.jsp")})
/*    */ public class StartTestCategoryAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 27 */   QuizService quizService = new QuizServiceImpl();
/* 28 */   HttpSession session = ServletActionContext.getRequest().getSession(false);
/*    */   private String category;
/*    */   private int testCategory;
/*    */   private int division;
/*    */   private List<TestsTopicList> topicList;
/*    */   
/*    */   public List<TestsTopicList> getTopicList() {
/* 35 */     return this.topicList;
/*    */   }
/*    */   
/*    */   public void setTopicList(List<TestsTopicList> topicList) {
/* 39 */     this.topicList = topicList;
/*    */   }
/*    */   
/*    */   public String getCategory() {
/* 43 */     return this.category;
/*    */   }
/*    */   
/*    */   public void setCategory(String category) {
/* 47 */     this.category = category;
/*    */   }
/*    */   
/*    */   public String execute() throws Exception {
/* 51 */     User user = (User)this.session.getAttribute("user");
/* 52 */     setTopicList(this.quizService.getTestTopicsByCategory(user.getUserId(), getCategory(), getDivision(), 
/* 53 */       getTestCategory()));
/*    */     
/* 55 */     return "success";
/*    */   }
/*    */   
/*    */   public int getDivision() {
/* 59 */     return this.division;
/*    */   }
/*    */   
/*    */   public void setDivision(int division) {
/* 63 */     this.division = division;
/*    */   }
/*    */   
/*    */   public int getTestCategory() {
/* 67 */     return this.testCategory;
/*    */   }
/*    */   
/*    */   public void setTestCategory(int testCategory) {
/* 71 */     this.testCategory = testCategory;
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\StartTestCategoryAction1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */