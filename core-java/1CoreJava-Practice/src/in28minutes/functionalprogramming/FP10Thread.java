package com.functionalprogrammingbyin28minutes;

public class FP10Thread {

	public static void main(String[] args) {
		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					System.out.println(Thread.currentThread().getId() + ": " + i);
				}
			}
		};
		Runnable runnable = () -> {
			for (int i = 0; i < 50; i++) {
				System.out.println(Thread.currentThread().getId() + ": " + i);
			}
		};

		Thread t1 = new Thread(runnable);
		t1.start();

		Thread t2 = new Thread(runnable);
		t2.start();
		Thread t3 = new Thread(runnable);
		t3.start();
		Thread t4 = new Thread(runnable);
		t4.start();
	}

}
