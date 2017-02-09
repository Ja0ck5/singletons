package com.lyj.lazyloading.threadsafe;

public class Singleton {
	
	private static Singleton singleton;
	
	private Singleton(){};
	
	/**
	 * 增加 synchronized 
	 * @return
	 */
	public static synchronized Singleton getInstance(){
		if(null == singleton)
			singleton = new Singleton();
		return singleton;
	}

}
