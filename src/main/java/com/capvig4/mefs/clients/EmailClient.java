package com.capvig4.mefs.clients;

import com.capvig4.mefs.domain.CommunicationType;
import com.capvig4.mefs.domain.User;
import org.springframework.stereotype.Component;

@Component
public class EmailClient{

    public void sendMail(User user, CommunicationType type, String body){
        System.out.println(String.format( "Sending email to User: %s, with body type: %s with body: %s", user.getName(), type, body));
    }

}
