package collection;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		AdditionManager manager = new AdditionManager();

		Scanner scannerManu = new Scanner(System.in);

		String manuDisplay = "--メニュー--" + "\n1:商品追加" + "\n2:商品情報取得" +
				"\n3:商品検索" + "\n4:商品すべて表示" + "\n5:商品削除" +
				"\n0:終了\n" + "\nメニューから操作を選択してください。";

		int manuNumber;

		//1と3と4と5は完成かな！他がんばれ

		do {
			
			//メニューを表示！
			System.out.println(manuDisplay);

			//メニュー番号スキャン
			manuNumber = scannerManu.nextInt();
			
			//1の場合の表示と処理
			switch ((int) manuNumber) {

			case 1:

				System.out.println("商品IDを入力してください:");
				//IDの入力
				int inputId = scannerManu.nextInt();
				System.out.println("入力された商品ID : " + inputId);
				System.out.println("商品名を入力してください:");
				//商品名の入力
				String inputName = scannerManu.next();
				System.out.println("入力された商品名 : " + inputName);
				System.out.println("価格を入力してください:");
				//価格の入力
				int inputPrice = scannerManu.nextInt();
				System.out.println("入力された価格 : " + inputPrice);
				System.out.println("在庫数を入力してください:");
				//在庫の入力
				int inputStock = scannerManu.nextInt();
				System.out.println("入力された価格 : " + inputStock);

				//最後
				Addition product = manager.addProduct(new Addition(inputId, inputName, inputPrice, inputStock));
				System.out.println(product + "を登録しました。");
				
				break;

			case 2:
				//2の場合の表示と処理

				System.out.println("商品情報を取得する商品名を入力してください:");
				//商品名の入力
				String inputName2 = scannerManu.next();

				Addition searchResult2 = (Addition) manager.search(inputName2);
				System.out.println("取得した商品は、" + searchResult2);
				break;
				
			case 3:
				System.out.println("検索する商品名を入力してください:");
				//商品名の入力
				String inputName3 = scannerManu.next();
				//続く
				List<Addition> searchResults3 = manager.search(inputName3);
				if (!searchResults3.isEmpty()) {
		            for (Addition product3 : searchResults3) {
		                System.out.println(product3);
		            }
		        } else {
		            System.out.println("該当する商品が見つかりませんでした。");
		        }
				
				break;
				
			case 4:
				System.out.println("商品を全てを表示します");
				for (Addition product4 : manager.getProductList()) {
					System.out.println(product4);
				}
				break;
			
			case 5:
				System.out.println("削除する商品のIDを入力してください:");
				int inputID5 = scannerManu.nextInt();
				manager.removeProduct(inputID5);
				System.out.println("商品IDが"+inputID5+"の商品を削除しました");
				
				
			}
		} while (manuNumber != 0);

		//0の場合の表示と処理
		System.out.println("終了します");

		scannerManu.close();
	}
}
