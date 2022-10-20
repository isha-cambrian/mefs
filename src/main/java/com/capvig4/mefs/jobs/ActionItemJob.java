package com.capvig4.mefs.jobs;

import com.capvig4.mefs.clients.EmailClient;
import com.capvig4.mefs.domain.ActionItem;
import com.capvig4.mefs.domain.CommunicationType;
import com.capvig4.mefs.domain.User;
import com.capvig4.mefs.repository.ActionItemRespository;
import com.capvig4.mefs.repository.UserRepository;

import java.util.List;

public class ActionItemJob {

    ActionItemRespository actionItemRepo;
    UserRepository userRepo;
    EmailClient emailClient;


    public void sendEmails(){
        for(ActionItem actionItem: getLastOneDayUsers()){
            User user = userRepo.findByFeedbackId(actionItem.getFeedbackId());
            emailClient.sendMail(user, CommunicationType.ACTION_ITEM, actionItem.getBody());
        }
    }

    private List<ActionItem> getLastOneDayUsers(){
        return actionItemRepo.getTodayActionItems();
    }
}
