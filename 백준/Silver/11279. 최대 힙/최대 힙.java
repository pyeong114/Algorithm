import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				return (int) (o2 - o1);
			}
		});

		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			long input = sc.nextInt();
			if (input == 0) {
				if (pq.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(pq.poll() + "\n");
				}
			} else {
				pq.add(input);
			}
		}
		System.out.println(sb.toString());
	}
}
