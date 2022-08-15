package com.eliezermoraes.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliezermoraes.workshopmongodb.domain.Post;
import com.eliezermoraes.workshopmongodb.repositories.PostRepository;
import com.eliezermoraes.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return repository.findByTitleContainingIgnoreCase(text);
	}
}
