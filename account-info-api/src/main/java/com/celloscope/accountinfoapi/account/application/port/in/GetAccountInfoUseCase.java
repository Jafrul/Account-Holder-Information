package com.celloscope.accountinfoapi.account.application.port.in;

import com.celloscope.accountinfoapi.account.domain.AccountHolderInfo;

import java.util.List;
import java.util.Optional;

public interface GetAccountInfoUseCase {
    List<AccountHolderInfo> getAllAccountHolderList();
    Optional<AccountHolderInfo> getByAccountHolderId(Long id);


}
