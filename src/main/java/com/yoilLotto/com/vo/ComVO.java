package com.yoilLotto.com.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class ComVO implements Serializable {

	private List<HashMap<Object, Object>> menu;

	public List<HashMap<Object, Object>> getMenu() {
		return menu;
	}

	public void setMenu(List<HashMap<Object, Object>> menu) {
		this.menu = menu;
	}
	
}