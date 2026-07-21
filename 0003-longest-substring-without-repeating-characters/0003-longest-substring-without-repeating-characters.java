class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> f = new HashMap<>();

        int low = 0;
        int res = 0;

        for (int high = 0; high < s.length(); high++) {

            char ch = s.charAt(high);

            f.put(ch, f.getOrDefault(ch, 0) + 1);

            while (f.size() < high - low + 1) {

                char leftChar = s.charAt(low);

                f.put(leftChar, f.get(leftChar) - 1);

                if (f.get(leftChar) == 0) {
                    f.remove(leftChar);
                }

                low++;
            }

            int len = high - low + 1;
            res = Math.max(res, len);
        }

        return res;
    }
}