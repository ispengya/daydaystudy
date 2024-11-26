package com.ispengya.framework.beans.context;

import com.ispengya.framework.beans.context.event.ApplicationEventPublisher;
import com.ispengya.framework.beans.factory.ListableBeanFactory;

/**
 * 上下文顶级接口
 */
public interface ApplicationContext extends ListableBeanFactory, ApplicationEventPublisher {
}
