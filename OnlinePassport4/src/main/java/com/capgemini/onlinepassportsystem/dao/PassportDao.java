package com.capgemini.onlinepassportsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinepassportsystem.entity.Passport;

@Repository
public interface PassportDao extends JpaRepository<Passport, Long>{

	
	
}