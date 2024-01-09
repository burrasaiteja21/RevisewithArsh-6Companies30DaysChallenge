// 2933. High-Access Employees
//https://leetcode.com/problems/high-access-employees/
//import java.time.LocalTime;
//import java.time.temporal.ChronoUnit;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access)
    {
        Map<String,List<Integer>>  ma= new HashMap<>();
        int n = access.size();

        for(List<String> a:access)
        {
            if(!ma.containsKey(a.get(0)))
            {
                ma.put(a.get(0),new ArrayList<>());
            }
            char[] s=a.get(1).toCharArray();
            int h=(s[0]-'0')*10+s[1]-'0';
            int m=(s[2]-'0')*10+s[3]-'0';
            ma.get(a.get(0)).add(h*60+m);

        }
        List<String> ans = new ArrayList<>();
        for(String key: ma.keySet())
        {
            List<Integer> val = ma.get(key);
            Collections.sort(val);
            for(int i=0;i<val.size()-2;i++)
            {
                if(val.get(i+2)-val.get(i)<=59)
                {
                    ans.add(key);
                    break;
                }
            }
        }
        return ans;
    }
}
//        List<String> highAccessEmployees = new ArrayList<>();
//         Map<String, Integer> accessCountMap = new HashMap<>();
//         int n = access.size();

//         for (int i = 0; i < n; i++) {
//             if (!access.get(i).get(0).equals("0")) {
//                 String employeeId = access.get(i).get(0);

//                 for (int j = i + 1; j < n; j++) {
//                     if (employeeId.equals(access.get(j).get(0))) {
//                         // Extracting hours and minutes from the access records
//                         int hrOne = Integer.parseInt(access.get(i).get(1).substring(0, 2));
//                         int minOne = Integer.parseInt(access.get(i).get(1).substring(2));

//                         int hrTwo = Integer.parseInt(access.get(j).get(1).substring(0, 2));
//                         int minTwo = Integer.parseInt(access.get(j).get(1).substring(2));

//                         // Calculating the time difference between two access records
//                         LocalTime time1 = LocalTime.of(hrOne, minOne);
//                         LocalTime time2 = LocalTime.of(hrTwo, minTwo);
//                         long hours = ChronoUnit.HOURS.between(time1, time2);
//                         long minutesDifference = ChronoUnit.MINUTES.between(time1, time2);

//                         // Checking if the time difference is within the specified range (e.g., 0 to 60 minutes)
//                         if (minutesDifference >= 0 && minutesDifference <= 60) {
//                             accessCountMap.put(employeeId, accessCountMap.getOrDefault(employeeId, 0) + 1);
//                         }
//                     }
//                     access.get(j).set(0, "0"); // Mark the accessed record as processed
//                 }
//             }
//         }

//         // Extracting employee IDs with high access counts
//         for (Map.Entry<String, Integer> entry : accessCountMap.entrySet()) {
//             if (entry.getValue() > 3) {
//                 highAccessEmployees.add(entry.getKey());
//             }
//         }

//         return highAccessEmployees;
//     }
// }
