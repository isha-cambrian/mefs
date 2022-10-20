package com.capvig4.mefs.repository;

import com.capvig4.mefs.domain.Interaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteractionRepository {
    @Query("SELECT i FROM Interaction i WHERE i.userId = ?1")
    public List<Interaction> getUserInteractions(Long userId);

}
