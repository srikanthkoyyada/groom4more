/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.service.AdminService;
/*    */ import com.groom.service.impl.AdminServiceImpl;
/*    */ import com.groom.util.GroomUtil;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.sql.Date;
/*    */ import java.sql.SQLException;
/*    */ import java.text.ParseException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.struts2.ServletActionContext;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AddSubjectTopicAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 21 */   HttpServletRequest request = ServletActionContext.getRequest();
/* 22 */   AdminService adminService = new AdminServiceImpl();
/*    */   private String isTopicAdded;
/*    */   
/*    */   public String getIsTopicAdded() {
/* 26 */     return this.isTopicAdded;
/*    */   }
/*    */   
/*    */   public void setIsTopicAdded(String isTopicAdded) {
/* 30 */     this.isTopicAdded = isTopicAdded;
/*    */   }
/*    */   
/*    */   @Action(value="add-subject-topic", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/admin-success.jsp")})
/*    */   public String addSubject() {
/* 35 */     String subject = this.request.getParameter("subject");
/* 36 */     String topicname = this.request.getParameter("topic");
/* 37 */     int standard = Integer.parseInt(this.request.getParameter("standard"));
/* 38 */     int test_category_id = Integer.parseInt(this.request.getParameter("category"));
/* 39 */     String test_by = this.request.getParameter("test_by").toString();
/* 40 */     int test_time = Integer.parseInt(this.request.getParameter("test_time").toString());
/* 41 */     Date testDate = null;
/*    */     try {
/* 43 */       testDate = GroomUtil.convertStringtoSqlDate(this.request
/* 44 */         .getParameter("testdate"));
/*    */     }
/*    */     catch (ParseException e1) {
/* 47 */       e1.printStackTrace();
/*    */     }
/*    */     
/* 50 */     boolean status = false;
/*    */     try {
/* 52 */       status = this.adminService.addSubjectTopic(subject, topicname, standard, 
/* 53 */         testDate, test_category_id, test_by, test_time);
/*    */     }
/*    */     catch (SQLException e) {
/* 56 */       e.printStackTrace();
/*    */     }
/* 58 */     if (status) {
/* 59 */       setIsTopicAdded("YES");
/*    */     } else
/* 61 */       setIsTopicAdded("NO");
/* 62 */     return "success";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\AddSubjectTopicAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */