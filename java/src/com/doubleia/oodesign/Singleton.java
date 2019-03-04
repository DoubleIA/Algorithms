package com.doubleia.oodesign;

/**
 * 
 * Singleton is a most widely used design pattern. If a class has and only has one instance at every moment, 
 * we call this design as singleton. For example, for class Mouse (not a animal mouse), we should design it in singleton.
 * 
 * You job is to implement a getInstance method for given class, return the same instance of this class every time you call this method.
 * 
 * A a = A.getInstance();
 * A b = A.getInstance();
 * 
 * a should equal to b.
 * 
 * If we call getInstance concurrently, can you make sure your code could run correctly?
 * 
 * @author wangyingbo
 *
 */
public class Singleton {
	private static Singleton instance;
	
	private Singleton() {}
	
	/**
	 * @return: The same instance of this class every time
	 */
	public static Singleton getInstance() {
		// write your code here
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
