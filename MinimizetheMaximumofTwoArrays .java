//leetcode link: https://leetcode.com/problems/minimize-the-maximum-of-two-arrays/description/
class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2)
    {
        long left = uniqueCnt1 + uniqueCnt2, right = Integer.MAX_VALUE;
        long g = lcm(divisor1 , divisor2);

        long res = Integer.MAX_VALUE;
        while (left <= right) {
            long mid =  (left + right) / 2;

            boolean x = (mid - mid / divisor1) >= uniqueCnt1;
            boolean y = (mid - mid / divisor2) >= uniqueCnt2;
            boolean z = (mid - mid / g) >= uniqueCnt1 + uniqueCnt2;

            if (x && y && z){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return (int)res;
    }

    private long lcm(int a, int b) {
        return 1l * a * b / gcd(a, b);
    }
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b,a % b);
    }
}
//         int[] arr=new int[uniqueCnt1];
//         int[] arr1=new int[uniqueCnt2];
//         Map<Integer,Integer> ma=new HashMap<>();
//         int j=0;
//         int max1=Integer.MIN_VALUE;
//         int max2=Integer.MIN_VALUE;
//         if(uniqueCnt1>=divisor1)
//         {
//             for(int i=1;i<=uniqueCnt1*divisor1;i++)
//             {
//               if(i%divisor1!=0 && j<uniqueCnt1)
//               {
//                   arr[j++]=i;
//                   max1=Math.max(max1,i);
//                   ma.put(i,ma.getOrDefault(i,0)+1);
//               }
//             }
//         }
//         else
//         {
//            for(int i=1;i<=divisor1;i++)
//            {
//                if(i%divisor1!=0 && j<uniqueCnt1)
//                {
//                     arr[j++]=i;
//                     max1=Math.max(max1,i);
//                   ma.put(i,ma.getOrDefault(i,0)+1);
//                }

//            }

//         }
//         int k=0;
//         if(uniqueCnt2>=divisor2)
//         {
//             for(int i=1;i<=uniqueCnt2*divisor2;i++)
//             {
//                 if(i%divisor2!=0)
//                 {
//                     if(!ma.containsKey(i%divisor2) && k<uniqueCnt2)
//                     {
//                         max2=Math.max(max2,i);
//                        arr1[k++]=i;
//                     }

//                 }
//             }

//         }
//         else
//         {
//             for(int i=1;i<=divisor2;i++)
//             {
//                 if(i%divisor2!=0)
//                 {
//                     if(!ma.containsKey(i%divisor2) && k<uniqueCnt2)
//                     {
//                        max2=Math.max(max2,i);
//                        arr1[k++]=i;
//                     }

//                 }
//             }

//         }
//         int finmax=Math.max(max1,max2);

//         return finmax;

//     }
// }