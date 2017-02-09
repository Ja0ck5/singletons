package com.lyj.doublecheck;

/**
 * 双层检查
 * @author Ja0ck5
 *
 */
public class DoubleCheckSingleton {
	
	//未实例化，懒汉
	private static DoubleCheckSingleton dcs;
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
