class Solution
{
    public int findLength(int[] nums1, int[] nums2)
    {
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        int ans=0;
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(nums1[i-1]==nums2[j-1])
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;

    }
}



/*
class Solution {
    public int findLength(int[] nums1, int[] nums2)
    {
        /*
        if(nums1.length==0 && nums2.length>0)
        {
            return nums2.length;

        }
        if(nums2.length==0 && nums1.length>0)
        {
            return nums1.length;
        }
        //////
        ArrayList<ArrayList<Integer>> ans1=new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans2=new ArrayList<>();
       ArrayList<Integer> ds1=new ArrayList<>();
       ArrayList<Integer> ds2=new ArrayList<>();
       for(int i=0;i<nums1.length;i++)
       {
           for(int j=i;j<nums1.length;j++)
           {
               ds1.add(nums1[j]);
               ds2.add(nums2[j]);
               ans1.add(new ArrayList<>(ds1));
               ans2.add(new ArrayList<>(ds2));

           }
       }

        return 0;
    }
}
*/