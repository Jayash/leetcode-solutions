class Solution {
    public int[] threeEqualParts(int[] A) {
        if(A == null || A.length == 0) return new int[]{-1, -1};
        int ans[] = new int[2];
        int totalOne = 0;
        int lastOneIdx = -1;
        for(int i =0; i< A.length; i++) {
            if(A[i] == 1) {
                totalOne++;
                lastOneIdx = i;
            }
        }
        
        if(totalOne%3 != 0) return new int[]{-1, -1};
        if(totalOne == 0) return new int[]{0, 2};
        
        int[] checkForFirstPart = findIndex(A, lastOneIdx, totalOne, 0);
        if(checkForFirstPart[0] == -1) return new int[]{-1, -1};
        int totalZero = checkForFirstPart[1];
        
        ans[0] = checkForFirstPart[0];
        
        int[] checkForSecondPart = findIndex(A, lastOneIdx, totalOne, checkForFirstPart[0] + 1);
        if(checkForSecondPart[0] == -1) return new int[]{-1, -1};
        if(checkForSecondPart[1] != totalZero) return new int[]{-1, -1};
        ans[1] = checkForSecondPart[0]+1;
        
        int[] checkForThirdPart = findIndex(A, lastOneIdx, totalOne, checkForSecondPart[0] + 1);
        if(checkForThirdPart[0] == -1) return new int[]{-1, -1};
        if(checkForThirdPart[1] != totalZero) return new int[]{-1, -1};
        return ans;
    }
    
    public int[] findIndex(int[] A, int lastOneIdx, int totalOne, int j) {
        int leadingZeros = A.length - lastOneIdx - 1;
        int totalOneInInterval = totalOne/3;
        boolean flag = true;
        boolean startCountingZero = false;
        int totalZero = 0;
        while(j < A.length) {
            if(flag) {
                if(A[j] == 1) {
                    totalOneInInterval--;
                    startCountingZero = true;
                }
                if(totalOneInInterval == 0) flag = false;
            } else {
                if(A[j] == 1) return new int[]{-1, -1};
                if(A[j] == 0) leadingZeros--;
            }
            if(startCountingZero && A[j] == 0) totalZero++;
            if(!flag && leadingZeros == 0) break; 
            j++;
        }
        
        return new int[]{j, totalZero};
    }
}

/*

    1 0 1 0 1
    



*/
