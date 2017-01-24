package com.wuang.library.service.manager;

import java.util.List;
import com.wuang.library.dao.model.User;

public interface IUserService {

	public List<User> findUser(User t , int currPage , int pageSize); 
	public boolean updateOne(User t);
	public boolean deleteOne(String id);
	public boolean insertOne(User t);

	public User findOne(String id);

}