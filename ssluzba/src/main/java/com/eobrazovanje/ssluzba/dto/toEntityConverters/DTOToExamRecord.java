package com.eobrazovanje.ssluzba.dto.toEntityConverters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.ExamRecordDTO;
import com.eobrazovanje.ssluzba.entities.ExamRecord;
import com.eobrazovanje.ssluzba.repository.StudentHasSubjectRepository;

@Component
public class DTOToExamRecord implements Converter<ExamRecordDTO, ExamRecord> {

	@Autowired
	DTOToStudentHasSubject toStudentHasSubject;
	
	@Autowired
	StudentHasSubjectRepository studentHasSubjectRepository;
	
	@Override
	public ExamRecord convert(ExamRecordDTO source) {
		
		if (source == null) {
			return null;
		}
		ExamRecord examRecord = new ExamRecord();
		examRecord.setId(source.getId());
		examRecord.setNote(source.getNote());
		//examRecord.setStudentHasSubject(toStudentHasSubject.convert(source.getStudentHasSubject()));
		examRecord.setExamPeriod(source.getExamPeriod());
		examRecord.setExamDate(source.getExamDate());
		examRecord.setOcena(source.getOcena());
		
		return examRecord;
	}
}
