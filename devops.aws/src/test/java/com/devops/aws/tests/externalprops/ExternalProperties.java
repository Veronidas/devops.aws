package com.devops.aws.tests.externalprops;

import com.devops.aws.tests.jms.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:testing.properties")
public class ExternalProperties {
    @Autowired
    Environment env;

    @Bean
    public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUrl(env.getProperty("vero.jms.server"));
        fakeJmsBroker.setPort(env.getRequiredProperty("vero.jms.port", Integer.class));
        fakeJmsBroker.setUser(env.getProperty("vero.jms.user"));
        fakeJmsBroker.setPassword(env.getProperty("vero.jms.password"));
        return fakeJmsBroker;
    }
}




