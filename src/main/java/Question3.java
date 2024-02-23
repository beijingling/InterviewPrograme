
/**
 * 1000个数范围是[0,999],有2个相同的数字，请设计算法找出相同的数
 */
class Question3 {

	public static int getSameNum(int[] nums) {
		int length = nums.length;
		boolean[] findNum = new boolean[length];
		for (int num : nums) {
			if (findNum[num]) {
				return num;
			} else {
				findNum[num] = true;
			}
		}

		return -1;

	}

	public static int getSameNum1(int[] nums) {
		int startNum = nums[0];
		int next = 0;
		while (next != startNum) {
			next = nums[next];
		}
		return nums[next];
	}

/*	public static int getSameNum2(int[] nums) {
		int slow = 0, fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
		System.out.println("slow:" + slow + "\tfast:" + fast);
		slow = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}*/

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 0, 4, 5, 7, 6, 4, };
		System.out.println("0 double nums:" + getSameNum(nums));

		System.out.println("1 double nums:" + getSameNum1(nums));

//		System.out.println("2   nums:" + getSameNum2(nums));
	}
}