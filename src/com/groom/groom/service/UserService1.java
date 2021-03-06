package com.groom.service;

import com.groom.bean.User;
import com.groom.bean.UserActivation;
import java.sql.SQLException;

public abstract interface UserService
{
  public abstract boolean validateUser(User paramUser)
    throws SQLException;
  
  public abstract int registerUser(User paramUser)
    throws SQLException;
  
  public abstract boolean saveUserActivationRecord(UserActivation paramUserActivation)
    throws SQLException;
  
  public abstract boolean activateUser(String paramString)
    throws SQLException;
  
  public abstract String isUsernameAvailable(String paramString)
    throws SQLException;
  
  public abstract String isMailAvailable(String paramString)
    throws SQLException;
  
  public abstract String isPhoneNumberAvailable(String paramString)
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
}


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\service\UserService1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */