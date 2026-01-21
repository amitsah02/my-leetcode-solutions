import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineStart = i;
            int lineLen = words[i].length();
            i++;

            // Greedy: keep adding words while they fit (with at least 1 space between)
            while (i < words.length && lineLen + 1 + words[i].length() <= maxWidth) {
                lineLen += 1 + words[i].length();
                i++;
            }

            int lineEnd = i - 1;                 // last word index in this line
            int wordCount = lineEnd - lineStart + 1;

            boolean isLastLine = (i == words.length);
            if (wordCount == 1 || isLastLine) {
                result.add(buildLeftLine(words, lineStart, lineEnd, maxWidth));
            } else {
                result.add(buildFullLine(words, lineStart, lineEnd, maxWidth));
            }
        }

        return result;
    }

    private String buildLeftLine(String[] words, int start, int end, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int k = start; k <= end; k++) {
            sb.append(words[k]);
            if (k != end) sb.append(' ');
        }
        while (sb.length() < maxWidth) sb.append(' ');
        return sb.toString();
    }

    private String buildFullLine(String[] words, int start, int end, int maxWidth) {
        int totalWordsLen = 0;
        for (int k = start; k <= end; k++) totalWordsLen += words[k].length();

        int gaps = end - start;                 // number of spaces slots
        int totalSpaces = maxWidth - totalWordsLen;

        int base = totalSpaces / gaps;          // minimum spaces per gap
        int extra = totalSpaces % gaps;         // leftmost 'extra' gaps get +1 space

        StringBuilder sb = new StringBuilder();
        for (int k = start; k <= end; k++) {
            sb.append(words[k]);
            if (k == end) break;

            int spacesHere = base + (extra > 0 ? 1 : 0);
            extra--;

            for (int s = 0; s < spacesHere; s++) sb.append(' ');
        }
        return sb.toString();
    }
}
