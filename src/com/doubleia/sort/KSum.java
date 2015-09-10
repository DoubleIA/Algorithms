    public int kSum(int A[], int k, int target) {
        // write your code here
    	if (k <= 0) {
    		return -1;
    	}
    	
    	Arrays.sort(A);
    	int solutions = rSum(A, k, 0, target);
  
    	return solutions;
    }
    
    private int rSum(int A[], int k, int start, int target) {
    	int count = 0;
    	
    	if (k==1) {
    		for (int i = 0; i < A.length; i++) {
				if (A[i] == target) {
					count++;
				}
			}
    		return count;
    	}
    	
    	if (k == 2) {
        	int left = start;
    		int right = A.length - 1;
    		while (left < right) {
    			int sum = A[left] + A[right];
    			if (sum == target) {
    				count++;
    				left++;
    				right--;
    			} else if (sum < target)   {
    				left++;
    			} else {
    				right--;
    			}
     		}
    		return count;
    	}
    	
    	for (int i = start; i < A.length - k + 1; i++) {
    		int tar = target - A[i];
			int temp = rSum(A, k - 1, i + 1, tar);
			count += temp;
		}
    	
    	return count;
    }
