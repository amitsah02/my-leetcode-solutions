import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // agar i == n hai toh height 0 lelo (last bar ke baad kaam complete karne ke liye)
            int currHeight = (i == n) ? 0 : heights[i];

            // jab tak stack non-empty ho aur current height chhoti ho
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // jis bar ka rectangle banana hai
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // width calculate karo
                maxArea = Math.max(maxArea, height * width); // area nikalke max se compare karo
            }

            // current index ko stack me daal do
            stack.push(i);
        }

        return maxArea;
    }
}
