package com.eliezermoraes.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.eliezermoraes.workshopmongodb.domain.Post;
import com.eliezermoraes.workshopmongodb.domain.User;
import com.eliezermoraes.workshopmongodb.dto.AuthorDTO;
import com.eliezermoraes.workshopmongodb.repositories.PostRepository;
import com.eliezermoraes.workshopmongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User eliezer = new User(null, "Eliezer Moraes", "eliezer@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob, eliezer));
		
		Post post1 = new Post(null, sdf.parse("21/03/18"), "Partiu viagem!", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(maria));		
		postRepository.saveAll(Arrays.asList(post1, post2));

	}
}
