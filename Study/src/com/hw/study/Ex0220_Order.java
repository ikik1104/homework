package com.hw.study;

public class Ex0220_Order {
	public static void main(String[] args) {
		/*
		 * 10개 숫자 랜덤 선택 후 오름차순 정렬  20.02.20 (완료)
		 * 각 줄의 최대값 리턴없이 출력
		 * 1~100까지 랜덤으로 10개를 배열에 넣어서
		 * 작은숫자로 정렬해서 출력
		 * 
		 * */
		
		int[] num = new int[100];
		int[] ran = new int[10];
		
		
		in(num);
		shu(num, ran);
		print(ran);
	}
	
	//숫자 넣기
	static void in(int[] num) {
		
		for (int i = 0; i < num.length; i++) {
			num[i] = i+1;
		}
	}

	//숫자 섞고 넣기
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

	//숫자출력 ( 정렬포함)
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
