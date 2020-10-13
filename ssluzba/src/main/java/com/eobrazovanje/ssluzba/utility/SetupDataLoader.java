package com.eobrazovanje.ssluzba.utility;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.entities.Course;
import com.eobrazovanje.ssluzba.entities.Exam;
import com.eobrazovanje.ssluzba.entities.Lecturer;
import com.eobrazovanje.ssluzba.entities.Privilege;
import com.eobrazovanje.ssluzba.entities.Role;
import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.entities.StudentHasSubject;
import com.eobrazovanje.ssluzba.entities.Subject;
import com.eobrazovanje.ssluzba.entities.compositeKeys.StudentSubjectKey;
import com.eobrazovanje.ssluzba.repository.CourseRepository;
import com.eobrazovanje.ssluzba.repository.ExamRepository;
import com.eobrazovanje.ssluzba.repository.LecturerRepository;
import com.eobrazovanje.ssluzba.repository.PrivilegeRepository;
import com.eobrazovanje.ssluzba.repository.RoleRepository;
import com.eobrazovanje.ssluzba.repository.StudentHasSubjectRepository;
import com.eobrazovanje.ssluzba.repository.StudentRepository;
import com.eobrazovanje.ssluzba.repository.SubjectRepository;
import com.eobrazovanje.ssluzba.services.StudentService;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;
	
	@Autowired
	LecturerRepository lecturerRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PrivilegeRepository privilegeRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	
	@Autowired
	CourseRepository courseRepository;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private SubjectRepository subjectRepository;
    
    @Autowired
    private StudentHasSubjectRepository studentHasSubjectRespository;
    
    @Autowired
    private ExamRepository examRepository;
	
	
	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		if(alreadySetup)
			return;
		Privilege readPrivilege
			= createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilege writePrivilege
		= createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		
		
		
		List<Privilege> adminPrivileges = Arrays.asList(
				readPrivilege, writePrivilege
				);
		
		List<Privilege> professorPrivileges = Arrays.asList(
				readPrivilege, writePrivilege
				);
		
		List<Privilege> demonstatorPrivileges = Arrays.asList(
				readPrivilege, writePrivilege
				);
		
		List<Privilege> assistantPrivileges = Arrays.asList(
				readPrivilege, writePrivilege
				);
		
		List<Privilege> helperPrivileges = Arrays.asList(
				readPrivilege
				);
		
		List<Privilege> studentPrivileges = Arrays.asList(
				readPrivilege
				);
		
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));
        createRoleIfNotFound("PROFESSOR", professorPrivileges);
        createRoleIfNotFound("DEMONSTRATOR", demonstatorPrivileges);
        createRoleIfNotFound("ASSISTANT_PROFESSOR", assistantPrivileges);
        createRoleIfNotFound("HELPER", helperPrivileges);
        createRoleIfNotFound("STUDENT", studentPrivileges);

		
		
		/*
		 * Role adminRole = roleRepository.findByName("ROLE_ADMIN"); Lecturer lecturer =
		 * new Lecturer(); lecturer.setFirstName("Test"); lecturer.setLastName("Test");
		 * lecturer.setPassword(passwordEncoder.encode("test"));
		 * lecturer.setEmailAddress("test@test.com");
		 * lecturer.setRoles(Arrays.asList(adminRole));
		 * lecturer.setCitizenship("Serbian"); lecturer.setCity("Novi Sad");
		 * lecturer.setDateOfBirth(new Date(1986, 3, 21));
		 * lecturer.setEthnicity("Serbian"); lecturer.setGender("male");
		 * lecturer.setMobilePhoneNumber("0611180389"); lecturer.setDeleted(false);
		 * lecturerRepository.save(lecturer);
		 * 
		 * 
		 * 
		 * 
		 * Role studentRole = roleRepository.findByName("STUDENT"); Student student =
		 * new Student(); student.setFirstName("Andrej"); student.setLastName("Djapic");
		 * student.setPassword(passwordEncoder.encode("lozinka123"));
		 * student.setEmailAddress("djapic97@outlook.com");
		 * student.setCitizenship("Serbian"); student.setIndexNumber("SF1-2016");
		 * student.setDeleted(false); student.setPhoneNumber("0611180389");
		 * student.setEthnicity("Serbian"); student.setCurrentYear(3);
		 * student.setHighSchool("Srednja Poljoprivredno Prehrambena Skola");
		 * student.setAvgGrade(8.00); student.setUsername("adapic");
		 * student.setResidence_address("Dalmatinska 4, Novi Sad 21000");
		 * student.setStateOfBirth("Sombor");
		 * student.setRoles(Arrays.asList(studentRole));
		 * student.setDateOfBirth(Date.valueOf("1997-12-30"));
		 * student.setParentName("Dragana Djapic");
		 * student.setStudentStatus(STUDENT_STATUS.ADVANCED_UNIVERSITY_STUDENT);
		 * studentRepository.save(student);
		 */
		 
        
		
		/*
		 * alreadySetup = true; long id = 1; Student student =
		 * studentService.getOne(id); Course course = new Course();
		 * course.setCourseName("Softverske i informacione tehnologije");
		 * course.setShortName("SIT"); course.getStudent().add(student);
		 * courseRepository.save(course);
		 */
        
		
	/*	  Subject subject = new Subject(); long id = 1;
		  subject.setSubjectName("Matematika 1"); subject.setShortName("M1");
		  subject.setEctsPoints(8); subjectRepository.save(subject);*/
		  
		/*
		 * Role adminRole = roleRepository.findByName("ROLE_ADMIN"); Lecturer lecturer =
		 * new Lecturer(); lecturer.setFirstName("Milan");
		 * lecturer.setLastName("Milkovic");
		 * lecturer.setPassword(passwordEncoder.encode("test"));
		 * lecturer.setEmailAddress("milan@gmail.com");
		 * lecturer.setUsername("profmilan");
		 * lecturer.setRoles(Arrays.asList(adminRole));
		 * lecturer.setCitizenship("Serbian"); lecturer.setCity("Novi Sad");
		 * lecturer.setDateOfBirth(new Date(1986, 3, 21));
		 * lecturer.setEthnicity("Serbian"); lecturer.setGender("male");
		 * lecturer.setMobilePhoneNumber("0611180389"); lecturer.setDeleted(false);
		 * lecturerRepository.save(lecturer);
		 */
        
        
		/*
		 * Role studentRole = roleRepository.findByName("STUDENT"); Student student =new
		 * Student(); student.setFirstName("Petar"); student.setLastName("Petrovic");
		 * student.setPassword(passwordEncoder.encode("lozinka123"));
		 * student.setEmailAddress("petar@outlook.com");
		 * student.setCitizenship("Serbian"); student.setIndexNumber("SF32-2015");
		 * student.setDeleted(false); student.setPhoneNumber("0616865757");
		 * student.setEthnicity("Serbian"); student.setCurrentYear(3);
		 * student.setHighSchool("Srednja Tehnicka  Skola"); student.setAvgGrade(8.00);
		 * student.setUsername("pera");
		 * student.setResidence_address("Maksima Gorkog 14, Novi Sad 21000");
		 * student.setStateOfBirth("Novi Sad");
		 * student.setRoles(Arrays.asList(studentRole));
		 * student.setDateOfBirth(Date.valueOf("1997-12-30"));
		 * student.setParentName("Mitar Mitra Mitar");
		 * student.setStudentStatus(STUDENT_STATUS.ADVANCED_UNIVERSITY_STUDENT);
		 * studentRepository.save(student);
		 */
        
		/*
		 * long idd = 1; long idd2 = 2; Lecturer lecturer =
		 * lecturerRepository.findByFirstName("Milan"); System.out.println("lecturer");
		 * Subject subject = new Subject(); long id = 1;
		 * subject.setSubjectName("eObrazovanje"); subject.setShortName("EO1");
		 * subject.setEctsPoints(6); Set<Lecturer> lect =
		 * Stream.of(lecturer).collect(Collectors.toSet()); subject.setLecturer(lect);
		 * subjectRepository.save(subject);
		 */
		  
        	long idd = 1; long idd2 = 2; long idd6 = 6; long idd8 = 8;
		/*
		 * Student stud1 = studentRepository.getOne(idd); Student stud2 =
		 * studentRepository.getOne(idd2); Course course = new Course(); Subject
		 * subjectt = subjectRepository.getOne(idd);
		 * course.setCourseName("Softversko Inzenjerstvo"); course.setShortName("E1");
		 * course.setDescription("Akademski smer, programiranje"); Set<Subject> sub =
		 * Stream.of(subjectt).collect(Collectors.toSet()); Set<Student> stud =
		 * Stream.of(stud1,stud2).collect(Collectors.toSet());
		 * course.getSubject().add(subjectt); courseRepository.save(course);
		 */
        	
        
        	
        	
        Student stud1 = studentRepository.getOne(idd2);	
        Subject subbj = subjectRepository.getOne(idd8);
        Lecturer lect = lecturerRepository.getOne(idd6);
        Course crs = courseRepository.getOne(idd);
        
        StudentHasSubject studHasSub = studentHasSubjectRespository.findStudentHasSubjectByStudentId();
		
        subbj.getCourse().add(crs);
        /*
		 * Exam exam = new Exam(); exam.setHasPassed(false); exam.setDeleted(false);
		 * exam.setLecturer(lect); exam.setStudent_has_subject(studHasSub);
		 * examRepository.save(exam);
		 */
        
		/*
		 * crs.getSubject().add(subbj); courseRepository.save(crs);
		 */
		/*
		 * crs.getStudent().add(stud1); courseRepository.save(crs);
		 */
		//System.out.println(crs.getStudent().toString());
		
		
		/*
		 * StudentHasSubject sths = new StudentHasSubject(); StudentSubjectKey ssk = new
		 * StudentSubjectKey(); ssk.setStudentId(stud1.getId());
		 * ssk.setSubjectId(subbj.getId()); sths.setId(ssk); sths.setStudent(stud1);
		 * sths.setSubject(subbj); sths.setBrPokusaja(0); sths.setPassed(false);
		 * 
		 * sths.setOcena(0); studentHasSubjectRespository.save(sths);
		 */
		
		  
		 
	}
	
	@Transactional
	Privilege createPrivilegeIfNotFound(String name) {
		Privilege privilege = privilegeRepository.findByName(name);
		if(privilege == null) {
			privilege = new Privilege(name);
			privilegeRepository.save(privilege);
		}
		return privilege;
	}
	
    @Transactional
    Role createRoleIfNotFound(
      String name, Collection<Privilege> privileges) {
 
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

	
}
