package stock.view;

import java.util.ArrayList;
import java.util.Arrays;
import model.domain.Clothes;
import stock.controller.StockController;

public class StartView {

	public static void main(String[] args) {
		// public���� ����� ��ü Ÿ�Ե��� �̿��� starview�� �ʿ��� ���ο� ������ ����
				StockController controller = StockController.getInstance();
				
				//���ο� ��ǰ
				Clothes stockNew = new Clothes("��ؼ���", 25900, new ArrayList<>(Arrays.asList("90", "95","100")),
						"Top", "White", new ArrayList<Integer>(Arrays.asList(2,3,1)));
				
				System.out.println("-------------��� ��ǰ ��� ���-------------");
				controller.AllStockView();
				
				System.out.println("-------------�˻� ��ǰ ��� ���-------------");
				controller.OneStockView("�������μ���");
				

				System.out.println("==============");
				controller.addCart("�ּ���", "�������μ���", "100");
				
				System.out.println("==============");
				controller.sumPrice("�ּ���");
				controller.addCart("�ּ���", "������Ʈ��������", "100");
				controller.addCart("�۽���", "������Ʈ��������", "90");
				
				System.out.println("==============");
				controller.searchCustomer("�ּ���");
				controller.OneStockView("�������μ���");
				controller.sumPrice("�ּ���");
////				
//				System.out.println("==============");
//				controller.delCart("�ּ���", "�������μ���", "100");
//				controller.searchCustomer("�ּ���");
//				controller.sumPrice("�ּ���");
//				
//				
//				System.out.println("==============");
//				controller.OneStockView("������Ʈ��������");
//				
//				System.out.println("==============");
//				controller.addCart("�ּ���", "������Ʈ��������", "100");
//				
				System.out.println("=============");
				System.out.println("=============");
				System.out.println("=============");
				controller.searchSpecificCustomer("�������μ���2");
	}
}