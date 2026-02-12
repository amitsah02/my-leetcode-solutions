class Solution {
    public String reverseVowels(String s) {
       char[] arr = s.toCharArray();

        int start = 0;
        int last = arr.length - 1;

        while (start < last) {

            if (!isVowel(arr[start])) {
                start++;
                continue;
            }

            if (!isVowel(arr[last])) {
                last--;
                continue;
            }

            // swap vowels
            char temp = arr[start];
            arr[start] = arr[last];
            arr[last] = temp;

            start++;
            last--;
        }

        return new String(arr);
    

   
    }
     private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}