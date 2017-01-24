package com.wuang.library.service.manager.impl;

import java.util.List;
import org.springframework.stereotype.Service;import com.wuang.library.service.BaseService;
import com.wuang.library.dao.model.Pager;
import com.github.pagehelper.PageHelper;
import com.wuang.library.service.manager.IPagerService;

@Service
public class PagerService extends BaseService<Pager> implements IPagerService {

	public List<Pager> findPager(Pager t , int pageNum , int pageSize) { 
		try {
			PageHelper.startPage(pageNum, pageSize);
			return selectByList(t);
		} catch (Exception e) {
			return null;
		}
	}
	public boolean updateOne(Pager t) {
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
	public boolean insertOne(Pager t) {

		try {
			insert(t);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public Pager findOne(String id) {

		try {
			Pager t = new Pager();
			t.setId(id);
			return selectByEntity(t);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}