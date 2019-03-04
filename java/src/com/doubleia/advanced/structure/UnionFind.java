package com.doubleia.advanced.structure;

/**
 * 
 * @author wangyingbo 
 * 
 */
public class UnionFind {
	 // http://blog.csdn.net/dm_vincent/article/details/7655764
    int count = 0;
    int[] id = null;
    int[] size = null;

    public UnionFind(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
        count = n;
    }
    //version 4: weighted quick union with path compression, find & union, very close to O(1)
    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
    public void union(int p, int q) { //same with version 3
        int pRoot = find(p), qRoot = find(q);
        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count--;
    }
    //version 3: weighted quick union, find & union, O(logn)
    public int find3(int p) { // same with version 2
        while (p != id[p]) p = id[p];
        return p;
    }
    public void union3(int p, int q) {
        int pRoot = find(p), qRoot = find(q);
        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count--;
    }
    // version 2: quick union, find & union, O(tree height)
    public int find2(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }
    public void union2(int p, int q) {
        int pRoot = find(p), qRoot = find(q);
        id[pRoot] = qRoot;
        count--;
    }
    // version 1: quick find, find O(1), union O(n)
    public int find1(int p) {
        return id[p];
    }
    public void union1(int p, int q) {
        int pId = find(p), qId = find(q);// 特别注意进入循环先保存原始值，循环过程id[p]会被更改
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId)
                id[i] = qId;
        }
        count--;
    }

}
