/**
This problem can be viewed as get the max difference so far
The max difference is equal to the current value p[i]-the min value so far
so just visit all the prices array and update the max difference and the min value, the anwser is the max difference when visit all the array.
time complexity O(n), space complexity O(1)
*/
class Solution {
    
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len==0)
            return 0;
        int max=0;
        int minPrices=prices[0];
        for(int i=1;i<len;i++){
            max=Math.max(max,prices[i]-minPrices);
            minPrices=Math.min(minPrices,prices[i]);
        }
        return max;
    }
}