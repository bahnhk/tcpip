package frame;

public class Sql {

	
	
	//=======================T_IN sql¹®==============================
	public static String insert 
	= "INSERT into T_IN values (?,?,?,?,?,sysdate)";

	public static String update 
	="UPDATE T_IN SET flower_name=?, amount=?,prime_cost=?, grade=?  WHERE flower_code = ?";

	public static String delete 
	="delete from T_IN where flower_code = ?";

	public static String select 
	="select * from T_IN where flower_code = ?";

	public static String selectAll
	="select * from t_in order by flower_code";

	public static String getamount 
	="select amount from T_IN where flower_code=?";
	
	public static String getGrade
	= "select * from T_IN where flower_code=?";
	
	public static String getFlowerName =
	"select flower_name from T_IN where flower_code = ?";

	public static String GetInAmount
	="select amount from T_IN where flower_code = ?";
	
	public static String GetName
	="select flower_name from T_IN";
	
	
	//=======================T_OUT sql¹®==============================
	

	public static String insert_out 
	="INSERT into T_OUT values (?,?,?,?,sysdate)";

	public static String update_out
	="UPDATE T_OUT SET amount=?, client_code=?  WHERE flower_code = ?";

	public static String delete_out
	="delete from T_OUT where flower_code = ?";

	public static String select_out
	="select * from T_OUT join where flower_code = ?";

	public static String selectAll_out
	="select * from T_OUT order by flower_code";

	public static String GetPrimeCost
	="select PRIME_COST from T_IN where flower_code = ?";
	

	//=======================T_VENDOR sql¹®==============================
	
	public static String select_vendor 
	="select * from T_VENDOR where client_code = ?";

	public static String selectAll_vendor
	="select * from T_VENDOR order by client_code";
	
	
}
