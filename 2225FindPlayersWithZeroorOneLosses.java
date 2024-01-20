//leetcode link:https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/

class Solution {
    public List<List<Integer>> findWinners(int[][] matches)
    {
        List<List<Integer>> arr = new ArrayList<>();
        Map<Integer, Integer> win = new HashMap<>();
        Map<Integer, Integer> lost = new HashMap<>();

        for (int i = 0; i < matches.length; i++) {
            win.put(matches[i][0], win.getOrDefault(matches[i][0], 0) + 1);
            lost.put(matches[i][1], lost.getOrDefault(matches[i][1], 0) + 1);
        }

        Set<Integer> wi = new HashSet<>();
        Set<Integer> lo = new HashSet<>();

        for (int i = 0; i < matches.length; i++) {
            int w = matches[i][0];
            int l = matches[i][1];
            if (!lost.containsKey(w)) {
                wi.add(w);
            }
            if (lost.containsKey(l) && lost.get(l) == 1) {
                lo.add(l);
            }
        }

        List<Integer> winners = new ArrayList<>(wi);
        List<Integer> losers = new ArrayList<>(lo);
        Collections.sort(winners);
        Collections.sort(losers);
        arr.add(winners);
        arr.add(losers);
        return arr;
    }
}