package com.leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author  lidongmeng
 * @date 2023-01-30 20:21:44
 * @link https://leetcode.com/problems/top-k-frequent-elements/
 */
public class T347TopKFrequentElements {

    public static void main(String[] args) {
        Solution solution = new T347TopKFrequentElements().new Solution();
        // write test case
        int[] nums = {1,1,1,2,2,3};
        int[] result = solution.topKFrequent(nums, 2);
        for (int t: result) {
            System.out.println(t);
        }
   }
   

   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num: nums) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }
        Queue<Integer> q = new PriorityQueue<>(k, Comparator.comparingInt(a -> frequencyMap.get(a)));
        for (Integer key: frequencyMap.keySet()) {
            if (q.size() < k) {
                q.add(key);
            } else if (frequencyMap.get(key) > frequencyMap.get(q.peek())) {
                q.remove();
                q.add(key);
            }
        }
        int[] result = new int[k];
        int index = 0;
        while (!q.isEmpty()) {
            result[index++] = q.remove();
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}