package com.ispengya.observer;

import java.util.*;

public class EventManager {

    private Map<String, List<EventListener>> listeners = new HashMap<>();

    public void addEventListener(String eventKey, EventListener eventListener) {
        listeners.computeIfAbsent(eventKey, k -> new ArrayList<>()).add(eventListener);
    }

    public void notify(Event event) {
        List<EventListener> eventListeners = listeners.get(event.getEventKey());
        if (eventListeners == null) {
            return;
        }
        for (EventListener eventListener : eventListeners) {
            eventListener.doEvent(event);
        }
    }


    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        eventManager.addEventListener("ispeng1ya", new CommonEventListener());
        eventManager.notify(new CommonEvent("你好呀"));
    }
}
