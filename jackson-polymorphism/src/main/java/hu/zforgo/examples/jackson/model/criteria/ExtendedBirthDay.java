package hu.zforgo.examples.jackson.model.criteria;

import java.time.DayOfWeek;
import java.util.Date;
import java.util.Set;

public class ExtendedBirthDay extends Criteria {
	private Date from;
	private Date to;
	private Set<DayOfWeek> daysOnly;

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

	public Set<DayOfWeek> getDaysOnly() {
		return daysOnly;
	}

	public void setDaysOnly(Set<DayOfWeek> daysOnly) {
		this.daysOnly = daysOnly;
	}
}
