package com.celloscope.accountinfoapi.account.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountInfoRepository extends JpaRepository<AccountHolderInfoEntity, Long> {

}
