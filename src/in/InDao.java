package in;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.InVO;

public class InDao extends Dao<InVO,Integer>{
	
	

	@Override
	public void insert(InVO o, Connection conn) throws Exception {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(Sql.insert);
			st.setInt(1, o.getF_code());
			st.setString(2, o.getF_name());
			st.setInt(3, o.getAmount());
			st.setInt(4, o.getP_cost());
			st.setInt(5, o.getG_number());
			st.executeQuery();
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(st);
		}
	}



	@Override
	public void delete(Integer i, Connection conn) throws Exception {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(Sql.delete);
			st.setInt(1, i);
			st.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(st);
		}
		
		
	}

	@Override
	public void update(InVO o, Connection conn) throws Exception {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(Sql.update);
			st.setInt(5, o.getF_code());
			st.setString(1, o.getF_name());
			st.setInt(2, o.getAmount());
			st.setInt(3, o.getP_cost());
			st.setInt(4, o.getG_number());
			st.executeQuery();
		}catch(Exception e) {
			throw e;
		}finally {
			close(st);
		}
		
	}

	@Override
	public InVO select(Integer i, Connection conn) throws Exception {
		PreparedStatement st = null;
		InVO in = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(Sql.select);
			st.setInt(1, i);
			rs = st.executeQuery();
			rs.next();
				int F_code = rs.getInt("Flower_Code");
				String F_name = rs.getString("Flower_Name");
				int amount = rs.getInt("amount");
				int P_cost = rs.getInt("Prime_cost");
				int G_number = rs.getInt("grade");
				Date date = rs.getDate("register_date");
				in = new InVO(F_code,F_name,amount,P_cost,G_number,date);
				
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			close(st);
			close(rs);
	}return in;

	}	
		
	@Override
	public ArrayList<InVO> select(Connection conn) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<InVO> list = new ArrayList<>();
		InVO in = null;
		try {
			st = conn.prepareStatement(Sql.selectAll);
			rs = st.executeQuery();
			while(rs.next()) {
				int F_code = rs.getInt("flower_Code");
				String F_name = rs.getString("flower_Name");
				int amount = rs.getInt("amount");
				int P_cost = rs.getInt("prime_cost");
				int G_number = rs.getInt("grade");
				Date date = rs.getDate("Register_Date");
				in = new InVO(F_code,F_name,amount,P_cost,G_number,date);
				list.add(in);
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			close(st);
			close(rs);
		}
		return list;
	}
	
	

}
