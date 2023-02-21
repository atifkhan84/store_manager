package com.atif.jsppractice.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prac {
	List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
	Map<String, String> maps = new HashMap<String, String>();

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}

	@Override
	public String toString() {
		return "Prac [list=" + list + ", maps=" + maps + "]";
	}
	
	
}
