package com.hw.study;

import java.util.Scanner;

public class Ex0210_Lotto {
	public static void main(String[] args) {
		
		 /* 기본적인 로또 프로그램 만들기 20.02.10
		  * 
		  *  1. 로또번호 맞추기 
		  * (옵션 : 보너스카드 포함해서 만들어보세용)
		  *
		  * */
	
		Scanner scan = new Scanner(System.in);
		
		int[] m_num = new int[6]; //내가 입력할 숫자
		int[] r_num = new int[7]; //랜덤 숫자
		int num1 = 0; //임시
		int num2 = 0; //임시
		int num = 0;
		int success = 0;
		int b_chk = 0;
		
		//1-45까지 담아놓는다.
		for (int i = 0; i < r_num.length; i++) {
			r_num[i] = i+1; 
		}
		
		//숫자 바꿔주깅
		for (int i = 0; i < 100; i++) {
			num1 = (int)(Math.random()*6); //0~44까지의 랜덤수(자리수를 위한거라 상관없음
			
			num2 = r_num[0] ;
			r_num[0] = r_num[num1];
			r_num[num1] = num2;
		}
		
		//중복체크 ㅜ
		
		loop1:
		for (int i = 0; i < m_num.length; i++) {
			
			System.out.println((i+1)+"번째 숫자를 입력하세요 (1-45까지 숫자를 입력하세요.)");
			num = scan.nextInt();
			
			//입력이 이상하면 막아버리기
				if(num <1 || num > 45) {
					System.out.println("잘못된 입력입니다.");
					i--;
					continue;
				}
					for (int j = 0; j < m_num.length; j++) {
						if(m_num[j] == num) {
							System.out.println("이미 입력한 번호입니다. 다시 입력하세요.");
							i--;
							continue loop1;
						}
					}
					m_num[i] = num;
				}
		
		
		for (int i = 0; i < m_num.length; i++) {
			for (int j = 0; j < r_num.length-1; j++) {
				if(r_num[j] == m_num[i]) {
					success++;
				}
			}
		}
		
		switch (success) {
		case 3:
			System.out.println("5등 당첨");
			break;
		case 4:
			System.out.println("4등 당첨");
			break;
		case 5:
			for (int i = 0; i < m_num.length; i++) {
				if(r_num[6]==m_num[i]) {
					System.out.println("2등 당첨");
					b_chk++;
					break;
				}
			}
			if(b_chk == 0) {
				System.out.println("3등 당첨");
			}
			
			break;
		case 6:
			System.out.println("1등 당첨");
			break;

		default:
			System.out.println("당첨x");
			break;
		}
		System.out.print("이번 회차 당첨번호 : ");
		for (int i = 0; i < 7; i++) {
			if(i == 6) {
				System.out.println("보너스 번호 :"+r_num[i]+"");
			}else {
				System.out.print(r_num[i]+" ");
			}
			
		}
		
	}
	
}
