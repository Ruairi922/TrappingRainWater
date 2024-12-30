package Solutions;

public class TwoPointerSolution {

    public static int trap(int[] height) {
        // Initialize two pointers and variables to track the maximum heights.
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        // Traverse the array using two pointers.
        while (left < right) {
            if (height[left] < height[right]) {
                // Left side is shorter
                if (height[left] >= leftMax) {
                    // Update leftMax if current height is greater.
                    leftMax = height[left];
                } else {
                    // Calculate water trapped at the left pointer.
                    totalWater += leftMax - height[left];
                }
                left++; // Move the left pointer to the right.
            } else {
                // Right side is shorter
                if (height[right] >= rightMax) {
                    // Update rightMax if current height is greater.
                    rightMax = height[right];
                } else {
                    // Calculate water trapped at the right pointer.
                    totalWater += rightMax - height[right];
                }
                right--; // Move the right pointer to the left.
            }
        }

        return totalWater;
    }

    // Example usage
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Total trapped water: " + trap(height)); // Output: 6
    }
}
