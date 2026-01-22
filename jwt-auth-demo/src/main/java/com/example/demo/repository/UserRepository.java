	package com.example.demo.repository;

	import java.util.Optional;
	import org.springframework.data.jpa.repository.JpaRepository;
	import com.example.demo.model.User;

	public interface UserRepository extends JpaRepository<User, Long> 
	{
	    // This allows us to find a user by username during login
	    Optional<User> findByUsername(String username);
	}
