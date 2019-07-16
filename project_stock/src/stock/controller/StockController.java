package stock.controller;

import java.util.ArrayList;

import model.domain.Clothes;
import model.domain.Customer;
import stock.exception.NotExistException;
import stock.service.Service;
import stock.view.EndView;
import stock.view.FailView;

public class StockController {
	private static StockController instance = new StockController(); // ��Ʈ�ѷ��� ���� ���ο� ��ü.
	private Service service = Service.getInstance(); //���񽺿��� �ν��Ͻ� �޾ƿ�.
	
	private StockController() {}
	
	public static StockController getInstance() {
		return instance;
	}
	// -----------------------------��� ����-------------------------------
	
	//��� ��� �˻�
		public void AllStockView() {
			ArrayList<Clothes> allStockList = service.getAllClothes();		
			if(allStockList.size() != 0) {   
				EndView.AllStockListView(allStockList);	
			}else {
				EndView.messageView("��ǰ�� �ϳ��� �������� �ʽ��ϴ�.");
			}
		}
		//Ư�� ��ǰ �˻� 
		public void OneStockView(String name) { //��� ��� ���� �̸����� �˻�
			if(service.getClothes(name) != null){
				EndView.stockView(service.getClothes(name));
			} else {
				EndView.messageView("�˻� ��û�Ͻ� ��ǰ�� �������� �ʽ��ϴ�.\n");
				//e.printStackTrace();
			}
		}
		
		//���ο� ��ǰ ����		
//		public void insertStock(Clothes newStock) {
//			service.stockInsert(newStock);
//		}
		
		//�����ϴ� ��ǰ ����
		public void updateStock(String name, String size, int stock) {
			try {
				service.changeStock(name, size, stock);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
				//e.printStackTrace();
			}	
		}
		
		// ǰ������ ���� ����
		public void updatePrice(String name, int price) {
			try {
				service.changePrice(name, price);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		}
		
		// ��ǰ������ ��ǰ���� ����
//		public void deleteStock(String Name) {
//			try {
//				service.stockDelete(Name);
//			} catch (NotExistException e) {
//				FailView.failMessageView(e.getMessage());
//				//e.printStackTrace();
//			}
//		}
	//-------------------------------�� ����-----------------------------------
		//�� �˻�
		public void searchCustomer(String name) {
			try {
				EndView.messageView(service.getCustomer(name).toString());
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		}
		
		//�� ���� �Ѿ�
		public void sumPrice(String name) {
			try {
				EndView.howMuch(name,service.getAmounts(name));
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		}
		
		//��ٱ��Ͽ� ��ǰ �߰�
		public void addCart(String name,String clothesName, String size) {
			try {
				service.addCart(name, clothesName, size);
			}catch (Exception e) {
				FailView.failMessageView(e.getMessage());
			}
		}
		//��ٱ��Ͽ� ��ǰ ����
		public void delCart(String name,String clothesName, String size) {
			try {
				service.delCart(name, clothesName, size);
			}catch (Exception e) {
				FailView.failMessageView(e.getMessage());
			}
		}
		
		//Ư��ǰ���� ������ �� �˻�
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
