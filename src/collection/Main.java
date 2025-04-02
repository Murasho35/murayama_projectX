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
		//2は前回のnameだけで検索するやつを実装できればいいのでは
		//2と3一緒になってるから、2をあたらしくsearch2みたいなメソッド作って完全一致検索してあげたい

		do {

			//メニューを表示！
			System.out.println(manuDisplay);

			//メニュー番号スキャン
			manuNumber = scannerManu.nextInt();

			//1の場合の表示と処理
			switch ((int) manuNumber) {

			case 1:

				try {
					System.out.println("商品IDを入力してください:");
					//IDの入力
					int inputId = scannerManu.nextInt();
					System.out.println("入力された商品ID : " + inputId);
					System.out.println("商品名を入力してください:");

					//商品名の入力
					String inputName = scannerManu.next();
					//例外処理
					if (inputName.isEmpty()) {
						System.out.println("無効な入力です。入力された商品名 : " + inputName);
						throw new Exception("無効な商品名です。商品を正しく入力してください。");
					}//ここまで例外処理
					System.out.println("入力された商品名 : " + inputName);
					System.out.println("価格を入力してください:");
					

					//価格の入力
					int inputPrice = scannerManu.nextInt();
					//例外処理
					if (inputPrice < 0) {
						System.out.println("無効な入力です。入力された価格 : " + inputPrice);
						throw new Exception("無効な入力です。価格を正しく入力してください。");
					}//ここまで例外処理
					
					System.out.println("入力された価格 : " + inputPrice);
					System.out.println("在庫数を入力してください:");
				
					//在庫の入力
					int inputStock = scannerManu.nextInt();
					//例外処理
					if (inputStock < 0) {
						System.out.println("無効な入力です。入力された在庫数 : " + inputPrice);
						throw new Exception("無効な入力です。在庫を正しく入力してください。");
					}//ここまで例外処理
					System.out.println("入力された価格 : " + inputStock);
					

					//最後
					Addition product = manager.addProduct(new Addition(inputId, inputName, inputPrice, inputStock));
					System.out.println(product + "を登録しました。");
				} catch (Exception e) {e.printStackTrace();

				}
				break;

			case 2:
				//2の場合の表示と処理

				System.out.println("商品情報を取得する商品名を入力してください:");
				//商品名の入力
				String inputName2 = scannerManu.next();

				List<Addition> searchResults2 = manager.searchEquals(inputName2);
				if (!searchResults2.isEmpty()) {
					for (Addition product2 : searchResults2) {
						System.out.println(product2);
					}}
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
				System.out.println("商品IDが" + inputID5 + "の商品を削除しました");

			}
		} while (manuNumber != 0);

		//0の場合の表示と処理
		System.out.println("終了します");

		scannerManu.close();
	}
}
