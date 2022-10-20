package com.capvig4.mefs.service;

import com.capvig4.mefs.domain.User;
import com.capvig4.mefs.repository.ManagerSubordinateRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    ManagerSubordinateRepository managerSubordinateRepository;
    public void addSubordinate(User manager, User subordinate){
        managerSubordinateRepository.insertRelationship(manager,subordinate);
    }
}
