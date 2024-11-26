package com.ispengya.framework.test;

import com.ispengya.framework.beans.context.annotation.Component;
import com.ispengya.framework.beans.factory.annotation.Autowired;

@Component
public class Husband {

    @Autowired
    private Wife wife;

    public String queryWife(){
        return "Husband.wife";
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

}
