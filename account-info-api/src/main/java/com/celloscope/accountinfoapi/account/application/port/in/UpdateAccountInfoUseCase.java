package com.celloscope.accountinfoapi.account.application.port.in;

import com.celloscope.accountinfoapi.account.domain.AccountHolderInfo;


public interface UpdateAccountInfoUseCase {

    AccountHolderInfo updateByAccountHolderId(AccountHolderInfo accountHolderInfo, Long id);
}
