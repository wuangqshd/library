package com.wuang.library.service.manager.impl;

import java.util.List;
import org.springframework.stereotype.Service;import com.wuang.library.service.BaseService;
import com.wuang.library.dao.model.Worker;
import com.github.pagehelper.PageHelper;
import com.wuang.library.service.manager.IWorkerService;

@Service
public class WorkerService extends BaseService<Worker> implements IWorkerService {

	public List<Worker> findWorker(Worker t , int pageNum , int pageSize) { 
		try {
			PageHelper.startPage(pageNum, pageSize);
			return selectByList(t);
		} catch (Exception e) {
			return null;
		}
	}
	public boolean updateOne(Worker t) {
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
	public boolean insertOne(Worker t) {

		try {
			insert(t);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public Worker findOne(String id) {

		try {
			Worker t = new Worker();
			t.setId(id);
			return selectByEntity(t);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}