package com.eobrazovanje.ssluzba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eobrazovanje.ssluzba.dto.SubjectDTO;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToLecturer;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToStudentHasSubject;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToSubject;
import com.eobrazovanje.ssluzba.entities.Subject;
import com.eobrazovanje.ssluzba.interfaces.SubjectInterface;
import com.eobrazovanje.ssluzba.repository.SubjectRepository;

@Service
public class SubjectService implements SubjectInterface {

	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	DTOToSubject toSubject;
	
	@Autowired
	DTOToLecturer toLecturer;
	
	@Autowired
	DTOToStudentHasSubject toStudentHasSubject;
	
	@Override
	public Subject getOne(Long subjectId) {
		// TODO Auto-generated method stub
		return subjectRepository.getOne(subjectId) ;
	}


	@Override
	public Subject save(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepository.save(subject);
	}

	@Override
	public Subject edit(SubjectDTO subject, Long id) {
		
		Subject subjectEdit = subjectRepository.findSubjectById(subject.getId());
		subjectEdit.setSubjectName(subject.getSubjectName());
		subjectEdit.setShortName(subject.getShortName());
		subjectEdit.setEctsPoints(subject.getEctsPoints());
		//subjectEdit.setStudentHasSubject(toStudentHasSubject.convert(subject.getStudentHasSubDTO()));
		subjectRepository.save(subjectEdit);
		return subjectEdit;
	}

	@Override
	public void delete(Long id) {
		Subject deletedSubject = getOne(id);
		if(deletedSubject!=null){
			subjectRepository.deleteById(id);
		}
	}

	@Override
	public Page<Subject> getAllPaged(Pageable pageRequest) {
		// TODO Auto-generated method stub
		return subjectRepository.findAll(pageRequest);
	}

	@Override
	public List<Subject> getAll() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}

}
