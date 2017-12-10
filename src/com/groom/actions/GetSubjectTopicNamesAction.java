/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.service.AdminService;
/*    */ import com.groom.service.impl.AdminServiceImpl;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.struts2.ServletActionContext;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ import org.apache.struts2.convention.annotation.ParentPackage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ParentPackage("json-default")
/*    */ public class GetSubjectTopicNamesAction
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
/*    */   @Action(value="getTopics", results={@org.apache.struts2.convention.annotation.Result(type="json", params={"contentType", "application/json", "root", "topicMap"})})
/*    */   public String checkUsername() throws Exception {
/* 34 */     String subject = this.request.getParameter("subject");
/* 35 */     setTopicMap(this.adminService.getTopics(subject));
/* 36 */     return "success";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\GetSubjectTopicNamesAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */