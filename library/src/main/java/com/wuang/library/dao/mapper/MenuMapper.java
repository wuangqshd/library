package com.wuang.library.dao.mapper;

import java.util.List;

import tk.mybatis.mapper.common.Mapper;

import com.wuang.library.dao.model.Menu;

public interface MenuMapper extends Mapper<Menu> {
	public List<Menu> findMenusByOrder(String createId);

	public List<Menu> findMenusForMod();
}