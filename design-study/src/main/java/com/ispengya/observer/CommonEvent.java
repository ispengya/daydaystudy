package com.ispengya.observer;

public class CommonEvent extends Event{

    public String getMessage() {
        return message;
    }

    private String message;

    public  CommonEvent(String message){
        this.message = message;
    }

    @Override
    protected String getEventKey() {
        return "ispengya";
    }
}
