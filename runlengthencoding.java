//gfg link:https://www.geeksforgeeks.org/problems/run-length-encoding/1
class solve
{
	String encode(String str)
	{
	   if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder st = new StringBuilder();
        char ch = str.charAt(0);
        int count = 1;
       for(int i = 1; i < str.length(); i++)
       {
           if(ch == str.charAt(i))
           {
               count++;
           }
           else
           {
               st.append(ch);
               st.append((char) (count + '0'));
               ch=str.charAt(i);
               count=1;
           }
       }
       st.append(ch);
       st.append((char) (count + '0'));


     return st.toString();
	}

 }