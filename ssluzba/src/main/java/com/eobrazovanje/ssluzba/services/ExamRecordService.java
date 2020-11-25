package com.eobrazovanje.ssluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eobrazovanje.ssluzba.dto.ExamRecordDTO;
import com.eobrazovanje.ssluzba.dto.toEntityConverters.DTOToExamRecord;
import com.eobrazovanje.ssluzba.entities.ExamRecord;
import com.eobrazovanje.ssluzba.entities.Transaction;
import com.eobrazovanje.ssluzba.interfaces.ExamRecordInterface;
import com.eobrazovanje.ssluzba.repository.ExamRecordRepository;

@Service
@Transactional
public class ExamRecordService implements ExamRecordInterface {

	@Autowired
	ExamRecordRepository examRecordRepository;
	
	@Autowired
	DTOToExamRecord toExamRecord;
	
	@Override
	public ExamRecord getOne(String examRecordId) {
		return examRecordRepository.getOne(examRecordId);
	}
	
	@Override
	public ExamRecord save(ExamRecord examRecord) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public ExamRecord edit(ExamRecordDTO examRecord, Long id) {
		ExamRecord examRecordEdit = examRecordRepository.findExamRecordById(examRecord.getId());
		return examRecordEdit;
	}

}
