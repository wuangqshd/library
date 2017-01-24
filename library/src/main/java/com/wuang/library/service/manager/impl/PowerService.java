package com.wuang.library.service.manager.impl;

import java.util.List;
import org.springframework.stereotype.Service;import com.wuang.library.service.BaseService;
import com.wuang.library.dao.model.Power;
import com.github.pagehelper.PageHelper;
import com.wuang.library.service.manager.IPowerService;

@Service
public class PowerService extends BaseService<Power> implements IPowerService {

	public List<Power> findPower(Power t , int pageNum , int pageSize) { 
		try {
			PageHelper.startPage(pageNum, pageSize);
			return selectByList(t);
		} catch (Exception e) {
			return null;
		}
	}
	public boolean updateOne(Power t) {
		try {
			updateByPrimaryKey(t);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean deleteOne(String id) {
		try {
			deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean insertOne(Power t) {

		try {
			insert(t);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public Power findOne(String id) {

		try {
			Power t = new Power();
			t.setId(id);
			return selectByEntity(t);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}