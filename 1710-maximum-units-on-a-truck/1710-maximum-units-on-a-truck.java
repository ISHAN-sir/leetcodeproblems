
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int sum = 0;

        for (int i = 0; i < boxTypes.length; i++) {

            int boxes = boxTypes[i][0];
              int box = boxTypes[i][1];
              int min = Math.min(boxes,truckSize);
              truckSize -=min;

            sum += min * box;

            if (truckSize == 0) {
                return sum;
            }
        }
        return sum;
    }
}
