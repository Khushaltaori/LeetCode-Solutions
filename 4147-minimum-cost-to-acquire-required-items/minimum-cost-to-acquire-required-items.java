class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long totalCost = (long)cost1 * need1 + (long)cost2 * need2;
        long totalCost1 = (long)costBoth * Math.max(need1,need2);
        long totalCost2 = (long)costBoth * Math.min(need1,need2) + (long)Math.max(need1-need2,0) * cost1 + (long)Math.max(need2-need1,0) * cost2;

        return Math.min(totalCost2,Math.min(totalCost,totalCost1));
    }
}