package com.imooc.test;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional
	public void action() {
		String sql = "INSERT INTO sys_user(name,password,ch_name,group_id) VALUES(?,?,?,?)";
		int count = jdbcTemplate.update(sql, "testa","testa","testa",1);
		System.out.println("action:"+this);
		// work();
		TestService service =  (TestService)AopContext.currentProxy();
		service.work();
		System.out.println("AOPSERVICE:"+service.getClass().getSimpleName());
	}

	@Override
	@Transactional
	public void work() {
		String sql = "INSERT INTO sys_user(name,password,ch_name,group_id) VALUES(?,?,?,?)";
		int count = jdbcTemplate.update(sql, "test","test","test",1);
		System.out.println("work:"+this);
	//	throw new RuntimeException("故意抛出异常");
	}

}
