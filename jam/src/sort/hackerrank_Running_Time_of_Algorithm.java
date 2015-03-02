package sort;

/*Running_Time_of_Algorithm
 hackerrank


 */

class hackerrank_Running_Time_of_Algorithm {
	public static void main(String[] args) {
		runtimeAnalysis(new int[] { 2, 1, 3, 1, 2 });
	}

	public static void runtimeAnalysis(int[] arr) {
		if (arr == null || arr.length < 1) {
			System.out.println(0);
			return;
		}
		int count = 0;
		for (int i = 1; i < arr.length; ++i) {
			int tmp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > tmp) {
				arr[j + 1] = arr[j];
				--j;
				++count;
			}
			arr[j + 1] = tmp;
		}
		System.out.println(count);
	}
}
