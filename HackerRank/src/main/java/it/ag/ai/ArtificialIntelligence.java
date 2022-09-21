package it.ag.ai;

/**
 * https://www.hackerrank.com/domains/ai
 */
public class ArtificialIntelligence {

	static void displayPathtoPrincess(int n, String [] grid){
	}

	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int m;
//		m = in.nextInt();
//		String grid[] = new String[m];
//		for(int i = 0; i < m; i++) {
//			grid[i] = in.next();
//		}

		String grid[] = new String[10];
		grid[0] = "----------";
		grid[1] = "----------";
		grid[2] = "----------";
		grid[3] = "----------";
		grid[4] = "----m-----";
		grid[5] = "----------";
		grid[6] = "----------";
		grid[7] = "----------";
		grid[8] = "----------";
		grid[9] = "--------p-";

		displayPathtoPrincess(10,grid);
	}

}
