package com.groom.dao;

import com.groom.bean.QuizQuestionDetails;
import com.groom.bean.Shine;
import com.groom.bean.Video;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public abstract interface AdminDAO
{
  public abstract boolean addSubjectTopic(String paramString1, String paramString2, int paramInt1, Date paramDate, int paramInt2, String paramString3, int paramInt3)
    throws SQLException;
  
  public abstract HashMap<Integer, String> getTopics(String paramString)
    throws SQLException;
  
  public abstract int getMaxID(String paramString)
    throws SQLException;
  
  public abstract boolean saveQuestion(QuizQuestionDetails paramQuizQuestionDetails, String paramString)
    throws SQLException;
  
  public abstract List<String> getShineResultNames()
    throws SQLException;
  
  public abstract Shine getUserResults(int paramInt, String paramString1, String paramString2)
    throws SQLException;
  
  public abstract HashMap<Integer, String> getTestCategories()
    throws SQLException;
  
  public abstract boolean saveVideoURL(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws SQLException;
  
  public abstract List<Video> getAllVideos()
    throws SQLException;
  
  public abstract Video getVideoById(int paramInt)
    throws SQLException;
  
  public abstract List<Video> getAllVideosByStandardAndSubject(int paramInt, String paramString)
    throws SQLException;
}


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\dao\AdminDAO1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */