package com.millinch.mall.account.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.millinch.mall.account.entity.Account;
import com.millinch.core.config.DaoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        DaoConfig.class
})
public class AccountMapperTest {

    @Autowired AccountMapper accountMapper;

    @Test
    public void testSelect() {
        List<Account> accounts = accountMapper.selectList(new EntityWrapper<Account>());
        System.out.println("accounts.size() = " + accounts.size());
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

}