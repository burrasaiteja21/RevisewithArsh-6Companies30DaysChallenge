//leetcode link:https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/
class Solution {
    int[][] dp;
    public int numberOfWays(int startPos, int endPos, int k)
    {
        dp=new int[4001][1001];
        for(int[] ar:dp)
        {
            Arrays.fill(ar,-1);
        }
        return numways(startPos,endPos,k);

    }
    public int numways(int start,int end,int k)
    {
        if(start==end && k==0)
        {
            return 1;
        }
        if(k== 0 && start!=end)
        {
            return 0;
        }
        if(dp[start+2001][k]!=-1)
        {
            return dp[start+2001][k];
        }
        int take=numways(start-1,end,k-1);
        int notake=numways(start+1,end,k-1);
        dp[start+2001][k]=(take+notake)%1000000007;
        return dp[start+2001][k];
    }
}