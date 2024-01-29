package com.devops.aws.tests.externalproptest;

import com.devops.aws.tests.jms.FakeJmsBroker;
import com.devops.aws.tests.externalprops.ExternalPropertiesMultiFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExternalPropertiesMultiFile.class)

public class ExternaPropertyMultiFileTest {

    @Autowired
    FakeJmsBroker fakeJmsBroker;

    @Test
    public void testPropsSet() throws Exception {
        assertEquals("10.10.10.123", fakeJmsBroker.getUrl());
        assertEquals(3330, fakeJmsBroker.getPort().intValue());
        assertEquals("Vero", fakeJmsBroker.getUser());
        assertEquals("&%$)(*&#^!@!@#$", fakeJmsBroker.getPassword());
    }
}
