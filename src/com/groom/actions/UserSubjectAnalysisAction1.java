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
/*    */ 
/*    */ @InterceptorRefs({@org.apache.struts2.convention.annotation.InterceptorRef("loginstack")})
/*    */ @ParentPackage("default")
/*    */ @ResultPath("/jsp")
/*    */ @Results({@org.apache.struts2.convention.annotation.Result(name="success", location="analysis.jsp")})
/*    */ public class UserSubjectAnalysisAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 32 */   HttpServletRequest request = ServletActionContext.getRequest();
/* 33 */   HttpSession session = ServletActionContext.getRequest().getSession(false);
/*    */   
/*    */   private SubjectAnalysisBean subjectAnalysisBean;
/*    */   private SubjectAnalysisBean subjectAnalysisByCity;
/*    */   private SubjectAnalysisBean subjectAnalysisByState;
/* 38 */   QuizService quizService = new QuizServiceImpl();
/*    */   
/*    */ 
/*    */   public SubjectAnalysisBean getSubjectAnalysisByCity()
/*    */   {
/* 43 */     return this.subjectAnalysisByCity;
/*    */   }
/*    */   
/*    */   public void setSubjectAnalysisByCity(SubjectAnalysisBean subjectAnalysisByCity) {
/* 47 */     this.subjectAnalysisByCity = subjectAnalysisByCity;
/*    */   }
/*    */   
/*    */   public SubjectAnalysisBean getSubjectAnalysisByState() {
/* 51 */     return this.subjectAnalysisByState;
/*    */   }
/*    */   
/*    */   public void setSubjectAnalysisByState(SubjectAnalysisBean subjectAnalysisByState) {
/* 55 */     this.subjectAnalysisByState = subjectAnalysisByState;
/*    */   }
/*    */   
/*    */   public SubjectAnalysisBean getSubjectAnalysisBean() {
/* 59 */     return this.subjectAnalysisBean;
/*    */   }
/*    */   
/*    */   public void setSubjectAnalysisBean(SubjectAnalysisBean subjectAnalysisBean) {
/* 63 */     this.subjectAnalysisBean = subjectAnalysisBean;
/*    */   }
/*    */   
/*    */   @Action("analysis")
/*    */   public String execute() throws SQLException {
/* 68 */     User user = (User)this.session.getAttribute("user");
/* 69 */     if (user.getTotal_points() != 0) {
/* 70 */       setSubjectAnalysisBean(this.quizService.getUserSubjectWiseAnalysis(user.getUserId(), Integer.parseInt(user.getStandard())));
/* 71 */       setSubjectAnalysisByState(this.quizService.getUserSubjectWiseAnalysisByLocation(user.getUserId(), Integer.parseInt(user.getStandard()), "STATE", user.getState()));
/* 72 */       setSubjectAnalysisByCity(this.quizService.getUserSubjectWiseAnalysisByLocation(user.getUserId(), Integer.parseInt(user.getStandard()), "CITY", user.getCity()));
/*    */     }
/*    */     else {
/* 75 */       setSubjectAnalysisBean(buildAnalysisBean(user));
/* 76 */       setSubjectAnalysisByState(buildAnalysisBean(user));
/* 77 */       setSubjectAnalysisByCity(buildAnalysisBean(user));
/*    */     }
/*    */     
/* 80 */     return "success";
/*    */   }
/*    */   
/* 83 */   private SubjectAnalysisBean buildAnalysisBean(User user) { SubjectAnalysisBean bean = new SubjectAnalysisBean();
/* 84 */     bean.setUser_id(user.getUserId());
/* 85 */     bean.setFirst_name(user.getFirstname());
/* 86 */     bean.setMaths_points(user.getMaths_points());
/* 87 */     bean.setPhysics_points(user.getPhysics_points());
/* 88 */     bean.setChemistry_points(user.getChemistry_points());
/* 89 */     bean.setMaths_rank(0);
/* 90 */     bean.setPhysics_rank(0);
/* 91 */     bean.setChemistry_rank(0);
/* 92 */     bean.setTotal_ranks(0);
/*    */     
/* 94 */     bean.setMaths_percentile(0.0D);
/* 95 */     bean.setPhysics_percentile(0.0D);
/* 96 */     bean.setChemistry_percentile(0.0D);
/* 97 */     return bean;
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\UserSubjectAnalysisAction1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */