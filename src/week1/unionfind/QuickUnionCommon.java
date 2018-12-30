package week1.unionfind;

import java.util.Arrays;

//tree approach
public class QuickUnionCommon {
    public int[] id;

    public QuickUnionCommon(int N) {
        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    //move the parent pointer up to the root
    protected int root(int node){
        while(node != id[node]){
            node = id[node];
        }
        return node;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int pRoot = root(p);
        int qRoot = root(q);
        id[pRoot] = qRoot;
    }

    //quick-union(lazy approach)
    //better than QF but still slow
    //worst case - N for find, because of a tall trees
    public static void main(String[] args) {
        QuickUnionCommon quickUnionCommon = new QuickUnionCommon(10);
        quickUnionCommon.union(4, 3);
        quickUnionCommon.union(3, 8);
        quickUnionCommon.union(6, 5);
        quickUnionCommon.union(9, 4);
        quickUnionCommon.union(2, 1);
        System.out.println(quickUnionCommon.connected(8, 9));
        System.out.println(quickUnionCommon.connected(5, 0));
        quickUnionCommon.union(5, 0);
        quickUnionCommon.union(7, 2);
        quickUnionCommon.union(6, 1);
        quickUnionCommon.union(7, 3);
        System.out.println(Arrays.toString(quickUnionCommon.id));
    }
}
