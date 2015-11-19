package com.doubleia.alg.string;

/**
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * "/home/", => "/home"
 * "/a/./b/../../c/", => "/c"
 * 
 * Challenge
 * 
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * 
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * @author wangyingbo
 *
 */
public class SimplifyPath {
    /**
     * @param path the original path
     * @return the simplified path
     */
	public String simplifyPath(String path) {
		// Write your code here
		if (path.length() == 0)
			return path; 
		String[] spilts = path.split("/+");
		String abs = "";
		for (int i = 1; i < spilts.length; i++) {
			switch (spilts[i]) {
			case "..":
				if (i != 1 && abs.lastIndexOf("/") != -1)
					abs = abs.substring(0, abs.lastIndexOf("/"));
				break;
			case ".":
				break;
			default:
				abs += "/";
				abs += spilts[i];
				break;
			}
		}
		if (abs.equals(""))
			return "/";
		return abs;
	}
	
	public static void main(String[] args) {
		SimplifyPath sim = new SimplifyPath();
		System.out.println(sim.simplifyPath("/home//foo/"));
	}
}
