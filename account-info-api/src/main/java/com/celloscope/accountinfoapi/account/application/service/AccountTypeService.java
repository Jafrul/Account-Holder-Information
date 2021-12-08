package com.celloscope.accountinfoapi.account.application.service;

import com.celloscope.accountinfoapi.account.application.port.in.CrudAccountTypeUseCase;
import com.celloscope.accountinfoapi.account.application.port.out.AccountTypePort;
import com.celloscope.accountinfoapi.account.domain.AccountType;
import com.celloscope.accountinfoapi.common.BaseResponse;
import com.celloscope.accountinfoapi.common.CustomMessage;
import com.celloscope.accountinfoapi.common.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Component
public class AccountTypeService implements CrudAccountTypeUseCase {

    private final AccountTypePort accountTypePort;

    public AccountTypeService(AccountTypePort accountTypePort) {
        this.accountTypePort = accountTypePort;
    }

    @Override
    public List<AccountType> getAllAccountType() {
        return accountTypePort.getAllAccountType();
    }

    @Override
    public Optional<AccountType> getByAccountTypeId(Long id) {
        return Optional.ofNullable(accountTypePort.getByAccountTypeId(id));
    }

    @Override
    public AccountType createAccountType(AccountType accountType) {

        AccountType account = accountTypePort.createAccountType(accountType);

        return  account;
    }

    @Override
    public AccountType updateByAccountTypeId(AccountType accountType, Long id) {
        AccountType account = accountTypePort.updateByAccountTypeId(accountType, id);

        return account;
    }

    @Override
    public BaseResponse deleteByAccountTypeId(Long id) {
        try {
            accountTypePort.deleteByAccountTypeId(id);
        } catch (RecordNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RecordNotFoundException("No record found for given id: " + id);
        }

        return new BaseResponse(CustomMessage.DELETE_SUCCESS_MESSAGE, HttpStatus.OK.value());
    }

}

