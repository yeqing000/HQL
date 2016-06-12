package com.imooc.test;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.imooc.model.Commodity;
import com.imooc.model.Customer;
import com.imooc.model.Orderform;
import com.imooc.model.Seller;
import com.imooc.util.HibernateSessionFactory;

public class CommodityTest {
	private Session session=null;
	@Test
	public void tesOrder(){
		//is not empty 转为 exists    member of 转为 in 注意对象和属性严格区分大小写
		String hql="from Orderform o where o.orderitems is not empty";
		//创建Query 
		Query query=session.createQuery(hql);
		//list
		List<Orderform> orders=query.list();
		//外键 提高性能  如果一级缓存中有则不查询，如果没有则再查询
		for (Orderform order : orders) {
			System.out.println(order);
		}
	}
	@Test
	public void testLike(){
		//and or not
		//like _  外单内双  外双内单 _ 占位符   %通用
		//String hql="from Customer c where c.name like '张_' ";
		String hql="from Customer c where c.address like '%北京%' ";
		//创建Query 
		Query query=session.createQuery(hql);
		//list
		List<Customer> customers=query.list();
		//外键 提高性能 如果一级缓存中有则不查询，如果没有则再查询
		for (Customer customer : customers) {
			System.out.println(customer.getName()+","+customer.getAddress());
		}
	}
	@Test
	public void testCommodityin(){
		//hql语句 对象 自动引入完整名 is null =null 自动转换 ！=null　is not null
		//String hql="from Customer c where c.age in(20,40) ";
		//between and 包括边界
		String hql="from Customer c where c.age not between 20 and 40 ";
		//创建Query 
		Query query=session.createQuery(hql);
		//list
		List<Customer> customers=query.list();
		//外键 提高性能 如果一级缓存中有则不查询，如果没有则再查询
		for (Customer customer : customers) {
			System.out.println(customer.getName()+","+customer.getAge());
		}
	}
	@Test
	public void testCommoditynull(){
		//hql语句 对象 自动引入完整名 is null =null 自动转换 ！=null　is not null
		String hql="from Commodity c where c.description = null  ";
		//创建Query 
		Query query=session.createQuery(hql);
		//list
		List<Commodity> commodities=query.list();
		//外键 提高性能 如果一级缓存中有则不查询，如果没有则再查询
		for (Commodity commodity : commodities) {
			System.out.println(commodity.getName()+","+commodity.getDescription());
		}
	}
	@Test
	public void testCommodityWhere(){
		//hql语句 对象 自动引入完整名
		String hql="from Commodity c where c.price>400  ";
		//创建Query 
		Query query=session.createQuery(hql);
		//list
		List<Commodity> commodities=query.list();
		//外键 提高性能 如果一级缓存中有则不查询，如果没有则再查询
		for (Commodity commodity : commodities) {
			System.out.println(commodity.getName()+","+commodity.getPrice());
		}
	}
	@Test
	public void testCommodity(){
		//hql语句 对象 自动引入完整名
		String hql="from Commodity";
		//创建Query 
		Query query=session.createQuery(hql);
		//list
		List<Commodity> commodities=query.list();
		//外键 提高性能 如果一级缓存中有则不查询，如果没有则再查询
		for (Commodity commodity : commodities) {
			System.out.println(commodity.getName()+","+commodity.getSeller().getName());
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
