package com.celloscope.accountinfoapi.account.adapter.out.persistence;

import com.celloscope.accountinfoapi.account.application.port.out.AccountTypePort;
import com.celloscope.accountinfoapi.account.domain.AccountType;
import com.celloscope.accountinfoapi.common.BaseResponse;
import com.celloscope.accountinfoapi.common.CustomMessage;
import com.celloscope.accountinfoapi.common.RecordNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountPersistenceAdapter implements AccountTypePort {

    private final AccountRepository accountRepository;

    ModelMapper modelMapper = new ModelMapper();

    public AccountPersistenceAdapter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountType> getAllAccountType() {
        return accountRepository.findAll().stream().map(a-> modelMapper.map(a, AccountType.class)).collect(Collectors.toList());
    }

    @Override
    public AccountType getByAccountTypeId(Long id) {
        AccountTypeEntity accountTypeEntity;
        try{

            accountTypeEntity = accountRepository.findById(id)
                    .orElseThrow(() -> new RecordNotFoundException("AccountType Id '" + id + "' does not exist !"));
        } catch (RecordNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }



        return modelMapper.map(accountTypeEntity, AccountType.class);
    }

    @Override
    public AccountType createAccountType(AccountType accountType) {

        AccountTypeEntity accountTypeEntity =modelMapper.map(accountType, AccountTypeEntity.class);
       AccountTypeEntity account = accountRepository.save(accountTypeEntity);
        AccountType accountType1  = modelMapper.map(account, AccountType.class);

        return accountType1;
    }

    @Override
    public AccountType updateByAccountTypeId(AccountType accountType, Long id) {
        AccountTypeEntity accountTypeEntity = modelMapper.map(accountType, AccountTypeEntity.class);
        accountRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Account Type Not found, Id: " + id));
        AccountTypeEntity account = accountRepository.save(accountTypeEntity);
        AccountType accountType1 = modelMapper.map(account, AccountType.class);
        return accountType1;
    }

    @Override
    public BaseResponse deleteByAccountTypeId(Long id) {
        try {
            if (accountRepository.existsById(id)) {
                accountRepository.deleteById(id);

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
