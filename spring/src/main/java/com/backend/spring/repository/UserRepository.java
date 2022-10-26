package com.backend.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.spring.model.User;


	@Repository
	public interface UserRepository extends JpaRepository<User, Integer> {

}
