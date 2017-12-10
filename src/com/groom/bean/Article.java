/*    */ package com.groom.bean;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Article
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private int articleid;
/*    */   private String article_title;
/*    */   private String article_text;
/*    */   private String article_date;
/*    */   private int no_of_views;
/*    */   private String user;
/*    */   private String tags;
/*    */   
/*    */   public String getTags()
/*    */   {
/* 22 */     return this.tags;
/*    */   }
/*    */   
/*    */   public void setTags(String tags) {
/* 26 */     this.tags = tags;
/*    */   }
/*    */   
/*    */   public int getArticleid() {
/* 30 */     return this.articleid;
/*    */   }
/*    */   
/*    */   public void setArticleid(int articleid) {
/* 34 */     this.articleid = articleid;
/*    */   }
/*    */   
/*    */   public String getArticle_title() {
/* 38 */     return this.article_title;
/*    */   }
/*    */   
/*    */   public void setArticle_title(String article_title) {
/* 42 */     this.article_title = article_title;
/*    */   }
/*    */   
/*    */   public String getArticle_text() {
/* 46 */     return this.article_text;
/*    */   }
/*    */   
/*    */   public void setArticle_text(String article_text) {
/* 50 */     this.article_text = article_text;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getArticle_date()
/*    */   {
/* 56 */     return this.article_date;
/*    */   }
/*    */   
/*    */   public void setArticle_date(String article_date) {
/* 60 */     this.article_date = article_date;
/*    */   }
/*    */   
/*    */   public int getNo_of_views() {
/* 64 */     return this.no_of_views;
/*    */   }
/*    */   
/*    */   public void setNo_of_views(int no_of_views) {
/* 68 */     this.no_of_views = no_of_views;
/*    */   }
/*    */   
/*    */   public String getUser() {
/* 72 */     return this.user;
/*    */   }
/*    */   
/*    */   public void setUser(String user) {
/* 76 */     this.user = user;
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\bean\Article.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */