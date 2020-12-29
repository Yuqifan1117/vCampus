package vcampus.server.exception;

public class WrongPasswordException extends Exception{
	private String uMsg=new String("");
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	public String getMessage() {
		return new String("WrongPassword");
	}

	public void setMsg(String msg) {
		uMsg=msg;
	}
	
	public String getType() {
		return uMsg;
	}
}
