class Solution {
    public int[][] imageSmoother(int[][] img) {

        int[][] newImg = new int[img.length][img[0].length];

        for (int i = 0; i < img.length; i++ ) {
            for (int j = 0; j < img[0].length; j++ ) {
                newImg[i][j] = getAverage(img, new int[]{i,j});
            }
        }

        return newImg;
        
    }
    public int getAverage (int[][] img, int[] index) {
        int sum = 0;
        int totalEncountered = 0;

        int[][] directions = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}};

        for (int[] direction : directions) {
            int i = index[0] + direction[0];
            int j = index[1] + direction[1];

            if (i >= 0 && i < img.length && j >= 0 && j < img[0].length) {
                sum += img[i][j];
                totalEncountered++;
            }
        }

        return sum / totalEncountered;
    }
}