package stock.view;

import java.util.ArrayList;

import model.domain.Clothes;
import model.domain.Customer;

public class EndView {
		//��� ��ǰ ���
		public static void AllStockListView(ArrayList<Clothes> allStockList){
			for(int index = 0; index < allStockList.size(); index++){			
				System.out.println("[��ǰ " + (index+1) + "]\n" + allStockList.get(index) +"\n");
			}
		}
		//Ư�� ��ǰ ��� 
		public static void stockView(Clothes stockList){
			System.out.println(stockList);
		}	
		//���ܰ� �ƴ� �ܼ� �޼��� ���
		public static void messageView(String message) {
			System.out.println(message);
		}
		//�ݾ� ���
		public static void howMuch(String name, int amounts) {
			System.out.println(name +"���� �� ���� �ݾ��� " + amounts + " ���Դϴ�"); 
		}
		
		//��� �� ���� ���
	   public static void allCustomerView(ArrayList<Customer> allCustomerList) {
	      for(int index = 0; index < allCustomerList.size(); index++){         
	         System.out.println("[��"  + (index+1) + "]\n" + allCustomerList.get(index) +"\n");
	      }
	   }

}
