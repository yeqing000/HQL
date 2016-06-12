package com.imooc.test;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.imooc.model.Seller;
import com.imooc.util.HibernateSessionFactory;

public class SellerTest {
	private Session session = null;

	@Test
	public void testDistinct() {
		//对象名
		String hql = "select distinct sex from Customer";
		//新建查询
		Query query = session.createQuery(hql);
		//获取返回列表
		List<Object> list = query.list();
		for (Object object : list) {
			System.out.println(object);
		}
	}

	@Test
	public void testSelectClauseObjectArray() {
		// 单个列返回List<Object>
		String hql = "select s.name from Seller s";
		Query query = session.createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Object> list = query.list();
		for (Object objects : list) {
			System.out.println("姓名:" + objects);
		}

	}

	@Test
	public void testListObjects() {
		//多个列时才是对象数组
		String hql = "select s.name,s.tel from Seller s";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println("姓名:" + objects[0] + ",电话" + objects[1]);
		}

	}

	@Test
	public void testListList() {
		// List 返回 hql 中定义list集合
		String hql = "select new list(s.name,s.tel) from Seller s";
		Query query = session.createQuery(hql);
		List<List> list = query.list();
		for (List list2 : list) {
			System.out.println("姓名:" + list2.get(0) + ",电话" + list2.get(1));
		}

	}

	@Test
	public void testMap() {
		// Map 返回 hql 中定义Map集合 定义别名获取值
		String hql = "select new map(s.name as name ,s.tel as tel) from Seller s";
		Query query = session.createQuery(hql);
		List<Map> list = query.list();
		for (Map list2 : list) {
			// 别名获取值
			System.out.println("姓名:" + list2.get("name") + ",电话"
					+ list2.get("tel"));
		}
	}

	@Test
	public void testSeller() {

		// hql语句 对象 别名
		String hql = "from Seller as seller";
		// 创建Query
		Query query = session.createQuery(hql); // list
		List<Seller> sellers = query.list();
		for (Seller seller : sellers) {
			System.out.println(seller);
		}
	}
	@Test
	public void testSellerOne() {
		//order by asc,desc
		// hql语句 对象 别名
		String hql = "from Seller as s where s.age=20 ";
		// 创建Query
		Query query = session.createQuery(hql); // list
		//单一结果 uniqueResult
		Seller seller = (Seller) query.uniqueResult();
			System.out.println(seller);
	}

	@Test
	public void testOwnerSeller() {
		// hql语句 对象 别名 自定义构造器 对象必须大写 无参构造必须写 调用默认构造器
		String hql = "select new Seller(s.name,s.tel) from Seller s";
		// 创建Query
		Query query = session.createQuery(hql);
		// list
		List<Seller> sellers = query.list();
		for (Seller seller : sellers) {
			System.out.println(seller.getName() + "," + seller.getTel());
		}
	}

	@Before
	public void setUp() {
		session = HibernateSessionFactory.getSession();
	}

	@After
	public void tearDown() {
		session.close();
	}

}
