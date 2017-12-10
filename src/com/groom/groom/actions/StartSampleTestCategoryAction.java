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
/*    */ @Action(value="start-sample-test-category", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/tests/sample-test.jsp")})
/*    */ public class StartSampleTestCategoryAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 27 */   QuizService quizService = new QuizServiceImpl();
/* 28 */   HttpSession session = ServletActionContext.getRequest().getSession(false);
/*    */   private String category;
/*    */   private int testCategory;
/*    */   private int division;
/*    */   private int standard;
/*    */   private List<TestsTopicList> topicList;
/*    */   
/*    */   public List<TestsTopicList> getTopicList() {
/* 36 */     return this.topicList;
/*    */   }
/*    */   
/*    */   public void setTopicList(List<TestsTopicList> topicList) {
/* 40 */     this.topicList = topicList;
/*    */   }
/*    */   
/*    */   public String getCategory() {
/* 44 */     return this.category;
/*    */   }
/*    */   
/*    */   public void setCategory(String category) {
/* 48 */     this.category = category;
/*    */   }
/*    */   
/*    */   public String execute() throws Exception {
/* 52 */     User user = (User)this.session.getAttribute("user");
/* 53 */     setTopicList(this.quizService.getSampleTestTopics(user.getUserId(), getCategory(), 
/* 54 */       getTestCategory(), getStandard()));
/*    */     
/* 56 */     return "success";
/*    */   }
/*    */   
/*    */   public int getDivision() {
/* 60 */     return this.division;
/*    */   }
/*    */   
/*    */   public void setDivision(int division) {
/* 64 */     this.division = division;
/*    */   }
/*    */   
/*    */   public int getTestCategory() {
/* 68 */     return this.testCategory;
/*    */   }
/*    */   
/*    */   public void setTestCategory(int testCategory) {
/* 72 */     this.testCategory = testCategory;
/*    */   }
/*    */   
/*    */   public int getStandard() {
/* 76 */     return this.standard;
/*    */   }
/*    */   
/*    */   public void setStandard(int standard) {
/* 80 */     this.standard = standard;
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\StartSampleTestCategoryAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */