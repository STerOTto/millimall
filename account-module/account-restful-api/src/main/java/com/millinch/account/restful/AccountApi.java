package com.millinch.account.restful;

import com.millinch.account.entity.Account;
import com.millinch.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@RestController
@RequestMapping("/accounts")
public class AccountApi {

    @Autowired AccountService accountService;

    @GetMapping("")
    public List<Account> findAccounts() {
        return accountService.findAccounts();
    }
}
