package com.nf.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nf.entity.Account;



@Repository
public interface AccountDao extends JpaRepository<Account, String>
{
//	@Cacheable(key="#p0")
//	@Transactional
//	@Modifying
//	@Query("update Account u set u.name=:name where u.id=:id")
//	public void modifyAccounts(@Param("id") String id,@Param("name") String name);
	
	@Query("select u from #{#entityName} u where u.id=:id ")
	public List<Account> queryCustomer(@Param("id") int id);
	
	
	public Account findByAccountId(String accountId);
}
