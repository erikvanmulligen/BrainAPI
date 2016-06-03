package com.euretos.brain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUMap<K, V> extends LinkedHashMap<K, V> {      

	private static final long serialVersionUID = 1L;
	private int maxCapacity;       
	
	public LRUMap(int maxCapacity){             
		super();             
		this.maxCapacity = maxCapacity;       
	}       
	
	@Override  protected boolean removeEldestEntry( Map.Entry<K, V> eldest ){             
		return size() >= this.maxCapacity;       
	} 
}
