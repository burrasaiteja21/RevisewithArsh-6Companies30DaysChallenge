//leetcode link: https://leetcode.com/problems/random-flip-matrix/

class Solution {
    int m;
    int n;
    int val;
    Map<Integer,Integer> ma=new HashMap<>();
    public Solution(int m, int n)
    {
        this.m=m;
        this.n=n;
        val=m*n;
        ma=new HashMap<>();
    }
    public int[] flip()
    {
        Random red=new Random();
        int r=red.nextInt(val--);
        int x = ma.getOrDefault(r, r);
        ma.put(r, ma.getOrDefault(val,val));
        return new int[]{x / n, x % n};
    }
    public void reset()
    {
        val=m*n;
        ma.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */

//explanation
//Let's break down the key components of the code:
//
//        1) Class Variables:
//
//        m and n: The dimensions of the grid.
//        val: The total number of cells in the grid (m * n).
//        ma: A map to keep track of the mapping between the original indices and the current indices of the cells that have been flipped.
//        2) Constructor:
//
//        The constructor initializes the dimensions of the grid (m and n), sets the total number of cells (val), and initializes an empty map (ma).
//        3) flip Method:
//
//        The flip method generates a random index r in the range [0, val - 1].
//        It then uses the map ma to get the current index x corresponding to the random index r. If x is not present in the map, it uses r as the current index.
//        The method updates the map entry for r by replacing it with the current value of val - 1. It then decrements val.
//        The original index x is converted to grid coordinates (x / n and x % n), and these coordinates are returned.
//        4) reset Method:
//
//        The reset method resets the total number of cells (val) to the original value (m * n) and clears the map (ma).
//        Explanation:
//
//Explanation:
//        The flip method effectively simulates the process of randomly selecting an unrevealed cell in the grid and returns its coordinates. It ensures that each cell is flipped exactly once.
//        The reset method resets the grid, making all cells unrevealed again.
//        Time Complexity:
//
//        The time complexity of both the flip and reset methods is considered O(1) on average. This is because the random number generation and map operations are constant time or close to constant time on average.