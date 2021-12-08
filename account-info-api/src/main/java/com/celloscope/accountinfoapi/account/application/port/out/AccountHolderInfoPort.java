package com.celloscope.accountinfoapi.account.application.port.out;

import com.celloscope.accountinfoapi.account.domain.AccountHolderInfo;
import com.celloscope.accountinfoapi.common.BaseResponse;

import java.util.List;


public interface AccountHolderInfoPort {

    List<AccountHolderInfo> getAllAccountHolderList();

    AccountHolderInfo getByAccountHolderId(Long id);

    AccountHolderInfo createAccountInfo(AccountHolderInfo accountHolderInfo);

    AccountHolderInfo updateByAccountHolderId(AccountHolderInfo accountHolderInfo, Long id);

    BaseResponse deleteByAccountHolderId(Long id);
}
