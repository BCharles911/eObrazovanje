package com.eobrazovanje.ssluzba.controller;

//import java.util.Locale;
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.hibernate.validator.internal.util.logging.Messages;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.core.env.Environment;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.eobrazovanje.ssluzba.entities.Student;
//import com.eobrazovanje.ssluzba.entities.StudentPasswordResetToken;
//import com.eobrazovanje.ssluzba.exceptions.UsernameExistsException;
//import com.eobrazovanje.ssluzba.repository.StudentPasswordResetRepository;
//import com.eobrazovanje.ssluzba.repository.StudentRepository;
//import com.eobrazovanje.ssluzba.services.StudentService;
//import com.eobrazovanje.ssluzba.utility.GenericResponse;

//@RestController
//@RequestMapping("api/reset")
public class ResetController {
	
	
//	@Autowired
//	private StudentRepository studentRepository;
//	
//	@Autowired
//	private StudentService studentService;
//	
//	@Autowired
//	private MailSender mailSender;
//	
//	@Autowired
//	private StudentPasswordResetRepository sprr;
//	
//	@Autowired
//	private MessageSource messages;
//	
//	@Autowired
//	private Environment env;
//	
//	
//	
//	
//	@PostMapping("/resetPassword")
//	public GenericResponse resetPassword(HttpServletRequest request, final Mode @RequestParam("email") String studentEmail) {
//		Student student = studentRepository.getByEmailAddress(studentEmail);
//		if(student == null) {
//			throw new UsernameExistsException();
//		}
//		String token = UUID.randomUUID().toString();
//		studentService.createPasswordResetTokenForStudent(student, token);
//		mailSender.send(constructResetTokenEmail(getAppUrl(request),
//				request.getLocale(), token, student));
//				));
//		
//		
//		
//	}
//	
//	public void createPasswordResetTokenForUser(Student student, String token) {
//	    StudentPasswordResetToken myToken = new StudentPasswordResetToken(student, token);
//	    sprr.save(myToken);
//	}
//	
//	private SimpleMailMessage constructResetTokenEmail(
//			  String contextPath, Locale locale, String token, Student student) {
//			    String url = contextPath + "/user/changePassword?token=" + token;
//			    String message = messages.getMessage("message.resetPassword", 
//			      null, locale);
//			    return constructEmail("Reset Password", message + " \r\n" + url, student);
//			}
//	
//	
//	private SimpleMailMessage constructEmail(String subject, String body, 
//			  Student student) {
//			    SimpleMailMessage email = new SimpleMailMessage();
//			    email.setSubject(subject);
//			    email.setText(body);
//			    email.setTo(student.getEmailAddress());
//			    email.setFrom(env.getProperty("support.email"));
//			    return email;
//			}

	
	
}
