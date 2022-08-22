package com.matt;

public class AnswerPool {
	
	int[][] pool = new int[11][11];
	
	public AnswerPool() {}
	
	public void store(int last, int current) {
		pool[last][current] ++;
	}
	
	public int getGuess(int last) {
		int[] frame = pool[last];
		int max = 0, max_index = 0;
		for (int x = 0; x < frame.length; x++) {
			if (frame[x] > max) {
				max_index = x;
				max = frame[x];
			}
		}
		return max_index;
	}
}
