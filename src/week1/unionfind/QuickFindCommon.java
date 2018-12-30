package week1.unionfind;

import java.util.Arrays;

//the simplest approach
public class QuickFindCommon {

    private int[] N;

    public QuickFindCommon(int n) {
        N = new int[n];
        for (int i = 0; i < n; i++) {
            N[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return N[p] == N[q];
    }

    public void union(int p, int q) {
        int pid = N[p];
        int qid = N[q];

        for (int i = 0; i < N.length; i++) {
            if (N[i] == pid) {
                N[i] = qid;
            }
        }
    }

    //quick-find(eager approach)
    //N2
    //They're either connected or not then that will take quadratic time in squared time.
    //The reason is they don't scale
    public static void main(String[] args) {
        QuickFindCommon quickFindCommon = new QuickFindCommon(10);
        quickFindCommon.union(4, 3);
//        System.out.println(Arrays.toString(quickFindCommon.N));
        quickFindCommon.union(3, 8);
        quickFindCommon.union(6, 5);
        quickFindCommon.union(9, 4);
        quickFindCommon.union(2, 1);
        System.out.println(quickFindCommon.connected(8, 9));
        System.out.println(quickFindCommon.connected(5, 0));
        quickFindCommon.union(5, 0);
        quickFindCommon.union(7, 2);
        quickFindCommon.union(6, 1);
        System.out.println(Arrays.toString(quickFindCommon.N));

    }
}
