package com.eobrazovanje.ssluzba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eobrazovanje.ssluzba.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);
	
	@Override
	void delete(Role role);
}
