package com.dashingqi.module_arithmetic;

import java.util.HashMap;

/**
 * @author : zhangqi
 * @time : 1/15/21
 * desc :
 */
class Test {

    /**
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        int[] ints = new int[2];
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(nums[i])) {
                ints[0] = maps.get(nums[i]);
                ints[1] = i;

                return ints;
            }

            maps.put(target - nums[i], 1);
        }
        return ints;
    }


    /**
     * 反转链表
     *
     * @param head
     * @return 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;
        ListNode temp = null;

        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    /**
     * 环形链表
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        int count = 10000;

        while (head != null && count >= 0) {
            head = head.next;
            count--;
        }

        if (count >= 0) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * 爬楼梯
     */

    public int climbStairs(int n) {
        int[] ints = new int[n + 1];
        ints[0] = 1;
        ints[1] = 1;
        for (int i = 2; i <= n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }

    /**
     * 最大子序和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] ints = new int[nums.length];
        ints[0] = Math.max(nums[0], 0);
        int sum = 0;
        for (int i = 1; i < ints.length; i++) {
            ints[i] = nums[i] + Math.max(ints[i - 1], 0);
            if (ints[i] > sum) {
                sum = ints[i];
            }
        }
        return sum;
    }

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;

        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 反转字符
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int length = s.length;
        for (int left = 0, right = length - 1; left < right; ++left, --right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }


    /**
     * 买卖股票的最佳时机
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int maxPrice = 0;
        for (int i = prices.length - 1; i < prices.length; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (prices[i] - prices[j] > maxPrice) {
                    maxPrice = prices[i] - prices[j];
                }
            }
        }
        return maxPrice;
    }


    /**
     * 相交链表
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode hA = headA;
        ListNode hB = headB;

        if (headA == null || headB == null) return null;
        while (hA != hB) {
            hA = hA == null ? hB : hA.next;
            hB = hB == null ? hA : hB.next;
        }
        return hA;
    }

    /**
     * 只出现一次的数字
     *
     * @param nums
     * @return 位运算
     * <p>
     * a^a = 0;
     * a^b = a;
     */
    public int singleNumber(int[] nums) {

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp ^= nums[i];
        }
        return temp;
    }


    /**
     * 二叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {


    }
}
