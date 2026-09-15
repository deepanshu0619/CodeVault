class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int totalrows=matrix.length;
        int totalcols=matrix[0].length;
        int n=totalrows*totalcols;
        int s=0;
        int e=n-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            int rowidx=mid/totalcols;
            int colidx=mid%totalcols;
            if(matrix[rowidx][colidx]==target){
                return true;
            }else if(matrix[rowidx][colidx]>target){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return false;
    }
}