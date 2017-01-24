package com.wuang.library.service.manager;

import java.util.List;
import com.wuang.library.dao.model.Pager;

public interface IPagerService {

	public List<Pager> findPager(Pager t , int currPage , int pageSize); 
	public boolean updateOne(Pager t);
	public boolean deleteOne(String id);
	public boolean insertOne(Pager t);

	public Pager findOne(String id);

}