package com.millinch.mall.account.service;

import com.millinch.mall.account.entity.Account;

import java.util.List;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
public interface AccountService {

    List<Account> findAccounts();

    Account createAccount(Account account);
}
