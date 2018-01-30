package com.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.ProductVO;

public class ProductDao extends Dao<ProductVO, Integer> {

	@Override
	public void insert(ProductVO o, Connection conn) throws Exception {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(Sql.insertProduct);
			st.setInt(1, o.getId());
			st.setString(2, o.getName());
			st.setDouble(3, o.getPrice());
			st.executeUpdate();
			System.out.println("상품정보 입력 완료");
		} catch (Exception e) {
			System.out.println("입력 오류!!!!");
			throw e;
		} finally {
			close(st);
		}
	}

	@Override
	public void delete(Integer i, Connection conn) throws Exception {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(Sql.deleteProduct);
			st.setInt(1, i);
			st.executeUpdate();
			System.out.println("상품정보 삭제 완료");
		} catch (Exception e) {
			System.out.println("삭제 오류!!!!");
			throw e;
		} finally {
			close(st);
		}
	}

	@Override
	public void update(ProductVO o, Connection conn) throws Exception {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(Sql.updateProduct);
			st.setInt(3, o.getId());
			st.setString(1, o.getName());
			st.setDouble(2, o.getPrice());
			st.executeUpdate();
			System.out.println("상품정보 수정 완료");
		} catch (Exception e) {
			System.out.println("수정 오류!!!!");
			throw e;
		} finally {
			close(st);
		}
	}

	@Override
	public ProductVO select(Integer i, Connection conn) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		ProductVO product = null;
		try {
			st = conn.prepareStatement(Sql.selectProduct);
			st.setInt(1, i);
			rs = st.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			String name = rs.getString("name");
			double price = rs.getDouble("price");
			product = new ProductVO(id, name, price);
			System.out.println("상품정보 선택 완료");
		} catch (Exception e) {
			System.out.println("불러오기 오류!!!!");
			throw e;
		} finally {
			close(st);
			close(rs);
		}
		return product;
	}

	@Override
	public ArrayList<ProductVO> select(Connection conn) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<ProductVO> list = new ArrayList<>();
		ProductVO product = null;
		try {
			st = conn.prepareStatement(Sql.selectAllProduct);
			rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				product = new ProductVO(id, name, price);
				list.add(product);
			}
		} catch (Exception e) {
			System.out.println("불러오기 오류!!!!");
			throw e;
		} finally {
			close(st);
			close(rs);
		}
		return list;
	}

}
