class Solution {
    public int minAreaRect(int[][] points) {
        if(points == null || points.length < 4) return 0;
        
        Set<String> set = new HashSet<>();
        
        for(int[] point: points)
            set.add(point[0] + "-" + point[1]);
        
        int area = Integer.MAX_VALUE;
        
        for(int i=0; i< points.length-1; i++) {
            for(int j=i+1; j<points.length; j++) {

                if(points[j][0] != points[i][0] && points[j][1] != points[i][1]) {
                    if(points[j][0] > points[i][0]) {
                        if(set.contains(points[j][0] + "-" + points[i][1]) &&
                          set.contains(points[i][0] + "-" + points[j][1])) {

                            int recArea = Math.abs(points[i][0] - points[j][0]) * 
                                Math.abs(points[i][1] - points[j][1]);

                            area = Math.min(area, recArea);
                        }
                    } else {
                        if(set.contains(points[i][0] + "-" + points[j][1]) &&
                          set.contains(points[j][0] + "-" + points[i][1])) {

                            int recArea = Math.abs(points[i][0] - points[j][0]) * 
                                Math.abs(points[i][1] - points[j][1]);

                            area = Math.min(area, recArea);
                        }
                    }
                }

                if(area == 1) return 1;

            }
        }
        
        return area == Integer.MAX_VALUE ? 0: area;
    }
    
}
