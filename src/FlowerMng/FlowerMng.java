package FlowerMng;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import frame.Sql;

public class FlowerMng {

	Connection conn = null;
	PreparedStatement pr = null;
	ResultSet rs = null;
	int grade = 0;
	Date date = null;

	public FlowerMng() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found...");
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "hr";
		String password = "hr";
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public ArrayList<String> GetName() {
		
		conn = getConnection();
		ArrayList<String> list = new ArrayList<>();

		try {
			pr = conn.prepareStatement(Sql.GetName);
			rs = pr.executeQuery();
			while(rs.next()) {
				String name = rs.getString("flower_name");
				list.add(name);}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					pr.close();
					rs.close();
					conn.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

	return list;
	}

	public void Alarm(int flower_code) {

		conn = getConnection();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			pr = conn.prepareStatement(Sql.getGrade);
			pr.setInt(1, flower_code);
			rs = pr.executeQuery();
			rs.next();
			grade = rs.getInt("grade");
			conn.commit();
			date = rs.getDate("Register_Date");
			String name = rs.getString("flower_name");

			switch (grade) {
			case 1: {

				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.DATE, 3);
				String today = sdformat.format(cal.getTime());

				if (String.valueOf(date).equals(today)) {
					System.out.println("꽃 이름: " + name);
					System.out.println("오늘은 줄기를 자르는 날 입니다.");

				} else {
					System.out.println("꽃 이름: " + name);
					System.out.println("시드는 속도가 빠른 꽃이에요.");
					System.out.println(today + "에 줄기를 자르세요.");
				}
			}
				break;

			case 2: {

				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.DATE, 5);
				String today = sdformat.format(cal.getTime());

				if (String.valueOf(date).equals(today)) {
					System.out.println("꽃 이름: " + name);
					System.out.println("오늘은 줄기를 자르는 날 입니다.");

				} else {
					System.out.println("꽃 이름: " + name);
					System.out.println("시드는 속도가 보통 꽃이에요.");
					System.out.println(today + "에 줄기를 자르세요.");
				}

			}
				break;

			case 3: {

				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.DATE, 7);
				String today = sdformat.format(cal.getTime());

				if (String.valueOf(date).equals(today)) {
					System.out.println("꽃 이름: " + name);
					System.out.println("오늘은 줄기를 자르는 날 입니다.");

				} else {
					System.out.println("꽃 이름: " + name);
					System.out.println("시드는 속도가 느린 꽃이에요.");
					System.out.println(today + "에 줄기를 자르세요.");
				}

			}
				break;

			default:
				System.out.println("grade값을 입력하지 않았습니다.");
			}

		} catch (SQLException e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {

			try {
				pr.close();
				rs.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
