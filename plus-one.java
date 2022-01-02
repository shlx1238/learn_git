class Solution {
    /**
     * 复杂度分析：设数组长度为n，考虑最坏情况，全部需要进位，则需要首先遍历数组进行加法操作，再扩充数组，共处理（2n+1）个元素
     * 对于一般情况，则需要遍历n个元素
     * 综上，本算法时间复杂度为 O(n)
     */

    public int[] plusOne(int[] digits) {
        boolean flag = true;    // 定义标记变量，用于确定是否需要进位；初始时需要加1所以设置为true

        // 依次从个位开始向前处理进位
        for (int i = digits.length - 1; i >= 0 ; i--) {
            if (flag) {
                digits[i]++;
                if (digits[i] <= 9) {
                    flag = false;
                } else {
                    digits[i] = 0;
                }
            }
        }

        // 处理进位导致数字位数增大的情况，需要扩充数组的大小
        if (flag) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                ans[i+1] = digits[i]; 
            }
            
            return ans;
        } else {
            return digits;
        }
    }
}