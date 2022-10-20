package com.capvig4.mefs.service;

import com.capvig4.mefs.domain.Interaction;
import com.capvig4.mefs.domain.User;
import com.capvig4.mefs.domain.dto.InteractionResponse;
import com.capvig4.mefs.repository.ActionItemRespository;
import com.capvig4.mefs.repository.FeedbackRepository;
import com.capvig4.mefs.repository.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteractionService {
    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    ActionItemRespository actionItemRespository;

    @Autowired
    InteractionRepository interactionRepository;

    public InteractionResponse getInteractionResponse(Interaction interaction){
        return InteractionResponse.builder()
                .interaction(interaction)
                .feedbacks(feedbackRepository.getFeedbackForInteraction(interaction.getId()))
                .actionItems(actionItemRespository.getActionItemForInteraction(interaction.getId()))
                .build();
    }

    public List<Interaction> getInteractions(User user){
        return interactionRepository.getUserInteractions(user.getId());
    }


}
