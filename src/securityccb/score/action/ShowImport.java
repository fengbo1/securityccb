package securityccb.score.action;

public class ShowImport {

	private String position;
	private String jigou;
	
	public String getJigou() {
		return jigou;
	}
	public void setJigou(String jigou) {
		this.jigou = jigou;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String execute() throws Exception
	{
		if(position!=null&&position.length()>8)
		{
			jigou = position.substring(0, 3);
		}
		return "success";
	}
}
