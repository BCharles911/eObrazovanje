package com.eobrazovanje.ssluzba.utility;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.eobrazovanje.ssluzba.entities.ExamPeriod;
import com.eobrazovanje.ssluzba.entities.Privilege;
import com.eobrazovanje.ssluzba.entities.Role;
import com.eobrazovanje.ssluzba.repository.CourseRepository;
import com.eobrazovanje.ssluzba.repository.ExamPeriodRepository;
import com.eobrazovanje.ssluzba.repository.LecturerRepository;
import com.eobrazovanje.ssluzba.repository.PrivilegeRepository;
import com.eobrazovanje.ssluzba.repository.RoleRepository;
import com.eobrazovanje.ssluzba.repository.StudentRepository;

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
    private ExamPeriodRepository examPeriodRepository;
	
	
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

		
		
        
        
        
        ExamPeriod januarskiRok = new ExamPeriod();
        ExamPeriod februarskiRok = new ExamPeriod();
        ExamPeriod aprilskiRok = new ExamPeriod();
        ExamPeriod junskiRok = new ExamPeriod();
        ExamPeriod septembarskiRok = new ExamPeriod();
        
        
        /*		
		  
		  januarskiRok.setExamPeriodName("Januarski rok");
		  januarskiRok.setActive(false);
		  januarskiRok.setStartDate(Date.valueOf("2021-01-25"));
		  januarskiRok.setEndDate(Date.valueOf("2021-01-30"));
		  
		  februarskiRok.setExamPeriodName("Februarski rok");
		  februarskiRok.setActive(false);
		  februarskiRok.setStartDate(Date.valueOf("2021-02-20"));
		  februarskiRok.setEndDate(Date.valueOf("2021-02-25"));
		  
		  aprilskiRok.setExamPeriodName("Aprilski rok"); aprilskiRok.setActive(false);
		  aprilskiRok.setStartDate(Date.valueOf("2021-04-15"));
		  aprilskiRok.setEndDate(Date.valueOf("2021-04-20"));
		  
		  junskiRok.setExamPeriodName("Junski rok"); junskiRok.setActive(false);
		  junskiRok.setStartDate(Date.valueOf("2021-06-10"));
		  junskiRok.setEndDate(Date.valueOf("2021-06-15"));
		  
		  septembarskiRok.setExamPeriodName("Septembarski rok");
		  septembarskiRok.setActive(false);
		  septembarskiRok.setStartDate(Date.valueOf("2021-09-05"));
		  septembarskiRok.setEndDate(Date.valueOf("2021-09-10"));
		  
		  createExamPeriodIfNotFound(januarskiRok);
		  createExamPeriodIfNotFound(februarskiRok);
		  createExamPeriodIfNotFound(aprilskiRok);
		  createExamPeriodIfNotFound(junskiRok);
		  createExamPeriodIfNotFound(septembarskiRok);
		 */
		
/*		
		  Role adminRole = roleRepository.findByName("ROLE_ADMIN"); Lecturer lecturer =
		  new Lecturer(); lecturer.setFirstName("Test"); lecturer.setLastName("Test");
		  lecturer.setPassword(passwordEncoder.encode("test"));
		  lecturer.setEmailAddress("test@test.com");
		  lecturer.setRoles(Arrays.asList(adminRole));
		  lecturer.setCitizenship("Serbian"); lecturer.setCity("Novi Sad");
		  lecturer.setDateOfBirth(new Date(1986, 3, 21));
		  lecturer.setEthnicity("Serbian"); lecturer.setGender("male");
		  lecturer.setMobilePhoneNumber("0611180389"); lecturer.setDeleted(false);
		  lecturerRepository.save(lecturer);
		  
		  
		  
		  
		  Role studentRole = roleRepository.findByName("STUDENT"); Student student =
		  new Student(); student.setFirstName("Andrej"); student.setLastName("Djapic");
		  student.setPassword(passwordEncoder.encode("lozinka123"));
		  student.setEmailAddress("djapic97@outlook.com");
		  student.setCitizenship("Serbian"); student.setIndexNumber("SF1-2016");
		  student.setDeleted(false); student.setPhoneNumber("0611180389");
		  student.setEthnicity("Serbian"); student.setCurrentYear(3);
		  student.setHighSchool("Srednja Poljoprivredno Prehrambena Skola");
		  student.setAvgGrade(8.00); student.setUsername("adapic");
		  student.setResidence_address("Dalmatinska 4, Novi Sad 21000");
		  student.setStateOfBirth("Sombor");
		  student.setRoles(Arrays.asList(studentRole));
		  student.setDateOfBirth(Date.valueOf("1997-12-30"));
		  student.setParentName("Dragana Djapic");
		  student.setStudentStatus(STUDENT_STATUS.ADVANCED_UNIVERSITY_STUDENT);
		  studentRepository.save(student);
		 
		 
		 */

        
		
		/*
		 * alreadySetup = true; long id = 1; Student student =
		 * studentService.getOne(id); Course course = new Course();
		 * course.setCourseName("Softverske i informacione tehnologije");
		 * course.setShortName("SIT"); course.getStudent().add(student);
		 * courseRepository.save(course);
		 * 
		 * 
		 * 
		 * 
		 * Subject subject = new Subject(); subject.setSubjectName("Matematika 1");
		 * subject.setShortName("M1"); subject.setEctsPoints(8);
		 * subjectRepository.save(subject);
		 * 
		 * 
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
		
		  Role studentRole = roleRepository.findByName("STUDENT"); Student student =new
		  Student(); student.setFirstName("Petar"); student.setLastName("Petrovic");
		  student.setPassword(passwordEncoder.encode("lozinka123"));
		  student.setEmailAddress("petar@outlook.com");
		  student.setCitizenship("Serbian"); student.setIndexNumber("SF32-2015");
		  student.setDeleted(false); student.setPhoneNumber("0616865757");
		  student.setEthnicity("Serbian"); student.setCurrentYear(3);
		  student.setHighSchool("Srednja Tehnicka  Skola"); student.setAvgGrade(8.00);
		  student.setUsername("pera");
		  student.setResidence_address("Maksima Gorkog 14, Novi Sad 21000");
		  student.setStateOfBirth("Novi Sad");
		  student.setRoles(Arrays.asList(studentRole));
		  student.setDateOfBirth(Date.valueOf("1997-12-30"));
		  student.setParentName("Mitar Mitra Mitar");
		  student.setStudentStatus(STUDENT_STATUS.ADVANCED_UNIVERSITY_STUDENT);
		  studentRepository.save(student);
		  
		  
		  
		  long idd = 1; long idd2 = 2; Lecturer lecturer =
		  lecturerRepository.findByFirstName("Milan"); System.out.println("lecturer");
		  Subject subject = new Subject(); long id = 1;
		  subject.setSubjectName("eObrazovanje"); subject.setShortName("EO1");
		  subject.setEctsPoints(6); Set<Lecturer> lect =
		  Stream.of(lecturer).collect(Collectors.toSet()); subject.setLecturer(lect);
		  subjectRepository.save(subject);
		  
		  */
	/*	  
        long idd = 1; long idd2 = 2;
		  Student stud1 = studentRepository.getOne(idd); 
		  Student stud2 = studentRepository.getOne(idd2); 
		  Course course = new Course(); 
		  Subject subjectt = subjectRepository.getOne(idd);
		  course.setCourseName("Softversko Inzenjerstvo"); 
		  course.setShortName("E1");
		  course.setDescription("Akademski smer, programiranje"); 
		  Set<Subject> sub = Stream.of(subjectt).collect(Collectors.toSet()); 
		  Set<Student> stud = Stream.of(stud1,stud2).collect(Collectors.toSet());
		//System.out.println(subjectt);
		  //course.getSubject().add(subjectt); 
		  //courseRepository.save(course);
		 
*/

/*		
		  long idd = 1; long idd2 = 2; Lecturer lecturer =
		  lecturerRepository.findByFirstName("Milan"); System.out.println("lecturer");
		  Subject subject = new Subject(); long id = 1;
		  subject.setSubjectName("Matematika 1"); subject.setShortName("M1");
		  subject.setEctsPoints(6); Set<Lecturer> lect =
		  Stream.of(lecturer).collect(Collectors.toSet()); subject.setLecturer(lect);
		  subjectRepository.save(subject);
		  
		  
		  lecturerRepository.findByFirstName("Milan"); System.out.println("lecturer");
		  Subject subject2 = new Subject(); subject2.setSubjectName("Internet Mreze");
		  subject2.setShortName("IM1"); subject2.setEctsPoints(6); Set<Lecturer> lect2
		  = Stream.of(lecturer).collect(Collectors.toSet());
		  subject2.setLecturer(lect2); subjectRepository.save(subject2);
		  
		  
		  lecturerRepository.findByFirstName("Milan"); System.out.println("lecturer");
		  Subject subject3 = new Subject(); subject3.setSubjectName("eUprava");
		  subject3.setShortName("EUP"); subject3.setEctsPoints(6); Set<Lecturer> lect3
		  = Stream.of(lecturer).collect(Collectors.toSet());
		  subject3.setLecturer(lect3); subjectRepository.save(subject3);
		  
		  
		  lecturerRepository.findByFirstName("Milan"); System.out.println("lecturer");
		  Subject subject4 = new Subject();
		  subject4.setSubjectName("Poslovna Informatika");
		  subject4.setShortName("PINF"); subject4.setEctsPoints(6); Set<Lecturer> lect4
		  = Stream.of(lecturer).collect(Collectors.toSet());
		  subject4.setLecturer(lect4); subjectRepository.save(subject4);
		  
		  
		  
		  lecturerRepository.findByFirstName("Milan"); System.out.println("lecturer");
		  Subject subject5 = new Subject(); subject5.setSubjectName("Engleski 1");
		  subject5.setShortName("ENG1"); subject5.setEctsPoints(6); Set<Lecturer> lect5
		  = Stream.of(lecturer).collect(Collectors.toSet());
		  subject5.setLecturer(lect5); subjectRepository.save(subject5);
		  
		  
		  
		  
		  lecturerRepository.findByFirstName("Milan"); System.out.println("lecturer");
		  Subject subject6 = new Subject();
		  subject6.setSubjectName("Upravljanje datotekama");
		  subject6.setShortName("UDO"); subject6.setEctsPoints(6); Set<Lecturer> lect6
		  = Stream.of(lecturer).collect(Collectors.toSet());
		  subject6.setLecturer(lect6); subjectRepository.save(subject6);
		  
		  
		  
		  lecturerRepository.findByFirstName("Milan"); System.out.println("lecturer");
		  Subject subject7 = new Subject(); subject7.setSubjectName("Baze Podataka 1");
		  subject7.setShortName("BZP"); subject7.setEctsPoints(6); Set<Lecturer> lect7
		  = Stream.of(lecturer).collect(Collectors.toSet());
		  subject6.setLecturer(lect7); subjectRepository.save(subject7);
		  
		  
		  
		  lecturerRepository.findByFirstName("Milan"); System.out.println("lecturer");
		  Subject subject8 = new Subject();
		  subject8.setSubjectName("Osnove Racunarstva"); subject8.setShortName("ORS");
		  subject8.setEctsPoints(6); Set<Lecturer> lect8 =
		  Stream.of(lecturer).collect(Collectors.toSet()); subject8.setLecturer(lect8);
		  subjectRepository.save(subject8);
		  */
		 
        
     /*   	
		
		  long idd6 = 6; long idd8 = 8; long idd2 = 2; long idd = 1; long id5 = 5;
		  Student stud1 = studentRepository.getOne(idd2); Subject subbj =
		  subjectRepository.getOne(idd8); Lecturer lectr =
		  lecturerRepository.getOne(id5); Course crs = courseRepository.getOne(idd);
		  
		  StudentHasSubject studHasSub =
		  studentHasSubjectRespository.findStudentHasSubjectByStudentId();
		  
		  subbj.getCourse().add(crs);
		  
		  
		  Exam exam = examRepository.getOne(idd);
		  exam.setStudent_has_subject(studHasSub); examRepository.save(exam);
		 
		 */
        
	/*	
		  Role adminRole = roleRepository.findByName("ROLE_ADMIN"); Lecturer lecturer =
		  new Lecturer(); lecturer.setFirstName("Marko");
		  lecturer.setLastName("Markovic");
		  lecturer.setPassword(passwordEncoder.encode("test"));
		  lecturer.setEmailAddress("marko@test.com");
		  lecturer.setRoles(Arrays.asList(adminRole));
		  lecturer.setCitizenship("Serbian"); lecturer.setCity("Novi Sad");
		  lecturer.setDateOfBirth(new Date(1986, 3, 21));
		  lecturer.setPhoneNumber("0604435531"); lecturer.setPlaceOfBirth("Novi Sad");
		  lecturer.setResidence_address("Bulevar Oslobodjenja 21");
		  lecturer.setStateOfBirth("Srbija"); lecturer.setEthnicity("Serbian");
		  lecturer.setGender("male"); lecturer.setMobilePhoneNumber("0611180389");
		  lecturer.setDeleted(false); lecturerRepository.save(lecturer);
		 */
		  

		/*
		 * long idd = 1; long idd6 = 6; Subject subbj = subjectRepository.getOne(idd);
		 * Lecturer lectr = lecturerRepository.getOne(idd6);
		 * subbj.getLecturer().add(lectr); subjectRepository.save(subbj);
		 */
        
		
		  //crs.getSubject().add(subbj); courseRepository.save(crs);


 /*       
       	Course crs = courseRepository.getOne(idd);
		  crs.getSubject().add(subbj); 
		  courseRepository.save(crs);
>>>>>>> branch 'ongoing_branch' of https://github.com/BCharles911/eObrazovanje
		 
		  long idd2 = 2;
		  Student stud1 = studentRepository.getOne(idd2);
		 crs.getStudent().add(stud1); 
		 courseRepository.save(crs);
		 */
		//System.out.println(crs.getStudent().toString());
		
/*        
        long idd = 1;
        Subject subbj = subjectRepository.getOne(idd);
		
        long idd2 = 2;
		  Student stud1 = studentRepository.getOne(idd2);
        
		  StudentHasSubject sths = new StudentHasSubject(); StudentSubjectKey ssk = new
		  StudentSubjectKey(); ssk.setStudentId(stud1.getId());
		  ssk.setSubjectId(subbj.getId()); sths.setId(ssk); sths.setStudent(stud1);
		  sths.setSubject(subbj); sths.setBrPokusaja(0); sths.setPassed(false);
		  
		  sths.setOcena(0); studentHasSubjectRespository.save(sths);
		 
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
	ExamPeriod createExamPeriodIfNotFound(ExamPeriod examPeriod) {
		ExamPeriod examPeriodNew = examPeriodRepository.findByExamPeriodName(examPeriod.getExamPeriodName());
		if(examPeriodNew == null) {
			examPeriodNew = examPeriod;
			examPeriodRepository.save(examPeriodNew);
		}
		
		return examPeriodNew;
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
