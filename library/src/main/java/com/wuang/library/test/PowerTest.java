package com.wuang.library.test;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.wuang.library.dao.model.Power;
import com.wuang.library.service.manager.IPowerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mvc.xml","classpath:applicationContext.xml"})
public class PowerTest {
		@Autowired
		IPowerService service;

		@Test
		public void testPower(){
			Power t = new Power();
			List<Power> list = service.findPower(t,1,10);
			System.out.println(list.size());
			t = service.findOne("1");
		}
}