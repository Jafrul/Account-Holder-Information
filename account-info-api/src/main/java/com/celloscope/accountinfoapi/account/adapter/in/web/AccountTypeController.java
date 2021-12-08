package com.celloscope.accountinfoapi.account.adapter.in.web;


import com.celloscope.accountinfoapi.account.application.port.in.CrudAccountTypeUseCase;
import com.celloscope.accountinfoapi.account.domain.AccountType;
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

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/v1")
public class AccountTypeController {

  private final CrudAccountTypeUseCase crudAccountTypeUseCase;

    public AccountTypeController(CrudAccountTypeUseCase crudAccountTypeUseCase) {
        this.crudAccountTypeUseCase = crudAccountTypeUseCase;
    }
    @GetMapping("/accounts")
    public ResponseEntity<List<AccountType>> getAllAccountType() {

        List<AccountType> list = crudAccountTypeUseCase.getAllAccountType();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }



    @GetMapping("/accounts/{id}")
    public ResponseEntity<?> getAccountTypeById(@PathVariable("id") Long id) {

        Optional<AccountType> accountType = crudAccountTypeUseCase.getByAccountTypeId(id);

        if (accountType.isPresent()) return new ResponseEntity<AccountType>(accountType.get(), HttpStatus.OK);

        List<String> details = new ArrayList<>(
                Arrays.asList(
                        "Account Type Id '" + id + "' does not exist !"

                )
        );

        return new ResponseEntity<ErrorResponse>(new ErrorResponse("Record not found", details),
                HttpStatus.NOT_FOUND);

    }

    @PostMapping({"/accounts"})
    public ResponseEntity<?> createAccountType(@RequestBody AccountType accountType) {

        AccountType account = crudAccountTypeUseCase.createAccountType(accountType);

        return new ResponseEntity<AccountType>(account, HttpStatus.CREATED);
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<?> updateAccountTypeById(@RequestBody AccountType accountType, @PathVariable Long id) {

        AccountType account = crudAccountTypeUseCase.updateByAccountTypeId(accountType, id);

        return new ResponseEntity<AccountType>(account, HttpStatus.CREATED);

    }


    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> deleteAccountTypeById(@PathVariable("id") Long id) {
        BaseResponse response;
        try {
            response = crudAccountTypeUseCase.deleteByAccountTypeId(id);
        } catch (RecordNotFoundException e) {

            List<String> details = new ArrayList<>(
                    Arrays.asList(
                            "Account Type Id '" + id + "' does not exist !"

                    )
            );
            return new ResponseEntity<ErrorResponse>(new ErrorResponse("Record not found", details),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
