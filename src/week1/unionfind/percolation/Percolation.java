package week1.unionfind.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    //TODO: consider two dimensional array
//    int[] id;
    int side;
//    int numberOfOpenSites = 0;

    WeightedQuickUnionUF weightedQuickUnionUF;

    /**
     * Create n-by-n grid, with all sites blocked
     *
     * @param n grid side size
     */
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        weightedQuickUnionUF = new WeightedQuickUnionUF(n * n);
        side = n;
    }

    /**
     * Open site (row, col) if it is not open already
     *
     * @param row number of row in site address
     * @param col number of col in site address
     */
    public void open(int row, int col) {
        checkInputRowsAndColumns(row, col);

        if (isOpen(row, col)) {
            return;
        }


        //TODO implement
    }

    /**
     * Is site (row, col) open?
     *
     * @param row number of row in site address
     * @param col number of col in site address
     * @return true if site is open, false if closed
     */
    public boolean isOpen(int row, int col) {
        checkInputRowsAndColumns(row, col);

        return !(id[from2dTo1dArray(row, col)] == 0);

        //TODO implement
//        return false;
    }

    private int from2dTo1dArray(int row, int col) {
        return side * (row - 1) + (col - 1);
    }

    private int getRowFrom1dArray(int id) {
        return (id / side) + 1;
    }

    private int getColFrom1dArray(int id) {
        return (id % side) + 1;
    }

    /**
     * Is site (row, col) full?
     *
     * @param row number of row in site address
     * @param col number of col in site address
     * @return true if site is full, false if closed
     */
    public boolean isFull(int row, int col) {
        checkInputRowsAndColumns(row, col);

        //TODO implement
        return true;
    }

    private void checkInputRowsAndColumns(int row, int col) {
        if (row < 1 || row > side
                || col < 1 || col > side) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Number of open sites
     *
     * @return number of sites that are opened
     */
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    /**
     * Does the system percolate?
     *
     * @return true when there are route of open sites from top row to bottom, otherwise - false
     */
    public boolean percolates() {
        //TODO implement
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        Percolation percolation = new Percolation(n);

        System.out.println(percolation.from2dTo1dArray(5, 4));
        System.out.println(percolation.getColFrom1dArray(23));
        System.out.println(percolation.getRowFrom1dArray(23));

//        while(!percolation.percolates()){
//            int row = StdRandom.uniform(n);
//            int col = StdRandom.uniform(n);
//            System.out.println("row:" + row + "|col:" + col);
//        }
    }
}
