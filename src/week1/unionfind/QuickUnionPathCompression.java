package week1.unionfind;

//2nd improvement
//path compression. when performing internal root find operation - halving path by referring to grandparent node
//log*N (iterated logarithm) - number of times the logarithm function must be iteratively applied before the result is less than or equal to 1.
//in practical - less then 5, because 2^65536 is 5.
//no linear algorithm, but iterated logarithm is almost linear, and almost the best solution
public class QuickUnionPathCompression extends QuickUnionWeighted {
    public QuickUnionPathCompression(int N) {
        super(N);
    }

    @Override
    protected int root(int node) {
        while (node != id[node]){
            id[node] = id[id[node]];
            node = id[node];
        }
        return node;
    }
}
