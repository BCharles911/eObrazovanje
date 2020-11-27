package com.eobrazovanje.ssluzba.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eobrazovanje.ssluzba.entities.Lecturer;
import com.eobrazovanje.ssluzba.entities.Student;
import com.eobrazovanje.ssluzba.repository.LecturerRepository;
import com.eobrazovanje.ssluzba.repository.StudentRepository;
import com.eobrazovanje.ssluzba.utility.UserPrincipal;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    LecturerRepository lecturerRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        Student user = studentRepository.getByUsername(username);
        if(user == null) {
        	try {
				Lecturer lecturer = lecturerRepository.getByUsername(username);
				return UserPrincipal.createLecturer(lecturer);
			} catch (Exception e) {
				System.out.println("user not found");
			}
        	throw new UsernameNotFoundException("User not found with username or email : " + username);
        }
     

        return UserPrincipal.createStudent(user);
    }
    
    

    @Transactional
    public UserDetails loadUserById(Long id) {
    	
    	
    	
    		try {
    			Student user = studentRepository.getOne(id);
    			return UserPrincipal.createStudent(user);
			} catch (Exception e) {
				Lecturer lecturer = lecturerRepository.getOne(id);
				return UserPrincipal.createLecturer(lecturer);
				
				// TODO: handle exception
			}
    	}
        
    
}