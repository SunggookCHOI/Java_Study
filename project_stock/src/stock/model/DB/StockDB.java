package stock.model.DB;

import java.util.ArrayList;
import java.util.Arrays;
import lombok.Data;
import model.domain.Clothes;

public class StockDB {
	private static StockDB instance = new StockDB();
	private ArrayList<Clothes> stockList = new ArrayList<Clothes>();
	private StockDB() {
		stockList.add(new Clothes("반팔폴로셔츠",19900,new ArrayList<>(Arrays.asList("90", "95","100")),
				"Top", "Grey", new ArrayList<Integer>(Arrays.asList(2,3,1))));
		stockList.add(new Clothes("스트라이프폴로셔츠",19900,new ArrayList<>(Arrays.asList("90", "95","100")),
				"Top", "White", new ArrayList<Integer>(Arrays.asList(1,2,3))));
		stockList.add(new Clothes("슬림피트데미지진",29900,new ArrayList<>(Arrays.asList("90", "95","100")),
				"Trousers", "Indigo", new ArrayList<Integer>(Arrays.asList(1,1,1))));
		stockList.add(new Clothes("셀비지슬림피트진",59900,new ArrayList<>(Arrays.asList("90", "95","100")),
				"Trousers", "White", new ArrayList<Integer>(Arrays.asList(1,1,1))));
		
	}
	public static StockDB getInstance() {
		return instance;
	}
	public ArrayList<Clothes> getStockList(){
		return stockList;
	}
	public void insertProject(Clothes newProject) {
		stockList.add(newProject);
	}
}
