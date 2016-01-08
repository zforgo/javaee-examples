package hu.zforgo.examples.jackson.model.criteria;

import java.util.Date;

public class BirthDay extends Criteria {
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
}
