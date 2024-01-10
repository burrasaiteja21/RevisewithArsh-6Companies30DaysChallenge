//leetcode link:https://leetcode.com/problems/k-divisible-elements-subarrays/
//2261. K Divisible Elements Subarrays

class Solution {
    public int countDistinct(int[] nums, int k, int p)
    {
        int n=nums.length;

        Set<String> se=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            int count=0;
            StringBuilder str=new StringBuilder();
            for(int j=i;j<n;j++)
            {
                if(nums[j]%p==0)
                {
                    count++;
                }
                if(count>k)
                {
                    break;
                }
                str.append(nums[j] + ",");
                se.add(str.toString());

            }
        }
        return se.size();
    }

}