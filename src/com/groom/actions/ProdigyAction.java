/*     */ package com.groom.actions;
/*     */ 
/*     */ import com.groom.bean.User;
/*     */ import com.groom.service.MiscService;
/*     */ import com.groom.service.UserService;
/*     */ import com.groom.service.impl.MiscServiceImpl;
/*     */ import com.groom.service.impl.UserServiceImpl;
/*     */ import com.groom.util.GroomUtil;
/*     */ import com.opensymphony.xwork2.ActionSupport;
/*     */ import com.opensymphony.xwork2.ModelDriven;
/*     */ import com.opensymphony.xwork2.validator.annotations.EmailValidator;
/*     */ import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
/*     */ import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
/*     */ import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ import org.apache.struts2.convention.annotation.Action;
/*     */ import org.apache.struts2.convention.annotation.Results;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Results({@org.apache.struts2.convention.annotation.Result(name="input", location="/jsp/prodigy/prodigies-form.jsp"), @org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/prodigy/prodigies_success.jsp"), @org.apache.struts2.convention.annotation.Result(name="error", location="/jsp/prodigy/prodigies-form.jsp")})
/*     */ public class ProdigyAction
/*     */   extends ActionSupport
/*     */   implements ModelDriven<User>
/*     */ {
/*  31 */   HttpSession session = ServletActionContext.getRequest().getSession(false);
/*     */   
/*     */   private String teamname;
/*     */   
/*     */   private String schoolname;
/*     */   private String teamdetails;
/*     */   private String city;
/*     */   private String email;
/*     */   private String phone;
/*     */   private String theme;
/*     */   private String title;
/*     */   private String youridea;
/*     */   private Integer id;
/*     */   
/*     */   @Action("prodigy_submission")
/*     */   public String execute()
/*     */     throws Exception
/*     */   {
/*  49 */     User user = (User)this.session.getAttribute("user");
/*  50 */     UserService userService = new UserServiceImpl();
/*  51 */     MiscService miscService = new MiscServiceImpl();
/*     */     
/*  53 */     int id = miscService.addprodigy(user.getUsername().toString(), this.teamname, this.schoolname, this.teamdetails, this.city, this.email, this.phone, this.theme, this.title, this.youridea);
/*     */     
/*  55 */     if (id != 0)
/*     */     {
/*  57 */       String from = "bojja@groom4more.com";
/*  58 */       String bodyText = GroomUtil.buidProdigiesMail(user.getUsername(), id);
/*  59 */       String mailTitle = "Prodigy Submission at Groom4More";
/*  60 */       GroomUtil.sendMail(from, user.getMail(), "Welome to Prodigies", 
/*  61 */         bodyText, mailTitle);
/*  62 */       return "success";
/*     */     }
/*  64 */     addActionError("There is a problem with prodigy submmission.Please try again later");
/*  65 */     return "error";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequiredStringValidator(message="Team Name required")
/*     */   @StringLengthFieldValidator(trim=true, minLength="3", maxLength="15", message="length shoulb be between 3 and 15")
/*     */   public String getTeamname()
/*     */   {
/*  74 */     return this.teamname;
/*     */   }
/*     */   
/*     */   public void setTeamname(String teamname) {
/*  78 */     this.teamname = teamname;
/*     */   }
/*     */   
/*     */   @StringLengthFieldValidator(maxLength="25", minLength="5", message="length shoulb be between 5 and 25", trim=false)
/*     */   @RequiredStringValidator(message="Enter Your School Name")
/*     */   public String getSchoolname() {
/*  84 */     return this.schoolname;
/*     */   }
/*     */   
/*     */   public void setSchoolname(String schoolname) {
/*  88 */     this.schoolname = schoolname;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Team Details required")
/*     */   @StringLengthFieldValidator(trim=true, minLength="10", maxLength="500", message="length shoulb be between 10 and 500")
/*     */   public String getTeamdetails()
/*     */   {
/*  95 */     return this.teamdetails;
/*     */   }
/*     */   
/*     */   public void setTeamdetails(String teamdetails) {
/*  99 */     this.teamdetails = teamdetails;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="City required")
/*     */   @RegexFieldValidator(message="should start with alphabet and only dot,underscore,dash are allowed", regex="^[a-zA-Z][a-zA-Z0-9._-]+$")
/*     */   @StringLengthFieldValidator(trim=true, minLength="3", maxLength="15", message="length shoulb be between 3 and 15")
/*     */   public String getCity() {
/* 106 */     return this.city;
/*     */   }
/*     */   
/*     */   public void setCity(String city) {
/* 110 */     this.city = city;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Email required")
/*     */   @EmailValidator(message="invalid email")
/*     */   public String getEmail() {
/* 116 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 120 */     this.email = email;
/*     */   }
/*     */   
/*     */   @StringLengthFieldValidator(maxLength="10", minLength="10", message="length shoulb be 10 only", trim=false)
/*     */   @RequiredStringValidator(message="Enter Moblie Number")
/*     */   @RegexFieldValidator(message="only numbers allowed", regex="^[0-9]+$")
/*     */   public String getPhone() {
/* 127 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 131 */     this.phone = phone;
/*     */   }
/*     */   
/*     */ 
/*     */   @RequiredStringValidator(message="Select Your Theme")
/*     */   public String getTheme()
/*     */   {
/* 138 */     return this.theme;
/*     */   }
/*     */   
/*     */   public void setTheme(String theme) {
/* 142 */     this.theme = theme;
/*     */   }
/*     */   
/*     */   @StringLengthFieldValidator(minLength="3", message="enter atleast 3 letters", trim=false)
/*     */   @RequiredStringValidator(message="Project Title required")
/*     */   public String getTitle()
/*     */   {
/* 149 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/* 153 */     this.title = title;
/*     */   }
/*     */   
/*     */   @RequiredStringValidator(message="Enter Your Idea")
/*     */   @StringLengthFieldValidator(minLength="25", maxLength="5000", message="content length should be in between 25-5000", trim=false)
/*     */   public String getYouridea() {
/* 159 */     return this.youridea;
/*     */   }
/*     */   
/*     */   public void setYouridea(String youridea) {
/* 163 */     this.youridea = youridea;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getModel()
/*     */   {
/* 170 */     return null;
/*     */   }
/*     */   
/*     */   @Action("submit-vote")
/*     */   public String execute1() throws Exception
/*     */   {
/* 176 */     MiscService miscService = new MiscServiceImpl();
/*     */     
/* 178 */     if (this.session.getAttribute("user") != null) {
/* 179 */       User user = (User)this.session.getAttribute("user");
/* 180 */       String username = user.getUsername();
/* 181 */       if (miscService.voteProdigyEntry(username, this.id.intValue())) {
/* 182 */         return "success";
/*     */       }
/* 184 */       addActionError("You have already voted for today, Try again tomorrow");
/*     */     }
/*     */     else
/*     */     {
/* 188 */       addActionError("You must login to vote");
/* 189 */       return "error";
/*     */     }
/* 191 */     return "success";
/*     */   }
/*     */   
/*     */   public Integer getId()
/*     */   {
/* 196 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/* 200 */     this.id = id;
/*     */   }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\actions\ProdigyAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */