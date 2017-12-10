/*     */ package com.groom.actions;
/*     */ 
/*     */ import com.groom.bean.QuizQuestionDetails;
/*     */ import com.groom.service.AdminService;
/*     */ import com.groom.service.impl.AdminServiceImpl;
/*     */ import com.opensymphony.xwork2.ActionSupport;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Map;
/*     */ import javax.servlet.ServletContext;
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ import org.apache.struts2.convention.annotation.Action;
/*     */ import org.apache.struts2.convention.annotation.ParentPackage;
/*     */ import org.apache.struts2.dispatcher.SessionMap;
/*     */ import org.apache.struts2.interceptor.SessionAware;
/*     */ 
/*     */ @ParentPackage("json-default")
/*     */ public class AddQuestionToTopicAction
/*     */   extends ActionSupport
/*     */   implements SessionAware
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  27 */   AdminService adminService = new AdminServiceImpl();
/*     */   private File questionImage;
/*     */   private String questionImageFileName;
/*     */   private String questionImageContentType;
/*     */   private String subject;
/*     */   private String topic;
/*     */   private String option1;
/*     */   private String option2;
/*     */   private String option3;
/*     */   private String option4;
/*     */   private String answer;
/*     */   private String explanation;
/*     */   private String question;
/*     */   private String result;
/*     */   private SessionMap<String, Object> session;
/*     */   
/*     */   public String getResult() {
/*  44 */     return this.result;
/*     */   }
/*     */   
/*     */   public void setResult(String result) {
/*  48 */     this.result = result;
/*     */   }
/*     */   
/*     */   public String getQuestion() {
/*  52 */     return this.question;
/*     */   }
/*     */   
/*     */   public void setQuestion(String question) {
/*  56 */     this.question = question;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Action(value="add-question-to-topic", results={@org.apache.struts2.convention.annotation.Result(type="json", params={"contentType", "application/json", "root", "result"})})
/*     */   public String addQuestion()
/*     */     throws SQLException
/*     */   {
/*  67 */     String fileName = null;
/*  68 */     String user = null;
/*     */     try {
/*  70 */       if (this.session.get("admin") != null) {
/*  71 */         user = this.session.get("admin").toString();
/*     */       } else {
/*  73 */         this.result = "logout";
/*  74 */         return "success";
/*     */       }
/*  76 */       int maxid = this.adminService.getMaxID(getSubject()) + 1;
/*  77 */       if (getQuestionImage() != null) {
/*  78 */         if ((int)getQuestionImage().length() / 1048576 > 2) {
/*  79 */           this.result = "File size is too large..!Please choose a file of size less than 2MB";
/*  80 */           return "success";
/*     */         }
/*  82 */         FileInputStream fis = new FileInputStream(getQuestionImage());
/*  83 */         fileName = maxid + getQuestionImageFileName().substring(getQuestionImageFileName().lastIndexOf("."), 
/*  84 */           getQuestionImageFileName().length());
/*  85 */         String contentType = getQuestionImageContentType();
/*  86 */         System.out.println(contentType);
/*  87 */         System.out.println(fileName);
/*  88 */         String path = ServletActionContext.getServletContext().getRealPath("/quiz-images/") + "/" + getSubject() + 
/*  89 */           "/";
/*     */         
/*  91 */         File file = new File(path);
/*  92 */         file.mkdirs();
/*  93 */         File file2 = new File(file, fileName);
/*  94 */         FileOutputStream fos = new FileOutputStream(file2);
/*  95 */         byte[] b = new byte[(int)getQuestionImage().length()];
/*  96 */         while (fis.read(b) != -1) {
/*  97 */           fos.write(b);
/*     */         }
/*     */         
/* 100 */         fos.close();
/* 101 */         fis.close();
/*     */       }
/*     */     } catch (IOException e) {
/* 104 */       e.printStackTrace();
/*     */     }
/* 106 */     QuizQuestionDetails questionDetails = new QuizQuestionDetails();
/* 107 */     questionDetails.setQuestion(getQuestion());
/* 108 */     questionDetails.setOption_a(getOption1());
/* 109 */     questionDetails.setOption_b(getOption2());
/* 110 */     questionDetails.setOption_c(getOption3());
/* 111 */     questionDetails.setOption_d(getOption4());
/* 112 */     questionDetails.setAnswer(getAnswer());
/* 113 */     questionDetails.setTopicid(Integer.parseInt(getTopic()));
/* 114 */     questionDetails.setExplanation(getExplanation());
/* 115 */     questionDetails.setImage_name(fileName);
/* 116 */     boolean isQuestionAdded = this.adminService.saveQuestion(questionDetails, getSubject(), user);
/* 117 */     if (isQuestionAdded) {
/* 118 */       this.result = "Question added successfully";
/* 119 */       return "success";
/*     */     }
/* 121 */     this.result = "Error while adding a question..! Please try again";
/* 122 */     return "success";
/*     */   }
/*     */   
/*     */   public File getQuestionImage()
/*     */   {
/* 127 */     return this.questionImage;
/*     */   }
/*     */   
/*     */   public void setQuestionImage(File questionImage) {
/* 131 */     this.questionImage = questionImage;
/*     */   }
/*     */   
/*     */   public String getQuestionImageFileName() {
/* 135 */     return this.questionImageFileName;
/*     */   }
/*     */   
/*     */   public void setQuestionImageFileName(String questionImageFileName) {
/* 139 */     this.questionImageFileName = questionImageFileName;
/*     */   }
/*     */   
/*     */   public String getQuestionImageContentType() {
/* 143 */     return this.questionImageContentType;
/*     */   }
/*     */   
/*     */   public void setQuestionImageContentType(String questionImageContentType) {
/* 147 */     this.questionImageContentType = questionImageContentType;
/*     */   }
/*     */   
/*     */   public String getSubject() {
/* 151 */     return this.subject;
/*     */   }
/*     */   
/*     */   public void setSubject(String subject) {
/* 155 */     this.subject = subject;
/*     */   }
/*     */   
/*     */   public String getTopic() {
/* 159 */     return this.topic;
/*     */   }
/*     */   
/*     */   public void setTopic(String topic) {
/* 163 */     this.topic = topic;
/*     */   }
/*     */   
/*     */   public String getOption1() {
/* 167 */     return this.option1;
/*     */   }
/*     */   
/*     */   public void setOption1(String option1) {
/* 171 */     this.option1 = option1;
/*     */   }
/*     */   
/*     */   public String getOption2() {
/* 175 */     return this.option2;
/*     */   }
/*     */   
/*     */   public void setOption2(String option2) {
/* 179 */     this.option2 = option2;
/*     */   }
/*     */   
/*     */   public String getOption3() {
/* 183 */     return this.option3;
/*     */   }
/*     */   
/*     */   public void setOption3(String option3) {
/* 187 */     this.option3 = option3;
/*     */   }
/*     */   
/*     */   public String getOption4() {
/* 191 */     return this.option4;
/*     */   }
/*     */   
/*     */   public void setOption4(String option4) {
/* 195 */     this.option4 = option4;
/*     */   }
/*     */   
/*     */   public String getAnswer() {
/* 199 */     return this.answer;
/*     */   }
/*     */   
/*     */   public void setAnswer(String answer) {
/* 203 */     this.answer = answer;
/*     */   }
/*     */   
/*     */   public String getExplanation() {
/* 207 */     return this.explanation;
/*     */   }
/*     */   
/*     */   public void setExplanation(String explanation) {
/* 211 */     this.explanation = explanation;
/*     */   }
/*     */   
/*     */   public void setSession(Map<String, Object> map)
/*     */   {
/* 216 */     this.session = ((SessionMap)map);
/*     */   }
/*     */ }


/* Location:              D:\New folder\WEB-INF\classes\com\groom.zip!\groom\groom\actions\AddQuestionToTopicAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */