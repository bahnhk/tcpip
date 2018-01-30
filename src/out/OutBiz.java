package out;

import java.sql.Connection;
import java.util.ArrayList;

import frame.Biz;
import vo.ClientVO;
import vo.OutVO;

public class OutBiz extends Biz<OutVO, Integer> {

	OutDao outDao;

	public OutBiz() {
		outDao = new OutDao();
	}

	@Override
	public void register(OutVO o) throws Exception {
		Connection conn = getConnection();
		int p_cost;
		int s_price;
		int inAmount;
		try {

			inAmount = outDao.selectInAmount(o.getF_code(), conn);
			if (o.getAmount() < inAmount) {

				p_cost = outDao.selectPrimeCost(o.getF_code(), conn);
				s_price = (int) (p_cost * (1 + o.getProfit()));
				o.setS_price(s_price);

				outDao.insert(o, conn);
			} else {
				System.out.println("잔량을 확인해주세요");
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
	}

	@Override
	public void remove(Integer i) throws Exception {
		Connection conn = getConnection();
		try {
			outDao.delete(i, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}

	}

	@Override
	public void modify(OutVO o) throws Exception {
		Connection conn = getConnection();
		try {
			outDao.update(o, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}

	}

	@Override
	public OutVO get(Integer i) throws Exception {
		Connection conn = getConnection();
		OutVO out = null;
		String f_name;
		ClientVO client;
		try {
			out = outDao.select(i, conn);
			f_name = outDao.selectFlowerName(i, conn);
			out.setF_name(f_name);
			client = outDao.selectClient(out.getC_code(), conn);
			out.setClient(client);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
		return out;
	}

	@Override
	public ArrayList<OutVO> get() throws Exception {
		Connection conn = getConnection();
		ArrayList<OutVO> list = null;
		String f_name;
		ClientVO client;
		try {
			list = outDao.select(conn);
			for (OutVO out : list) {
				f_name = outDao.selectFlowerName(out.getF_code(), conn);
				out.setF_name(f_name);
				client = outDao.selectClient(out.getC_code(), conn);
				out.setClient(client);
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
		return list;
	}

}
