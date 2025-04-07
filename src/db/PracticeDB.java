package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PracticeDB {
	public static void main(String[] args) {
		//DB接続用定数
		String DATABASE_NAME = "product_management";
		String PROPATIES = "?characterEncoding=UTF-8&useSSL=false";
		String URL = "jdbc:mySQL://localhost/" + DATABASE_NAME + PROPATIES;
		//DB接続用・ユーザ定数
		String USER = "root";
		String PASS = "SEInama2011";

		try {
			//MySQL に接続する
			Class.forName("com.mysql.cj.jdbc.Driver");
			//データベースに接続
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			  Statement stmt = (Statement) conn.createStatement();

			// データベースに対する処理
			System.out.println("DB接続成功");
			
			 // SQL を実行
		     String sqlStr = "SELECT * FROM product_table";
		     ResultSet rs = stmt.executeQuery(sqlStr);
		     
		     // 結果行をループ 
		     
		     System.out.println("\n--productsテーブルの全ての商品情報を表示--");
		     while(rs.next()){
		       // レコードの値
		       int id = rs.getInt("id");
		       String name = rs.getString("name");
		       int price = rs.getInt("price");
		       int stock = rs.getInt("stock");

		       //表示
		       System.out.println("\nid: "+id);
		       System.out.println("name: "+name);
		       System.out.println("price: "+price);
		       System.out.println("stock: "+stock);
		       System.out.println("category_id: "+id);
		       }

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("DB接続失敗");
			e.printStackTrace();
		}
		//こっからproductsテーブルからのデータ取得
		
		
		
	}

}
