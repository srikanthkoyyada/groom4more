/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.service.AdminService;
/*    */ import com.groom.service.impl.AdminServiceImpl;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.io.PrintStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.struts2.ServletActionContext;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ import org.apache.struts2.convention.annotation.ParentPackage;
/*    */ 
/*    */ 
/*    */ @ParentPackage("json-default")
/*    */ public class GetSubjectTopicNamesByStandardAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 20 */   HttpServletRequest request = ServletActionContext.getRequest();
/* 21 */   AdminService adminService = new AdminServiceImpl();
/*    */   private Map<Integer, String> topicMap;
/*    */   
/*    */   public Map<Integer, String> getTopicMap() {
/* 25 */     return this.topicMap;
/*    */   }
/*    */   
/*    */   public void setTopicMap(Map<Integer, String> topicMap) {
/* 29 */     this.topicMap = topicMap;
/*    */   }
/*    */   
/*    */   @Action(value="getTopicsByStandard", results={@org.apache.struts2.convention.annotation.Result(type="json", params={"contentType", "application/json", "root", "topicMap"})})
/*    */   public String checkUsername() throws Exception {
/*    */     try {
/* 35 */       System.out.println("getTopicsByStandard");
/* 36 */       String subject = this.request.getParameter("subject");
/* 37 */       int standard = Integer.parseInt(this.request.getParameter("standard"));
/*    */       
/* 39 */       int division = 0;
/* 40 */       System.out.println(standard + "::" + division);
/* 41 */       System.out.println(this.adminService.getTopicsByStandard(subject, standard, division).size());
/* 42 */       setTopicMap(this.adminService.getTopicsByStandard(subject, standard, division));
/*    */     } catch (Exception exception) {
/* 44 */       exception.printStackTrace();
/*    */     }
/*    */     
/* 47 */     return "success";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\GetSubjectTopicNamesByStandardAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */