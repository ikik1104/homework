package com.hw.study;
import java.util.Scanner;
		
public class Ex0205_Number_Game {

	public static void main(String[] args) {
		  /* ���ڰ��� 20.02.05
		   * ���� 5���� �������� �޴´�.
		   * �������� ���ؼ� (5�ڸ� �����ڸ� ���� ��
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
		   System.out.println("���� ���߱� ���α׷�");
		   System.out.println("1~9 ���� 5���� �������� �Է����ּ���. (���� : 0)");
		   num = scan.nextInt();
		   
		   if(num == 0) {
		    break loop1;
		   }
		   
		   num2 = num+"";
		   
		   
		   for (int i = 1; i <=5; i++) {
		    ran += (int)(Math.random()*9)+1; //1~9������ ���ڸ� �̴´�.
		   }
		   
		   for (int i = 0; i <=4; i++) {
		    if(num2.charAt(i)==ran.charAt(i)) {
		     count++;
		    }else {
		    }
		   }
		   
		   switch (count) {
		   case 1:
		    System.out.println("���� �� :"+num2);
		    System.out.println("���� �� :"+ran);
		    System.out.println(count+"�� ��ġ ***�����մϴ� 1���� ��÷ *****");
		    System.out.println("------------------------------------");
		    break;
		   case 2:
		    System.out.println("���� �� :"+num2);
		    System.out.println("���� �� :"+ran);
		    System.out.println(count+"�� ��ġ ***�����մϴ� 10���� ��÷ *****");
		    System.out.println("------------------------------------");
		    break;
		   case 3:
		    System.out.println("���� �� :"+num2);
		    System.out.println("���� �� :"+ran);
		    System.out.println(count+"�� ��ġ ***�����մϴ� 100���� ��÷ *****");
		    System.out.println("------------------------------------");
		    break;
		   }
		   
		   
		  }
		  System.out.println("�ý����� �����մϴ�.");
		
		 
		 
		 }
		}
