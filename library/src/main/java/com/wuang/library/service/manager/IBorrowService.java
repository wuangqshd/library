package com.wuang.library.service.manager;

import java.util.List;
import com.wuang.library.dao.model.Borrow;

public interface IBorrowService {

	public List<Borrow> findBorrow(Borrow t , int currPage , int pageSize); 
	public boolean updateOne(Borrow t);
	public boolean deleteOne(String id);
	public boolean insertOne(Borrow t);

	public Borrow findOne(String id);

}