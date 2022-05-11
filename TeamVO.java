package MiniProject;

public class TeamVO {
	private int number;
	private String tname;
	private int vote;
	
	public TeamVO() {  }
	
	public TeamVO(int number, String tname, int vote) {
		super();
		this.number = number;
		this.tname = tname;
		this.vote = vote;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}

	@Override
	public String toString() {
		return number + ".\t" + tname + " ¢¹ " + vote + "Ç¥";
	}
	public String view() {
		return number + ".\t" + tname ;
	}
}
