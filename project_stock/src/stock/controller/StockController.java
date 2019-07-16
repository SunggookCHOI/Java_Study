package stock.controller;

import java.util.ArrayList;

import model.domain.Clothes;
import model.domain.Customer;
import stock.exception.NotExistException;
import stock.service.Service;
import stock.view.EndView;
import stock.view.FailView;

public class StockController {
	private static StockController instance = new StockController(); // 컨트롤러를 위한 새로운 객체.
	private Service service = Service.getInstance(); //서비스에서 인스턴스 받아옴.
	
	private StockController() {}
	
	public static StockController getInstance() {
		return instance;
	}
	// -----------------------------재고 관리-------------------------------
	
	//모든 재고 검색
		public void AllStockView() {
			ArrayList<Clothes> allStockList = service.getAllClothes();		
			if(allStockList.size() != 0) {   
				EndView.AllStockListView(allStockList);	
			}else {
				EndView.messageView("상품이 하나도 존재하지 않습니다.");
			}
		}
		//특정 상품 검색 
		public void OneStockView(String name) { //재능 기부 유형 이름으로 검색
			if(service.getClothes(name) != null){
				EndView.stockView(service.getClothes(name));
			} else {
				EndView.messageView("검색 요청하신 상품은 존재하지 않습니다.\n");
				//e.printStackTrace();
			}
		}
		
		//새로운 상품 저장		
//		public void insertStock(Clothes newStock) {
//			service.stockInsert(newStock);
//		}
		
		//존재하는 상품 수정
		public void updateStock(String name, String size, int stock) {
			try {
				service.changeStock(name, size, stock);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
				//e.printStackTrace();
			}	
		}
		
		// 품명으로 가격 변경
		public void updatePrice(String name, int price) {
			try {
				service.changePrice(name, price);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		}
		
		// 상품명으로 상품정보 삭제
//		public void deleteStock(String Name) {
//			try {
//				service.stockDelete(Name);
//			} catch (NotExistException e) {
//				FailView.failMessageView(e.getMessage());
//				//e.printStackTrace();
//			}
//		}
	//-------------------------------고객 관리-----------------------------------
		//고객 검색
		public void searchCustomer(String name) {
			try {
				EndView.messageView(service.getCustomer(name).toString());
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		}
		
		//고객 구매 총액
		public void sumPrice(String name) {
			try {
				EndView.howMuch(name,service.getAmounts(name));
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		}
		
		//장바구니에 물품 추가
		public void addCart(String name,String clothesName, String size) {
			try {
				service.addCart(name, clothesName, size);
			}catch (Exception e) {
				FailView.failMessageView(e.getMessage());
			}
		}
		//장바구니에 물품 삭제
		public void delCart(String name,String clothesName, String size) {
			try {
				service.delCart(name, clothesName, size);
			}catch (Exception e) {
				FailView.failMessageView(e.getMessage());
			}
		}
		
		//특정품목을 구매한 고객 검색
		public void searchSpecificCustomer(String clothes) {
			ArrayList<Customer> allStockList;
			try {
				allStockList = service.searchCustomerWhoBought(clothes);
				EndView.allCustomerView(allStockList);	
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}		
			
		}
}
