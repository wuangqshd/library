package com.wuang.library.entry;

import java.util.List;

public class SecoundMenu {
	private String name;
	private List<ThridMenu> children;

	public SecoundMenu(String name, List<ThridMenu> children) {
		super();
		this.name = name;
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ThridMenu> getChildren() {
		return children;
	}

	public void setChildren(List<ThridMenu> children) {
		this.children = children;
	}

}
