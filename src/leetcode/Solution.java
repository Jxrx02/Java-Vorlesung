package leetcode;

import java.util.*;

public class Solution {

    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num))
                return true;
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {


    }



    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map = new HashMap();
        for(String s: strs){
            char[] sorted = s.toCharArray();

            Arrays.sort(sorted);
            String sortedWord = new String(sorted);

            if(!map.containsKey(sortedWord)){
                map.put(sortedWord,new ArrayList<>());
            }

            map.get(sortedWord).add(s);


        }


        return new ArrayList<>(map.values());

    }
    public static boolean isAnagram(String s, String t) {

        char[] a  =s.toCharArray();
        char[] b =t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a,b);
    }

    public static int[] twoSum(int[] nums, int target) {
        //[3,3]
        //target =6
        //Output
        //[1,1]
        //Expected
        //[0,1]
        int [] sol = new int[2];
        for(int i =0;i<nums.length;i++){
            for(int j = 1; j<=nums.length-1;j++){
                int erg = nums[i] +nums[j];
                if(erg ==target && i!=j)
                {
                    sol[0] = i;
                    sol[1] = j;
                    return sol;
                }
            }
        }
        return null;


    }
}
