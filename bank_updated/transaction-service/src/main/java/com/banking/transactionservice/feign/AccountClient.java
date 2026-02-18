package com.banking.transactionservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service", configuration = com.banking.transactionservice.config.FeignConfig.class)
public interface AccountClient {

    @GetMapping("/accounts/{id}")
    Object getAccountById(@PathVariable("id") Long id);
}
