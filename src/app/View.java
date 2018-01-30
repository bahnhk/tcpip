package app;

import java.util.ArrayList;
import java.util.Scanner;

import com.product.ProductBiz;
import com.user.UserBiz;
import com.vo.ProductVO;
import com.vo.UserVO;

public class View {
	public static void main(String[] args) {

		w: while (true) {
			System.out.println("[1] 사용자정보 업무  [2] 상품정보 업무  [9] 종료");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int select = sc.nextInt();

			switch (select) {
			case 1:
				while (true) {
					System.out.println();
					System.out.println("[1] 사용자 조회      [2] 모든 사용자 조회 [3] 사용자 정보 입력");
					System.out.println("[4] 사용자 정보 수정 [5] 사용자 정보 삭제 [6] 이전으로 돌아가기 [9] 종료");
					UserBiz biz = new UserBiz();
					UserVO user = null;
					ArrayList<UserVO> list = null;
					String id = null;
					String pwd = null;
					String name = null;

					int select2 = sc.nextInt();
					s: switch (select2) {
					case 1:
						System.out.println("정보 조회할 ID입력>>");
						id = sc.next();
						try {
							user = biz.get(id);
							System.out.println(user);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break s;

					case 2:
						try {
							list = biz.get();
							for (UserVO u : list) {
								System.out.println(u);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break s;

					case 3:
						try {
							System.out.println("ID, 비밀번호, 이름>>");
							id = sc.next();
							pwd = sc.next();
							name = sc.next();
							user = new UserVO(id, pwd, name);
							biz.register(user);					
						} catch (Exception e) {
							e.printStackTrace();
						}
						break s;

					case 4:
						try {
							System.out.println("정보 수정할 ID입력>>");
							id = sc.next();
							System.out.println("비밀번호, 이름 입력>>");
							pwd = sc.next();
							name = sc.next();
							user = new UserVO(id, pwd, name);
							biz.modify(user);					
						} catch (Exception e) {
							e.printStackTrace();
						}
						break s;
					case 5:
						System.out.println("정보 삭제할 ID입력>>");
						id = sc.next();
						try {
							biz.remove(id);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break s;
					case 6:
						continue w;
					case 9:
						break w;
					default:
						System.out.println("다시 입력하세요");
					}
				}
			case 2:
				while (true) {
					System.out.println();
					System.out.println("[1] 상품 조회      [2] 모든 상품 조회 [3] 상품 정보 입력");
					System.out.println("[4] 상품 정보 수정 [5] 상품 정보 삭제 [6] 이전으로 돌아가기 [9] 종료");
					ProductBiz biz = new ProductBiz();
					ProductVO product = null;
					ArrayList<ProductVO> list = null;
					int id;
					String name = null;
					double price;

					int select2 = sc.nextInt();
					s: switch (select2) {
					case 1:
						System.out.println("정보 조회할 상품ID입력>>");
						id = sc.nextInt();
						try {
							product = biz.get(id);
							System.out.println(product);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break s;

					case 2:
						try {
							list = biz.get();
							for (ProductVO p : list) {
								System.out.println(p);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break s;

					case 3:
						try {
							System.out.println("ID, 상품명, 가격>>");
							id = sc.nextInt();
							name = sc.next();
							price = sc.nextDouble();
							product = new ProductVO(id, name, price);
							biz.register(product);
							System.out.println(product);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break s;

					case 4:
						try {
							System.out.println("정보 수정할 상품ID입력>>");
							id = sc.nextInt();
							System.out.println("상품명, 가격 입력>>");
							name = sc.next();
							price = sc.nextDouble();
							product = new ProductVO(id, name, price);
							biz.modify(product);
							System.out.println(product);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break s;
					case 5:
						System.out.println("정보 삭제할 ID입력>>");
						id = sc.nextInt();
						try {
							biz.remove(id);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break s;
					case 6:
						continue w;
					case 9:
						break w;
						
					default:
						System.out.println("다시 입력하세요");
					}
				}
			case 9:
				break w;
				
			default:
				System.out.println("다시 입력하세요");
			}
			
		}
	}
}