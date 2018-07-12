package com.nf.contr;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nf.dao.AccountDao;
import com.nf.dao.AccountDao1;
import com.nf.dao.SpringARedisService;
import com.nf.entity.Account;

@Transactional
@Controller
public class HelloWorldController {
	
	@Autowired
	private AccountDao accountDao;  
	
	@Autowired
	private SpringARedisService redisService;  
	
	@RequestMapping(value="/hello")  
	@ResponseBody
	@Cacheable(value = "account", key="#p0")
    public Account HelloWorld(@RequestParam String id){  
		Account list = redisService.findAccount(id);
		
        return list; 
    } 
	
	@RequestMapping(value="/hello1")  
	@ResponseBody
    public String HelloWorld1(){  
		redisService.updateAccount("1114");
		
//		this.save();
//		syso
        return "success";  
    } 
	
	@RequestMapping(value="/delete")  
	@ResponseBody
    public String HelloWorld2(){  
		redisService.deleteAccount("1114");
		
//		this.save();
//		syso
        return "success";  
    } 
	
	
	
	@Transactional
	public void save()
	{
		String che ="";
		for(int i=0;i<10;i++)
		{
			che += "a";
			Account account= new Account();
			account.setAccountId(String.valueOf(new Random().nextInt(10000)));
			account.setMoney(1000);
//			account.setAddre("test123"+che);
			accountDao.save(account);
		}
		
	}
}
