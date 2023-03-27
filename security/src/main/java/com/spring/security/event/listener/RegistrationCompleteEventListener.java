package com.spring.security.event.listener;

import com.spring.security.entity.User;
import com.spring.security.event.RegistrationCompleteEvent;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create the Verification token for user with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();

        //send mail to user

    }
}
