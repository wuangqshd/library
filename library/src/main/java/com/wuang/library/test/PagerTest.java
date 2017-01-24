package com.wuang.library.test;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.wuang.library.dao.model.Pager;
import com.wuang.library.service.manager.IPagerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mvc.xml","classpath:applicationContext.xml"})
public class PagerTest {
		@Autowired
		IPagerService service;

		@Test
		public void testPager(){
			Pager t = new Pager();
			List<Pager> list = service.findPager(t,1,10);
			System.out.println(list.size());
			t = service.findOne("1");
		}
}