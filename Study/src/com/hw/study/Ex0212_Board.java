package com.hw.study;
import java.util.Scanner;

public class Ex0212_Board {

     public static void main(String[] args) {
        // �Խ��� ���α׷�
          // ��ȣ(������ ) �̸� ���� �۳��� (String) ��ȸ�� (int)
          
          
          //10������ �Է°��� -> 1�����ϰ� ����� �� ������.
          //1) �۾���, 2 ���- ����Ʈ 1) �б�,2)����,3)����
          Scanner scan = new Scanner(System.in);
//          int[] num = new int[2];
          String[] sub = {"�۹�ȣ","�̸�","����","�۳���","��ȸ��"};
          String[][] bor = new String[10][5];
          String del = "";
          int count = 0;
          int select = 0;
          int number = 0; //�Խù� ��ȣ ���� �̵�
          

          loop1:
          while(true) {
             if(count >= 10){
                System.out.println("�Է°����� �Խñ� ���� �ʰ��Ͽ� ��ȸ�� �����մϴ�.");
                select = 2;
             }else{
                System.out.println("1) �۾���, 2) �� ���");
                  select = scan.nextInt();
                  
                  if(select < 1 || select > 2) {
                     System.out.println("�ٽ� �Է��ϼ���");
                     continue;
                  }
                  
             }
            
             switch (select) {
             case 1:
//                    num[i] = i+1;
                   for (int j = 0; j < bor[count].length-2; j++) {
                      System.out.println(sub[j+1]+"�� �Է��ϼ���.");
                      bor[count][j] = scan.next();
//                      if(bor[count][j] != Integer){
//                         System.out.println("����");
//                      }
                      
                   }
                   bor[count][bor[count].length-2] = "0";
                   bor[count][bor[count].length-1] = "n";
                   count++;
                     break;
                     

             case 2:
                while(true){
                if(count == 0){
                   System.out.println("---- �Խù��� �����ϴ�. ----");
                   break;
                }
               System.out.println("_____________________________________ �� ��� _________________________________________");
                for (int i = 0; i < sub.length; i++) {
                   System.out.print("\t"+sub[i]+"\t");
                }
                System.out.println();
                for (int i = 0; i < count; i++) {
                	if(bor[i][bor[i].length-1].equals("1")) {
                		System.out.println("������ �Խù��Դϴ�.");
                		i++;
                	}
//                   �۹�ȣ
                   System.out.print("\t"+(i+1)+"\t");
                   for (int j = 0; j < bor[i].length-1; j++) {
                      
                      System.out.print("\t"+bor[i][j]+"\t");
                   }
                   System.out.println();
                }
                System.out.println("____________________________________________________________________________________");
                System.out.println("                           ��ȸ�� �Խù��� ��ȣ�� �����ϼ���. [ �ڷΰ��� ) 0 ��  ]");
                   select = scan.nextInt();
                   if(select == 0){
                      continue loop1;
               }
                   if(select>count || select <0){
                      System.out.println("�߸��� �Է��Դϴ�.");
                      continue;
                   }
                   number = select-1; //�Խù� ��ȣ ���
                   while(true){
                   System.out.println("----------------------------------");
                   System.out.println("����: "+bor[select-1][1]);
                   System.out.println("�̸�: "+bor[select-1][0]);
                   System.out.println("����: "+bor[select-1][2]);
                   bor[select-1][3] = (Integer.parseInt(bor[select-1][3])+1)+"" ;
                  
                   
                   System.out.println("[ ��� ) 0��    / ���� ) 1��  / ���� ) 2��   ]");
                   select = scan.nextInt();
                   
                   switch (select) {
				case 0:
					break;
				case 1:
					System.out.println("�����Ͻ� �κ��� �Է����ּ���");
					System.out.println("1) �̸�  / 2) ����  / 3) ����");
					select = scan.nextInt();
					switch (select) {
					case 1:
						System.out.println("�����Ͻ� �̸��� �Է��ϼ���");
						bor[number][0] = scan.next();
						break;
					case 2:
						System.out.println("�����Ͻ� ������ �Է��ϼ���");
						bor[number][1] = scan.next();
						break;
					case 3:
						System.out.println("�����Ͻ� �̸��� �Է��ϼ���");
						bor[number][2] = scan.next();
						break;
					default:
						break;
					}
					break;
				case 2:
					System.out.println("�Խñ��� �����Ͻðڽ��ϱ�?  ��) 0  , �ƴϿ�) 1");
					select = scan.nextInt();
					if(select < 0 || select >1) {
						System.out.println("�߸��� �Է��Դϴ�.");
						break;
					}else {
						bor[number][bor[number].length-1] = "1";
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					}
					
				default:
					  System.out.println("�߸��� �Է��Դϴ�.");
                      continue;
				}
                   break;
                   /*
                   if(select == 0){
                      break;
                   }else{
                      System.out.println("�߸��� �Է��Դϴ�.");
                      continue;
                   }
                   */
                   
                   }
                }
             }
       
          
          
          
          }//while
          
     }

   
}