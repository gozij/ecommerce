package com.tts.ecommerce.model;

import java.beans.Transient;
import java.util.Collection;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails{
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
     String username;
	
	@NotEmpty
	String password;
	
	public User(@NotEmpty String username, @NotEmpty String password, Map<Product, Integer>cart) {
	
	@ElementCollection
	protected Map<product, Integer> cart;
	        
}
    
    private boolean  accountNonExpired = true;
    
 
    private boolean accountNonLocked = true;
    
    
    private boolean credentialsNonExpired = true;
    
    
    private boolean enabled = true;
    
     
    private Collection<GrantedAuthority> authorities = null;{
    	}
    }
