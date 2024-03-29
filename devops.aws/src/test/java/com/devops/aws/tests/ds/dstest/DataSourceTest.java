package com.devops.aws.tests.ds.dstest;

import com.devops.aws.tests.config.DataSourceConfig;
import com.devops.aws.tests.ds.FakeDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= DataSourceConfig.class)
@SpringBootTest
//@ActiveProfiles("qa")
public class DataSourceTest {
    private FakeDataSource fakeDataSource;
    @Autowired
    public void setFakeDataSource(FakeDataSource fakeDataSource) {
        this.fakeDataSource = fakeDataSource;
    }

    @Test
    public void TestDataSource() throws Exception {
        System.out.println(fakeDataSource.getConnectionInfo());
    }
}
