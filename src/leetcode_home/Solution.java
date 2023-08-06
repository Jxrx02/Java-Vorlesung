package leetcode_home;

import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        /*
        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]
         */
        //Num, Frequency
        HashMap<Integer, Integer> map = new HashMap();

        for(int i = 0; i<nums.length; i++){

            if(!map.containsKey(nums[i])){
                map.put(nums[i], map.getOrDefault(nums,0) + 1 );
            }
        }
        int[] values = (int[]) map.values().toArray();
        return values;
    }

}
