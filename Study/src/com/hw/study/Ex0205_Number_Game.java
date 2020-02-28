package com.hw.study;
import java.util.Scanner;
		
public class Ex0205_Number_Game {

	public static void main(String[] args) {
		  /* 숫자게임 20.02.05
		   * 숫자 5개를 연속으로 받는다.
		   * 랜덤수를 구해서 (5자리 같은자리 숫자 비교
		   *
		   */
		  
		  Scanner scan = new Scanner(System.in);
		  int num = 0;
		  String num2 = "";
		  String ran = "";
		  int count = 0;
		  
		//  ran = (int)(Math.random()*99999)+10000;
		//  System.out.println(ran);
		  
		  
		  loop1 : while(true) {
		   System.out.println("숫자 맞추기 프로그램");
		   System.out.println("1~9 숫자 5개를 연속으로 입력해주세요. (종료 : 0)");
		   num = scan.nextInt();
		   
		   if(num == 0) {
		    break loop1;
		   }
		   
		   num2 = num+"";
		   
		   
		   for (int i = 1; i <=5; i++) {
		    ran += (int)(Math.random()*9)+1; //1~9까지의 숫자를 뽑는다.
		   }
		   
		   for (int i = 0; i <=4; i++) {
		    if(num2.charAt(i)==ran.charAt(i)) {
		     count++;
		    }else {
		    }
		   }
		   
		   switch (count) {
		   case 1:
		    System.out.println("뽑은 수 :"+num2);
		    System.out.println("랜덤 수 :"+ran);
		    System.out.println(count+"개 일치 ***축하합니다 1만원 당첨 *****");
		    System.out.println("------------------------------------");
		    break;
		   case 2:
		    System.out.println("뽑은 수 :"+num2);
		    System.out.println("랜덤 수 :"+ran);
		    System.out.println(count+"개 일치 ***축하합니다 10만원 당첨 *****");
		    System.out.println("------------------------------------");
		    break;
		   case 3:
		    System.out.println("뽑은 수 :"+num2);
		    System.out.println("랜덤 수 :"+ran);
		    System.out.println(count+"개 일치 ***축하합니다 100만원 당첨 *****");
		    System.out.println("------------------------------------");
		    break;
		   }
		   
		   
		  }
		  System.out.println("시스템을 종료합니다.");
		
		 
		 
		 }
		}
