class Solution {
    public int minMoves(int[] nums) {
        int min=Arrays.stream(nums).min().getAsInt();
        int sum=Arrays.stream(nums).sum();
        return sum-nums.length*min;
    }
}