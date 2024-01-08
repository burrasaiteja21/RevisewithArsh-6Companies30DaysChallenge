class Solution {
    public int numberOfSubarrays(int[] nums, int k)
    {
        for(int i=0; i<nums.length; i++) nums[i]=(nums[i]%2==0)? 0 : 1;
        Map<Integer,Integer> map = new HashMap<>();
        int prefSum = 0, result = 0;
        for(int i=0; i<nums.length; i++)
        {
            map.put(prefSum,map.getOrDefault(prefSum,0)+1);
            prefSum += nums[i];
            if(map.containsKey(prefSum-k)) result += map.get(prefSum-k);
        }
        return result;
    }
}

//    Time limit exceeded
//         int n=nums.length;
//         int start=0;
//         int end=0;
//         int totalnice=0;

//         for(int i=0;i<n;i++)
//         {
//             int j=i;
//             int oddcount=0;
//             while(j<n)
//             {
//                 if(nums[j]%2!=0)
//                 {
//                     oddcount++;

//                 }
//                 if(oddcount==k)
//                 {
//                     totalnice++;
//                 }
//                 j++;
//             }
//         }

//         return totalnice;


//     }
// }