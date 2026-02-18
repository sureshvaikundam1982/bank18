package com.banking.fundtransfer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "account-service", configuration = com.banking.fundtransfer.config.FeignConfig.class)
public interface AccountClient {

    @GetMapping("/accounts/{id}")
    Object getAccount(@PathVariable("id") Long id);

    @PutMapping("/accounts/{id}/debit/{amount}")
    void debit(@PathVariable Long id, @PathVariable Double amount);

    @PutMapping("/accounts/{id}/credit/{amount}")
    void credit(@PathVariable Long id, @PathVariable Double amount);
}
