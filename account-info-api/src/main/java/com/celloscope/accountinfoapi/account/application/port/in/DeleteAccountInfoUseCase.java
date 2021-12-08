package com.celloscope.accountinfoapi.account.application.port.in;


import com.celloscope.accountinfoapi.common.BaseResponse;

public interface DeleteAccountInfoUseCase {

    BaseResponse deleteByAccountHolderId(Long id);

}
