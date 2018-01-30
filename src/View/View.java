package View;

import java.util.ArrayList;
import java.util.Scanner;

import FlowerMng.FlowerMng;
import in.InBiz;
import out.OutBiz;
import vo.InVO;
import vo.OutVO;

public class View {

	public static void main(String[] args) {
		/*
		 * 3,100,10000,'cl001') 4,12,10000,'cl001'); 3,10,20000,'cl001');
		 * 5,50,30000,'cl001');
		 */

		Scanner sc = new Scanner(System.in);
		w:while (true) {
			System.out.println("[1] 입고 관리  [2] 출고 관리 [3] 꽃 관리 [4] 나가기");
			int number = sc.nextInt();
			
			switch (number) {
			case 1:
				while (true) {
					System.out.println();
					System.out.println("[1] 입고 정보 조회  [2] 모든 정보 조회 [3] 입고 정보 입력");
					System.out.println("[4] 입고 정보 수정  [5] 입고 정보 삭제 [6] 이전으로");
					InBiz biz = new InBiz();
					InVO in = null;
					ArrayList<InVO> list = null;
					
					int f_code;
					String f_name;
					int amount, p_cost, g_number;

					int select = sc.nextInt();
					switch (select) {
					case 1:
						System.out.println("정보 조회할 '꽃 code' 입력>>");
						f_code = sc.nextInt();
						try {
							in = biz.get(f_code);
							System.out.println(in);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 2:
						try {
							list = biz.get();
							for (InVO o : list) {
								System.out.println(o);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;

					case 3:
						try {
							System.out.println("'꽃 code', '꽃 이름', '원가', '꽃관리 등급' 입력>>");
							f_code = sc.nextInt();
							f_name = sc.next();
							amount = sc.nextInt();
							p_cost = sc.nextInt();
							g_number = sc.nextInt();
							in = new InVO(f_code, f_name, amount, p_cost, g_number);
							biz.register(in);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;

					case 4:
						try {
							System.out.println("정보 수정할 '꽃 code' 입력>>");
							f_code = sc.nextInt();
							System.out.println("수정 내용:'꽃 이름' 입력>>");
							f_name = sc.next();
							System.out.println("수정 내용:'꽃 단수' 입력 >>");
							amount = sc.nextInt();
							System.out.println("수정 내용:'꽃 원가' 입력 >>");
							p_cost = sc.nextInt();
							System.out.println("수정 내용:'꽃 등급' 입력 >>");
							g_number = sc.nextInt();
							in = new InVO(f_code, f_name, amount, p_cost, g_number);
							biz.modify(in);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 5:
						System.out.println("정보 삭제할 '꽃 code' 입력>>");
						f_code = sc.nextInt();
						try {
							biz.remove(f_code);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					
					case 6: continue w;
					}
				}
			case 2:

				while (true) {
					System.out.println();
					System.out.println("[1] 출고 정보 조회  [2] 모든 정보 조회 [3] 출고 정보 입력");
					System.out.println("[4] 출고 정보 수정  [5] 출고 정보 삭제 [6] 이전으로");
					OutBiz biz = new OutBiz();
					OutVO out = null;
					ArrayList<OutVO> list = null;
					int f_code;
					int amount;
					String c_code;

					int select = sc.nextInt();
					switch (select) {
					case 1:
						System.out.println("정보 조회할 '꽃 code' 입력>>");
						f_code = sc.nextInt();
						try {
							out = biz.get(f_code);
		
							System.out.println(out);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;

					case 2:
						try {
							list = biz.get();
							System.out.println(list.get(1));
							for (OutVO o : list) {
								System.out.println(o);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;

					case 3:
						try {
							System.out.println("'꽃 code', '잔량', '거래처 code' 입력>>");
							f_code = sc.nextInt();
							amount = sc.nextInt();
							c_code = sc.next();
							out = new OutVO(f_code, amount, c_code);
							biz.register(out);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;

					case 4:
						try {
							System.out.println("정보 수정할 '꽃 code' 입력>>");
							f_code = sc.nextInt();
							System.out.println("수정 내용:'잔량' 입력>>");
							amount = sc.nextInt();
							System.out.println("수정 내용:'거래처 code' 입력 >>");
							c_code = sc.next();
							out = new OutVO(f_code, amount, c_code);
							biz.modify(out);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 5:
						System.out.println("정보 삭제할 '꽃 code' 입력>>");
						f_code = sc.nextInt();
						try {
							biz.remove(f_code);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 6: continue w;
					default:
						System.out.println("다시 입력하세요");
					}
				}
				
			case 3: 	
				while (true) {
					
					System.out.println("꽃 코드를 입력하세요>>");
					FlowerMng fm = new FlowerMng();
					fm.Alarm(sc.nextInt());
					continue w;
				}

			case 4: break w;
				
			}
		}
	}
}
