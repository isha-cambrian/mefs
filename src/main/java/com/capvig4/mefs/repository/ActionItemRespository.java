package com.capvig4.mefs.repository;

import com.capvig4.mefs.domain.ActionItem;
import com.capvig4.mefs.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionItemRespository extends JpaRepository<ActionItem, Long> {
    @Query("SELECT a FROM ActionItem a WHERE a.dueDate = CURDATE()")
    public List<ActionItem> getTodayActionItems();

    @Query("SELECT ai FROM ActionItem ai WHERE ai.interactionId = ?1")
    public List<ActionItem> getActionItemForInteraction(Long interactionId);

}
