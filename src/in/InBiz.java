package in;

import java.sql.Connection;
import java.util.ArrayList;

import frame.Biz;
import vo.InVO;

public class InBiz extends Biz<InVO,Integer>{
	
	InDao dao;
	
	public InBiz() {
		dao = new InDao();
	}

	@Override
	public void register(InVO o) throws Exception {
		Connection conn = getConnection();
		try {
			dao.insert(o, conn);
			conn.commit();
		}catch(Exception e) {
			conn.rollback();
			throw e;
		}finally {
			close(conn);
		}
		
	}

	@Override
	public void remove(Integer i) throws Exception {
		Connection conn = getConnection();
		try {
			dao.delete(i, conn);
			conn.commit();
		}catch(Exception e){
			conn.rollback();
			throw e;
		}finally {
			close(conn);
		}
	}

	@Override
	public void modify(InVO o) throws Exception {
		Connection conn = getConnection();
		try {
			dao.update(o, conn);
			conn.commit();
		}catch(Exception e){
			conn.rollback();
			throw e;
		}finally {
			close(conn);
		}
	}

	@Override
	public InVO get(Integer i) throws Exception {
		
		Connection conn = getConnection();
		InVO in = null;
		try {
			in = dao.select(i, conn);

			
		}catch(Exception e) {
			throw e;
		}finally {
			close(conn);
		}
		return in;
	}

	@Override
	public ArrayList<InVO> get() throws Exception {
		Connection conn = getConnection();
		ArrayList<InVO> in = null;
		
		try {
			
			in = dao.select(conn);
			for(InVO inlist : in) {
				//System.out.println(inlist);
			}
			}catch(Exception e) {
				throw e;
		}finally {
			close(conn);
		}return in;
		
	}
}
