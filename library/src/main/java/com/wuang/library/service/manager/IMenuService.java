package com.wuang.library.service.manager;

import java.util.List;

import com.wuang.library.dao.model.Menu;

public interface IMenuService {

	public List<Menu> findMenu(Menu t, int currPage, int pageSize);

	public boolean updateOne(Menu t);

	public boolean deleteOne(String id);

	public boolean insertOne(Menu t);

	public Menu findOne(String id);

	public List<Menu> findOrderMenus(String startmod);

	public List<Menu> findMenusForMod();

}