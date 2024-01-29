package com.devops.aws.test.externalprops;

import com.devops.aws.jms.FakeJmsBroker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({
        @PropertySource("classpath:testing.properties"),
        @PropertySource("classpath:encrypted-testing.properties")})
public class ExternalPropertiesMultiFile {

    @Autowired
    Environment env;

    @Bean
    public FakeJmsBroker fakeJmsBrokerMulti(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUrl(env.getProperty("vero.jms.server"));
        fakeJmsBroker.setPort(env.getRequiredProperty("vero.jms.port", Integer.class));
        fakeJmsBroker.setUser(env.getProperty("vero.jms.user"));
        fakeJmsBroker.setPassword(env.getProperty("vero.jms.encrypted.password"));
        return fakeJmsBroker;
    }


}
