package com.wuang.library.service.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wuang.library.dao.mapper.MenuMapper;
import com.wuang.library.dao.model.Menu;
import com.wuang.library.service.BaseService;
import com.wuang.library.service.manager.IMenuService;

@Service
public class MenuService extends BaseService<Menu> implements IMenuService {
	@Autowired
	MenuMapper mapper;

	public List<Menu> findMenu(Menu t, int pageNum, int pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			return selectByList(t);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean updateOne(Menu t) {
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

	public boolean insertOne(Menu t) {

		try {
			insert(t);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Menu findOne(String id) {

		try {
			Menu t = new Menu();
			t.setId(id);
			return selectByEntity(t);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public List<Menu> findOrderMenus(String startmod) {
		// TODO Auto-generated method stub
		return mapper.findMenusByOrder(startmod);
	}

	public List<Menu> findMenusForMod() {
		// TODO Auto-generated method stub
		return mapper.findMenusForMod();
	}
}