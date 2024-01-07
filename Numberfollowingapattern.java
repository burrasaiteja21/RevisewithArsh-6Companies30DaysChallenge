//gfg link:https://www.geeksforgeeks.org/problems/number-following-a-pattern3126/1
//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S)
    {
        Stack<Integer> stk=new Stack<>();
        int dig=0;
        StringBuilder st=new StringBuilder();
        for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i)=='I')
            {
                dig++;
                stk.push(dig);
                while(!stk.isEmpty())
                {
                    st.append(stk.pop());

                }
            }
            else
            {
                dig++;
                stk.push(dig);
            }
        }
        dig++;
        stk.push(dig);
        while(!stk.isEmpty())
        {
            st.append(stk.pop());

        }

        return st.toString();
    }
}
//         Map<Character,Integer> ma=new HashMap<>();
//         ma.put('I',1);
//         ma.put('D',2);
//         int n=S.length();
//         char la=' ';
//         StringBuilder str=new StringBuilder();
//         for(int i=0;i<S.length();i++)
//         {
//             char ch=S.charAt(i);
//             if(ch=='I')
//             {
//                 str.append(ma.get('I'));
//                 ma.put('I',ma.getOrDefault('I',0)+1);
//             }
//             else if(ch=='D')
//             {
//                 int m=ma.get('D');
//                 if(m==2)
//                 {
//                     int k=m+n-1;
//                     str.append(k);
//                     k--;
//                     ma.put('D',k);
//                 }
//                 else
//                 {

//                     str.append(m);
//                     m--;
//                     ma.put('D',m);


//                 }


//             }
//             if(i==n-1)
//             {
//                 la=S.charAt(i);
//             }
//         }
//         str.append(ma.get(la));

//         return str.toString();
//         // code here
//     }
// }
