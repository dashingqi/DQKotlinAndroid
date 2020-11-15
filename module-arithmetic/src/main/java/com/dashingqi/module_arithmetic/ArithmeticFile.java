package com.dashingqi.module_arithmetic;

import java.util.HashMap;

/**
 * @ProjectName: KotlinProject
 * @Package: com.dashingqi.module_arithmetic
 * @ClassName: ArithmeticFile
 * @Author: DashingQI
 * @CreateDate: 2020/11/12 10:16 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/11/12 10:16 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ArithmeticFile {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     */
    public static int[] numberOne(int[] nums, int target) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(nums[i])) {
                index[0] = i;
                index[1] = maps.get(nums[i]);
                return index;
            }
            maps.put(target - nums[i], i);
        }
        return index;
    }

    /**
     * 整数的反转 采用数学公式的计算
     * 假设我们的环境只能存储得下 32 位的有符号整数，
     * 则其数值范围为 [−231,  231 − 1]。
     * 请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {

            //取到整数的最后一位
            // 5376 ---> 6
            int tempValue = x % 10;

            if (res > 214748364) {
                return 0;
            }

            if (res < -214748364) {
                return 0;
            }
            res = res * 10 + tempValue;

            // 5376 -> 537
            x /= 10;
        }

        return res;
    }
}
