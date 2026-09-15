class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int totrows=matrix.length;
        int totcols=matrix[0].length;
        int row=0;
        int col=totcols-1;
        while(row<totrows && col>=0){
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]>target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}