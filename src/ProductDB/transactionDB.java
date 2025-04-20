package ProductDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class transactionDB {
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
			//トランザクションのオートコミット解除
			conn.setAutoCommit(false);

			//更新する商品の数というか、更新回数。今回は2回
			int updateCount = 2;
			int result = 0;

			int[] IDs = new int[updateCount];
			int[] prices = new int[updateCount];
			int[] stocks = new int[updateCount];

			for (int i = 0; i < updateCount; i++) {

				Scanner scannerManu = new Scanner(System.in);

				int updateNumber = ('\u2460' + i);

				System.out.println("\n--商品の価格と在庫を更新" + (char) updateNumber + "--");

				System.out.println("商品IDを入力してください :");
				int inputID = scannerManu.nextInt();

				System.out.println("価格を入力してください :");
				int inputPrice = scannerManu.nextInt();

				System.out.println("在庫数を入力してください :");
				int inputStock = scannerManu.nextInt();

				stmt = conn.createStatement();
				String SQL = "UPDATE product_table SET price=" + inputPrice + ", stock="
						+ inputStock + " WHERE id=" + inputID + "";

				int returnUpdate = stmt.executeUpdate(SQL);

				if (returnUpdate == 1) {
					result++;

					IDs[i] = inputID;
					prices[i] = inputPrice;
					stocks[i] = inputStock;

				}

			}

			//成功したとき
			if (result == 2) {
				conn.commit();
				conn.setAutoCommit(true);
				conn.close();
				for (int i = 0; i < updateCount; i++) {
					int updateNumber = ('\u2460' + i);
					System.out.println("更新成功件数:" + result + "件");
					System.out.println("\n更新内容" + (char) updateNumber + ":");
					System.out.println("商品ID: " + IDs[i] + ", 価格: " + prices[i] + ", 在庫数: " + stocks[i]);
				}
				//失敗したとき	
			} else {
				conn.rollback();
				conn.setAutoCommit(true);
				conn.close();
				System.out.println(""+updateCount+"件全ての更新に失敗しました。:");
				System.out.println("更新成功件数:" + result + "件" + "\nロールバックしました。:");

			}

		

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
