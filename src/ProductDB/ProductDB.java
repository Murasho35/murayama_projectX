package ProductDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductDB {
	public static void main(String[] args) {
		//DB接続用定数
		String DATABASE_NAME = "product_management";
		String PROPATIES = "?characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true";
		String URL = "jdbc:mySQL://localhost/" + DATABASE_NAME + PROPATIES;
		//DB接続用・ユーザ定数
		String USER = "root";
		String PASS = "SEInama2011";
		
		  Connection conn = null;
	      Statement stmt = null;
		

		try {
			//MySQL に接続する
			Class.forName("com.mysql.cj.jdbc.Driver");
			//データベースに接続
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = (Statement) conn.createStatement();

			// SQL を実行
			String sqlStr = "SELECT * FROM product_table";
			ResultSet rs = stmt.executeQuery(sqlStr);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("DB接続失敗");
			e.printStackTrace();
		}


		try {
			Scanner scannerManu = new Scanner(System.in);
			
			System.out.println("\n--商品の登録--");
			System.out.println("\n商品名を入力してください :");
			String inputName = scannerManu.next();
			
			System.out.println("価格を入力してください :");
			int inputPrice = scannerManu.nextInt();
			
			System.out.println("在庫数を入力してください :");
			int inputStock = scannerManu.nextInt();
			
			System.out.println("カテゴリーIDを入力してください :");
			int inputID = scannerManu.nextInt();
			
			stmt = conn.createStatement();
			String SQL = "INSERT INTO product_table(id, name, price, stock) VALUES("+inputID+", '"+inputName+"', "+inputPrice+", "+inputStock+") ";
			stmt.executeUpdate(SQL);
			
			System.out.println("登録成功件数: 1件"+"\n登録内容:");
			System.out.print("商品名: "+inputName+", 価格: " +inputPrice+", 在庫数: "+inputStock+", カテゴリーID: "+inputID);
			
			
			scannerManu.close();
			//スキャンたやつを前はproductオブジェクトに入れてたと思うけど
			//今回はSQLのテーブルに入れたいね
			

		}catch(SQLException e) {
			System.out.println("更新成功件数: 0件"+"\n更新失敗");
			e.printStackTrace();
			
			
	}
	
		

	}
}
