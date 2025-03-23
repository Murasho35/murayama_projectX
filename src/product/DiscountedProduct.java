package product;

public class DiscountedProduct extends Product {

	double discountRate = 0.3;
	
	DiscountedProduct(int id, String name, int price, int stock) {
		super(id, name, price, stock);
		// TODO 自動生成されたコンストラクター・スタブ
	}
//最初の呪文まだ書いてないpublic static void main(String[] args) {
	//priceのとこに指定したidのpriceをいれてあげたい！2
	

	public int calulateDiscountedPrice(int price) {
		
		int afterDiscountPrice = (int)(price*(1 - discountRate));
		
		return afterDiscountPrice;

	}

}
