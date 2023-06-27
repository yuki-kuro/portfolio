
import java.util.List;

import dao.SavedataDAO;
import model.Result;

public class Main {

	public static void main(String[] args) {
		// employeeテーブルの全レコードを取得
		SavedataDAO savedataDAO = new SavedataDAO();
		List<Result> rList = savedataDAO.findAll();

		// 取得したレコードの内容を出力
		for (Result emp : rList) {
			System.out.println("ID:" + emp.getId());
			System.out.println("名前:" + emp.getWin());
			System.out.println("年齢:" + emp.getLose() + "\n");
		}

	}

}
