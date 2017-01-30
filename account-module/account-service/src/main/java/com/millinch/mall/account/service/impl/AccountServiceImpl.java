package com.millinch.mall.account.service.impl;

import com.millinch.mall.account.entity.Account;
import com.millinch.mall.account.mapper.AccountMapper;
import com.millinch.mall.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired AccountMapper accountMapper;

    @Override
    public List<Account> findAccounts() {
        return accountMapper.selectList(null);
    }

    @Override
    public Account createAccount(Account account) {
        int insert = accountMapper.insert(account);
        return account;
    }
}
