package com.celloscope.accountinfoapi.account.application.port.in;

import com.celloscope.accountinfoapi.account.domain.AccountHolderInfo;

public interface CreateAccountInfoUseCase {

    AccountHolderInfo createAccountInfo(AccountHolderInfo accountHolderInfo);
}
