package week1.unionfind;

import java.util.Arrays;

//1st QU improvement
//weighted union - less tree to bigger tree
//this will improve performance to logN for 'union'(if including cost of finding the roots), and logN for 'connected'
public class QuickUnionWeighted extends QuickUnionCommon {

    protected int[] size;

    public QuickUnionWeighted(int N) {
        super(N);
        size = new int[N];
        for (int i = 0; i < size.length; i++) {
            size[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (qRoot == pRoot) {
            return;
        }

        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }

    public static void main(String[] args) {
        QuickUnionWeighted quickUnionWeighted = new QuickUnionWeighted(10);
        quickUnionWeighted.union(4, 3);
        quickUnionWeighted.union(3, 8);
        quickUnionWeighted.union(6, 5);
        quickUnionWeighted.union(9, 4);
        quickUnionWeighted.union(2, 1);
        System.out.println(quickUnionWeighted.connected(8, 9));
        System.out.println(quickUnionWeighted.connected(5, 0));
        quickUnionWeighted.union(5, 0);
        quickUnionWeighted.union(7, 2);
        quickUnionWeighted.union(6, 1);
        quickUnionWeighted.union(7, 3);
        System.out.println(Arrays.toString(quickUnionWeighted.id));
    }
}
