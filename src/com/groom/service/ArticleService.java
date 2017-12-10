package com.groom.service;

import com.groom.bean.Article;
import java.sql.SQLException;
import java.util.List;

public abstract interface ArticleService
{
  public abstract List<Article> getAllArticles()
    throws SQLException;
  
  public abstract Article getArticle(int paramInt)
    throws SQLException;
  
  public abstract boolean updateArticleViewsCount(int paramInt)
    throws SQLException;
}


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\service\ArticleService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */