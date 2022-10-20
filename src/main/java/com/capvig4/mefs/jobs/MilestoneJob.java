package com.capvig4.mefs.jobs;

import com.capvig4.mefs.clients.EmailClient;
import com.capvig4.mefs.domain.CommunicationType;
import com.capvig4.mefs.domain.Milestone;
import com.capvig4.mefs.domain.User;
import com.capvig4.mefs.repository.MilestoneRepository;
import com.capvig4.mefs.repository.UserRepository;

import java.util.List;

public class MilestoneJob {
    MilestoneRepository milestoneRespository;
    UserRepository userRepo;
    EmailClient emailClient;

    public void sendEmails(){
        for(Milestone milestone: getYesterdayMilestones()){
            User user = userRepo.findByFeedbackId(milestone.getFeedbackId());
            emailClient.sendMail(user, CommunicationType.MILESTONE, milestone.getBody());
        }
    }

    private List<Milestone> getYesterdayMilestones(){
        return milestoneRespository.getMilestonesCompletedYesterday();
    }
}
