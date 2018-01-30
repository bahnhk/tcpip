package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.UserVO;

public class UserDao extends Dao<UserVO, String> {

	@Override
	public void insert(UserVO o, Connection conn) throws Exception {
		PreparedStatement st = null;
		int result;
		try {
			st = conn.prepareStatement(Sql.insertUser);
			st.setString(1, o.getId());
			st.setString(2, o.getPwd());
			st.setString(3, o.getName());
			result = st.executeUpdate();
			if(result==1)
			//수정한다는 의미.이거 없으면 실행은 되지만 database수정이 안됨.
				System.out.println(result+"건 입력");
			else if(result==0)
				System.out.println("입력 실패!! 다시 확인하세요~");
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}
	}

	@Override
	public void delete(String i, Connection conn) throws Exception {
		PreparedStatement st = null;
		int result;
		try {
			st = conn.prepareStatement(Sql.deleteUser);
			st.setString(1, i);
			result = st.executeUpdate();
			if(result==1)
			System.out.println(result+"건 삭제");
			else if(result==0)
				System.out.println("삭제할 데이터가 없습니다.");
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}

	}

	@Override
	public void update(UserVO o, Connection conn) throws Exception {
		PreparedStatement st = null;
		int result;
		try {
			st = conn.prepareStatement(Sql.updateUser);
			st.setString(3, o.getId());
			st.setString(1, o.getPwd());
			st.setString(2, o.getName());
			result = st.executeUpdate();
			if(result==1) {
			System.out.println(result+"건 수정");
			System.out.println(o);
			}else if (result==0) {
				System.out.println("수정 실패! 다시 확인해주세요~");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}

	}

	@Override
	public UserVO select(String i, Connection conn) throws Exception {
		PreparedStatement st = null;
		UserVO user = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(Sql.selectUser);
			st.setString(1, i);
			rs=st.executeQuery();
			rs.next();
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			user= new UserVO(id, pwd, name);
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}
		return user;
	}

	@Override
	public ArrayList<UserVO> select(Connection conn) throws Exception {
		PreparedStatement st = null;
		ArrayList<UserVO> list = new ArrayList<>();
		UserVO user = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(Sql.selectAllUser);
			rs=st.executeQuery();
			while(rs.next()) {
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			user= new UserVO(id, pwd, name);
			list.add(user);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}
		return list;
	}

}
