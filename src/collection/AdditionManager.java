package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AdditionManager implements collectionSearchable{
	public List<Addition> productList;

	// コンストラクタ
	public AdditionManager() {
		this.productList = new ArrayList<>();
	}

	// Productを追加
	public Addition addProduct(Addition product) {
		productList.add(product);
		return product;
	}

	
	
	public boolean removeProduct(int id) {
	    Iterator<Addition> iterator = productList.iterator(); // イテレータを取得
	    while (iterator.hasNext()) { // 次の要素がある間ループ
	        Addition product = iterator.next(); // 現在の要素を取得
	        if (product.getId() == id) {
	            iterator.remove(); // イテレータ経由で安全に削除
	            return true;
	        }
	    }
	    return false;
	}

	// nameを指定してProductを取得
	public Addition getProductByName(String name) {
		for (Addition product : productList) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		return null;
	}

	// 商品リストを取得
	public List<Addition> getProductList() {
		return productList;
	}

	@Override
	public List<Addition> search(String name) {
		// TODO 自動生成されたメソッド・スタブ
		List<Addition> result = new ArrayList<>();
		for (Addition product : productList) {
			if (product.getName().contains(name)) {//nameを含む
				result.add(product);
			}
		}
		return result;
	}

	//完全一致メソッド
	public List<Addition> searchEquals(String name){
		List<Addition> resultList = new ArrayList<>();
		 for (Addition product2 : productList) {
		        if (product2.getName().equals(name)) { // 完全一致
		            resultList.add(product2);
		        }
		    }
		    return resultList;
	}

}
