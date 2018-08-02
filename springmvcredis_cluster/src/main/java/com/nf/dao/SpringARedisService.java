package com.nf.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nf.entity.Account;

@Service
@CacheConfig(cacheNames = "accounts")
public class SpringARedisService {

	@Autowired
	private AccountDao accountDao; 
	
//	@Cacheable(value = "account", key="#p0")
	public Account findAccount(String id)
	{
		Account account = accountDao.findOne(id);
		return account;
	}
	
	
	@CachePut(key="#p0")
	public Account updateAccount(String id)
	{
		Account account = accountDao.findOne(id);
		account.setMoney(2000);
		accountDao.save(account);
		return account;
	}
	
	@CacheEvict(key="#p0")
	public void deleteAccount(String id)
	{
		accountDao.delete(id);
	}
}
