package com.example.authentication.service;

import com.example.authentication.model.Choosepost;
import com.example.authentication.repository.ChoosepostRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChoosepostService {

    private final ChoosepostRepository repository;

    public ChoosepostService(ChoosepostRepository repository) {
        this.repository = repository;
    }

    public Choosepost createPost(Choosepost choosepost) {
        return repository.save(choosepost);
    }

    public List<Choosepost> getAllPosts() {
        return repository.findAll();
    }

    public Choosepost getPostById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post Record not found with id: " + id));
    }

    public Choosepost updatePost(Integer id, Choosepost updatedDetails) {
        Choosepost existingPost = getPostById(id);

        existingPost.setPosId(updatedDetails.getPosId());
        existingPost.setPosition(updatedDetails.getPosition());
        existingPost.setStatus(updatedDetails.getStatus());
        existingPost.setLink(updatedDetails.getLink());

        return repository.save(existingPost);
    }

    public void deletePost(Integer id) {
        Choosepost existingPost = getPostById(id);
        repository.delete(existingPost);
    }
}