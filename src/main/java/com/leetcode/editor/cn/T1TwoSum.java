package com.leetcode.editor.cn;

import java.util.HashMap;

/**
 * @author  lidongmeng
 * @date 2023-01-29 16:20:51
 * @link https://leetcode.com/problems/two-sum/
 */
public class T1TwoSum {

    public static void main(String[] args) {
        Solution solution = new T1TwoSum().new Solution();
        // write test case
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i = 0; i < result.length; ++i) {
            System.out.println(result[i]);
        }
   }
   

   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}