package com.lyj.lazyloading.threadnosafe;

/**
 * 线程不安全的懒汉式单例模式
 * @author Ja0ck5
 *
 */
public class Singleton {
	//未实例化，则懒汉式
	private static Singleton singleton;
	
	private Singleton(){}
	
	public static Singleton getInstance(){
		if(null == singleton)
			singleton = new Singleton();
		return singleton;
	}
	
}
