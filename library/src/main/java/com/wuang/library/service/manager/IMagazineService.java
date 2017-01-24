package com.wuang.library.service.manager;

import java.util.List;
import com.wuang.library.dao.model.Magazine;

public interface IMagazineService {

	public List<Magazine> findMagazine(Magazine t , int currPage , int pageSize); 
	public boolean updateOne(Magazine t);
	public boolean deleteOne(String id);
	public boolean insertOne(Magazine t);

	public Magazine findOne(String id);

}