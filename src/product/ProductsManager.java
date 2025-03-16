package product;

import java.util.ArrayList;
import java.util.List;

public class ProductsManager {
//Product.javaに対応したリスト(配列)を作成:名前がproductList
//紫のProductはジェネリクス
	public List<Product> productList;
	
	// コンストラクタ
	public ProductsManager() {
		this.productList = new ArrayList<>();
	}

	// Productを追加
	public void addProduct(Product product) {
		productList.add(product);
	}

	// idを指定してProductを削除
//removeIfは条件でリストの要素を削除するメソッド
	//今回はproductのidがremoveProductの引数と同じなら削除するやで
//removeIf内の左のproductにProduct.javaのオブジェクトが入っている(クラスの全ての情報を持ってる)
//productはremoveIf のラムダ式内で productList の各 Product を順番に指す変数
	public void removeProduct(int id) {
		productList.removeIf(product -> product.getId() == id);
	}

	// nameを指定してProductを取得
	public Product getProductByName(String name) {
		for (Product product : productList) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		return null;
	}

	// 商品リストを取得
	public List<Product> getProductList() {
		return productList;
	}
}
