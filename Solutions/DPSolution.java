package Solutions;

public class DPSolution {

    public static int trap(int[] height) {
        // Variable to store the total water trapped.
        int totalWater = 0;

        // Length of the height array.
        int n = height.length;

        // Edge case: If there are fewer than 3 bars, no water can be trapped.
        if (n < 3) {
            return 0;
        }

        // Arrays to store the maximum height to the left and right of each index.
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        // Step 1: Calculate the maximum height to the left of each index.
        maxLeft[0] = height[0]; // First element has no left neighbor, so it is its own max.
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        // Step 2: Calculate the maximum height to the right of each index.
        maxRight[n - 1] = height[n - 1]; // Last element has no right neighbor, so it is its own max.
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        // Step 3: Calculate the total water trapped at each index.
        for (int i = 0; i < n; i++) {
            int potentialWater = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (potentialWater > 0) {
                totalWater += potentialWater;
            }
        }

        // Return the total amount of water trapped.
        return totalWater;
    }

    // Example usage
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Total trapped water: " + trap(height)); // Output: 6
    }
}
