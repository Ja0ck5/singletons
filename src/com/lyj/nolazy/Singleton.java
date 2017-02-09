package com.lyj.nolazy;

/**
 * 类加载时就初始化，浪费内存
 * 基于 classloder 机制避免了多线程的同步问题
 * @author Ja0ck5
 *
 */
public class Singleton {
	
	private static Singleton singleton = new Singleton();
	
	private Singleton(){};
	
	public static Singleton getInstance(){
		return singleton;
	}
	
}
