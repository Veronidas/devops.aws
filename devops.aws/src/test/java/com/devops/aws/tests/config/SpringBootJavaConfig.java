package com.devops.aws.tests.config;

import com.devops.aws.tests.jms.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootJavaConfig {
    @Value("${vero.jms.server}")
    String jmsServer;

    @Value("${vero.jms.port}")
    Integer jmsPort;

    @Value("${vero.jms.user}")
    String jmsUser;

    @Value("${vero.jms.password}")
    String jmsPassword;

    @Bean
    public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUrl(jmsServer);
        fakeJmsBroker.setPort(jmsPort);
        fakeJmsBroker.setUser(jmsUser);
        fakeJmsBroker.setPassword(jmsPassword);
        return fakeJmsBroker;
    }
}

