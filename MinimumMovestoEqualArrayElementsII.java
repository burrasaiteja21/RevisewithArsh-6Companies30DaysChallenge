//462. Minimum Moves to Equal Array Elements II
//leetcode link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
class Solution {
    public int minMoves2(int[] nums)
    {
         Arrays.sort(nums);
        int minMoves = 0;
        int n = nums.length;
        int medianIndex = n / 2;
        int median = nums[medianIndex];

        for (int i = 0; i < n; i++) {
            minMoves += Math.abs(nums[i] - median);
        }

        return minMoves;
    }
}