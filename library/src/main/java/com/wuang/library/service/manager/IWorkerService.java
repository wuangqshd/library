package com.wuang.library.service.manager;

import java.util.List;
import com.wuang.library.dao.model.Worker;

public interface IWorkerService {

	public List<Worker> findWorker(Worker t , int currPage , int pageSize); 
	public boolean updateOne(Worker t);
	public boolean deleteOne(String id);
	public boolean insertOne(Worker t);

	public Worker findOne(String id);

}