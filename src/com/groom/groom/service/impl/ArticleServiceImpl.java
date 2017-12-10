/*    */ package com.groom.service.impl;
/*    */ 
/*    */ import com.groom.bean.Article;
/*    */ import com.groom.dao.ArticleDAO;
/*    */ import com.groom.dao.impl.ArticleDAOImpl;
/*    */ import com.groom.service.ArticleService;
/*    */ import java.sql.SQLException;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ArticleServiceImpl
/*    */   implements ArticleService
/*    */ {
/* 13 */   ArticleDAO dao = new ArticleDAOImpl();
/*    */   
/*    */   public List<Article> getAllArticles() throws SQLException
/*    */   {
/* 17 */     return this.dao.getAllArticles();
/*    */   }
/*    */   
/*    */   public Article getArticle(int articleid)
/*    */     throws SQLException
/*    */   {
/* 23 */     return this.dao.getArticle(articleid);
/*    */   }
/*    */   
/*    */   public boolean updateArticleViewsCount(int articleid) throws SQLException
/*    */   {
/* 28 */     return this.dao.updateArticleViewsCount(articleid);
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\service\impl\ArticleServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */