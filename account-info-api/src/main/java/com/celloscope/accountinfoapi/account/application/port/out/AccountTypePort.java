package com.celloscope.accountinfoapi.account.application.port.out;

import com.celloscope.accountinfoapi.account.domain.AccountType;
import com.celloscope.accountinfoapi.common.BaseResponse;

import java.util.List;


public interface AccountTypePort {
    List<AccountType> getAllAccountType();
    AccountType getByAccountTypeId(Long id);
    AccountType createAccountType(AccountType accountType);
    AccountType updateByAccountTypeId(AccountType accountType, Long id);
    BaseResponse deleteByAccountTypeId(Long id);
}
