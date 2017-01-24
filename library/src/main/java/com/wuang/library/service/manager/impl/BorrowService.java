package com.wuang.library.service.manager.impl;

import java.util.List;
import org.springframework.stereotype.Service;import com.wuang.library.service.BaseService;
import com.wuang.library.dao.model.Borrow;
import com.github.pagehelper.PageHelper;
import com.wuang.library.service.manager.IBorrowService;

@Service
public class BorrowService extends BaseService<Borrow> implements IBorrowService {

	public List<Borrow> findBorrow(Borrow t , int pageNum , int pageSize) { 
		try {
			PageHelper.startPage(pageNum, pageSize);
			return selectByList(t);
		} catch (Exception e) {
			return null;
		}
	}
	public boolean updateOne(Borrow t) {
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
	public boolean insertOne(Borrow t) {

		try {
			insert(t);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public Borrow findOne(String id) {

		try {
			Borrow t = new Borrow();
			t.setId(id);
			return selectByEntity(t);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}