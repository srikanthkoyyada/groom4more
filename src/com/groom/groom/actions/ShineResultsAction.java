/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.bean.Shine;
/*    */ import com.groom.service.AdminService;
/*    */ import com.groom.service.impl.AdminServiceImpl;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Action(value="shine-result", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/shine-student-results.jsp"), @org.apache.struts2.convention.annotation.Result(name="input", location="/jsp/shine-results.jsp")})
/*    */ public class ShineResultsAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private Shine shine;
/*    */   private String school;
/*    */   private String standard;
/*    */   private String rollnumber;
/*    */   
/*    */   @RequiredStringValidator(message="Please select your school")
/*    */   public String getSchool()
/*    */   {
/* 25 */     return this.school;
/*    */   }
/*    */   
/*    */   public void setSchool(String school) {
/* 29 */     this.school = school;
/*    */   }
/*    */   
/*    */   @RequiredStringValidator(message="Select class studying")
/*    */   public String getStandard() {
/* 34 */     return this.standard;
/*    */   }
/*    */   
/*    */   public void setStandard(String standard) {
/* 38 */     this.standard = standard;
/*    */   }
/*    */   
/*    */   @RequiredStringValidator(message="Enter Your Roll Number here")
/*    */   public String getRollnumber() {
/* 43 */     return this.rollnumber;
/*    */   }
/*    */   
/*    */   public void setRollnumber(String rollnumber) {
/* 47 */     this.rollnumber = rollnumber;
/*    */   }
/*    */   
/*    */   public Shine getShine() {
/* 51 */     return this.shine;
/*    */   }
/*    */   
/*    */   public void setShine(Shine shine) {
/* 55 */     this.shine = shine;
/*    */   }
/*    */   
/* 58 */   AdminService adminService = new AdminServiceImpl();
/*    */   
/*    */   public String execute() throws Exception
/*    */   {
/* 62 */     setShine(this.adminService.getUserResults(Integer.parseInt(getStandard()), getSchool(), 
/* 63 */       getRollnumber()));
/*    */     
/* 65 */     return "success";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\ShineResultsAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */