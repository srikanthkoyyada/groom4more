/*    */ package com.groom.actions;
/*    */ 
/*    */ import com.groom.bean.Article;
/*    */ import com.groom.service.ArticleService;
/*    */ import com.groom.service.impl.ArticleServiceImpl;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import org.apache.struts2.convention.annotation.Action;
/*    */ import org.apache.struts2.convention.annotation.ParentPackage;
/*    */ 
/*    */ 
/*    */ 
/*    */ @ParentPackage("default")
/*    */ @Action(value="show-article-content", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/blog-article-content.jsp")})
/*    */ public class ShowArticleContentAction
/*    */   extends ActionSupport
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 18 */   ArticleService articleService = new ArticleServiceImpl();
/*    */   
/*    */   private Article article;
/*    */   private String id;
/*    */   
/*    */   public String getId()
/*    */   {
/* 25 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(String id) {
/* 29 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Article getArticle() {
/* 33 */     return this.article;
/*    */   }
/*    */   
/*    */   public void setArticle(Article article) {
/* 37 */     this.article = article;
/*    */   }
/*    */   
/*    */   public String execute() throws Exception
/*    */   {
/* 42 */     this.articleService.updateArticleViewsCount(Integer.parseInt(getId()));
/* 43 */     setArticle(this.articleService.getArticle(Integer.parseInt(getId())));
/*    */     
/* 45 */     return "success";
/*    */   }
/*    */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\ShowArticleContentAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */