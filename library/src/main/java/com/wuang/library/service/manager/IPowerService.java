package com.wuang.library.service.manager;

import java.util.List;
import com.wuang.library.dao.model.Power;

public interface IPowerService {

	public List<Power> findPower(Power t , int currPage , int pageSize); 
	public boolean updateOne(Power t);
	public boolean deleteOne(String id);
	public boolean insertOne(Power t);

	public Power findOne(String id);

}