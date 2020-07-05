package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DetailProduct;
import model.Product;
import model.ProductInCart;
import model.SearchProduct;

public class ProductDAO {
	// データベース接続に使用する情報
		private String url = "jdbc:mysql://localhost/gwec";
		private String id = "root";
		private String pass ="1qaz2wSX?";
		private String searchResults; // 商品検索時の検索数
		private String searchPartResults;//何件表示させたか
		private String pageNo="1"; // 商品検索時のページ数
		PreparedStatement pStmt;
		Connection conn;

		public String getSearchResults() {
			return searchResults;
		}

		public String getSearchPartResults() {
			return searchPartResults;
		}

		public String getPageNo() {
			return pageNo;
		}



		public List<Product> searchByproduct(SearchProduct searchProduct) { //商品リストの習得
			List<Product> productList = new ArrayList<>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url,id,pass);

				//INSERT準備をして検索したワードを含むインスタンスを生成
				String sql = "SELECT * FROM ProductTbl WHERE product_name like ? ORDER BY product_id ASC LIMIT 10";
				pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, "%" + searchProduct.getSearchItemName() + "%");

				//SELECT文を実行し結果表を作成
				ResultSet rs = pStmt.executeQuery();
				//一致した商品があった場合Productインスタンスを生成しListに格納する
//				if(!rs.next()) {
//					productList= null;
//				}
				int resultlistCount =0; //全部で何件リストにいれたか
					while(rs.next()) {
						int product_id = rs.getInt("product_id");
						int category_id = rs.getInt("category_id");
						String product_name = rs.getString("product_name");
						int product_price = rs.getInt("product_price");
						String product_img = rs.getString("product_img");
						String product_detail = rs.getString("product_detail");
						String del_flg = rs.getString("del_flg");
						String ins_date = rs.getString("ins_date");
						String upd_date = rs.getString("upd_date");

						Product product = new Product(product_id, category_id, product_name, product_price, product_img, product_detail, del_flg, ins_date, upd_date);
						productList.add(product);
						resultlistCount++;
					}
					searchPartResults = Integer.toString(resultlistCount);
				//検索結果は合計何件か計算する
				//INSERT準備をして検索したワードを含むインスタンスを生成
				sql = "SELECT * FROM ProductTbl WHERE product_name like ? ORDER BY product_id  ASC";
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, "%" + searchProduct.getSearchItemName() + "%");
				rs = pStmt.executeQuery();
				int allCount = 0;
				while(rs.next()) {
					allCount++;
					}
					searchResults = Integer.toString(allCount);

			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				try {
					if(conn != null) conn.close();
					if(pStmt !=null) pStmt.close();
					return productList;
				} catch (Exception ex) {}
			}
			return productList;

		}

		public List<Product> searchByproduct(SearchProduct searchProduct, int nowPage) { //商品リストの習得しページ変更
			List<Product> productList = new ArrayList<>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url,id,pass);

				//INSERT準備をして検索したワードを含むインスタンスを生成
				String sql = "SELECT * FROM ProductTbl WHERE product_name like ? ORDER BY product_name  ASC LIMIT 10 OFFSET ?";
				pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, "%" + searchProduct.getSearchItemName() + "%");
				pStmt.setInt(2,(nowPage-1)*10);



//				searchResults = pStmt.executeUpdate();
				pageNo = Integer.toString(nowPage);
				//SELECT文を実行し結果表を作成
				ResultSet rs = pStmt.executeQuery();
				//一致した商品があった場合Productインスタンスを生成しListに格納する
//				if(!rs.next()) {
//					productList= null;
//				}

				int resultlistCount =0; //全部で何件リストにいれたか
					while(rs.next() ) {
						int product_id = rs.getInt("product_id");
						int category_id = rs.getInt("category_id");
						String product_name = rs.getString("product_name");
						int product_price = rs.getInt("product_price");
						String product_img = rs.getString("product_img");
						String product_detail = rs.getString("product_detail");
						String del_flg = rs.getString("del_flg");
						String ins_date = rs.getString("ins_date");
						String upd_date = rs.getString("upd_date");

						Product product = new Product(product_id, category_id, product_name, product_price, product_img, product_detail, del_flg, ins_date, upd_date);
						productList.add(product);
						resultlistCount++;

					}
					searchPartResults = Integer.toString(resultlistCount);
					//検索結果は合計何件か計算する
					//INSERT準備をして検索したワードを含むインスタンスを生成
					sql = "SELECT * FROM ProductTbl WHERE product_name like ?";
					pStmt = conn.prepareStatement(sql);
					pStmt.setString(1, "%" + searchProduct.getSearchItemName() + "%");
					rs = pStmt.executeQuery();
					int allCount = 0;
					while(rs.next()) {
						allCount++;
						}
						searchResults = Integer.toString(allCount);



			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				try {
					if(pStmt !=null) pStmt.close();
					if(conn != null) conn.close();
					return productList;
				} catch (Exception ex) {}
			}
			return productList;

		}

		public DetailProduct getProductDetail(String getProduct_name) { //商品詳細データの習得
			DetailProduct detailProduct = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url,id,pass);

				//SELECT文を準備
				String sql = "select ProductTbl.product_name,ProductTbl.product_price,CategoryTbl.category_name,StockTbl.stock,ProductTbl.product_detail,ProductTbl.product_img";
						sql += " from ProductTbl inner join StockTbl on ProductTbl.product_id = StockTbl.product_id inner join CategoryTbl";
							sql	+= " on ProductTbl.category_id = CategoryTbl.category_id WHERE ProductTbl.product_name = ?;";
				pStmt = conn.prepareStatement(sql);

				pStmt.setString(1,getProduct_name);

				//SELECT文を実行し結果表を作成
				ResultSet rs = pStmt.executeQuery();
//				boolean test = rs.next();
//				if(rs.next() == test) { System.out.println("エラー");}
				//一致した商品があった場合Productインスタンスを生成
					if(rs.next()) {
						String product_name = rs.getString("product_name");
						int product_price = rs.getInt("product_price");
						String category_name = rs.getString("category_name");
						int stock = rs.getInt("stock");
						String product_detail = rs.getString("product_detail");
						String product_img = rs.getString("product_img");

						detailProduct = new DetailProduct(product_name,product_price,category_name,stock,product_detail,product_img);
					}

			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				try {
					if(conn != null) conn.close();
					if(pStmt !=null) pStmt.close();
					return detailProduct;
				} catch (Exception ex) {}
			}
			return detailProduct;

		}

		public String getProductId(ProductInCart productInCart) { //商品詳細データの習得
			String product_id = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url,id,pass);

				//SELECT文を準備
				String sql = "select product_id from ProductTbl WHERE product_name = ?;";
				pStmt = conn.prepareStatement(sql);

				pStmt.setString(1,productInCart.getProduct_name());

				//SELECT文を実行し結果表を作成
				ResultSet rs = pStmt.executeQuery();
				//一致した商品があった場合product_idを取得
					if(rs.next()) {
						product_id = rs.getString("product_id");
					}

			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				return null;
			} catch (SQLException ex) {
				ex.printStackTrace();
				return null;
			} finally {
				try {
					if(conn != null) conn.close();
					if(pStmt !=null) pStmt.close();
				} catch (Exception ex) {}
			}
			return product_id;

		}
}
