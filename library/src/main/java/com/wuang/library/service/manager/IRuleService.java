package com.wuang.library.service.manager;

import java.util.List;
import com.wuang.library.dao.model.Rule;

public interface IRuleService {

	public List<Rule> findRule(Rule t , int currPage , int pageSize); 
	public boolean updateOne(Rule t);
	public boolean deleteOne(String id);
	public boolean insertOne(Rule t);

	public Rule findOne(String id);

}