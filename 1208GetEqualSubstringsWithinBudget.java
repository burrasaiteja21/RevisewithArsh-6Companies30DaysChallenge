//leetcode link:https://leetcode.com/problems/get-equal-substrings-within-budget/
class Solution {
    public int equalSubstring(String s, String t, int maxCost)
    {
       int n=s.length();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            int l=s.charAt(i);
            int k=t.charAt(i);
            arr[i]=Math.abs(l-k);
        }
        int sum=0;
        int count=0;
        int start=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            while(sum>maxCost)
            {
                sum-=arr[start];
                ++start;
            }
            count=Math.max(count,i-start+1);
        }
        return count;
    }
}