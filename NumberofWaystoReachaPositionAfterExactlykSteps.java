//leetcode link:https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/
class Solution {
     public int numberOfWays(int startPos, int endPos, int k)
    {

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
         int take=numways(start-1,end,k-1);
        int notake=numways(start+1,end,k-1);
        return (take+notake)%1000000007;

    }
}