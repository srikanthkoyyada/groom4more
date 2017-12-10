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
/*    */ 
/*    */ 
/*    */ 
/*    */ @InterceptorRefs({@org.apache.struts2.convention.annotation.InterceptorRef("loginstack")})
/*    */ @ParentPackage("default")
/*    */ @Action(value="start-board-test", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/tests/start-test.jsp")})
/*    */ public class StartBoardTestAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 30 */   QuizService quizService = new QuizServiceImpl();
/* 31 */   HttpSession session = ServletActionContext.getRequest().getSession(false);
/*    */   private String category;
/*    */   private int standard;
/*    */   private int testCategory;
/*    */   private int division;
/*    */   private List<TestsTopicList> topicList;
/*    */   
/*    */   public List<TestsTopicList> getTopicList() {
/* 39 */     return this.topicList;
/*    */   }
/*    */   
/*    */   public void setTopicList(List<TestsTopicList> topicList) {
/* 43 */     this.topicList = topicList;
/*    */   }
/*    */   
/*    */   public String getCategory()
/*    */   {
/* 48 */     return this.category;
/*    */   }
/*    */   
/*    */   public void setCategory(String category) {
/* 52 */     this.category = category;
/*    */   }
/*    */   
/*    */   public String execute() throws Exception {
/* 56 */     User user = (User)this.session.getAttribute("user");
/* 57 */     setTopicList(this.quizService.getTestTopicsByBoard(user.getUserId(), getCategory(), getStandard(), 
/* 58 */       getDivision(), getTestCategory()));
/*    */     
/* 60 */     return "success";
/*    */   }
/*    */   
/*    */   public int getDivision() {
/* 64 */     return this.division;
/*    */   }
/*    */   
/*    */   public void setDivision(int division) {
/* 68 */     this.division = division;
/*    */   }
/*    */   
/*    */   public int getTestCategory() {
/* 72 */     return this.testCategory;
/*    */   }
/*    */   
/*    */   public void setTestCategory(int testCategory) {
/* 76 */     this.testCategory = testCategory;
/*    */   }
/*    */   
/*    */   public int getStandard() {
/* 80 */     return this.standard;
/*    */   }
/*    */   
/*    */   public void setStandard(int standard) {
/* 84 */     this.standard = standard;
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\StartBoardTestAction1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */