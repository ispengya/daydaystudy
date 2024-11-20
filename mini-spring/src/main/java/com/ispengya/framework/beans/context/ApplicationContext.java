package com.ispengya.framework.beans.context;

import com.ispengya.framework.beans.context.event.ApplicationEventPublisher;
import com.ispengya.framework.beans.factory.ListableBeanFactory;

public interface ApplicationContext extends ListableBeanFactory, ApplicationEventPublisher {
}
