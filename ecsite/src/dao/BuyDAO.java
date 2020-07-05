package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Order;
import model.OrderDetail;

public class BuyDAO {
	// データベース接続に使用する情報
		private String url = "jdbc:mysql://localhost/gwec";
		private String id = "root";
		private String pass ="1qaz2wSX?";
		PreparedStatement pStmt;
		Connection conn;

		public boolean buy(Order order,List<OrderDetail> orderDetailList) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url,id,pass);
				conn.setAutoCommit(false);
			String sql = "INSERT INTO OrderTbl(order_id,whole_amount,order_date,limit_date,confirm_date,order_status,del_flg,ins_date,upd_date) VALUES(?,?,?,?,?,?,?,?,?)";
			pStmt = conn.prepareStatement(sql);
			//INSERT文中「？」に使用する値を設定しSQLを完成
			//
			pStmt.setInt(1,order.getOrder_id());
			pStmt.setInt(2,order.getWhole_amount());
			pStmt.setString(3,order.getOrder_date());
			pStmt.setString(4,order.getLimit_date());
			pStmt.setString(5,order.getConfirm_date());
			pStmt.setString(6,order.getOrder_status());
			pStmt.setString(7,order.getDel_flg());
			pStmt.setString(8,order.getIns_date());
			pStmt.setString(9,order.getUpd_date());

			//INSERT文を実行
			pStmt.executeUpdate();


			//ListのOederDetailをすべてINSERTへ流す
			for(OrderDetail o : orderDetailList) {
				sql = "INSERT INTO OrderDetailTbl(order_id,detail_id,product_id,whole_amount,money_amount,tax,del_flg,ins_date,upd_date) VALUES (?,?,?,?,?,?,?,?,?)";
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1,o.getOrder_id());
				pStmt.setInt(2,o.getDetail_id());
				pStmt.setInt(3,o.getProduct_id());
				pStmt.setInt(4,o.getWhole_amount());
				pStmt.setInt(5,o.getMoney_amount());
				pStmt.setInt(6,o.getTax());
				pStmt.setString(7,o.getDel_flg());
				pStmt.setString(8,o.getIns_date());
				pStmt.setString(9,o.getUpd_date());
				//INSERT文を実行
				pStmt.executeUpdate();



				//商品idで検索し在庫を取得
				sql = "SELECT stock FROM StockTbl WHERE product_id = ?";
				int stock=0;
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1,o.getProduct_id());
				ResultSet rs = pStmt.executeQuery();
				//一致した商品の在庫数を取得
				if(rs.next()) {
					stock = rs.getInt("stock");
				}
				//取得した在庫数-o.getWhole_amount()をする
				//UPDATE準備
				sql ="UPDATE StockTbl set stock = ? - ? WHERE product_id = ?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1,stock);
				pStmt.setInt(2,o.getWhole_amount()); //買った数
				pStmt.setInt(3,o.getProduct_id());
				pStmt.executeUpdate();
			}
			conn.commit();

			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				return false;
			} catch (SQLException ex) {
				ex.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException ex2) {
					ex2.printStackTrace();
				}
				return false;
			} finally {
				try {
					if(pStmt !=null) pStmt.close();
					if(conn != null) conn.close();
				} catch (Exception ex) {}
			}
			return true;
		}
}
