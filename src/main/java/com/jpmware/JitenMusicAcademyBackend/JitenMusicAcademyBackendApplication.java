package com.jpmware.JitenMusicAcademyBackend;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jpmware.JitenMusicAcademyBackend.dao.role.RoleRepository;
import com.jpmware.JitenMusicAcademyBackend.dao.user.UserRepository;
import com.jpmware.JitenMusicAcademyBackend.entity.Role;
import com.jpmware.JitenMusicAcademyBackend.entity.User;

@SpringBootApplication
public class JitenMusicAcademyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JitenMusicAcademyBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {

			if (roleRepository.findByAuthority("ADMIN").isPresent()) return;

			Role adminRole = roleRepository.save(new Role("ADMIN")); 
			roleRepository.save(new Role("STUDENT"));
			roleRepository.save(new Role("INSTRUCTOR"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			
			User admin = new User(
				"admin", 
				"admin", 
				"admin@email.com", 
				passwordEncoder.encode("password"), 
				roles
			);
			userRepository.save(admin);
		};
	}

}
