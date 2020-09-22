class Solution {
    public int minDays(int n) {
        if(n == 0) return 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        Set<Integer> visited = new HashSet<>();
        visited.add(n);
        
        int numOfDays = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
            
                int num = queue.poll();
                if(num == 1) return numOfDays + 1;

                if(num%3 == 0 && !visited.contains(num/3)) {
                    queue.offer(num/3);
                    visited.add(num/3);
                }

                if(num%2 == 0 && !visited.contains(num/2)) {
                    queue.offer(num/2);
                    visited.add(num/2);
                }


                if(!visited.contains(num-1)) {
                    queue.offer(num-1);
                    visited.add(num- 1);
                }
            }
            
            numOfDays++;
            
        }
        
        return numOfDays;
    }
    
    
}



/*






*/
