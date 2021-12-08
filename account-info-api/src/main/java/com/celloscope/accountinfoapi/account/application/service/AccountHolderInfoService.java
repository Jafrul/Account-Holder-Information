package com.celloscope.accountinfoapi.account.application.service;

import com.celloscope.accountinfoapi.account.application.port.in.CreateAccountInfoUseCase;
import com.celloscope.accountinfoapi.account.application.port.in.DeleteAccountInfoUseCase;
import com.celloscope.accountinfoapi.account.application.port.in.GetAccountInfoUseCase;
import com.celloscope.accountinfoapi.account.application.port.in.UpdateAccountInfoUseCase;
import com.celloscope.accountinfoapi.account.application.port.out.AccountHolderInfoPort;
import com.celloscope.accountinfoapi.account.domain.AccountHolderInfo;
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
public class AccountHolderInfoService implements
        CreateAccountInfoUseCase, GetAccountInfoUseCase, UpdateAccountInfoUseCase, DeleteAccountInfoUseCase {
   private final AccountHolderInfoPort accountHolderInfoPort;

    public AccountHolderInfoService(AccountHolderInfoPort accountHolderInfoPort) {
        this.accountHolderInfoPort = accountHolderInfoPort;
    }


    @Override
    public List<AccountHolderInfo> getAllAccountHolderList() {

        return accountHolderInfoPort.getAllAccountHolderList();
    }

    @Override
    public Optional<AccountHolderInfo> getByAccountHolderId(Long id) {

        return Optional.ofNullable(accountHolderInfoPort.getByAccountHolderId(id));
    }

    @Override
    public AccountHolderInfo createAccountInfo(AccountHolderInfo accountHolderInfo) {

        AccountHolderInfo accountInfo = accountHolderInfoPort.createAccountInfo(accountHolderInfo);

        return accountInfo;

    }

    @Override
    public AccountHolderInfo updateByAccountHolderId(AccountHolderInfo accountHolderInfo, Long id) {
        AccountHolderInfo accountHolder = accountHolderInfoPort.updateByAccountHolderId(accountHolderInfo, id);

        return accountHolder;
    }

    @Override
    public BaseResponse deleteByAccountHolderId(Long id) {
        try {
            accountHolderInfoPort.deleteByAccountHolderId(id);
        } catch (RecordNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RecordNotFoundException("No record found for given id: " + id);
        }

        return new BaseResponse(CustomMessage.DELETE_SUCCESS_MESSAGE, HttpStatus.OK.value());
    }

}

