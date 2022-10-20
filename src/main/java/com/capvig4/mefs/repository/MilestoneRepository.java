package com.capvig4.mefs.repository;


import com.capvig4.mefs.domain.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
    @Query("SELECT m FROM milestone m WHERE m.CompletionDate = DATE_SUB(CURDATE(), INTERVAL 1 DAY)")
    public List<Milestone> getMilestonesCompletedYesterday();
}
