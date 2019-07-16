package stock.view;

import java.util.ArrayList;
import java.util.Arrays;
import model.domain.Clothes;
import stock.controller.StockController;

public class StartView {

	public static void main(String[] args) {
		// public으로 선언된 객체 타입들을 이용해 starview에 필요한 새로운 변수들 생성
				StockController controller = StockController.getInstance();
				
				//새로운 상품
				Clothes stockNew = new Clothes("헨리넥셔츠", 25900, new ArrayList<>(Arrays.asList("90", "95","100")),
						"Top", "White", new ArrayList<Integer>(Arrays.asList(2,3,1)));
				
				System.out.println("-------------모든 상품 재고 출력-------------");
				controller.AllStockView();
				
				System.out.println("-------------검색 상품 재고 출력-------------");
				controller.OneStockView("반팔폴로셔츠");
				

				System.out.println("==============");
				controller.addCart("최성국", "반팔폴로셔츠", "100");
				
				System.out.println("==============");
				controller.sumPrice("최성국");
				controller.addCart("최성국", "슬림피트데미지진", "100");
				controller.addCart("송시찬", "슬림피트데미지진", "90");
				
				System.out.println("==============");
				controller.searchCustomer("최성국");
				controller.OneStockView("반팔폴로셔츠");
				controller.sumPrice("최성국");
////				
//				System.out.println("==============");
//				controller.delCart("최성국", "반팔폴로셔츠", "100");
//				controller.searchCustomer("최성국");
//				controller.sumPrice("최성국");
//				
//				
//				System.out.println("==============");
//				controller.OneStockView("슬림피트데미지진");
//				
//				System.out.println("==============");
//				controller.addCart("최성국", "슬림피트데미지진", "100");
//				
				System.out.println("=============");
				System.out.println("=============");
				System.out.println("=============");
				controller.searchSpecificCustomer("반팔폴로셔츠2");
	}
}