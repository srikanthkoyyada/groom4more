/*    */ package com.groom.bean;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ public class UserRankBean
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private int user_id;
/*    */   private int points;
/*    */   private int rank;
/*    */   private int total_ranks;
/*    */   private double subject_percentile;
/*    */   
/*    */   public double getSubject_percentile()
/*    */   {
/* 18 */     return this.subject_percentile;
/*    */   }
/*    */   
/*    */   public void setSubject_percentile(double subject_percentile) {
/* 22 */     this.subject_percentile = subject_percentile;
/*    */   }
/*    */   
/*    */   public int getUser_id() {
/* 26 */     return this.user_id;
/*    */   }
/*    */   
/*    */   public void setUser_id(int user_id) {
/* 30 */     this.user_id = user_id;
/*    */   }
/*    */   
/*    */   public int getPoints() {
/* 34 */     return this.points;
/*    */   }
/*    */   
/*    */   public void setPoints(int points) {
/* 38 */     this.points = points;
/*    */   }
/*    */   
/*    */   public int getRank() {
/* 42 */     return this.rank;
/*    */   }
/*    */   
/*    */   public void setRank(int rank) {
/* 46 */     this.rank = rank;
/*    */   }
/*    */   
/*    */   public int getTotal_ranks() {
/* 50 */     return this.total_ranks;
/*    */   }
/*    */   
/*    */   public void setTotal_ranks(int total_ranks) {
/* 54 */     this.total_ranks = total_ranks;
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\bean\UserRankBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */