/*     */ package com.groom.bean;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SubjectAnalysisBean
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private int user_id;
/*     */   private String first_name;
/*     */   private String last_name;
/*     */   private int maths_points;
/*     */   private int physics_points;
/*     */   private int chemistry_points;
/*     */   private int maths_rank;
/*     */   private int physics_rank;
/*     */   private int chemistry_rank;
/*     */   private int total_ranks;
/*     */   private double physics_percentile;
/*     */   private double maths_percentile;
/*     */   private double chemistry_percentile;
/*     */   
/*     */   public double getPhysics_percentile()
/*     */   {
/*  28 */     return this.physics_percentile;
/*     */   }
/*     */   
/*  31 */   public void setPhysics_percentile(double physics_percentile) { this.physics_percentile = physics_percentile; }
/*     */   
/*     */   public double getMaths_percentile() {
/*  34 */     return this.maths_percentile;
/*     */   }
/*     */   
/*  37 */   public void setMaths_percentile(double maths_percentile) { this.maths_percentile = maths_percentile; }
/*     */   
/*     */   public double getChemistry_percentile() {
/*  40 */     return this.chemistry_percentile;
/*     */   }
/*     */   
/*  43 */   public void setChemistry_percentile(double chemistry_percentile) { this.chemistry_percentile = chemistry_percentile; }
/*     */   
/*     */   public int getUser_id() {
/*  46 */     return this.user_id;
/*     */   }
/*     */   
/*  49 */   public void setUser_id(int user_id) { this.user_id = user_id; }
/*     */   
/*     */   public String getFirst_name() {
/*  52 */     return this.first_name;
/*     */   }
/*     */   
/*  55 */   public void setFirst_name(String first_name) { this.first_name = first_name; }
/*     */   
/*     */   public String getLast_name() {
/*  58 */     return this.last_name;
/*     */   }
/*     */   
/*  61 */   public void setLast_name(String last_name) { this.last_name = last_name; }
/*     */   
/*     */   public int getMaths_points() {
/*  64 */     return this.maths_points;
/*     */   }
/*     */   
/*  67 */   public void setMaths_points(int maths_points) { this.maths_points = maths_points; }
/*     */   
/*     */   public int getPhysics_points() {
/*  70 */     return this.physics_points;
/*     */   }
/*     */   
/*  73 */   public void setPhysics_points(int physics_points) { this.physics_points = physics_points; }
/*     */   
/*     */   public int getChemistry_points() {
/*  76 */     return this.chemistry_points;
/*     */   }
/*     */   
/*  79 */   public void setChemistry_points(int chemistry_points) { this.chemistry_points = chemistry_points; }
/*     */   
/*     */   public int getMaths_rank() {
/*  82 */     return this.maths_rank;
/*     */   }
/*     */   
/*  85 */   public void setMaths_rank(int maths_rank) { this.maths_rank = maths_rank; }
/*     */   
/*     */   public int getPhysics_rank() {
/*  88 */     return this.physics_rank;
/*     */   }
/*     */   
/*  91 */   public void setPhysics_rank(int physics_rank) { this.physics_rank = physics_rank; }
/*     */   
/*     */   public int getChemistry_rank() {
/*  94 */     return this.chemistry_rank;
/*     */   }
/*     */   
/*  97 */   public void setChemistry_rank(int chemistry_rank) { this.chemistry_rank = chemistry_rank; }
/*     */   
/*     */   public int getTotal_ranks() {
/* 100 */     return this.total_ranks;
/*     */   }
/*     */   
/* 103 */   public void setTotal_ranks(int total_ranks) { this.total_ranks = total_ranks; }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\bean\SubjectAnalysisBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */