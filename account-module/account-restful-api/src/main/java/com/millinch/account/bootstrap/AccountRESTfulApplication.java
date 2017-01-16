package com.millinch.account.bootstrap;

import com.millinch.core.config.DaoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@ComponentScan({"com.millinch.account"})
@SpringBootApplication
@Import(DaoConfig.class)
public class AccountRESTfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountRESTfulApplication.class, args);
    }
}
