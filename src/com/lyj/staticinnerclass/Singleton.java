package com.lyj.staticinnerclass;

/**
 * 静态内部类的形式实现单例模式
 * 在多线程中经常使用的一种
 * 线程安全的
 * 解决 方案
 * 
 * 也称作    登记式
 * 
 * 因为 SingletonHolder 类没有被主动使用
 * 只有显示通过调用 getInstance 方法时
 * 才会显示装载 SingletonHolder 类
 * 从而实例化 instance
 * 
 * @author Ja0ck5
 *
 */
public class Singleton {
	
	private static class SingletonHolder{
		private static final Singleton SINGLETON = new Singleton();
	}
	
    private Singleton(){}
    
	public static Singleton getInstance(){
		return SingletonHolder.SINGLETON;
	}
}
