package com.groom.service;

import java.sql.SQLException;

public abstract interface MiscService
{
  public abstract int addprodigy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
    throws SQLException;
  
  public abstract boolean voteProdigyEntry(String paramString, int paramInt)
    throws SQLException;
}


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\service\MiscService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */