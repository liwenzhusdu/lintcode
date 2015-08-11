public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        int len = A.length, n = len/2 -1;
        if(len == 0){
            return;
        }
        for( ;n >= 0 ; n--){
            int i = 2*n + 1, j = n,temp = A[n];//×óº¢×ÓÏÂ±ê
            while(i < len){
                if( i+1 < len){
                    if(A[i] > A[i+1]){
                        i++;
                    }
                }
                if(temp <= A[i]){
                    break;
                }
                A[j] = A[i];
                j = i ;
                i = 2*i +1;
            }
            A[j] = temp;
        }
        
    }
}
