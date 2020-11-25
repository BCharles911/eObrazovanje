package com.eobrazovanje.ssluzba.interfaces;

import com.eobrazovanje.ssluzba.dto.ExamRecordDTO;
import com.eobrazovanje.ssluzba.entities.ExamRecord;

public interface ExamRecordInterface {

	//ExamRecord getOne(Long examRecord);
	ExamRecord save(ExamRecord examRecord);
	ExamRecord edit(ExamRecordDTO examRecord, Long id);
	void delete(Long id);
	ExamRecord getOne(String examRecordId);
}
