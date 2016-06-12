package com.imooc.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.imooc.model.Customer;
import com.imooc.model.Seller;
import com.imooc.util.HibernateSessionFactory;

public class CustomerTest {
	private Session session=null;
	@Test
	public void testCustomer(){
		//hql语句 对象
		String hql="from Customer";
		//创建Query 
		Query query=session.createQuery(hql);
		//list
		List<Customer> customers=query.list();
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
	@Before
	public void setUp(){
		session=HibernateSessionFactory.getSession();
	}
	@After
	public void tearDown(){
		session.close();
	}

}
