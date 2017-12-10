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
/*    */ 
/*    */ @ParentPackage("json-default")
/*    */ public class GetCategoryNamesByStandardAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 21 */   HttpServletRequest request = ServletActionContext.getRequest();
/* 22 */   AdminService adminService = new AdminServiceImpl();
/*    */   private Map<String, String> categoryMap;
/*    */   
/*    */   public Map<String, String> getCategoryMap() {
/* 26 */     return this.categoryMap;
/*    */   }
/*    */   
/*    */   public void setCategoryMap(Map<String, String> categoryMap) {
/* 30 */     this.categoryMap = categoryMap;
/*    */   }
/*    */   
/*    */   @Action(value="getCategoryByStandard", results={@org.apache.struts2.convention.annotation.Result(type="json", params={"contentType", "application/json", "root", "categoryMap"})})
/*    */   public String checkUsername() throws Exception {
/* 35 */     int standard = Integer.parseInt(this.request.getParameter("standard"));
/* 36 */     setCategoryMap(this.adminService.getCategoryByStandard(standard));
/*    */     
/* 38 */     return "success";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\GetCategoryNamesByStandardAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */