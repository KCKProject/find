package find.vo;

import java.util.Date;

public class DateSearchCommand extends Criteria{

	private Date from; 
	private Date to;
	
	
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	@Override
	public String toString() {
		 return super.toString() + "DateSearchCommand [from=" + from + ", to=" + to 
				 + "]";
	 }
}