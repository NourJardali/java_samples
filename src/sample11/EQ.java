package sample11;

import java.util.Arrays;

public class EQ {
	private int[] queens;
	
	public EQ() {
		queens = new int[8];
		Arrays.fill(queens, -1);
	}
	
	public EQ(int[] queens) {
		this.queens = queens;
	}
	
	public int get(int i) {
		return queens[i];
	}
	
	public void set(int i, int j) {
		queens[i] = j;
	}
	
	public boolean isSolved() {
		for(int i = 0; i < 8; i++) {
			int p = get(i);
			for(int j = i + 1; j < 8; j++) {
				if(p == get(j))
					return false;
			}
		}
		return true;
	}
	
	public void printBoard() {
		for(int i = 0; i < 8; i++) {
			int p = get(i);
			for(int j = 0; j < 8; j++) {
				System.out.print("|");
				if(j == p) {
					System.out.print("X");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.print("|\n");
		}
	}
	
	public static void main(String[] args) {
		EQ eq = new EQ();
		eq.set(0, 0);
		eq.set(1, 6);
		eq.set(2, 4);
		eq.set(3, 7);
		eq.set(4, 1);
		eq.set(5, 3);
		eq.set(6, 5);
		eq.set(7, 2);
		System.out.println(eq.isSolved());
	}
}
