class Solution {
    HashSet<String> set;
    HashMap<Integer, Boolean> memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        memo = new HashMap<>();
        for (String word : wordDict) {
            set.add(word);
        }
        return backtrack(0, s);
    }

    public boolean backtrack(int start, String s) {
        if (start >= s.length()) {
            return true;
        }
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (set.contains(s.substring(start, i))) {
                if (backtrack(i, s)) {
                    memo.put(start, true);
                    return true;
                }
            }
        }
        memo.put(start, false);
        return false;
    }
}
