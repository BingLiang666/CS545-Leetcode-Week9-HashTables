public class Solutions {

    /* Problem 350. Intersection of Two Arrays II  #Easy#
     * https://leetcode.com/problems/intersection-of-two-arrays-ii/
     *  Problem description:
     *  Given two integer arrays nums1 and nums2, return an array of their intersection.
     *  Each element in the result must appear as many times as it shows in both arrays
     *  and you may return the result in any order.
     */
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
                return new int[0];
            }
            Map<Integer, Integer> map = new HashMap();
            List<Integer> list = new ArrayList();
            for (int i: nums1) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            for (int i: nums2) {
                if (map.containsKey(i)) {
                    if (map.get(i) > 1) {
                        map.put(i, map.get(i) - 1);
                    } else {
                        map.remove(i);
                    }
                    list.add(i);
                }
            }
            int[] res = new int[list.size()];
            int index = 0;
            for (int i: list) {
                res[index++] = i;
            }
            return res;
        }
    }

    /* Problem 242. Valid Anagram  #Easy#
     * https://leetcode.com/problems/valid-anagram/
     *  Problem description:
     *  Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     *  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     *  typically using all the original letters exactly once.
     */
    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] record = new int[26];
            for (char c: s.toCharArray()) {
                record[c - 'a']++;
            }
            for (char c: t.toCharArray()) {
                record[c - 'a']--;
            }
            for (int i: record) {
                if (i != 0) return false;
            }
            return true;
        }
    }

    /* Problem 383. Ransom Note  #Easy#
     * https://leetcode.com/problems/ransom-note/
     *  Problem description:
     *  Given two strings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
     *  Each letter in magazine can only be used once in ransomNote.
     */
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] record = new int[26];
            for (char c: magazine.toCharArray()) {
                record[c - 'a']++;
            }
            for (char c:ransomNote.toCharArray()) {
                record[c - 'a']--;
            }
            for (int i: record) {
                if (i < 0) return false;
            }
            return true;
        }
    }
}
