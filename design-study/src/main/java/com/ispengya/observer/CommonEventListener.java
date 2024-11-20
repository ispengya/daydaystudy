package com.ispengya.observer;

public class CommonEventListener implements EventListener {

    @Override
    public void doEvent(Event event) {
        CommonEvent commonEvent = (CommonEvent) event;
        System.out.println(commonEvent.getMessage());
    }
}
