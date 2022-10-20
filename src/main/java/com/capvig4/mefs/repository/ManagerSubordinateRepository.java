package com.capvig4.mefs.repository;

import com.capvig4.mefs.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public interface ManagerSubordinateRepository {
    @PersistenceContext
    EntityManager entityManager = Persistence
            .createEntityManagerFactory("com.capvig4.mefs.domain")
            .createEntityManager();

    @Transactional
    public default void insertRelationship(User manager, User subordinate) {
        entityManager.createNativeQuery("INSERT INTO ManagerSubordinate (managerId, subordinateId) VALUES (?,?)")
                .setParameter(1, manager.getId())
                .setParameter(2, subordinate.getId())
                .executeUpdate();
    }
}
