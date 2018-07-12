package com.nf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nf.entity.Account;

public interface AccountDao1 extends JpaRepository<Account, Integer>{

	Account findByAccountId(Integer accountId);
}
