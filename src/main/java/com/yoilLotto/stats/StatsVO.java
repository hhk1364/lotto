package com.yoilLotto.stats;

import java.io.*;

@SuppressWarnings("serial")
public class StatsVO implements Serializable {
		 
	private String isBonus;
	private String drwNoStart;
	private String drwNoEnd;
	
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

}
