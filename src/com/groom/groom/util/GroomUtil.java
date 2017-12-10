/*     */ package com.groom.util;
/*     */ 
/*     */ import com.groom.bean.User;
/*     */ import java.io.PrintStream;
/*     */ import java.security.Key;
/*     */ import java.sql.Time;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Properties;
/*     */ import java.util.Random;
/*     */ import java.util.TimeZone;
/*     */ import java.util.UUID;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ import javax.mail.Message;
/*     */ import javax.mail.Message.RecipientType;
/*     */ import javax.mail.Session;
/*     */ import javax.mail.Transport;
/*     */ import javax.mail.internet.InternetAddress;
/*     */ import javax.mail.internet.MimeMessage;
/*     */ import sun.misc.BASE64Decoder;
/*     */ import sun.misc.BASE64Encoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GroomUtil
/*     */ {
/*     */   private static final String ALGO = "AES";
/*  30 */   private static final byte[] keyValue = { 103, 114, 111, 111, 
/*  31 */     109, 52, 106, 101, 101, 111, 102, 98, 111, 106, 106, 97 };
/*     */   private static final String HOST = "smtpout.asia.secureserver.net";
/*     */   private static final String MAIL_AUTH_USER = "info@groom4more.com";
/*     */   private static final String MAIL_AUTH_PASSWORD = "Bojja9977";
/*     */   
/*     */   private static Key generateKey() throws Exception {
/*  37 */     Key key = new SecretKeySpec(keyValue, "AES");
/*  38 */     return key;
/*     */   }
/*     */   
/*     */   public static String getEncryptedPassword(String password)
/*     */   {
/*     */     try {
/*  44 */       Key key = generateKey();
/*  45 */       Cipher c = Cipher.getInstance("AES");
/*  46 */       c.init(1, key);
/*  47 */       byte[] encVal = c.doFinal(password.getBytes());
/*  48 */       return new BASE64Encoder().encode(encVal);
/*     */     }
/*     */     catch (Exception exception) {
/*  51 */       exception.printStackTrace();
/*     */     }
/*  53 */     return null;
/*     */   }
/*     */   
/*     */   public static String getDecryptedPassword(String encryptedPassword)
/*     */   {
/*     */     try {
/*  59 */       Key key = generateKey();
/*  60 */       Cipher c = Cipher.getInstance("AES");
/*  61 */       c.init(2, key);
/*  62 */       byte[] decordedValue = new BASE64Decoder()
/*  63 */         .decodeBuffer(encryptedPassword);
/*  64 */       byte[] decValue = c.doFinal(decordedValue);
/*  65 */       return new String(decValue);
/*     */     }
/*     */     catch (Exception exception) {
/*  68 */       exception.printStackTrace();
/*     */     }
/*  70 */     return null;
/*     */   }
/*     */   
/*     */   public static java.sql.Date getCurrentDate()
/*     */   {
/*  75 */     Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  80 */     long time = calendar.getTimeInMillis();
/*     */     
/*  82 */     java.sql.Date currentDate = new java.sql.Date(time);
/*     */     
/*  84 */     return currentDate;
/*     */   }
/*     */   
/*     */   public static java.sql.Date convertStringtoSqlDate(String date)
/*     */     throws ParseException
/*     */   {
/*  90 */     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
/*  91 */     java.util.Date parsed = format.parse(date);
/*  92 */     java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
/*     */     
/*  94 */     return sqlDate;
/*     */   }
/*     */   
/*     */   public static Time getSqlTimeDiff(String totalTime, String balTime)
/*     */   {
/*  99 */     long hours = 0L;long minutes = 0L;long seconds = 0L;
/*     */     try {
/* 101 */       Time oldTime = Time.valueOf(totalTime);
/* 102 */       Time currentTime = Time.valueOf(balTime);
/* 103 */       long milliseconds1 = oldTime.getTime();
/* 104 */       long milliseconds2 = currentTime.getTime();
/* 105 */       long diff = milliseconds2 - milliseconds1;
/* 106 */       long diffSeconds = diff / 1000L;
/* 107 */       hours = Math.abs(diffSeconds) / 3600L;
/* 108 */       minutes = Math.abs(diffSeconds) % 3600L / 60L;
/* 109 */       seconds = Math.abs(diffSeconds) % 60L;
/*     */     } catch (Exception exception) {
/* 111 */       exception.printStackTrace();
/*     */     }
/* 113 */     return convertStringToSqlTime(hours + ":" + minutes + ":" + seconds);
/*     */   }
/*     */   
/*     */   public static Time convertStringToSqlTime(String time) {
/* 117 */     Time sqlTime = null;
/*     */     try {
/* 119 */       SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
/* 120 */       java.util.Date utilDate = format.parse(time);
/* 121 */       long t = utilDate.getTime();
/* 122 */       sqlTime = new Time(t);
/*     */     } catch (ParseException exception) {
/* 124 */       exception.printStackTrace();
/*     */     }
/* 126 */     return sqlTime;
/*     */   }
/*     */   
/*     */   public static boolean sendMail(String from, String to, String subjectText, String bodyText, String mailTitle)
/*     */     throws Exception
/*     */   {
/* 132 */     Properties properties = new Properties();
/*     */     
/* 134 */     properties.put("mail.transport.protocol", "smtp");
/* 135 */     properties.put("mail.smtp.host", "smtpout.asia.secureserver.net");
/* 136 */     properties.put("mail.smtp.starttls.enable", Boolean.valueOf(false));
/* 137 */     properties.put("mail.smtp.auth", "true");
/* 138 */     properties.put("mail.smtp.port", "3535");
/*     */     try
/*     */     {
/* 141 */       Session session = Session.getDefaultInstance(properties, 
/* 142 */         new GroomUtil.1());
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 149 */       Message message = new MimeMessage(session);
/* 150 */       InternetAddress fromAddress = new InternetAddress(from, mailTitle);
/* 151 */       message.setFrom(fromAddress);
/* 152 */       message.setRecipients(Message.RecipientType.TO, 
/* 153 */         InternetAddress.parse(to));
/*     */       
/* 155 */       message.setSubject(subjectText);
/* 156 */       message.setContent(bodyText, "text/html; charset=ISO-8859-1");
/*     */       
/* 158 */       Transport.send(message);
/* 159 */       return true;
/*     */     }
/*     */     catch (Exception e) {
/* 162 */       e.printStackTrace(); }
/* 163 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String generateActivationCode(String customString, int length)
/*     */   {
/* 170 */     String AB = "0123456789" + customString + 
/* 171 */       "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
/* 172 */     Random rnd = new Random();
/*     */     
/* 174 */     StringBuilder sb = new StringBuilder(length);
/* 175 */     for (int i = 0; i < length; i++)
/* 176 */       sb.append(AB.charAt(rnd.nextInt(AB.length())));
/* 177 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static String buidRegistrationMail(User user, String activationCode)
/*     */   {
/* 182 */     String body = "<div class=\"well\"><div class=\"row\"><img src=\"groom4more.com/images/gr.png\" alt=\"Logo\"></div><div class=\"row\"><div class=\"col-md-1\"></div><div class=\"col-md-10\"><h3>Welcome to the Groom4More community,  " + 
/*     */     
/*     */ 
/*     */ 
/* 186 */       user.getFirstname() + 
/* 187 */       " !</h3>" + 
/* 188 */       "<p>You have registered with the Username as <b>" + 
/* 189 */       user.getUsername() + 
/* 190 */       "</b></p>" + 
/* 191 */       "<p>Please click the below activation link to activate your account :</p>" + 
/* 192 */       "<a href=\"http://groom4more.com/user-activation?acode=" + activationCode + 
/* 193 */       "\">Activate Groom4more Account</a>" + 
/* 194 */       "<p>For future reference, we are sharing the details you\tprovided us with :</p>" + 
/* 195 */       "<br>" + 
/* 196 */       "<div class=\"col-md-2\"></div>" + 
/* 197 */       "<table>" + 
/* 198 */       "<thead></thead>" + 
/* 199 */       "<tbody>" + 
/* 200 */       "<tr><td>User Name :</td><td>" + 
/* 201 */       user.getUsername() + 
/* 202 */       "</td></tr>" + 
/* 203 */       "<tr><td>User Password :</td><td>" + 
/* 204 */       user.getPassword() + 
/* 205 */       "</td></tr>" + 
/* 206 */       "<tr><td>Full Name :</td><td>" + 
/* 207 */       user.getFirstname() + 
/* 208 */       " " + 
/* 209 */       user.getLastname() + 
/* 210 */       "</td></tr>" + 
/* 211 */       "<tr><td>Email ID :</td><td>" + 
/* 212 */       user.getMail() + 
/* 213 */       "</td></tr>" + 
/* 214 */       "<tr><td>Mobile/Phone Number :</td><td>" + 
/* 215 */       user.getMobile() + 
/* 216 */       "</td></tr>" + 
/* 217 */       "<tr><td>Class :</td><td>" + 
/* 218 */       user.getStandard() + 
/* 219 */       "</td></tr>" + 
/* 220 */       "</tbody>" + 
/* 221 */       "</table>" + 
/* 222 */       "<br>" + 
/* 223 */       "<p>If you need assistance or have any queries, feel free to call us up at 97013 20902</p>" + 
/* 224 */       "<p>You can also email us at <a href=\"#\">info@groom4more.com</a> and our team will get in touch with you as soon as possible.</p>" + 
/* 225 */       "<h3>All the best !</h3>" + 
/* 226 */       "<p>Regards, The Groom4More Team.</p>" + 
/* 227 */       "</div>" + 
/* 228 */       "</div>" + 
/* 229 */       "</div>";
/* 230 */     return body;
/*     */   }
/*     */   
/*     */   public static String buidForgotPwdMail(String pwd) {
/* 234 */     String body = "<div class=\"well\"><div class=\"row\"><img src=\"groom4more.com/images/gr.png\" alt=\"Logo\"></div><div class=\"row\"><div class=\"col-md-1\"></div><div class=\"col-md-10\"><h3>Password for your Groom4More account is  " + 
/*     */     
/*     */ 
/*     */ 
/* 238 */       getDecryptedPassword(pwd) + 
/* 239 */       "</h3>" + 
/*     */       
/* 241 */       "<br>" + 
/* 242 */       "<p>Please ignore if you are not requested your password</p>" + 
/* 243 */       "<p>If you need assistance or have any queries, feel free to call us up at 97013 20902</p>" + 
/* 244 */       "<p>You can also email us at <a href=\"#\">info@groom4more.com</a> and our team will get in touch with you as soon as possible.</p>" + 
/*     */       
/* 246 */       "<p>Regards, The Groom4More Team.</p>" + "</div>" + "</div>" + 
/* 247 */       "</div>";
/* 248 */     return body;
/*     */   }
/*     */   
/*     */   public static String getActivationCode()
/*     */   {
/* 253 */     String aCode = UUID.randomUUID().toString();
/*     */     
/* 255 */     System.out.println("Activation code is : " + aCode);
/* 256 */     return aCode;
/*     */   }
/*     */   
/*     */   public static String buidProdigiesMail(String username, int id) {
/* 260 */     String body = "<div style='background-color: #d9edf7; border-color: #bce8f1; color: #31708f; padding: 15px; margin-bottom: 20px; border: 1px solid transparent;'><p>&nbsp;</p><img src='http://groom4more.com/images/prodigies.jpg' style='width: 100%'<h4>Dear " + 
/*     */     
/*     */ 
/*     */ 
/* 264 */       username + 
/* 265 */       ", THANKS for participating in the PRODIGIES!</h4>" + 
/* 266 */       "<p>You are now competing with the best and the brightest from across the country in solving problems faced by people every day. Let's do our bit in suggesting solutions and ideas that can improve the lives of hundreds of millions of people.</p>" + 
/* 267 */       "<p>You can check out your entry at <a href='www.groom4more.com/jsp/prodigy/entry.jsp?id=" + 
/* 268 */       id + "'>www.groom4more.com/prodigy/entry.jsp?id=" + 
/* 269 */       id + "</a></p>" + 
/* 270 */       "<br>" + 
/* 271 */       "<br>" + 
/* 272 */       "<p>Top 10% of the entries in this round will be selected for the second round. The results will be announced on the 12th of December, 2016. You will be informed about the guidelines for the second round, if your team gets selected for the second round.</p>" + 
/* 273 */       "<p>The top 5 entries with the highest votes will get automatic selection into round 2. So promote your entry among your friends and family so that you can get into the second round automatically. You can also check out the entries submitted by others.</p>" + 
/* 274 */       "<h3>All the best !</h3>" + 
/* 275 */       "<p>Thanks & Regards</p>" + 
/* 276 */       "<p>Team Groom4More.com</p>" + 
/* 277 */       "+9550 114466" + 
/* 278 */       "yuva@groom4more.com" + 
/* 279 */       "</div>";
/* 280 */     return body;
/*     */   }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\util\GroomUtil.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */