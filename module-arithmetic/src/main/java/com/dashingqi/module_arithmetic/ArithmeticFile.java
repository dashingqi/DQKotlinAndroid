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
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     */
    public static int[] numberOne(int[] nums, int target){
        HashMap<Integer, Integer> maps = new HashMap<>();
        int [] index = new int[2];
        for (int i=0;i<nums.length;i++){
            if (maps.containsKey(nums[i])){
                index[0] =i;
                index[1] =  maps.get(nums[i]);
                return index;
            }
            maps.put(target-nums[i],i);
        }
        return index;
    }
}
