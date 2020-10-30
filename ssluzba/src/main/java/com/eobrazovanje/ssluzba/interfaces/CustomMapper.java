package com.eobrazovanje.ssluzba.interfaces;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.eobrazovanje.ssluzba.dto.StudentDTO;
import com.eobrazovanje.ssluzba.entities.Student;


@Mapper(componentModel = "spring")
public interface CustomMapper {
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateStudentFromDTO(StudentDTO dto, @MappingTarget Student student);

	
}
