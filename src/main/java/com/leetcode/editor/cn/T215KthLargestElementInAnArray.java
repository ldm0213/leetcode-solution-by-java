package com.leetcode.editor.cn;

/**
 * @author  lidongmeng
 * @date 2023-01-30 19:18:12
 * @link https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class T215KthLargestElementInAnArray {

    public static void main(String[] args) {
        Solution solution = new T215KthLargestElementInAnArray().new Solution();
        // write test case
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(solution.findKthLargest(nums, 4));
   }


   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) --r;
            if (l < r) nums[l++] = nums[r];

            while (l < r && nums[l] < pivot) ++l;
            if (l < r) nums[r--] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

    int quickSort(int[] nums, int l, int r, int k) {
        int index = partition(nums, l, r);
        int gap = index - l + 1;
        if (gap == k) return nums[index];
        else if (k < gap) return quickSort(nums, l, index - 1, k);
        else return quickSort(nums, index + 1, r, k - gap);
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}