package com.hw.study;
import java.util.Scanner;

public class Ex0226_Poker {

	public static void main(String[] args) {
		  /*ī����� ���α׷�
		   *�� ���� 3�徿 ���������� 1���� �����Ѵ�. �迭�� ��´�. ���Ͳ� ����  
		   * ī��ޱ� ������ ���徿 �߰��Ǿ �� 7�� 
		   * 1) ���ӽ��� 3�徿 
		   * 2) 1�徿 �߰� ��ü ������
		   * 3) ����
		   * */
		  Scanner scan = new Scanner(System.in);
		  Deck d = new Deck(); //52���� ī�尡 ���´� (������)
		  Card[] com = new Card[7];
		  Card[] user = new Card[7];
		  int cnt = 0;
		  
		
		  while(true) {
		  
		  System.out.println("1) �����ӽ���       2) ī��ޱ�    3) Ŭ�ι����� ");
		  System.out.println("���ϴ� ��ȣ�� �Է��ϼ���.>>");
		  
		  switch (scan.nextInt()) {
		  case 1:
		   d.shuffle(); //���´�.
		   cnt = 0;
		   
		   for (int i = 0; i < 3; i++) {
		    com[i] = d.pick(i);
		    cnt++;
		   }
		   for (int i = 0; i < 3; i++) {
		    user[i] = d.pick(cnt);
		    cnt++;
		   }
		   print(com,user,cnt);
		   break;
		  case 2:
		   if(cnt >= 14) {
		    System.out.println("ī��ޱ� �Ұ�");
		    break;
		   }
		   
		   com[cnt/2] = d.pick(cnt);
		   user[cnt/2] = d.pick(cnt+1);
		   cnt+=2;
		   print(com,user,cnt);
		   
		   break;
		  case 3:
		   clo_chk(com,user,cnt);
		   break;
		  default:
		   System.out.println("�߸��� �Է��Դϴ�.");
		   break;
		  }
		  
		 }
		}
		 //��� �޼ҵ�
		 static void print(Card[] com,Card[] user,int cnt) {
		  System.out.print("��ǻ���� ī��:\t");
		  for (int i = 0; i < cnt/2; i++) {
		//   System.out.print("\t  ( card )");
		   System.out.print("\t("+(i+1)+") "+com[i]);
		  }
		  System.out.println();
		  
		  System.out.print("�� ī��:\t\t");
		  for (int i = 0; i < cnt/2; i++) {
		   System.out.print("\t("+(i+1)+") "+user[i]);
		  }
		  System.out.println();
		//  System.out.println("���Ͻô� ī�带 �������ּ���.");
		 }
		 
		 //Ŭ�ι��� ���� ���ϱ�
		 static void clo_chk(Card[] com, Card[] user, int cnt) {
		  int u_chk = 0;
		  int c_chk = 0;
		  for (int i = 0; i < cnt/2; i++) {
		   if(user[i].kind==1) {
		    u_chk++;
		   }
		   if(com[i].kind==1) {
		    c_chk++;
		   }
		  }
		  System.out.println("��ǻ���� Ŭ�ι� ���� :"+c_chk);
		  System.out.println("������ Ŭ�ι� ���� :"+u_chk);
		  
		 }
		 
		}
		
		class Card{
			static final int NUM_MAX = 13;
			static final int KIND_MAX = 4;
			
			static final int CLOVER = 1;
			static final int HEART = 2;
			static final int DIAMIND = 3;
			static final int SPADE = 4;
			
			int kind;
			int number;
			
			Card(){
				super(); //�ڵ�����
				//�����ڿ� �ƹ��͵� ������ �Ʒ� �����ε��� �����ڿ��� super�� �����ȴ�
		//		this(1,CLOVER); ������ ������ ȣ���ϴ� �����ڷ� ���� super�Ⱥ���
			}
			
			Card(int kind, int number){
				super(); //�ڵ�����
				this.kind = kind;
				this.number = number;
			}
			//���
			public String toString() { //toString -> Object���� ������ �޼ҵ� (�������̵�)
				String[] kinds = {"","CLOVER","HEAER","DIAMOND","SPADE"};
				String numbers = "0123456789XJQK";
				return kinds[kind]+" "+numbers.charAt(number);
			}
			
		}
		
		
		class Deck {
			static final int CARD_MAX = 52;
			Card[] cardArr = new Card[CARD_MAX];
			
			Deck(){
				for (int i = 0; i < Card.KIND_MAX; i++) {
					for (int j = 0; j < Card.NUM_MAX; j++) {
						cardArr[(i*13)+j] = new Card(i+1,j+1);
					}
				}
			}
			
			//�Է¹��� ī�� ���
			Card pick(int index) {
				return cardArr[index];
			}
			
			//����ī�� ���
			Card pick() {
				int index = 0;
				index = (int)(Math.random()*CARD_MAX);
				return cardArr[index];
			}
			
			//ī�� ����
			
			void shuffle() {
				for (int i = 0; i < 2000; i++) {
					int num = (int)(Math.random()*CARD_MAX);
					
					Card temp = cardArr[0];
					cardArr[0] = cardArr[num];
					cardArr[num] = temp;
				}
			}
		}
