//package com.dashingqi.module_arithmetic;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Stack;
//
//import kotlin.collections.ArraysKt;
//
///**
// * @ProjectName: KotlinProject
// * @Package: com.dashingqi.module_arithmetic
// * @ClassName: ArithmeticFile
// * @Author: DashingQI
// * @CreateDate: 2020/11/12 10:16 PM
// * @UpdateUser: 更新者
// * @UpdateDate: 2020/11/12 10:16 PM
// * @UpdateRemark:
// * @Version: 1.0
// */
//public class ArithmeticFile {
//    /**
//     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//     * <p>
//     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//     */
//    public static int[] numberOne(int[] nums, int target) {
//        HashMap<Integer, Integer> maps = new HashMap<>();
//        int[] index = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            if (maps.containsKey(nums[i])) {
//                index[0] = i;
//                index[1] = maps.get(nums[i]);
//                return index;
//            }
//            maps.put(target - nums[i], i);
//        }
//        return index;
//    }
//
//    public static int[] numberOnew(int[] nums, int target) {
//
//        int[] index = new int[2];
//        HashMap<Integer, Integer> maps = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            if (maps.containsKey(nums[i])) {
//                index[0] = i;
//                index[1] = maps.get(nums[i]);
//            }
//
//            maps.put(target - nums[i], i);
//        }
//
//        return index;
//    }
//
//
//    /**
//     * 整数的反转 采用数学公式的计算
//     * 假设我们的环境只能存储得下 32 位的有符号整数，
//     * 则其数值范围为 [−231,  231 − 1]。
//     * 请根据这个假设，如果反转后整数溢出那么就返回 0。
//     *
//     * @param x
//     * @return
//     */
//    public int reverse(int x) {
//        int res = 0;
//        while (x != 0) {
//
//            //取到整数的最后一位
//            // 5376 ---> 6
//            int tempValue = x % 10;
//
//            if (res > 214748364) {
//                return 0;
//            }
//
//            if (res < -214748364) {
//                return 0;
//            }
//            res = res * 10 + tempValue;
//
//            // 5376 -> 537
//            x /= 10;
//        }
//
//        return res;
//
//    }
//
//
//    /**
//     * 平衡分割字符串
//     * 输入：s = "RLRRLLRLRL"
//     * 输出：4
//     * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
//     */
//    public static int balancedSplitStr(String targetStr) {
//        //剩余判断的字符串
//        String surplusStr = targetStr;
//        List splitList = new ArrayList<String>();
//        //当剩余未判断的字符串长度大于0
//        while (surplusStr.length() > 0) {
//            // 拿到剩余未判断的字符串
//            surplusStr = balanceSplitUtil(surplusStr)[1];
//            //拿到符合条件的字符串 添加到集合中
//            splitList.add(balanceSplitUtil(surplusStr)[0]);
//        }
//        //返回符合条件的切割数
//        return splitList.size();
//
//    }
//
//    private static String[] balanceSplitUtil(String surplusStr) {
//
//        String justStr = "";
//
//        for (int i = 1; i < surplusStr.length(); i++) {
//
//            justStr = surplusStr.substring(0, i);
//            //分别用于此次字符串中 L和R出现的次数
//            int leftNumber = 0, rightNumber = 0;
//
//            for (int j = 0; j < justStr.length(); j++) {
//                if (justStr.charAt(j) == 'L') {
//                    leftNumber++;
//                } else if (justStr.charAt(j) == 'R') {
//                    rightNumber++;
//                }
//            }
//
//            if (leftNumber == rightNumber) {
//                //将本次符合条件的字符串和剩余未判断字符串返回回去
//                return new String[]{justStr, surplusStr.substring(i)};
//            } else {
//                continue;
//            }
//
//        }
//        return new String[]{"", ""};
//    }
//
//
//    /**
//     * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
//     * 输入: "Hello"
//     * 输出: "hello"
//     * 输入: "here"
//     * 输出: "here"
//     */
//    public static String toLowerCase(String str) {
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < str.length(); i++) {
//            char tempC = str.charAt(i);
//            if (tempC >= 'A' && tempC <= 'Z') {
//                tempC += 32;
//            }
//            sb.append(tempC);
//        }
//        return sb.toString();
//    }
//
//
//    /**
//     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//     * 输入："Let's take LeetCode contest"
//     * 输出："s'teL ekat edoCteeL tsetnoc"
//     *
//     * @param s
//     * @return
//     */
//    public String reverseWords(String s) {
//        //切割字符串
//        String[] tempStrArray = s.split(" ");
//        StringBuilder sb = new StringBuilder();
//        StringBuilder tempSb = new StringBuilder();
//        //将子字符串进行反转
//        for (int i = 0; i < tempStrArray.length; i++) {
//            tempSb.delete(0, tempSb.length());
//            sb.append(tempSb.append(tempStrArray[i]).reverse().toString());
//            if (i < tempStrArray.length - 1) {
//                sb.append(" ");
//            }
//        }
//        return sb.toString();
//    }
//
//
//    /**
//     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//     * <p>
//     * 输入: s1 = "abc", s2 = "bca"
//     * 输出: true
//     * <p>
//     * 输入: s1 = "abc", s2 = "bad"
//     * 输出: false
//     * 1. 首先判断 s1和s2的长度是否相等
//     * 2. 然后匹配s2中每一个字符串
//     */
//
//    public static boolean checkPermutation(String s1, String s2) {
//
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//
//        String tempStr = s2;
//
//        for (int i = 0; i < s1.length(); i++) {
//            int tempIndex = tempStr.indexOf(s1.charAt(i));
//            if (tempIndex == -1) {
//                return false;
//            } else {
//                tempStr = deleteCharByIndex(tempStr, tempIndex);
//            }
//        }
//
//        return true;
//    }
//
//    private static String deleteCharByIndex(String tempStr, int index) {
//        return tempStr.substring(0, index) + tempStr.substring(index + 1);
//    }
//
//    /**
//     * 贪心算法
//     * 非升序排列的总列数
//     *
//     * @param A
//     * @return
//     */
//    public int minDeletionSize(String[] A) {
//        int result = 0;
//        int length = A[0].length();
//        // i表示列数
//        for (int i = 0; i < length; i++) {
//            //j 表示行数
//            for (int j = 0; j < A.length; j++) {
//                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
//                    result++;
//                    break;
//                }
//            }
//        }
//        return result;
//    }
//
//    /**
//     * 给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
//     * <p>
//     * 如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
//     * <p>
//     * 与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
//     *
//     * @param nums
//     * @return
//     */
//    public List<Integer> minSubsequence(int[] nums) {
//
//        List<Integer> resultList = new ArrayList<>();
//        int sum = 0;
//        int count = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        Arrays.sort(nums);
//        for (int i = nums.length - 1; i >= 0; i--) {
//            count += nums[i];
//            resultList.add(nums[i]);
//            if (count > (sum - count)) {
//                return resultList;
//            }
//        }
//        return null;
//
//    }
//
//    /**
//     * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
//     * <p>
//     * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
//     * <p>
//     * 请你计算 最多 能喝到多少瓶酒。
//     */
//
//    public static int numWaterBottles(int numBottles, int numExchange) {
//        //喝过的瓶数
//        int drinkNum = numBottles;
//        int bottleCount = numBottles;
//
//        while (bottleCount >= numExchange) {
//            //喝过的瓶子能换几个
//            int tempDrinkBottles = bottleCount / numExchange;
//            //喝过的瓶子中 还剩几个不能换
//            int restBottleCount = bottleCount % numExchange;
//            // 重新计算喝过的瓶子
//            drinkNum += tempDrinkBottles;
//            bottleCount = tempDrinkBottles + restBottleCount;
//        }
//
//        return drinkNum;
//    }
//
//    // ======================= 动态规划 =======================
//
//    /***
//     *
//     *
//     * 输入: [7,1,5,3,6,4]
//     * 输出: 5
//     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
//     *
//     *
//     */
//
//    public static int maxProfit(int[] prices) {
//        int maxPrice = 0;
//        for (int i = prices.length - 1; i >= 0; i--) {
//            for (int j = i - 1; j >= 0; j--) {
//                if (prices[i] - prices[j] > maxPrice) {
//                    maxPrice = prices[i] - prices[j];
//                }
//            }
//        }
//        return maxPrice;
//    }
//
//
//    public int maxSubArray(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0] = Math.max(dp[0], 0);
//        int max = Math.max(dp[0], 0);
//        for (int i = 1; i < dp.length; i++) {
//            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
//            if (dp[i] > max) {
//                max = dp[i];
//            }
//        }
//        return max;
//    }
//
//    public int maxSubArrays(int[] nums) {
//
//
//        int[] dp = new int[nums.length];
//
//        dp[0] = Math.max(dp[0], 0);
//        int max = Math.max(dp[0], 0);
//
//        for (int i = 1; i < dp.length; i++) {
//            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
//            if (dp[i] > max) {
//                max = dp[i];
//            }
//        }
//
//        return max;
//    }
//
//
//    /**
//     * 数字N如果是奇数，它的约数必然都是奇数；若为偶数，则其约数可奇可偶。
//     * 无论N初始为多大的值，游戏最终只会进行到N=2时结束，那么谁轮到N=2时谁就会赢。
//     * 因为爱丽丝先手，N初始若为偶数，爱丽丝则只需一直选1，使鲍勃一直面临N为奇数的情况，这样爱丽丝稳赢；
//     * N初始若为奇数，那么爱丽丝第一次选完之后N必为偶数，那么鲍勃只需一直选1就会稳赢。
//     * 综述，判断N是奇数还是偶数，即可得出最终结果！
//     *
//     *
//     */
//
//
//    /**
//     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//     * <p>
//     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//     * <p>
//     * 注意：给定 n 是一个正整数。
//     * <p>
//     * <p>
//     * <p>
//     * 示例 1：
//     * <p>
//     * 输入： 2
//     * 输出： 2
//     * 解释： 有两种方法可以爬到楼顶。
//     * 1.  1 阶 + 1 阶
//     * 2.  2 阶
//     * <p>
//     * <p>
//     * 示例 2：
//     * <p>
//     * 输入： 3
//     * 输出： 3
//     * 解释： 有三种方法可以爬到楼顶。
//     * <p>
//     * <p>
//     * 1.  1 阶 + 1 阶 + 1 阶
//     * 2.  1 阶 + 2 阶
//     * 3.  2 阶 + 1 阶
//     */
//
//    public int climbStairs(int n) {
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
//    }
//
//
//    public int climbStairss(int n) {
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i + 2];
//        }
//
//        return dp[n];
//    }
//
//
//    //    public class ListNode {
////      int val;
////      ListNode next;
////      ListNode(int x) { val = x; }
////      }
//    public void deleteNode(ListNode node) {
//        node.val = node.next.val;
//        node.next = node.next.next;
//    }
//
//
//    /**
//     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
//     * 即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//     * 它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
//     *
//     * @param head
//     * @param k
//     * @return
//     */
//    public ListNode getKthFromEnd(ListNode head, int k) {
//        ListNode former = head;
//        ListNode latter = head;
//        for (int i = 0; i < k - 1; i++) {
//            latter = latter.next;
//        }
//        while (latter.next != null) {
//            latter = latter.next;
//            former = former.next;
//        }
//        return former;
//    }
//
//
//    /**
//     * 使用栈 将链表入栈
//     *
//     * @param head
//     * @return
//     */
//    public int[] reversePrint(ListNode head) {
//        Stack<ListNode> stack = new Stack<>();
//        ListNode tempNode = head;
//        //将链表入栈
//        while (tempNode != null) {
//            stack.push(tempNode);
//            tempNode = tempNode.next;
//        }
//
//        //打印栈
//        int[] nodes = new int[stack.size()];
//
//        for (int i = 0; i < stack.size(); i++) {
//            //取到值 赋值给node数组
//            nodes[i] = stack.pop().val;
//        }
//        return nodes;
//    }
//
//
//    /**
//     * 合并两个数组
//     *
//     * @param nums1
//     * @param m
//     * @param nums2
//     * @param n
//     */
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//
//        int len1 = m - 1;
//
//        int len2 = n - 1;
//
//        int len = m + n - 1;
//
//        while (len1 >= 0 && len2 >= 0) {
//
//            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
//
//        }
//
//        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
//    }
//
//
//    /**
//     * 二叉搜索树
//     * <p>
//     * 根节点要大于左树小于右树，左树要比右树小
//     * <p>
//     * 如果一个比根节点大，一个比根节点小 说是 一个在左树上 一个在右树上，就没有公共的节点·
//     * <p>
//     * 如果两个都比根节点小，说明在左树上，去左树上查找
//     * <p>
//     * 如果两个都比根节点大，说明都在右树上，去右树上查找
//     */
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//        //用于剔去 不在同一个树上的情况
//        while ((root.val - p.val) * (root.val - q.val) > 0)
//            root = p.val < root.val ? root.left : root.right;
//        return root;
//    }
//
//
//}
