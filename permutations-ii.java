class Solution {
    private List<List<Integer>> ans = new ArrayList<List<Integer>>();
    private List<Integer> list = new ArrayList<>();
    private boolean[] flag;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        flag = new boolean[nums.length];
        recur(nums, 0);
        return ans;
    }

    private void recur(int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (flag[i] || (i > 0 && nums[i] == nums[i-1] && !flag[i-1])) {
                continue;
            }

            list.add(nums[i]);
            flag[i] = true;

            recur(nums, index+1);

            list.remove(index);
            flag[i] = false;
        }
    }
}