package com.millinch.core.config;

import com.millinch.core.config.DaoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
    DaoConfig.class
})
public class DaoConfigTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void testDataSource() throws Exception {
        Connection connection = dataSource.getConnection();
        Assert.notNull(connection, "can not get connection");
    }
}
