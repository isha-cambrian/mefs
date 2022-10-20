package com.capvig4.mefs.service;

import com.capvig4.mefs.domain.Interaction;
import com.capvig4.mefs.domain.User;
import com.capvig4.mefs.repository.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    InteractionRepository interactionRepository;

    public List<Interaction> getUserIntractions(User user){
        return interactionRepository.getUserInteractions(user.getId());
    }
}
