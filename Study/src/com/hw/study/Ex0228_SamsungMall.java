package com.hw.study;
import java.util.Scanner;

public class Ex0228_SamsungMall {
	public static void main(String[] args) {
		/*
		 * 	�Ｚ������ǰ ���� ���α׷�(�������� �̿��Ͽ�) 20.02.28
		 * 
		 * ������, 
		 * 
		 * 
		 * 1)��ǻ��    2)TV   3)�����     4)��Ź��    5)������ 
		 * 6) ���Ź�ǰ, ���űݾ� ���      7)�����ݾ�,���ʽ� ����Ʈ ���
		 * 8)�����ݾ� ����   0 ����
		 * */
		Buyer1 b = new Buyer1();
		
		loop1:
		while(true) {
		Scanner scan = new Scanner(System.in);
		System.out.println("---------------------------------------------");
		System.out.println("1)��ǻ��    2)TV   3)�����     4)��Ź��    5)������ ");
		System.out.println("6) ���Ź�ǰ, ���űݾ� ���      7)�����ݾ�,���ʽ� ����Ʈ ���");
		System.out.println("8)�����ݾ� ����            9)ȯ��            10) �˻�         0) ����");
		System.out.println("---------------------------------------------");
		System.out.println("���Ͻô� ��ȣ�� �Է��ϼ���. >>");
		
		switch (scan.nextInt()) {
		case 1://��ǻ��
			b.buy(new Computer1());
			break;
		case 2://TV
			b.buy(new Tv1());
			break;
		case 3://�����
			b.buy(new Ref1());
			break;
		case 4://��Ź��
			b.buy(new Washer1());
			break;
		case 5://������
			b.buy(new Condi1());
			break;
		case 6://���Ź�ǰ, ���űݾ� ���
			b.buy_list();
			break;
		case 7://�����ݾ�, ���ʽ� ����Ʈ ���
			b.point();
			break;
		case 8://���� �ݾ� ����
			b.charge(); //�����ݾ� ������ �Ѿ��
			break;
		case 9://���� ��ǰ���� ����
			
//			b.buy_list();
			b.delete();
			break;
		case 10://�ý��� ����
			b.search();
			break;
		case 0://�ý��� ����
			System.out.println("�ý����� �����մϴ�.");
			break loop1;

		default:
			System.out.println("�߸��� �Է��Դϴ�.");
			break;
		}
		
		}//while
	}
}

class Buyer1{ //������
	
	
	int money = 100000; //�⺻ �ܾ�
	Product1[] cart = new Product1[10];  //������ ���� ��ǰ �� 
	int cnt = 0;	// ���� ���� ��
	int bonusPoint; //���ʽ� ����Ʈ
	int sum; //���� �ѱݾ�
	int refund=0; //ȯ�� Ƚ��
	
	//���� �޼ҵ�
	void buy(Product1 p) {
		if(cnt == 10) { //���Ű����� 10���̸�
			System.out.println("���� ���ɰ��� �ʰ�");
			return;
		}
		if(money < p.price) { //���� �ܾ��� ��ǰ ���ݺ��� ������
			System.out.println("�ܾ׺���");
			return;
		}
		
		bonusPoint += p.bonusPoint; //���ʽ� ����
		money -= p.price; //���� �ܾ׿��� ��ǰ���� ����
		sum += p.price; //�� ���űݾ�(����) ����
		cart[cnt] = p; //�Ѿ�� ��ǰ�� ������ user�� ��ǰ ����Ʈ�� ��´�.
		System.out.println(p.name+" 1�븦 �����Ͽ����ϴ�.");
		cnt++; //���� ���� ����
		
	}
	
	//���Ÿ�� ����Ʈ
	void buy_list() {
		if(cnt == 0) { //������ ��ǰ�� ���� ���
			System.out.println("�����Ͻ� ��ǰ�� �����ϴ�.");
			return;
		}
		System.out.println("_______________________________________________");
		for (int i = 0; i < cnt; i++) { //���� ������ŭ ��µǵ���
			if(!(cart[i].name.equals(""))){
				System.out.print((i+1)+"."+cart[i].name+"\t"); //������ ����Ʈ�� �̸� ���
			}
		}
		System.out.println();
		System.out.println("�� ��ǰ ���Ű��� :"+(cnt-refund)+"��");
		System.out.println("�� ���� �ݾ�:"+sum+"��");
		System.out.println("_______________________________________________");
	}
	
	//�����ܰ� & ���� ����Ʈ ���
	void point() {
		System.out.println("���� �ܰ�   : "+money); 
		System.out.println("Point  : "+bonusPoint);
	}
	
	//����
	void charge() { //�Ѿ�� �����ݾ�
		Scanner scan = new Scanner(System.in);
		System.out.println(" [ �ݾ����� ] ");
		System.out.println("���ϴ� �ݾ��� �Է��ϼ���.>> 1) ī�����");
		int ch_money = scan.nextInt();
		//ī��ȸ�� - card(num,card_num,ch_money,price); ȸ����ȣ , ī���ȣ, �ݾ�
		//ȸ����ȣ, �ݾ�, true/false
		money += ch_money;
		
		System.out.println(ch_money+"���� �����Ǿ����ϴ�.");
		System.out.println("���� �� �ܾ�  : "+this.money);
	}
	
	//����(ȯ��)
	void delete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("ȯ���� ���Ͻô� ��ǰ�� ��ȣ�� ������");
		buy_list(); //������ ��ǰ�� ��� �ҷ�����
		int num = scan.nextInt();
		
		bonusPoint -= cart[num-1].bonusPoint;
		money += cart[num-1].price;
		sum -= cart[num-1].price;
		cart[num-1].name = "";
		cart[num-1].price = 0;
		refund++;
		System.out.println("ȯ���� �Ϸ�Ǿ����ϴ�.");
	}
	
	void search() {
		System.out.println("[ �˻� - Tv ]");
		int tv_count = 0;
		int com_count = 0;
		int ref_count = 0;
		int washer_count = 0;
		int condi_count = 0;
		for (int i = 0; i < cart.length; i++) {
			if(cart[i] == null) {
				break;
			}
			if(cart[i].name.equals("��ǻ��")) {
				com_count++;
			}else if(cart[i].name.equals("Tv")) {
				tv_count++;
			}else if(cart[i].name.equals("������")) {
				condi_count++;
			}else if(cart[i].name.equals("�����")) {
				ref_count++;
			}else {
				washer_count++;
			}
		}
		System.out.println("��ǻ�� ���Ŵ�� :"+com_count+"��");
		System.out.println(" TV ���Ŵ��  :"+tv_count+"��");
		System.out.println("������ ���Ŵ�� :"+condi_count+"��");
		System.out.println("����� ���Ŵ�� :"+ref_count+"��");
		System.out.println("��Ź�� ���Ŵ�� :"+washer_count+"��");
	}
	
}



class Product1{ //��ǰ
	int price; //��ǰ�� ����
	int bonusPoint; //��ǰ�� ����Ʈ
	String name; //��ǰ�� �̸�
	int product_cnt;//��ǰ�� ���� ����
	int p_cnt; 
	
	Product1() {

	}
	
	Product1(String name, int price, int bonusPoint) {
		this.name = name;
		this.price = price;
		this.bonusPoint = bonusPoint;
	}
	
}

class Computer1 extends Product1{ //��ǻ��
	
	Computer1() {
		super("��ǻ��",100,(100/10));
	}
}

class Tv1 extends Product1{ //Ƽ��
	
	Tv1(){
		super("Tv",200,(200/10));
	}
}

class Ref1 extends Product1{ //�����
	
	Ref1(){
		super("�����",300,(300/10));
	}
}

class Washer1 extends Product1{ //��Ź��
	Washer1(){
		super("��Ź��",400,(400/10));
	}
}

class Condi1 extends Product1{ //������
	
	Condi1(){
		super("������",500,(500/10));
	}
	
}
