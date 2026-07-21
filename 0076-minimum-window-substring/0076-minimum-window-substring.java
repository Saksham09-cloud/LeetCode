class Solution {

    private int[] have = new int[256];
    private int[] need = new int[256];

    private boolean isCorrect(int[] have, int[] need) {
        for (int i = 0; i < 256; i++) {
            if (have[i] < need[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {

        // Store the required characters from t
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        int low = 0;
        int start = 0;
        int res = Integer.MAX_VALUE;

        for (int high = 0; high < s.length(); high++) {

            char ch = s.charAt(high);
            have[ch]++;

            while (isCorrect(have, need)) {

                int len = high - low + 1;

                if (len < res) {
                    res = len;
                    start = low;
                }

                // Remove the leftmost character
                have[s.charAt(low)]--;

                low++;
            }
        }

        if (res == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + res);
    }
}