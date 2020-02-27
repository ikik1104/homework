package com.hw.study;
import java.util.Scanner;

public class Ex0212_Board {

     public static void main(String[] args) {
        // 게시판 프로그램
          // 번호(순차적 ) 이름 제목 글내용 (String) 조회수 (int)
          
          
          //10개까지 입력가능 -> 1개만하고 물어본다 더 쓸건지.
          //1) 글쓰기, 2 목록- 리스트 1) 읽기,2)수정,3)삭제
          Scanner scan = new Scanner(System.in);
//          int[] num = new int[2];
          String[] sub = {"글번호","이름","제목","글내용","조회수"};
          String[][] bor = new String[10][5];
          String del = "";
          int count = 0;
          int select = 0;
          int number = 0; //게시물 번호 같이 이동
          

          loop1:
          while(true) {
             if(count >= 10){
                System.out.println("입력가능한 게시글 수가 초과하여 조회만 가능합니다.");
                select = 2;
             }else{
                System.out.println("1) 글쓰기, 2) 글 목록");
                  select = scan.nextInt();
                  
                  if(select < 1 || select > 2) {
                     System.out.println("다시 입력하세요");
                     continue;
                  }
                  
             }
            
             switch (select) {
             case 1:
//                    num[i] = i+1;
                   for (int j = 0; j < bor[count].length-2; j++) {
                      System.out.println(sub[j+1]+"를 입력하세요.");
                      bor[count][j] = scan.next();
//                      if(bor[count][j] != Integer){
//                         System.out.println("ㅎㅇ");
//                      }
                      
                   }
                   bor[count][bor[count].length-2] = "0";
                   bor[count][bor[count].length-1] = "n";
                   count++;
                     break;
                     

             case 2:
                while(true){
                if(count == 0){
                   System.out.println("---- 게시물이 없습니다. ----");
                   break;
                }
               System.out.println("_____________________________________ 글 목록 _________________________________________");
                for (int i = 0; i < sub.length; i++) {
                   System.out.print("\t"+sub[i]+"\t");
                }
                System.out.println();
                for (int i = 0; i < count; i++) {
                	if(bor[i][bor[i].length-1].equals("1")) {
                		System.out.println("삭제된 게시물입니다.");
                		i++;
                	}
//                   글번호
                   System.out.print("\t"+(i+1)+"\t");
                   for (int j = 0; j < bor[i].length-1; j++) {
                      
                      System.out.print("\t"+bor[i][j]+"\t");
                   }
                   System.out.println();
                }
                System.out.println("____________________________________________________________________________________");
                System.out.println("                           조회할 게시물을 번호를 선택하세요. [ 뒤로가기 ) 0 번  ]");
                   select = scan.nextInt();
                   if(select == 0){
                      continue loop1;
               }
                   if(select>count || select <0){
                      System.out.println("잘못된 입력입니다.");
                      continue;
                   }
                   number = select-1; //게시물 번호 담기
                   while(true){
                   System.out.println("----------------------------------");
                   System.out.println("제목: "+bor[select-1][1]);
                   System.out.println("이름: "+bor[select-1][0]);
                   System.out.println("내용: "+bor[select-1][2]);
                   bor[select-1][3] = (Integer.parseInt(bor[select-1][3])+1)+"" ;
                  
                   
                   System.out.println("[ 목록 ) 0번    / 수정 ) 1번  / 삭제 ) 2번   ]");
                   select = scan.nextInt();
                   
                   switch (select) {
				case 0:
					break;
				case 1:
					System.out.println("수정하실 부분을 입력해주세요");
					System.out.println("1) 이름  / 2) 제목  / 3) 내용");
					select = scan.nextInt();
					switch (select) {
					case 1:
						System.out.println("수정하실 이름을 입력하세요");
						bor[number][0] = scan.next();
						break;
					case 2:
						System.out.println("수정하실 제목을 입력하세요");
						bor[number][1] = scan.next();
						break;
					case 3:
						System.out.println("수정하실 이름을 입력하세요");
						bor[number][2] = scan.next();
						break;
					default:
						break;
					}
					break;
				case 2:
					System.out.println("게시글을 삭제하시겠습니까?  네) 0  , 아니오) 1");
					select = scan.nextInt();
					if(select < 0 || select >1) {
						System.out.println("잘못된 입력입니다.");
						break;
					}else {
						bor[number][bor[number].length-1] = "1";
						System.out.println("삭제가 완료되었습니다.");
					}
					
				default:
					  System.out.println("잘못된 입력입니다.");
                      continue;
				}
                   break;
                   /*
                   if(select == 0){
                      break;
                   }else{
                      System.out.println("잘못된 입력입니다.");
                      continue;
                   }
                   */
                   
                   }
                }
             }
       
          
          
          
          }//while
          
     }

   
}