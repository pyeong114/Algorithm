import java.util.Scanner;

public class Main {
	public static int N;
	public static int M;
	public static int[] classes;
	public static long sum;
	public static long max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 강의 수
		N = sc.nextInt();
		// 블루레이의 갯수
		M = sc.nextInt();

		classes = new int[N];
		sum = 0;
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			classes[i] = sc.nextInt();
			sum += classes[i];
			max = Math.max(classes[i], max);
		}
		System.out.println(binarySearch());
	}

	public static long binarySearch() {
		long str = max;
		long end = sum;
		long ans = Integer.MAX_VALUE;
		long mid = 0;
		while (str <= end) {
			int classCnt = 0;
			mid = (str + end) / 2;
			int classSum = 0;
			for (int i = 0; i < N; i++) {
				classSum += classes[i];
				if (classSum == mid) {
					classCnt++;
					classSum = 0;
				} else if (classSum > mid) {
					classCnt++;
					classSum = classes[i];
				}

				if (classSum != 0 && i == N - 1) {
					classCnt++;
				}
			}
			if (classCnt <= M) {
				ans = Math.min(mid, ans);
				end = mid - 1;
			} else {
				str = mid + 1;
			}
		}
		return ans;
	}
}