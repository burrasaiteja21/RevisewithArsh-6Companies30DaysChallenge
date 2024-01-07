//leetcode link:https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/
class Solution {
    public int incremovableSubarrayCount(int[] nums)
    {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(checkincremovablearray(nums,i,j))
                {
                    count++;
                }
            }
        }

        return count;
    }
    public boolean checkincremovablearray(int[] num,int start,int end)
    {
        int len=num.length;
        int prev=0;
        for(int i=0;i<len;i++)
        {
            if(i >= start && i <= end)
            {
                continue;
            }
            if(num[i] <= prev)
            {
                return false;
            }
            prev=num[i];
        }
        return true;
    }
}

