package com.hw.study;

public class Ex0220_Order {
	public static void main(String[] args) {
		/*
		 * 10�� ���� ���� ���� �� �������� ����  20.02.20 (�Ϸ�)
		 * �� ���� �ִ밪 ���Ͼ��� ���
		 * 1~100���� �������� 10���� �迭�� �־
		 * �������ڷ� �����ؼ� ���
		 * 
		 * */
		
		int[] num = new int[100];
		int[] ran = new int[10];
		
		
		in(num);
		shu(num, ran);
		print(ran);
	}
	
	//���� �ֱ�
	static void in(int[] num) {
		
		for (int i = 0; i < num.length; i++) {
			num[i] = i+1;
		}
	}

	//���� ���� �ֱ�
	static void shu(int[] num, int[] ran) {
		for (int i = 0; i < 200; i++) {
			int temp1 = (int)(Math.random()*100);
			
			int temp2 = num[0];
			num[0] =  num[temp1];
			num[temp1] = temp2;
		}
		
		for (int i = 0; i < ran.length; i++) {
			ran[i] = num[i];
		}
		
	}

	//������� ( ��������)
	static void print(int[] ran) {
		
		for (int i = 0; i < ran.length-1; i++) {
			boolean boo = false;
			for (int j = 0; j < ran.length-1; j++) {
				if(ran[j] > ran[j+1]) {
					int temp = ran[j];
					ran[j] = ran[j+1];
					ran[j+1] = temp;
					boo = true;
				}
			}
			if(boo==false) {
				break;
			}
		}
		
		for (int i = 0; i < ran.length; i++) {
			System.out.print(ran[i]+" ");
		}
		
		
	}
}
