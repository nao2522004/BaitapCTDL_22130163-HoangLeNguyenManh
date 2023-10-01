public class Task1_4 {
	public static void moveTowerHN(int disk, char src, char desk, char spare) {
		if (disk == 1) {
			System.out.println(src + "->" + spare);
		
		} else {
          moveTowerHN(disk-1, src, spare, desk);
          moveTowerHN(1, src, desk, spare);
          moveTowerHN(disk-1, desk, src, spare);
         
		}
	}
	public static void main(String[] args) {
		// test moveTowerHN
		moveTowerHN(3, 'A', 'B', 'C');
	}
}
