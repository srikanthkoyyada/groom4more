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
/*    */ @Action(value="start-test", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/tests/start-test.jsp")})
/*    */ public class StartTestAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 27 */   QuizService quizService = new QuizServiceImpl();
/* 28 */   HttpSession session = ServletActionContext.getRequest().getSession(false);
/*    */   private String category;
/*    */   private String testCategory;
/*    */   private List<TestsTopicList> topicList;
/*    */   
/*    */   public List<TestsTopicList> getTopicList() {
/* 34 */     return this.topicList;
/*    */   }
/*    */   
/*    */   public void setTopicList(List<TestsTopicList> topicList) {
/* 38 */     this.topicList = topicList;
/*    */   }
/*    */   
/*    */   public String getTestCategory()
/*    */   {
/* 43 */     return this.testCategory;
/*    */   }
/*    */   
/*    */   public void setTestCategory(String testCategory) {
/* 47 */     this.testCategory = testCategory;
/*    */   }
/*    */   
/*    */   public String getCategory() {
/* 51 */     return this.category;
/*    */   }
/*    */   
/*    */   public void setCategory(String category) {
/* 55 */     this.category = category;
/*    */   }
/*    */   
/*    */   public String execute() throws Exception {
/* 59 */     User user = (User)this.session.getAttribute("user");
/* 60 */     setTopicList(this.quizService.getTestTopics(user.getUserId(), getCategory(), 
/* 61 */       Integer.parseInt(user.getStandard()), Integer.parseInt(getTestCategory())));
/*    */     
/* 63 */     return "success";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\StartTestAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */