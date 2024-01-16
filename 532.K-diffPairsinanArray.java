//leetcode link:https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
class Solution {
    public int findPairs(int[] nums, int k)
    {
        Arrays.sort(nums);
        int i=0, j=1, diff=0, n=nums.length, sum=Integer.MIN_VALUE;
        int count=0;
        while(j<n && i<n-1){

            if(nums[j]-nums[i]==k && (nums[i]+nums[j])!=sum){
                sum=nums[i]+nums[j];
                i++; j++; count++;
            }

            else if((nums[j]-nums[i])<k){
                j++;
            }

            else{
                i++;
            }

            if(i==j) j++;
        }
        return count;
    }
}
//          HashSet<Integer> se=new HashSet<>();
//          int n=nums.length;
//          int i=0;
//          se.add(nums[i]);
//          int j=i+1;
//          int count=0;
//          while(j<n)
//          {
//              int dif=Math.abs(nums[j]-nums[i]);
//              if(dif==k && !se.contains(nums[j]))
//              {
//                  se.add(nums[j]);
//                  count++;
//                  i++;

//              }
//              else if(se.contains(nums[j]))
//              {
//                count++;
//              }
//              j++;

//          }
//      return count;
//     }
// }


//         int coun=0;

//         HashSet<Integer> se=new HashSet<>();
//         for(int i=0;i<nums.length;i++)
//         {
//             se.add(nums[i]);
//             if(nums[i]==1 && k==0)
//             {
//                 coun=1;
//                 break;
//             }
//         }
//         if(coun!=0 && k==0)
//         {
//             return coun;
//         }
//         int count=0;
//         for(int i=0;i<nums.length;i++)
//         {
//             int temp=nums[i]-k;
//             if(se.contains(temp))
//             {
//                 count++;
//             }
//         }

//         return count;


//     }
// }