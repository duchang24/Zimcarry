package com.zimcarry.review;

import java.util.Date;

public class ReviewDTO {
	private long reIdx;
	private double reScore;
	private String reTitle;
	private String reContent;
	private Date reWritedate;
	private long reBookidx;
	private String reHidden;
	
	public long getReIdx() {
		return reIdx;
	}
	public void setReIdx(long reIdx) {
		this.reIdx = reIdx;
	}
	public double getReScore() {
		return reScore;
	}
	public void setReScore(double reScore) {
		this.reScore = reScore;
	}
	public String getReTitle() {
		return reTitle;
	}
	public void setReTitle(String reTitle) {
		this.reTitle = reTitle;
	}
	public String getReContent() {
		return reContent;
	}
	public void setReContent(String reContent) {
		this.reContent = reContent;
	}
	public Date getReWritedate() {
		return reWritedate;
	}
	public void setReWritedate(Date reWritedate) {
		this.reWritedate = reWritedate;
	}
	public long getReBookidx() {
		return reBookidx;
	}
	public void setReBookidx(long reBookidx) {
		this.reBookidx = reBookidx;
	}
<<<<<<< HEAD
	
=======
	public String getReHidden() {
		return reHidden;
	}
	public void setReHidden(String reHidden) {
		this.reHidden = reHidden;
	}
>>>>>>> 707b2909e2bc45515aafb655849e1cc09a6a66d8
}
