class Solution {
    public int maxPoints(int[][] points) {
        
        int max = 0;
        for(int i =0; i< points.length; i++) {
            Map<Pair, Integer>  lines = new HashMap<>();
            int horizontal = 0;
            int vertical = 0;
            int duplicates = 0;
            int currMax = 0;
            for(int j=i+1; j< points.length; j++) {
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1])
                    duplicates++;
                else if(points[i][0] == points[j][0]) horizontal++;
                else if(points[i][1] == points[j][1]) vertical++;
                else {
                    Pair p = getSlope(points[i], points[j]);
                    lines.put(p, lines.getOrDefault(p, 0) + 1);
                    currMax = Math.max(currMax, lines.get(p) + 1);
                }
            }
            currMax = duplicates + Math.max(currMax , 1 + Math.max(vertical, horizontal));
            
            max = Math.max(max, currMax);
        }
        return max;
    }
    
    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    public Pair getSlope(int[] a, int[] b) {
        if(b[1] > a[1]) {
            int gcd = gcd(b[1] - a[1], b[0] - a[0]);
            return new Pair((b[1] - a[1]) / gcd,  (b[0] - a[0]) / gcd);
        }
        int gcd = gcd(a[1] - b[1], a[0] - b[0]);
        return new Pair((a[1] - b[1]) / gcd, (a[0] - b[0]) / gcd);
    }
}

class Pair {
    int a;
    int b;
    
    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    public boolean equals(Object o) {
        Pair p = (Pair)o;
        return p.a == this.a && p.b == this.b;
    }
    
    public int hashCode() {
        final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		return result;
    }
}
