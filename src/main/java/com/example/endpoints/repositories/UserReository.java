package com.example.endpoints.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.endpoints.entity.User;

public interface UserReository extends CrudRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.firstName=:name")
	List<User>findUsersByFirstName(String name);
	@Query("SELECT u FROM User u WHERE u.lastName=:name")
	List<User>findUsersByLastName(String name);
	@Query("SELECT u FROM User u WHERE u.firstName=:firstName and u.lastName=:lastName")
	Optional<User>findUserByFirstNameAndLastName(String firstName,String lastName);
	@Query("UPDATE User u SET u.firstName=:name where id=:id ")
	void updateUserByFirstName(String  name,int id)  ;
 
		 
		
	 
		
	 
}
