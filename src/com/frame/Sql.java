package com.frame;


public class Sql {

	public static String insertUser = 
			"INSERT INTO TB_USER VALUES (?,?,?)";
	//static 변경x, 여러class에서 사용할 수 있도록 하는 것
	public static String updateUser =
			"UPDATE TB_USER SET PWD=?, name=? WHERE ID = ?";
	public static String deleteUser = 
			"DELETE FROM TB_USER WHERE ID=?"; 
	public static String selectUser = 
			"SELECT * FROM TB_USER WHERE ID=?"; 
	public static String selectAllUser = 
			"SELECT * FROM TB_USER order by id"; 
	
	public static String insertProduct = 
			"INSERT INTO TB_PRODUCT VALUES (?,?,?)";
	public static String updateProduct =
			"UPDATE TB_PRODUCT SET NAME=?, PRICE=? WHERE ID = ?";
	public static String deleteProduct = 
			"DELETE FROM TB_PRODUCT WHERE ID=?"; 
	public static String selectProduct = 
			"SELECT * FROM TB_PRODUCT WHERE ID=?"; 
	public static String selectAllProduct = 
			"SELECT * FROM TB_PRODUCT ORDER BY ID"; 
				
}
