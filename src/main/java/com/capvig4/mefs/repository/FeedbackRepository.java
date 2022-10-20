package com.capvig4.mefs.repository;

import com.capvig4.mefs.domain.Feedback;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedbackRepository {
    @Query("SELECT f FROM Feedback f WHERE f.interactionId = ?1")
    public List<Feedback> getFeedbackForInteraction(Long interactionId);
}
