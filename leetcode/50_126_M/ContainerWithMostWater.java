public class ContainerWithMostWater {

	public int maxArea(int[] heights) {
		int left = 0;
		int right = heights.length - 1;
		int maxArea = 0;

		while (left < right) {
			int area = (right - left) 
				* (heights[left] < heights[right] ? heights[left] : heights[right]);

			maxArea = Math.max(maxArea, area);
			if (heights[left] < heights[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}	

}
