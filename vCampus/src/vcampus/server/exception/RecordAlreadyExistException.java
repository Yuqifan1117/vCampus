package vcampus.server.exception;

public class RecordAlreadyExistException extends Exception{
	private String uMsg=new String("");
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	public String getMessage() {
		return new String("RecordAlreadyExist");
	}
	
	public void setMsg(String msg) {
		uMsg=msg;
	}
	
	public String getType() {
		return uMsg;
	}
}
