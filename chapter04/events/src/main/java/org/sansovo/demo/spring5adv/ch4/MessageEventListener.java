package org.sansovo.demo.spring5adv.ch4;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
    @Override
    public void onApplicationEvent(MessageEvent event) {
        MessageEvent msgEvt = event;
        System.out.println("Received: " + msgEvt.getMessage());
    }
}
