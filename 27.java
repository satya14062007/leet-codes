import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words.length == 0)
            return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int windowSize = wordLen * wordCount;

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - windowSize; i++) {

            HashMap<String, Integer> seen = new HashMap<>();
            int j = 0;

            while (j < wordCount) {

                int start = i + j * wordLen;
                String word = s.substring(start, start + wordLen);

                if (!map.containsKey(word))
                    break;

                seen.put(word, seen.getOrDefault(word, 0) + 1);

                if (seen.get(word) > map.get(word))
                    break;

                j++;
            }

            if (j == wordCount)
                result.add(i);
        }

        return result;
    }
}
