package com.groom.service;

import com.groom.bean.QuizPoints;
import com.groom.bean.QuizQuestionDetails;
import com.groom.bean.SubjectAnalysisBean;
import com.groom.bean.TestsTopicList;
import com.groom.bean.UserRankBean;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public abstract interface QuizService
{
  public abstract List<QuizQuestionDetails> getQuizDetails(String paramString, int paramInt)
    throws SQLException;
  
  public abstract List<QuizQuestionDetails> getQuizKey(String paramString, int paramInt1, int paramInt2)
    throws SQLException;
  
  public abstract Map<Integer, String> getQuizAnswers(String paramString1, String paramString2)
    throws SQLException;
  
  public abstract boolean saveQuizPoints(QuizPoints paramQuizPoints)
    throws SQLException;
  
  public abstract boolean getTestsAttemptedByUserStaus(int paramInt, String paramString)
    throws SQLException;
  
  public abstract List<TestsTopicList> getTestTopics(int paramInt1, String paramString, int paramInt2, int paramInt3)
    throws SQLException;
  
  public abstract boolean incrementQuestionsAttemptedCount(List<Integer> paramList, String paramString)
    throws SQLException;
  
  public abstract boolean incrementCorrectQuestionsAttemptedCount(List<Integer> paramList, String paramString)
    throws SQLException;
  
  public abstract QuizPoints getTopicScore(String paramString, int paramInt1, int paramInt2, int paramInt3)
    throws SQLException;
  
  public abstract UserRankBean getUserRankInSubjectTopic(String paramString, int paramInt1, int paramInt2)
    throws SQLException;
  
  public abstract UserRankBean getUserRankInSubjectTopicbyLocation(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
    throws SQLException;
  
  public abstract SubjectAnalysisBean getUserSubjectWiseAnalysis(int paramInt1, int paramInt2)
    throws SQLException;
  
  public abstract SubjectAnalysisBean getUserSubjectWiseAnalysisByLocation(int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws SQLException;
  
  public abstract List<TestsTopicList> getTestTopicsByCategory(int paramInt1, String paramString, int paramInt2, int paramInt3)
    throws SQLException;
  
  public abstract List<TestsTopicList> getTestTopicsByBoard(int paramInt1, String paramString, int paramInt2, int paramInt3)
    throws SQLException;
  
  public abstract List<TestsTopicList> getSampleTestTopics(int paramInt1, String paramString, int paramInt2, int paramInt3)
    throws SQLException;
}


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\service\QuizService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */