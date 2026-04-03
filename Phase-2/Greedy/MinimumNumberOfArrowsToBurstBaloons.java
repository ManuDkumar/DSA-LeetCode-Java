class MinimumNumberOfArrowsToBurstBaloons {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int currentEnd = points[0][1];
        int minArrow = 1;

        for(int i = 1; i < points.length; i++) {
            if(points[i][0] > currentEnd) {
                minArrow++;
                currentEnd = points[i][1];
            } 
        }
        return minArrow;
    }
}
