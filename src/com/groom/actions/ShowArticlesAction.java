/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.bean.Article;
/*    */ import com.groom.service.ArticleService;
/*    */ import com.groom.service.impl.ArticleServiceImpl;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.util.List;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ import org.apache.struts2.convention.annotation.ParentPackage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ParentPackage("default")
/*    */ @Action(value="show-articles", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/blog.jsp")})
/*    */ public class ShowArticlesAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 20 */   ArticleService articleService = new ArticleServiceImpl();
/*    */   private List<Article> articleList;
/*    */   
/*    */   public List<Article> getArticleList()
/*    */   {
/* 25 */     return this.articleList;
/*    */   }
/*    */   
/*    */   public void setArticleList(List<Article> articleList) {
/* 29 */     this.articleList = articleList;
/*    */   }
/*    */   
/*    */   public String execute() throws Exception
/*    */   {
/* 34 */     setArticleList(this.articleService.getAllArticles());
/*    */     
/* 36 */     return "success";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\ShowArticlesAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */