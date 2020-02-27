package com.hw.study;

import java.util.Scanner;

public class Ex0210_Lotto {
	public static void main(String[] args) {
		
		 /* �⺻���� �ζ� ���α׷� ����� 20.02.10
		  * 
		  *  1. �ζǹ�ȣ ���߱� 
		  * (�ɼ� : ���ʽ�ī�� �����ؼ� ��������)
		  *
		  * */
	
		Scanner scan = new Scanner(System.in);
		
		int[] m_num = new int[6]; //���� �Է��� ����
		int[] r_num = new int[7]; //���� ����
		int num1 = 0; //�ӽ�
		int num2 = 0; //�ӽ�
		int num = 0;
		int success = 0;
		int b_chk = 0;
		
		//1-45���� ��Ƴ��´�.
		for (int i = 0; i < r_num.length; i++) {
			r_num[i] = i+1; 
		}
		
		//���� �ٲ��ֱ�
		for (int i = 0; i < 100; i++) {
			num1 = (int)(Math.random()*6); //0~44������ ������(�ڸ����� ���ѰŶ� �������
			
			num2 = r_num[0] ;
			r_num[0] = r_num[num1];
			r_num[num1] = num2;
		}
		
		//�ߺ�üũ ��
		
		loop1:
		for (int i = 0; i < m_num.length; i++) {
			
			System.out.println((i+1)+"��° ���ڸ� �Է��ϼ��� (1-45���� ���ڸ� �Է��ϼ���.)");
			num = scan.nextInt();
			
			//�Է��� �̻��ϸ� ���ƹ�����
				if(num <1 || num > 45) {
					System.out.println("�߸��� �Է��Դϴ�.");
					i--;
					continue;
				}
					for (int j = 0; j < m_num.length; j++) {
						if(m_num[j] == num) {
							System.out.println("�̹� �Է��� ��ȣ�Դϴ�. �ٽ� �Է��ϼ���.");
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
			System.out.println("5�� ��÷");
			break;
		case 4:
			System.out.println("4�� ��÷");
			break;
		case 5:
			for (int i = 0; i < m_num.length; i++) {
				if(r_num[6]==m_num[i]) {
					System.out.println("2�� ��÷");
					b_chk++;
					break;
				}
			}
			if(b_chk == 0) {
				System.out.println("3�� ��÷");
			}
			
			break;
		case 6:
			System.out.println("1�� ��÷");
			break;

		default:
			System.out.println("��÷x");
			break;
		}
		System.out.print("�̹� ȸ�� ��÷��ȣ : ");
		for (int i = 0; i < 7; i++) {
			if(i == 6) {
				System.out.println("���ʽ� ��ȣ :"+r_num[i]+"");
			}else {
				System.out.print(r_num[i]+" ");
			}
			
		}
		
	}
	
}
