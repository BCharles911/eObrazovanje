package com.eobrazovanje.ssluzba.controller;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eobrazovanje.ssluzba.dto.CourseDTO;
import com.eobrazovanje.ssluzba.dto.LecturerDTO;
import com.eobrazovanje.ssluzba.dto.SubjectDTO;
import com.eobrazovanje.ssluzba.dto.converter.CoursesToDTO;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToLecturer;
import com.eobrazovanje.ssluzba.entities.Course;
import com.eobrazovanje.ssluzba.entities.FinancialCard;
import com.eobrazovanje.ssluzba.entities.Lecturer;
import com.eobrazovanje.ssluzba.entities.Person;
import com.eobrazovanje.ssluzba.entities.Role;
import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.entities.Subject;
import com.eobrazovanje.ssluzba.entities.Transaction;
import com.eobrazovanje.ssluzba.entities.enumerations.CARD_TYPE;
import com.eobrazovanje.ssluzba.entities.enumerations.STUDENT_STATUS;
import com.eobrazovanje.ssluzba.exceptions.UsernameExistsException;
import com.eobrazovanje.ssluzba.repository.CourseRepository;
import com.eobrazovanje.ssluzba.repository.FinancialCardRepository;
import com.eobrazovanje.ssluzba.repository.LecturerRepository;
import com.eobrazovanje.ssluzba.repository.RoleRepository;
import com.eobrazovanje.ssluzba.repository.StudentRepository;
import com.eobrazovanje.ssluzba.repository.SubjectRepository;
import com.eobrazovanje.ssluzba.repository.TransactionRepository;

@RestController
@RequestMapping("api/manager")
public class AdminController {
	
	public static long USER_ROLE = 7;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	LecturerRepository lecturerRepository;
	
	
	@Autowired
	FinancialCardRepository financialRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	CoursesToDTO courseToDTO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	
	@Autowired
	DTOToLecturer dtoToLect;
	
	//private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	@GetMapping(value="/get-roles", produces="application/json")
	public ResponseEntity<List<Role>> getRoles(){
		List<Role> roles = roleRepository.findAll();
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}
	
	@GetMapping(value="/get-courses", produces="application/json")
	public ResponseEntity<List<CourseDTO>> getCourses(){
		List<CourseDTO> courses = courseToDTO.convert(courseRepository.findAll());
		return new ResponseEntity<List<CourseDTO>>(courses, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value="/check-if-exists")
	public ResponseEntity<?> check(@RequestParam("username") String username){
		if(studentRepository.existsByUsername(username) == true) {
			throw new UsernameExistsException();
		}
		
		return new ResponseEntity<Role>(roleRepository.getOne(USER_ROLE), HttpStatus.OK);
		
	}
	
	
	@PostMapping(value="/create-user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createNewUser(@RequestBody Person person,@RequestParam("indexNumber") String indexNumber, @RequestParam("courseName") String courseName,@RequestParam("role") String role, @RequestParam("cardType") String cardType){

			System.out.println(person.getFirstName() + "HAHASHAHs");
			System.out.println(person.getDateOfBirth().toString());
			if(studentRepository.existsByUsername(person.getUsername()) == true ) {
				System.out.println(person.getUsername());
				System.out.println(studentRepository.existsByUsername(person.getUsername()));
				throw new UsernameExistsException();
			}
			
	
			Course course = courseRepository.getByCourseName(courseName);
			
			Student student = new Student();
			student.setFirstName(person.getFirstName());
			student.setIndexNumber(indexNumber);
			student.setLastName(person.getLastName());
			student.setPassword(passwordEncoder.encode(person.getPassword()));
			student.setUsername(person.getUsername());
			student.setDeleted(false);
			student.setCurrentYear(1);
			student.setAvgGrade((double) 0);
			student.setCity(person.getCity());
			student.setEmailAddress(person.getEmailAddress());
			student.setGender(person.getGender());
			student.setDateOfBirth(person.getDateOfBirth());
			student.setPlaceOfBirth(person.getPlaceOfBirth());
			student.setStateOfBirth(person.getStateOfBirth());
			student.setResidence_address(person.getResidence_address());
			student.setPhoneNumber(person.getPhoneNumber());
			student.setMobilePhoneNumber(person.getMobilePhoneNumber());
			student.setCitizenship(person.getCitizenship());
			student.setStudentStatus(STUDENT_STATUS.REGULAR);
			student.setCourse(course);
			student.setHighSchool("Srednja skola");
			//student.getRoles().add(studentRole);
			student.setUsername(person.getUsername());		
			studentRepository.save(student);			
			
			Student studentForFinancialCard = studentRepository.getByUsername(person.getUsername());
			
			FinancialCard newFinancialCard = new FinancialCard();
			newFinancialCard.setBalance((double) 0);
			newFinancialCard.setBlocked(false);
			newFinancialCard.setCardNumber("");
			newFinancialCard.setCardType(CARD_TYPE.B);
			newFinancialCard.setStudent(studentForFinancialCard);
			financialRepository.save(newFinancialCard);
			
			

	
			
			
		
		
		return null;
		
		
	}

		@PostMapping(value="/create-lecturer",  consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> createNewLecturer(@RequestBody Lecturer person){
			
				Lecturer lecturer = new Lecturer();
				if(lecturerRepository.existsByUsername(person.getUsername()) == true ) {
					System.out.println(person.getUsername());
					System.out.println(studentRepository.existsByUsername(person.getUsername()));
					throw new UsernameExistsException();
				}
				System.out.println(person.getPassword() + "ha");
				lecturer.setFirstName(person.getFirstName());
				lecturer.setLastName(person.getLastName());
				lecturer.setEmailAddress(person.getEmailAddress());
				lecturer.setDateOfBirth(person.getDateOfBirth());
				lecturer.setCity(person.getCity());
				lecturer.setPassword(passwordEncoder.encode(person.getPassword()));
				lecturer.setUsername(person.getUsername());
				lecturer.setDeleted(false);
				lecturer.setEmailAddress(person.getEmailAddress());
				lecturer.setGender(person.getGender());
				lecturer.setPlaceOfBirth(person.getPlaceOfBirth());
				lecturer.setStateOfBirth(person.getStateOfBirth());
				lecturer.setResidence_address(person.getResidence_address());
				lecturer.setPhoneNumber(person.getPhoneNumber());
				lecturer.setMobilePhoneNumber(person.getMobilePhoneNumber());
				lecturer.setCitizenship(person.getCitizenship());
				Collection<Role> list = new LinkedList<Role>(); 
				for(Role r : person.getRoles()) {
					list.add(r);
				}
				lecturer.setRoles(list);
				lecturerRepository.save(lecturer);
				Lecturer l = lecturerRepository.getByUsername(lecturer.getUsername());
				Set<Subject> subs = new HashSet<Subject>();
				for(Subject sub : person.getSubjects()) {
					System.out.println(sub);
					Subject s = subjectRepository.getOne(sub.getId());
					s.getLecturer().add(l);
					subjectRepository.save(s);
				}
				//lecturer.setSubjects(subs);
				
				
		
			return new ResponseEntity<String>("All ok", HttpStatus.OK);
	}
		
	
	@PostMapping(value="/create-subject",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createNewSubject(@RequestBody SubjectDTO subject){
		System.out.println(subject.getShortName());
		System.out.println(subject.getSubjectName());
		System.out.println(subject.getLecturerDTO());
		
		Subject subj = new Subject();
		
		subj.setSubjectName(subject.getSubjectName());
		subj.setShortName(subject.getShortName());
		subj.setEctsPoints(subject.getEctsPoints());
		Set<Lecturer> lectSet = new HashSet<Lecturer>();
		for(LecturerDTO lecturer: subject.getLecturerDTO()) {
	
			lectSet.add(lecturerRepository.getOne(lecturer.getId()));
			
		}
		subj.setLecturer(lectSet);
		
		subjectRepository.save(subj);
		
//		newSub.setSubjectName(subject.getSubjectName());
//		newSub.setShortName(subject.getShortName());
//		newSub.setEctsPoints(subject.getEctsPoints());
//		newSub.setLecturer(subject.getLecturer());
//		subjectRepository.save(subject);
//		
		return new ResponseEntity<String>("Uspesno kreiran predmet", HttpStatus.OK);
	}

	
	
	@PostMapping(value="/deposit-amount")
	public ResponseEntity<?> depositAmount(@RequestBody Student student, @RequestParam("amount") double amount){
		
		Transaction newTransaction = new Transaction();
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		newTransaction.setAmount(amount);
		newTransaction.setPaymentPurpose("Dodavanje sredstava");
		newTransaction.setTransactionDate(date);
		newTransaction.setFinancialCard(student.getFinancialCard());
		transactionRepository.save(newTransaction);
		
		FinancialCard fc = financialRepository.findFinancialCardById(student.getFinancialCard().getId());
		
		
		fc.setBalance(fc.getBalance() + amount);
		
		financialRepository.save(fc);
		
		//studentRepository.save(student);
	
		return null;
	}
	
	
	
	
	// upravlja  ispitima (student polozio ili ne)
	// postavlja datum i vreme odrzavanja ispita
	
	// dodaje novac na finansijsku karticu
	// pregleda sve one koji su prijavili odredjeni ispit
		// u prevodu, kada otvori svoj ispit, treba da vidi
		// prijave svih studenata za taj ispit
	//
	
	//change student status
	
	//add new user
	//kreira nove rokove
	//

}
