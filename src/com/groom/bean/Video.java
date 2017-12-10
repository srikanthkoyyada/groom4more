/*    */ package com.groom.bean;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Video implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private int standard;
/*    */   private String subject;
/*    */   private String title;
/*    */   private String description;
/*    */   private String url;
/*    */   private int id;
/*    */   
/*    */   public String getDescription()
/*    */   {
/* 17 */     return this.description;
/*    */   }
/*    */   
/*    */   public void setDescription(String description) {
/* 21 */     this.description = description;
/*    */   }
/*    */   
/*    */   public String getUrl() {
/* 25 */     return this.url;
/*    */   }
/*    */   
/*    */   public void setUrl(String url) {
/* 29 */     this.url = url;
/*    */   }
/*    */   
/*    */   public int getId() {
/* 33 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 37 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getSubject() {
/* 41 */     return this.subject;
/*    */   }
/*    */   
/*    */   public void setSubject(String subject) {
/* 45 */     this.subject = subject;
/*    */   }
/*    */   
/*    */   public String getTitle() {
/* 49 */     return this.title;
/*    */   }
/*    */   
/*    */   public void setTitle(String title) {
/* 53 */     this.title = title;
/*    */   }
/*    */   
/*    */   public int getStandard() {
/* 57 */     return this.standard;
/*    */   }
/*    */   
/*    */   public void setStandard(int standard) {
/* 61 */     this.standard = standard;
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\bean\Video.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */