/*     */ package com.groom.bean;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ public class Shine
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private int id;
/*     */   private String name;
/*     */   private int standard;
/*     */   private String rool_number;
/*     */   private String school_code;
/*     */   private int ma_right;
/*     */   private int ma_ua;
/*     */   private int ma_wrong;
/*     */   private int m_right;
/*     */   private int m_ua;
/*     */   private int m_wrong;
/*     */   private int pc_right;
/*     */   private int pc_ua;
/*     */   private int pc_wrong;
/*     */   private int b_right;
/*     */   private int b_ua;
/*     */   private int b_wrong;
/*     */   private int total_score;
/*     */   private int total_right;
/*     */   private int total_ua;
/*     */   private int total_wrong;
/*     */   
/*     */   public int getId()
/*     */   {
/*  34 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  38 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  42 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  46 */     this.name = name;
/*     */   }
/*     */   
/*     */   public int getStandard() {
/*  50 */     return this.standard;
/*     */   }
/*     */   
/*     */   public void setStandard(int standard) {
/*  54 */     this.standard = standard;
/*     */   }
/*     */   
/*     */   public String getRool_number() {
/*  58 */     return this.rool_number;
/*     */   }
/*     */   
/*     */   public void setRool_number(String rool_number) {
/*  62 */     this.rool_number = rool_number;
/*     */   }
/*     */   
/*     */   public String getSchool_code() {
/*  66 */     return this.school_code;
/*     */   }
/*     */   
/*     */   public void setSchool_code(String school_code) {
/*  70 */     this.school_code = school_code;
/*     */   }
/*     */   
/*     */   public int getMa_right() {
/*  74 */     return this.ma_right;
/*     */   }
/*     */   
/*     */   public void setMa_right(int ma_right) {
/*  78 */     this.ma_right = ma_right;
/*     */   }
/*     */   
/*     */   public int getMa_ua() {
/*  82 */     return this.ma_ua;
/*     */   }
/*     */   
/*     */   public void setMa_ua(int ma_ua) {
/*  86 */     this.ma_ua = ma_ua;
/*     */   }
/*     */   
/*     */   public int getMa_wrong() {
/*  90 */     return this.ma_wrong;
/*     */   }
/*     */   
/*     */   public void setMa_wrong(int ma_wrong) {
/*  94 */     this.ma_wrong = ma_wrong;
/*     */   }
/*     */   
/*     */   public int getM_right() {
/*  98 */     return this.m_right;
/*     */   }
/*     */   
/*     */   public void setM_right(int m_right) {
/* 102 */     this.m_right = m_right;
/*     */   }
/*     */   
/*     */   public int getM_ua() {
/* 106 */     return this.m_ua;
/*     */   }
/*     */   
/*     */   public void setM_ua(int m_ua) {
/* 110 */     this.m_ua = m_ua;
/*     */   }
/*     */   
/*     */   public int getM_wrong() {
/* 114 */     return this.m_wrong;
/*     */   }
/*     */   
/*     */   public void setM_wrong(int m_wrong) {
/* 118 */     this.m_wrong = m_wrong;
/*     */   }
/*     */   
/*     */   public int getPc_right() {
/* 122 */     return this.pc_right;
/*     */   }
/*     */   
/*     */   public void setPc_right(int pc_right) {
/* 126 */     this.pc_right = pc_right;
/*     */   }
/*     */   
/*     */   public int getPc_ua() {
/* 130 */     return this.pc_ua;
/*     */   }
/*     */   
/*     */   public void setPc_ua(int pc_ua) {
/* 134 */     this.pc_ua = pc_ua;
/*     */   }
/*     */   
/*     */   public int getPc_wrong() {
/* 138 */     return this.pc_wrong;
/*     */   }
/*     */   
/*     */   public void setPc_wrong(int pc_wrong) {
/* 142 */     this.pc_wrong = pc_wrong;
/*     */   }
/*     */   
/*     */   public int getB_right() {
/* 146 */     return this.b_right;
/*     */   }
/*     */   
/*     */   public void setB_right(int b_right) {
/* 150 */     this.b_right = b_right;
/*     */   }
/*     */   
/*     */   public int getB_ua() {
/* 154 */     return this.b_ua;
/*     */   }
/*     */   
/*     */   public void setB_ua(int b_ua) {
/* 158 */     this.b_ua = b_ua;
/*     */   }
/*     */   
/*     */   public int getB_wrong() {
/* 162 */     return this.b_wrong;
/*     */   }
/*     */   
/*     */   public void setB_wrong(int b_wrong) {
/* 166 */     this.b_wrong = b_wrong;
/*     */   }
/*     */   
/*     */   public int getTotal_score() {
/* 170 */     return this.total_score;
/*     */   }
/*     */   
/*     */   public void setTotal_score(int total_score) {
/* 174 */     this.total_score = total_score;
/*     */   }
/*     */   
/*     */   public int getTotal_right() {
/* 178 */     return this.total_right;
/*     */   }
/*     */   
/*     */   public void setTotal_right(int total_right) {
/* 182 */     this.total_right = total_right;
/*     */   }
/*     */   
/*     */   public int getTotal_ua() {
/* 186 */     return this.total_ua;
/*     */   }
/*     */   
/*     */   public void setTotal_ua(int total_ua) {
/* 190 */     this.total_ua = total_ua;
/*     */   }
/*     */   
/*     */   public int getTotal_wrong() {
/* 194 */     return this.total_wrong;
/*     */   }
/*     */   
/*     */   public void setTotal_wrong(int total_wrong) {
/* 198 */     this.total_wrong = total_wrong;
/*     */   }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\bean\Shine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */