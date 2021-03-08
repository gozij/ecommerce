package com.tts.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tts.ecommerce.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUserName(String username);

}
