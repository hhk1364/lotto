package com.yoilLotto.stats;

import java.io.*;

@SuppressWarnings("serial")
public class StatsVO implements Serializable {
		 
	private String isBonus;
	private String drwNoStart;
	private String drwNoEnd;
	private String drwNoDateStart;
	private String drwNoDateEnd;
	
	public String getIsBonus() {
		return isBonus;
	}
	public void setIsBonus(String isBonus) {
		this.isBonus = isBonus;
	}
	public String getDrwNoStart() {
		return drwNoStart;
	}
	public void setDrwNoStart(String drwNoStart) {
		this.drwNoStart = drwNoStart;
	}
	public String getDrwNoEnd() {
		return drwNoEnd;
	}
	public void setDrwNoEnd(String drwNoEnd) {
		this.drwNoEnd = drwNoEnd;
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
	
	
	
	
}
