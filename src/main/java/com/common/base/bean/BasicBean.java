package com.common.base.bean;

import java.util.HashMap;
import java.util.Map;



/**
 * @author Young
 */
public class BasicBean{
	
	private Map<String, Object> map = new HashMap<>();

	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
