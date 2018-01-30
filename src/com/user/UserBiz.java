package com.user;

import java.sql.Connection;
import java.util.ArrayList;

import com.frame.Biz;
import com.vo.UserVO;

import oracle.jdbc.OracleConnection.CommitOption;

public class UserBiz extends Biz<UserVO, String> {

	public UserBiz() {
		dao = new UserDao();
		// 자바에서 커플링이 많이 있을 수록 안좋은 것//
	}

	@Override
	public void register(UserVO o) throws Exception {
		Connection conn = getConnection();
		try {
			dao.insert(o, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
	}

	@Override
	public void remove(String i) throws Exception {
		Connection conn = getConnection();
		try {
			dao.delete(i, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
	}

	@Override
	public void modify(UserVO o) throws Exception {
		Connection conn = getConnection();
		try {
			dao.update(o, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
	}

	@Override
	public UserVO get(String i) throws Exception {
		Connection conn = getConnection();
		UserVO user=null;
		try {
			user= dao.select(i, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
		return user;
	}

	@Override
	public ArrayList<UserVO> get() throws Exception {
		Connection conn = getConnection();
		ArrayList<UserVO> list = null;
		try {
			list= dao.select(conn);
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
