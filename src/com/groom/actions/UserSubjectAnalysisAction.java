/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.bean.SubjectAnalysisBean;
/*    */ import com.groom.bean.User;
/*    */ import com.groom.service.QuizService;
/*    */ import com.groom.service.impl.QuizServiceImpl;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.sql.SQLException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.apache.struts2.ServletActionContext;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ import org.apache.struts2.convention.annotation.InterceptorRefs;
/*    */ import org.apache.struts2.convention.annotation.ParentPackage;
/*    */ import org.apache.struts2.convention.annotation.ResultPath;
/*    */ import org.apache.struts2.convention.annotation.Results;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @InterceptorRefs({@org.apache.struts2.convention.annotation.InterceptorRef("loginstack")})
/*    */ @ParentPackage("default")
/*    */ @ResultPath("/jsp")
/*    */ @Results({@org.apache.struts2.convention.annotation.Result(name="success", location="analysis.jsp")})
/*    */ public class UserSubjectAnalysisAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 31 */   HttpServletRequest request = ServletActionContext.getRequest();
/* 32 */   HttpSession session = ServletActionContext.getRequest().getSession(false);
/*    */   
/*    */   private SubjectAnalysisBean subjectAnalysisBean;
/*    */   private SubjectAnalysisBean subjectAnalysisByCity;
/*    */   private SubjectAnalysisBean subjectAnalysisByState;
/* 37 */   QuizService quizService = new QuizServiceImpl();
/*    */   
/*    */ 
/*    */   public SubjectAnalysisBean getSubjectAnalysisByCity()
/*    */   {
/* 42 */     return this.subjectAnalysisByCity;
/*    */   }
/*    */   
/*    */   public void setSubjectAnalysisByCity(SubjectAnalysisBean subjectAnalysisByCity) {
/* 46 */     this.subjectAnalysisByCity = subjectAnalysisByCity;
/*    */   }
/*    */   
/*    */   public SubjectAnalysisBean getSubjectAnalysisByState() {
/* 50 */     return this.subjectAnalysisByState;
/*    */   }
/*    */   
/*    */   public void setSubjectAnalysisByState(SubjectAnalysisBean subjectAnalysisByState) {
/* 54 */     this.subjectAnalysisByState = subjectAnalysisByState;
/*    */   }
/*    */   
/*    */   public SubjectAnalysisBean getSubjectAnalysisBean() {
/* 58 */     return this.subjectAnalysisBean;
/*    */   }
/*    */   
/*    */   public void setSubjectAnalysisBean(SubjectAnalysisBean subjectAnalysisBean) {
/* 62 */     this.subjectAnalysisBean = subjectAnalysisBean;
/*    */   }
/*    */   
/*    */   @Action("analysis")
/*    */   public String execute() throws SQLException {
/* 67 */     User user = (User)this.session.getAttribute("user");
/* 68 */     setSubjectAnalysisBean(this.quizService.getUserSubjectWiseAnalysis(user.getUserId(), Integer.parseInt(user.getStandard())));
/* 69 */     setSubjectAnalysisByState(this.quizService.getUserSubjectWiseAnalysisByLocation(user.getUserId(), Integer.parseInt(user.getStandard()), "STATE", user.getState()));
/* 70 */     setSubjectAnalysisByCity(this.quizService.getUserSubjectWiseAnalysisByLocation(user.getUserId(), Integer.parseInt(user.getStandard()), "CITY", user.getCity()));
/* 71 */     return "success";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\UserSubjectAnalysisAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */