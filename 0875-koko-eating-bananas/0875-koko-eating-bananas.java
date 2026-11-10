class Solution {

static long helper(int[] piles, int h, int k) {
    long hour = 0;

    for (int i = 0; i < piles.length; i++) {
        hour += piles[i] / k;

        if (piles[i] % k != 0) {
            hour++;
        }
    }

    return hour;
}

    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int low=1;
        int high=piles[0];
        for (int i = 1; i < piles.length; i++) {
        if (piles[i] > high) {
            high = piles[i];
            }
        }
        int res=-1;
        while(low<=high){
            int guess=low+(high-low)/2;
            long hour=helper(piles,h,guess);
            if(hour>h){
                low=guess+1;
            }else{
                res=guess;
                high=guess-1;
            }
        }
        return res;
    }
}