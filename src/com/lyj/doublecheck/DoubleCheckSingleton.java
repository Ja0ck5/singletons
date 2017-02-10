package com.lyj.doublecheck;

/**
 * 双层检查
 * 
 *  Singleton 构造函数体执行之前，变量 instance 可能成为非 null 的，
 *  即赋值语句在对象实例化之前调用，此时别的线程得到的是一个还会初始化的对象，这样会导致系统崩溃。
 *  1、线程 1 进入 getInstance() 方法。
 *  2、由于 instance 为 null，线程 1 在 //1 处进入 synchronized 块。 
 *  3、线程 1 前进到 //3 处，但在构造函数执行之前，使实例成为非 null。 
 *  4、线程 1 被线程 2 预占。
 *  5、线程 2 检查实例是否为 null。因为实例不为 null，
 *  线程 2 将 instance 引用返回给一个构造完整但部分初始化了的 Singleton 对象。 
 *  6、线程 2 被线程 1 预占。
 *  7、线程 1 通过运行 Singleton 对象的构造函数并将引用返回给它，来完成对该对象的初始化。
 *  
 *  
 *  无序写入
 *  
 *  jdk5 之后使用 volatile 关键字就可以解决
 * @author Ja0ck5
 */
public class DoubleCheckSingleton {
	
	//未实例化，懒汉
	//同步块外面的if (instance == null)可能看到已存在，但不完整的实例 所以要使用 volatile
	private static volatile DoubleCheckSingleton dcs;
	//私有化构造方法
	private DoubleCheckSingleton(){}
	
	public static DoubleCheckSingleton getDcs(){
		if(null == dcs){
			synchronized (DoubleCheckSingleton.class) {
				//再次判断
				if(null == dcs)
					dcs = new DoubleCheckSingleton();
			}
		}
		return dcs;
	}
	
}
