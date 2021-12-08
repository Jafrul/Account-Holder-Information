package com.celloscope.accountinfoapi.account.application.port.in;

import com.celloscope.accountinfoapi.account.domain.AccountType;
import com.celloscope.accountinfoapi.common.BaseResponse;

import java.util.List;
import java.util.Optional;

public interface CrudAccountTypeUseCase {

    List<AccountType> getAllAccountType();

    Optional<AccountType> getByAccountTypeId(Long id);

    AccountType createAccountType(AccountType accountType);

    AccountType updateByAccountTypeId(AccountType accountType, Long id);

    BaseResponse deleteByAccountTypeId(Long id);

}