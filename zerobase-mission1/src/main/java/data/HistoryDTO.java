package data;

public class HistoryDTO {
	private int historyId;
	private float coorX;
	private float coorY;
	private String inquiryDt;
	
	public HistoryDTO() {}
	

	public HistoryDTO(float coorX, float coorY) {
		super();
		this.coorX = coorX;
		this.coorY = coorY;
	}
	
	
	public int getHistoryId() {
		return historyId;
	}


	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}


	public String getInquiryDt() {
		return inquiryDt;
	}


	public void setInquiryDt(String inquiryDt) {
		this.inquiryDt = inquiryDt;
	}


	public float getCoorX() {
		return coorX;
	}

	public void setCoorX(float coorX) {
		this.coorX = coorX;
	}

	public float getCoorY() {
		return coorY;
	}

	public void setCoorY(float coorY) {
		this.coorY = coorY;
	}
	
}