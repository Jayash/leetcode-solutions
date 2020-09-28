class Solution {
    public int scheduleCourse(int[][] courses) {
        if(courses == null || courses.length == 0) return 0;
        
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int max = 0;
        
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int sum=0;
        for(int i=0; i< courses.length; i++) {
            if(courses[i][0] <= courses[i][1]) {
                sum += courses[i][0];
                heap.offer(courses[i]);
                if(!heap.isEmpty() && sum > courses[i][1])
                    sum -= heap.poll()[0];
                max = Math.max(max, heap.size());
            }
        }
        
        return max;
    }
    
}

/*


      




*/
