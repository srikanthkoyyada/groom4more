package com.groom.dao;

import com.groom.bean.User;
import com.groom.bean.UserActivation;
import java.sql.SQLException;

public abstract interface UserDAO
{
  public abstract boolean validateUser(User paramUser)
    throws SQLException;
  
  public abstract int registerUser(User paramUser)
    throws SQLException;
  
  public abstract boolean saveUserActivationRecord(UserActivation paramUserActivation)
    throws SQLException;
  
  public abstract boolean activateUser(String paramString)
    throws SQLException;
  
  public abstract boolean isUsernameExist(String paramString)
    throws SQLException;
  
  public abstract boolean isMailExist(String paramString)
    throws SQLException;
  
  public abstract boolean isPhoneNumberExist(String paramString)
    throws SQLException;
  
  public abstract User getUserDetails(String paramString)
    throws SQLException;
  
  public abstract User getUserDetails(int paramInt)
    throws SQLException;
  
  public abstract User getUserForgotPwdDetails(String paramString)
    throws SQLException;
  
  public abstract boolean updateUserSubjectPoints(String paramString, int paramInt1, int paramInt2)
    throws SQLException;
  
  public abstract boolean updateUserTotalPoints(int paramInt1, int paramInt2)
    throws SQLException;
  
  public abstract int addprodigy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    throws SQLException;
  
  public abstract void incLoginCount(String paramString)
    throws SQLException;
  
  public abstract boolean updateDetails(String paramString1, String paramString2, String paramString3)
    throws SQLException;
}


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\dao\UserDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */