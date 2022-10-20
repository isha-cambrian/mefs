package com.capvig4.mefs.repository;

import com.capvig4.mefs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

    @Query("SELECT u FROM User u INNER JOIN interactions i ON u.id=i.userId INNER JOIN feedbacks f ON f.id=i.feedbackId WHERE f.id = ?1")
    public User findByFeedbackId(Integer id);

    @Query("SELECT u FROM User u INNER JOIN ManagerSubordinate ms ON u.id=ms.managerId WHERE ms.id = ?1")
    public List<User> getSubordinates(Long managerId);

}