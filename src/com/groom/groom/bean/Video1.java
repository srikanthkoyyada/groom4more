/*    */ package com.groom.bean;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Video implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String subject;
/*    */   private String title;
/*    */   private String description;
/*    */   private String url;
/*    */   private int id;
/*    */   
/*    */   public String getDescription() {
/* 15 */     return this.description;
/*    */   }
/*    */   
/*    */   public void setDescription(String description) {
/* 19 */     this.description = description;
/*    */   }
/*    */   
/*    */   public String getUrl() {
/* 23 */     return this.url;
/*    */   }
/*    */   
/*    */   public void setUrl(String url) {
/* 27 */     this.url = url;
/*    */   }
/*    */   
/*    */   public int getId() {
/* 31 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 35 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getSubject() {
/* 39 */     return this.subject;
/*    */   }
/*    */   
/*    */   public void setSubject(String subject) {
/* 43 */     this.subject = subject;
/*    */   }
/*    */   
/*    */   public String getTitle() {
/* 47 */     return this.title;
/*    */   }
/*    */   
/*    */   public void setTitle(String title) {
/* 51 */     this.title = title;
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\bean\Video1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */