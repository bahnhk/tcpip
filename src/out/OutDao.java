package out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.ClientVO;
import vo.OutVO;

public class OutDao extends Dao<OutVO, Integer> {

	public int selectInAmount(int f_code, Connection conn) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		int amount;
		
		try {
			st = conn.prepareStatement(Sql.GetInAmount);
			st.setInt(1, f_code);
			rs=st.executeQuery();
			rs.next();
			amount = rs.getInt("AMOUNT");
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
			close(rs);		
		}
		return amount;
	}
	
	public int selectPrimeCost(int f_code, Connection conn) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		int p_cost;
		
		try {
			st = conn.prepareStatement(Sql.GetPrimeCost);
			st.setInt(1, f_code);
			rs = st.executeQuery();
			rs.next();
			p_cost = rs.getInt("PRIME_COST");
			
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
			close(rs);		
		}
		return p_cost;
	}
	
	@Override
	public void insert(OutVO o, Connection conn) throws Exception {
		PreparedStatement st = null;
		int result;
		// 1. sql에 물음표 넣기(1.code, 2.amount, 3.s-p, 4.client-c)

		try {
			st = conn.prepareStatement(Sql.insert_out);
			st.setInt(1, o.getF_code());
			st.setInt(2, o.getAmount());
			st.setInt(3, o.getS_price());
			st.setString(4, o.getC_code());
			result = st.executeUpdate();
			if (result == 1)
				System.out.println(result + "건 OutDao 입력 완료");
			else if (result == 0)
				System.out.println(result + "건 OutDao 입력 실패");
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}
	}

	@Override
	public void delete(Integer i, Connection conn) throws Exception {
		PreparedStatement st = null;
		int result;
		// 1. sql에 물음표 넣기(1.code로 조회//)
		try {
			st = conn.prepareStatement(Sql.delete_out);
			st.setInt(1, i);

			result = st.executeUpdate();

			if (result == 1)
				System.out.println(result + "건 OutDao 삭제 완료");
			else if (result == 0)
				System.out.println(result + "건 OutDao 삭제 실패");
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}

	}

	@Override
	public void update(OutVO o, Connection conn) throws Exception {
		PreparedStatement st = null;
		int result;
		// 1. sql에 물음표 넣기(1.amount, 2.s-p, 3.client-c, 4.code)

		try {
			st = conn.prepareStatement(Sql.update_out);

			st.setInt(1, o.getAmount());
			st.setString(2, o.getC_code());
			st.setInt(3, o.getF_code());
			result = st.executeUpdate();

			if (result == 1)
				System.out.println(result + "건 OutDao 수정 완료");
			else if (result == 0)
				System.out.println(result + "건 OutDao 수정 실패");
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}
	}

	@Override
	public OutVO select(Integer i, Connection conn) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		OutVO out = null;

		// ClientVO client = null;
		// 1. code로 조회
		// 2. 받아오는 것(1.get name(in), 2.amount, 3.price, 4.clientid)
		try {
			st = conn.prepareStatement(Sql.select_out);
			st.setInt(1, i);
			rs = st.executeQuery();
			rs.next();
			int f_code = rs.getInt("FLOWER_CODE");//1
			int amount = rs.getInt("AMOUNT");//2
			int s_price = rs.getInt("SELLING_PRICE");//3
			String c_code = rs.getString("CLIENT_CODE");//4
			String date = rs.getString("SOLD_DATE");//5
			out = new OutVO(f_code, amount, c_code);//123
			out.setS_price(s_price);//4
			out.setDate(date);//5
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}
		return out;
	}

	
	@Override
	public ArrayList<OutVO> select(Connection conn) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<OutVO> list = new ArrayList<>();
		OutVO out = null;

		// ClientVO client = null;
		// 1. code로 조회
		// 2. 받아오는 것(1.get name(in), 2.amount, 3.price, 4.clientid)
		try {
			st = conn.prepareStatement(Sql.selectAll_out);
			//12345가져옴.
			rs = st.executeQuery();
			while (rs.next()) {
				int f_code = rs.getInt("FLOWER_CODE");//1
				int amount = rs.getInt("AMOUNT");//2
				int s_price = rs.getInt("SELLING_PRICE");//3
				String c_code = rs.getString("CLIENT_CODE");//4
				String date = rs.getString("SOLD_DATE");//5
				out = new OutVO(f_code, amount, c_code);//123
				out.setS_price(s_price);//4
				out.setDate(date);//5
				list.add(out);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}
		return list;
	}

	public String selectFlowerName(int f_code, Connection conn) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		String f_name;
	// client자체 넣는 과정 -> biz id로 전체조회
		try {
			st = conn.prepareStatement(Sql.getFlowerName);
			st.setInt(1, f_code);
			rs=st.executeQuery();
			rs.next();
			f_name = rs.getString("FLOWER_NAME");
			
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
			close(rs);		
		}
		return f_name;
	}

	public ClientVO selectClient(String code, Connection conn) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		ClientVO client = null;

		// client자체 넣는 과정 -> biz id로 전체조회
		try {
			st = conn.prepareStatement(Sql.select_vendor);
			st.setString(1, code);
			rs = st.executeQuery();
			rs.next();
			String c_code = rs.getString("CLIENT_CODE");
			String account = rs.getString("ACCOUNT");
			String address = rs.getString("ADDRESS");
			String p_number = rs.getString("PHONE_NUMBER");
			client = new ClientVO(c_code, account, address, p_number);
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
			close(rs);
		}
		return client;
	}

	
}
