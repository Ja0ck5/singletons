package com.lyj.enumsingleton;

/**
 * Effective Java 作者 Josh Bloch 提倡的方式
 * 它不仅能避免多线程同步问题
 * 而且还自动支持序列化机制
 * 防止反序列化重新创建新的对象，绝对防止多次实例化。
 * 
 * 不能通过 reflection attack 来调用私有构造方法。
 * @author Ja0ck5
 *
 */
public enum Singleton {  
    INSTANCE;
}  
