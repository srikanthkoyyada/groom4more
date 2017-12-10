package com.groom.service;

import com.groom.bean.QuizQuestionDetails;
import com.groom.bean.Shine;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public abstract interface AdminService
{
  public abstract boolean addSubjectTopic(String paramString1, String paramString2, int paramInt1, Date paramDate, int paramInt2, String paramString3, int paramInt3)
    throws SQLException;
  
  public abstract HashMap<Integer, String> getTopics(String paramString)
    throws SQLException;
  
  public abstract int getMaxID(String paramString)
    throws SQLException;
  
  public abstract boolean saveQuestion(QuizQuestionDetails paramQuizQuestionDetails, String paramString1, String paramString2)
    throws SQLException;
  
  public abstract boolean updateQuestion(QuizQuestionDetails paramQuizQuestionDetails, String paramString1, String paramString2)
    throws SQLException;
  
  public abstract List<String> getShineResultNames()
    throws SQLException;
  
  public abstract Shine getUserResults(int paramInt, String paramString1, String paramString2)
    throws SQLException;
  
  public abstract HashMap<Integer, String> getTestCategories()
    throws SQLException;
  
  public abstract HashMap<Integer, String> getTopicsByStandard(String paramString, int paramInt1, int paramInt2)
    throws SQLException;
  
  public abstract HashMap<String, String> getCategoryByStandard(int paramInt)
    throws SQLException;
  
  public abstract boolean validateAdmin(String paramString1, String paramString2)
    throws SQLException;
}


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\service\AdminService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */