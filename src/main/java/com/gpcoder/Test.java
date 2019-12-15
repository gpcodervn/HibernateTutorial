package com.gpcoder;

public class Test {

	public static void main(String[] args) {
		int[][] a = {
			{3,3,1},
			{3,3,1},
			{1,3,3}
		};
		System.out.println("" + cubes(a));
		System.out.println("" + Math.cbrt(Long.MAX_VALUE));
	}

	static long cubes(int[][] a) {
		long rs = volume(a[0]) + volume(a[1]) + volume(a[2]);
		double cbrt = Math.cbrt(rs);
		if (cbrt % 1 == 0) {
			return (long) cbrt;
		}
		return -1;
	}

	static int volume(int a[]) {
		return a[0] * a[1] * a[2];
	}
}
