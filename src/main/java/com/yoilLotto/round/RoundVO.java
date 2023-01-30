package com.yoilLotto.round;

import java.io.*;

@SuppressWarnings("serial")
public class RoundVO implements Serializable {
		 
	private String drwNo;
	private String drwNoDateStart;
	private String drwNoDateEnd;
	private String grade;

	
	public String getDrwNo() {
		return drwNo;
	}
	public void setDrwNo(String drwNo) {
		this.drwNo = drwNo;
	}
	public String getDrwNoDateStart() {
		return drwNoDateStart;
	}
	public void setDrwNoDateStart(String drwNoDateStart) {
		this.drwNoDateStart = drwNoDateStart;
	}
	public String getDrwNoDateEnd() {
		return drwNoDateEnd;
	}
	public void setDrwNoDateEnd(String drwNoDateEnd) {
		this.drwNoDateEnd = drwNoDateEnd;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
