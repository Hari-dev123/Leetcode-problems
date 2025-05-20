class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;
        for (int i = 0; i < k; i++) {
            totalSum += cardPoints[i];
        }
        int max = totalSum;
        int leftIndex = k - 1;
        int rightIndex = n - 1;
        for (int i = 1; i <= k; i++) {
            totalSum = totalSum - cardPoints[leftIndex--] + cardPoints[rightIndex--];
            max = Math.max(max, totalSum);
        }
        return max;
    }
}
