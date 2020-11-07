package com.eobrazovanje.ssluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eobrazovanje.ssluzba.dto.CourseDTO;
import com.eobrazovanje.ssluzba.dto.converter.CoursesToDTO;
import com.eobrazovanje.ssluzba.entities.Course;
import com.eobrazovanje.ssluzba.entities.FinancialCard;
import com.eobrazovanje.ssluzba.entities.Lecturer;
import com.eobrazovanje.ssluzba.entities.Person;
import com.eobrazovanje.ssluzba.entities.Role;
import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.entities.enumerations.CARD_TYPE;
import com.eobrazovanje.ssluzba.entities.enumerations.ROLES;
import com.eobrazovanje.ssluzba.entities.enumerations.STUDENT_STATUS;
import com.eobrazovanje.ssluzba.exceptions.UsernameExistsException;
import com.eobrazovanje.ssluzba.repository.CourseRepository;
import com.eobrazovanje.ssluzba.repository.FinancialCardRepository;
import com.eobrazovanje.ssluzba.repository.LecturerRepository;
import com.eobrazovanje.ssluzba.repository.RoleRepository;
import com.eobrazovanje.ssluzba.repository.StudentRepository;

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
	RoleRepository roleRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	CoursesToDTO courseToDTO;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
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
		
		switch (role) {
		case "STUDENT":
			System.out.println(person.getFirstName() + "HAHASHAHs");
			System.out.println(person.getDateOfBirth().toString());
			if(studentRepository.existsByUsername(person.getUsername()) == true ) {
				System.out.println(person.getUsername());
				System.out.println(studentRepository.existsByUsername(person.getUsername()));
				throw new UsernameExistsException();
			}
			
			
	
			Role studentRole = roleRepository.getOne(USER_ROLE);
			Course course = courseRepository.getByCourseName(courseName);
			
			Student student = new Student();
			student.setFirstName(person.getFirstName());
			student.setIndexNumber(indexNumber);
			student.setLastName(person.getLastName());
			student.setPassword(person.getPassword());
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
			
			
			break;
		default:
			Lecturer lecturer = new Lecturer();
			lecturer.setFirstName(person.getFirstName());
			lecturer.setLastName(person.getLastName());
			lecturer.setEmailAddress(person.getEmailAddress());
			lecturer.setDateOfBirth(person.getDateOfBirth());
			lecturer.setCity(person.getCity());
			
			
		}
		
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
