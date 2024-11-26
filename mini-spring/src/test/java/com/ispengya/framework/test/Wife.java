package com.ispengya.framework.test;

import com.ispengya.framework.beans.context.annotation.Component;
import com.ispengya.framework.beans.factory.annotation.Autowired;

@Component
public class Wife {

    @Autowired
    private Husband husband;
    @Autowired
    private IMother mother; // 婆婆

    public String queryHusband() {
        return "Wife.husband、Mother.callMother：" + mother.callMother();
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    public IMother getMother() {
        return mother;
    }

    public void setMother(IMother mother) {
        this.mother = mother;
    }

}
