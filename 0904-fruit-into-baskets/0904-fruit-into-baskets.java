
class Solution {
    public int totalFruit(int[] fruits) {

        int low = 0;
        int res = 0;

        HashMap<Integer, Integer> f = new HashMap<>();

        for (int high = 0; high < fruits.length; high++) {

            // Add current fruit to the window
            f.put(fruits[high], f.getOrDefault(fruits[high], 0) + 1);

            // More than 2 types of fruits
            while (f.size() > 2) {

                f.put(fruits[low], f.get(fruits[low]) - 1);

                if (f.get(fruits[low]) == 0) {
                    f.remove(fruits[low]);
                }

                low++;
            }

            // Maximum valid window
            int len = high -low + 1;
            res = Math.max(res, len);
        }

        return res;
    
    }
}