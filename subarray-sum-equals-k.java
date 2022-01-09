class Solution {
    public int subarraySum(int[] nums, int k) {
        /**
         * 复杂度分析：采用的方法是前缀和，设数组长度为n
         * 首先需要遍历数组nums，得到前缀和数组
         * 其次需要循环n^2次，以找出和为k的子数组
         * 因此，本算法时间复杂度为O(n^2)，空间复杂度为O(n)
         */

        int[] s = new int[nums.length + 1];
        int count = 0;
        for (int i = 1; i < s.length; i++) {
            s[i] += s[i-1] + nums[i-1];
        }

        for (int r = 1; r < s.length; r++) {
            for (int l = 1; l <= r; l++) {
                if (s[r] - s[l-1] == k) {
                    count++;
                }
            }
        }

        return count;
    }
}