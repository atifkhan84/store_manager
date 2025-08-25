package com.atif.jsppractice.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@lombok.Data
public class Prac {
	List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
	Map<String, String> maps = new HashMap<String, String>();

}
