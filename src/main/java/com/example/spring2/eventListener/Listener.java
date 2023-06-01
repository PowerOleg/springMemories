package com.example.spring2.eventListener;

import org.springframework.context.event.EventListener;

public class Listener {

    @EventListener
    public void acceptEntity(EntityEvent entityEvent) {
        System.out.println("ENTITY_EVENT YOYO");
    }
}
