class Solution {
    public int[] findOriginalArray(int[] changed) {

        int n = changed.length;

        if (n % 2 != 0) {
            return new int[0];
        }

        Arrays.sort(changed);

        HashMap<Integer, Integer> map = new HashMap<>();

        // Frequency of every number
        for (int num : changed) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[n / 2];
        int index = 0;

        for (int num : changed) {

            // This number has already been used
            if (map.get(num) == 0) {
                continue;
            }

            // Special case for 0
            if (num == 0) {

                if (map.get(0) < 2) {
                    return new int[0];
                }

                result[index++] = 0;

                map.put(0, map.get(0) - 2);
            }

            else {

                int twice = num * 2;

                if (map.getOrDefault(twice, 0) == 0) {
                    return new int[0];
                }

                result[index++] = num;

                map.put(num, map.get(num) - 1);
                map.put(twice, map.get(twice) - 1);
            }
        }

        return result;
    }
}