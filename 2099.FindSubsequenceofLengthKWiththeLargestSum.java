//leetcode link:https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pue=new PriorityQueue<>();
        List<Integer> tosto=new ArrayList<>();
        for(int x:nums){
            pue.add(x);
            tosto.add(x);
        }

        int[] ans=new int[k];

        for(int i=0;i<nums.length-k;i++)
            tosto.remove(pue.remove());

        for(int i=0;i<k;i++)
            ans[i]=tosto.get(i);

        return ans;
    }
}