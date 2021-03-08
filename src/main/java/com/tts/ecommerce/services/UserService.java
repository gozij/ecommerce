package com.tts.ecommerce.services;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tts.ecommerce.repository.UserRepository;

@Service
public class UserService implements UserDetailsService  {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryPasswordEncoder;
	
	public User findByUsername(String username) {
		
		return userRepository.findByUsername(username);{
			
		}
		
	 public void savedNow(User user) {
		 user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		 userRepository.save(user);
	 }
	  public void saveExisting(User user) {
		  userRepository.save(user);
	  }
	  
	  public user getLoggedInUser() {
		  
	  }
	  
findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

	}
	
	public void updateCart(Map<Product, integer> cart) {
	User user = getLoggedInUser();
	user.setCart(cart);
	saveExisting(user);

}
	public UserDetails loadUserByUsername(String username) throws 
	UsernameNotFoundException {
		User user = findByUserName (username);
		if(user == null) throw new UsernameNotFoundException("Username not found. ");
		return user;
		
	}
}
	}
