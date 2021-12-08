package com.celloscope.accountinfoapi.account.adapter.in.web;


import com.celloscope.accountinfoapi.account.application.port.in.CreateAccountInfoUseCase;
import com.celloscope.accountinfoapi.account.application.port.in.DeleteAccountInfoUseCase;
import com.celloscope.accountinfoapi.account.application.port.in.GetAccountInfoUseCase;
import com.celloscope.accountinfoapi.account.application.port.in.UpdateAccountInfoUseCase;
import com.celloscope.accountinfoapi.account.domain.AccountHolderInfo;
import com.celloscope.accountinfoapi.common.BaseResponse;
import com.celloscope.accountinfoapi.common.ErrorResponse;
import com.celloscope.accountinfoapi.common.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/v1")
public class AccountHolderInfoController {

    private final CreateAccountInfoUseCase createAccountInfoUseCase;
    private final GetAccountInfoUseCase getAccountInfoUseCase;
    private final UpdateAccountInfoUseCase updateAccountInfoUseCase;
    private final DeleteAccountInfoUseCase deleteAccountInfoUseCase;

    public AccountHolderInfoController(CreateAccountInfoUseCase createAccountInfoUseCase, GetAccountInfoUseCase getAccountInfoUseCase, UpdateAccountInfoUseCase updateAccountInfoUseCase, DeleteAccountInfoUseCase deleteAccountInfoUseCase) {
        this.createAccountInfoUseCase = createAccountInfoUseCase;
        this.getAccountInfoUseCase = getAccountInfoUseCase;
        this.updateAccountInfoUseCase = updateAccountInfoUseCase;
        this.deleteAccountInfoUseCase = deleteAccountInfoUseCase;
    }

    @GetMapping("/accountinfo")
    public ResponseEntity<List<AccountHolderInfo>> getAllAccountHolderInfo() {

        List<AccountHolderInfo> list = getAccountInfoUseCase.getAllAccountHolderList();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("/accountinfo/{id}")
    public ResponseEntity<?> getAccountHolderById(@PathVariable("id") Long id) {

        Optional<AccountHolderInfo> accountHolderInfo = getAccountInfoUseCase.getByAccountHolderId(id);

        if (accountHolderInfo.isPresent()) return new ResponseEntity<AccountHolderInfo>(accountHolderInfo.get(), HttpStatus.OK);

        List<String> details = new ArrayList<>(
                Arrays.asList(
                        "Account Holder Id '" + id + "' does not exist !"

                )
        );

        return new ResponseEntity<ErrorResponse>(new ErrorResponse("Record not found", details),
                HttpStatus.NOT_FOUND);

    }



    @PostMapping({"/accountinfo"})
    public ResponseEntity<?> createAccountHolder(@RequestBody AccountHolderInfo accountHolderInfo) {

        AccountHolderInfo accountInfo = createAccountInfoUseCase.createAccountInfo(accountHolderInfo);

        return new ResponseEntity<AccountHolderInfo>(accountInfo, HttpStatus.CREATED);
    }


    @PutMapping("/accountinfo/{id}")
    public ResponseEntity<?> updateAccountHolderById(@RequestBody AccountHolderInfo accountHolderInfo, @PathVariable Long id) {

        AccountHolderInfo accountInfo = updateAccountInfoUseCase.updateByAccountHolderId(accountHolderInfo, id);

        return new ResponseEntity<AccountHolderInfo>(accountInfo, HttpStatus.CREATED);

    }

    @DeleteMapping("/accountinfo/{id}")
    public ResponseEntity<?> deleteAccountHolderById(@PathVariable("id") Long id) {
        BaseResponse response;
        try {
            response = deleteAccountInfoUseCase.deleteByAccountHolderId(id);
        } catch (RecordNotFoundException e) {

            List<String> details = new ArrayList<>(
                    Arrays.asList(
                            "Account Holder Id '" + id + "' does not exist !"

                    )
            );
            return new ResponseEntity<ErrorResponse>(new ErrorResponse("Record not found", details),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
