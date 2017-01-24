package com.wuang.library.service.manager.impl;

import java.util.List;
import org.springframework.stereotype.Service;import com.wuang.library.service.BaseService;
import com.wuang.library.dao.model.Magazine;
import com.github.pagehelper.PageHelper;
import com.wuang.library.service.manager.IMagazineService;

@Service
public class MagazineService extends BaseService<Magazine> implements IMagazineService {

	public List<Magazine> findMagazine(Magazine t , int pageNum , int pageSize) { 
		try {
			PageHelper.startPage(pageNum, pageSize);
			return selectByList(t);
		} catch (Exception e) {
			return null;
		}
	}
	public boolean updateOne(Magazine t) {
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
	public boolean insertOne(Magazine t) {

		try {
			insert(t);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public Magazine findOne(String id) {

		try {
			Magazine t = new Magazine();
			t.setId(id);
			return selectByEntity(t);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}