class Solution {
    public int maxAbsoluteSum(int[] nums) {
        //-ve values ka sum bhi matter krega
        //max(max subarray sum,abs(min subarray sum))
        int maxcurrsum=nums[0];
        int mincurrsum=nums[0];
        int maxsubarraysum=nums[0];
        int minsubarraysum=nums[0];
        for(int i=1;i<nums.length;i++){
            maxcurrsum=Math.max(nums[i],maxcurrsum+nums[i]);
            maxsubarraysum=Math.max(maxcurrsum,maxsubarraysum);
            mincurrsum=Math.min(nums[i],mincurrsum+nums[i]);
            minsubarraysum=Math.min(mincurrsum,minsubarraysum);
        }
        return Math.max(maxsubarraysum,Math.abs(minsubarraysum));
    }
}