package com.celloscope.accountinfoapi.account.adapter.out.persistence;

import com.celloscope.accountinfoapi.account.application.port.out.AccountHolderInfoPort;
import com.celloscope.accountinfoapi.account.domain.AccountHolderInfo;
import com.celloscope.accountinfoapi.common.BaseResponse;
import com.celloscope.accountinfoapi.common.CustomMessage;
import com.celloscope.accountinfoapi.common.RecordNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountInfoPersistenceAdapter implements AccountHolderInfoPort {

    private  final AccountInfoRepository accountInfoRepository;
    ModelMapper modelMapper = new ModelMapper();

    public AccountInfoPersistenceAdapter(AccountInfoRepository accountInfoRepository) {
        this.accountInfoRepository = accountInfoRepository;
    }


    @Override
    public List<AccountHolderInfo> getAllAccountHolderList() {
        return accountInfoRepository.findAll().stream().map(a -> modelMapper.map(a, AccountHolderInfo.class)).collect(Collectors.toList());
    }


    @Override
    public AccountHolderInfo getByAccountHolderId(Long id) {
        AccountHolderInfoEntity accountHolderInfoEntity;
        try{

            accountHolderInfoEntity = accountInfoRepository.findById(id)
                    .orElseThrow(() -> new RecordNotFoundException("Account Holder Id '" + id + "' does not exist !"));
        } catch (RecordNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }



        return modelMapper.map(accountHolderInfoEntity, AccountHolderInfo.class);
    }

    @Override
    public AccountHolderInfo createAccountInfo(AccountHolderInfo accountHolderInfo) {
       modelMapper.typeMap(AccountHolderInfo.class, AccountHolderInfoEntity.class).addMapping(AccountHolderInfo::getAccountType, AccountHolderInfoEntity::setAccountType );
        AccountHolderInfoEntity accountHolderInfoEntity =modelMapper.map(accountHolderInfo, AccountHolderInfoEntity.class);
        AccountHolderInfoEntity accountHolderInfoEntity1 = accountInfoRepository.save(accountHolderInfoEntity);
        System.out.println(accountHolderInfoEntity1.getAccountType().getId());
        AccountHolderInfo accountHolderInfo1  = modelMapper.map(accountHolderInfoEntity1, AccountHolderInfo.class);
        System.out.println(accountHolderInfo1.getAccountType().getType());
        return accountHolderInfo1;
    }

    @Override
    public AccountHolderInfo updateByAccountHolderId(AccountHolderInfo accountHolderInfo, Long id) {
       modelMapper.typeMap(AccountHolderInfo.class, AccountHolderInfoEntity.class).addMapping(AccountHolderInfo::getAccountType, AccountHolderInfoEntity::setAccountType );
        AccountHolderInfoEntity accountHolderInfoEntity = modelMapper.map(accountHolderInfo, AccountHolderInfoEntity.class);
        accountInfoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Account Holder Not found, Id: " + id));
        AccountHolderInfoEntity account = accountInfoRepository.save(accountHolderInfoEntity);
        AccountHolderInfo accountHolder = modelMapper.map(account, AccountHolderInfo.class);

        return accountHolder;
    }

    @Override
    public BaseResponse deleteByAccountHolderId(Long id) {
        try {
            if (accountInfoRepository.existsById(id)) {
                accountInfoRepository.deleteById(id);

            } else {
                throw new RecordNotFoundException("No record found for given id: " + id);
            }
        }
        catch(RecordNotFoundException e){
            System.out.println(e.getMessage());
            throw new RecordNotFoundException("No record found for given id: " + id);

        }
        return new BaseResponse(CustomMessage.DELETE_SUCCESS_MESSAGE, HttpStatus.OK.value());
    }
}
