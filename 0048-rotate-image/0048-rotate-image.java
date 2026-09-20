class Solution {
    public void rotate(int[][] arr) {
        int n = arr.length;
        //int m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j =i;j<n;j++){
             int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
            }
        }
         for (int i = 0; i < n; i++) {
              int a = 0, b = n - 1;
                while (a < b) {
        int temp = arr[i][a];
        arr[i][a] = arr[i][b];
        arr[i][b] = temp;

        a++;
        b--;
    }
}
    }
}