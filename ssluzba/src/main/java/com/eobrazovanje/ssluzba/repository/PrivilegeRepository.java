package com.eobrazovanje.ssluzba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eobrazovanje.ssluzba.entities.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

	Privilege findByName(String name);
	
	@Override
	void delete(Privilege privilege);
}
