package com.banking.fundtransfer.controller;

import org.springframework.web.bind.annotation.*;
import com.banking.fundtransfer.model.TransferRequest;
import com.banking.fundtransfer.service.FundTransferService;

@RestController
@RequestMapping("/transfer")
public class FundTransferController {

    private final FundTransferService service;

    public FundTransferController(FundTransferService service) {
        this.service = service;
    }

    @PostMapping
    public String transfer(@RequestBody TransferRequest request) {
        return service.transfer(request);
    }
}
