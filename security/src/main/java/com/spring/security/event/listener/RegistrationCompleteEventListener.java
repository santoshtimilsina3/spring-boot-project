package com.spring.security.event.listener;

import com.spring.security.entity.User;
import com.spring.security.event.RegistrationCompleteEvent;
import com.spring.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;


    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create the Verification token for user with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        //send mail to user
        String url = event.getApplicationUrl()
                + "verifyRegistration?token="
                + token;
        log.info("Click to verify your account " + url);

    }
}
