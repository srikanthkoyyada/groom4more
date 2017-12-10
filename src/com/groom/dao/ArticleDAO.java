package com.groom.dao;

import com.groom.bean.Article;
import java.sql.SQLException;
import java.util.List;

public abstract interface ArticleDAO
{
  public abstract List<Article> getAllArticles()
    throws SQLException;
  
  public abstract Article getArticle(int paramInt)
    throws SQLException;
  
  public abstract boolean updateArticleViewsCount(int paramInt)
    throws SQLException;
}


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\dao\ArticleDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */