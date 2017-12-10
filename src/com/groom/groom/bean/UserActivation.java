/*    */ package com.groom.bean;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserActivation
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private int userId;
/*    */   private String activationKey;
/*    */   
/*    */   public int getUserId()
/*    */   {
/* 16 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(int userId) {
/* 20 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   public String getActivationKey() {
/* 24 */     return this.activationKey;
/*    */   }
/*    */   
/*    */   public void setActivationKey(String activationKey) {
/* 28 */     this.activationKey = activationKey;
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\bean\UserActivation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */