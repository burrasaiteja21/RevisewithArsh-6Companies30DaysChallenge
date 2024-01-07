/*time complexity:O(n^2)
space complexity:O(1)
class main
{
public static int[] findTwoElement(int arr[], int n)
    {
        int[] a=new int[2];
        int k=0;
        int missing=-1;
        int rep=-1;
        for(int i=1;i<=n;i++)
        {
            int flag=0;
            for(int j=0;j<arr.length;j++)
            {
                if(arr[j]==i)
                {
                    flag++;
                }

            }
            if(flag==0)
            {
                missing=i;
            }
            else if(flag==2)
            {
                rep=i;
            }
            if(missing !=-1 && rep!=-1)
            {
                break;
            }
        }
        a[k++]=rep;
        a[k++]=missing;
        return a;
   }
}
*/

//gfg link:https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
class Solve {
    int[] findTwoElement(int arr[], int n) {
        int[] has = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            has[arr[i]]++;
        }
        int missingvalue = 0;
        int repeted = 0;
        for (int i = 1; i <= arr.length; i++) {
            if (has[i] == 0) {
                missingvalue = i;
            } else if (has[i] == 2) {
                repeted = i;
            }
        }
        int[] ar = new int[2];
        ar[0] = repeted;
        ar[1] = missingvalue;
        return ar;
    }
}