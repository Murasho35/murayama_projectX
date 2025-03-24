package product;

public class main {
	public static void main(String[] args) {
		//managerって変数はProductManagerのコンストラクタと対応(配列扱い？)
		//ProductManagerの要素を包括して持つmanagerってオブジェクトをつくってる？
		ProductsManager manager = new ProductsManager();

		// 商品を追加(new ProductはProductクラスのコンストラクタに対応している)
		//managerのaddProductって意味で、上の行でmanagerってオブジェクト作ってる
		manager.addProduct(new Product(1, "冷蔵庫", 50000, 10));
		manager.addProduct(new Product(2, "ソファ", 30000, 5));
		manager.addProduct(new Product(3, "米", 2000, 3));
		manager.addProduct(new Product(4, "小説", 1500, 4));
		manager.addProduct(new Product(5, "Tシャツ", 1500, 5));

		// 商品リストを表示
		System.out.println("---商品を5つ追加して全てを表示する---");
		for (Product product : manager.getProductList()) {
			System.out.println(product);
		}

		// 商品を1つ削除
		manager.removeProduct(1);

		// 削除後の商品リストを表示
		System.out.println("\n---商品を1つ削除して全てを表示する---");
		for (Product product : manager.getProductList()) {
			System.out.println(product);
		}

		// 商品名「米」の情報を表示
		System.out.println("\n---商品名「米」の情報を表示する---");
		Product foundProduct = manager.getProductByName("米");
		System.out.println(foundProduct);

		Product sofaProduct = manager.getProductByName("ソファ");
		DiscountedProduct afterDiscountPrice = new DiscountedProduct(
				sofaProduct.getId(),
				sofaProduct.getName(),
				sofaProduct.getPrice(),
				sofaProduct.getStock());

		//ソファの割引後も表示
		int resultDiscount = afterDiscountPrice.calulateDiscountedPrice(sofaProduct.getPrice());
		System.out.println("\n--商品名「ソファ」の情報と割引率30%の情報を表示する--");
		Product foundProduct2 = manager.getProductByName("ソファ");
		System.out.print(foundProduct2);
		System.out.print(", 割引後価格=");
		System.out.println(resultDiscount);//割引後の値段の変数を引数として入れてあげたい！1

		// 商品名「Tシャツ」の情報を検索して表示
		System.out.println("\n---商品名「Tシャツ」を検索して表示する---");
		Product searchResult = manager.search("Tシャツ");
		System.out.println(searchResult);

	}

}
