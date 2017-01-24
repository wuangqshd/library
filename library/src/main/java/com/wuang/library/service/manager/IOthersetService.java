package com.wuang.library.service.manager;

import java.util.List;
import com.wuang.library.dao.model.Otherset;

public interface IOthersetService {

	public List<Otherset> findOtherset(Otherset t , int currPage , int pageSize); 
	public boolean updateOne(Otherset t);
	public boolean deleteOne(String id);
	public boolean insertOne(Otherset t);

	public Otherset findOne(String id);

}