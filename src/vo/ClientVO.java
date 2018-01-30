package vo;

public class ClientVO {
	private String C_code;
	private String account;
	private String address;
	private String P_number;
	public ClientVO() {
		super();
	}
	public ClientVO(String c_code, String account, String address, String p_number) {
		super();
		C_code = c_code;
		this.account = account;
		this.address = address;
		P_number = p_number;
	}
	public String getC_code() {
		return C_code;
	}
	public void setC_code(String c_code) {
		C_code = c_code;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getP_number() {
		return P_number;
	}
	public void setP_number(String p_number) {
		P_number = p_number;
	}
	@Override
	public String toString() {
		return "[°í°´ code= " + C_code + ", °èÁÂ= " + account + ", ÁÖ¼Ò= " + address + ", ¹øÈ£= " + P_number
				+ "]";
	}
	
	

}
