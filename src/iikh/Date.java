package iikh;

public class Date {
	private int date,month,year;
	
	public Date() {
		date = 0;
		month = 0;
		year = 0;
	}
	public Date(int dt, int mth, int yr ) {
		setDate(dt);
		setMonth(mth);
		setYear(yr);
	}	
	public int getDate() {
		return date;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String toString() {
		String Date = date+"/"+month+"/"+year;
		return Date;
	}
}
