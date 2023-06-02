package data;

public class DTO {
	private String manNum;
	private float dist; 
	private String locGu;
	private String wifiName;
	private String locAd;
	private String locAd2;
	private String locFloor;
	private String instType;
	private String instAd;
	private String service;
	private String netType;
	private int instYear;
	private String inOut;
	private String envir;
	private float coorX;
	private float coorY;
	private String workDt; 
	
	public DTO() {}
	
	public DTO(String manNum, float dist, String locGu, String wifiName, String locAd, String locAd2, String locFloor,
			String instType, String instAd, String service, String netType, String instYear, String inOut, String envir,
			String coorX, String coorY, String workDt) {
		super();
		this.manNum = manNum;
		this.dist = dist;
		this.locGu = locGu;
		this.wifiName = wifiName;
		this.locAd = locAd;
		this.locAd2 = locAd2;
		this.locFloor = locFloor;
		this.instType = instType;
		this.instAd = instAd;
		this.service = service;
		this.netType = netType;
		this.instYear = instYear == "" ? null : Integer.parseInt(instYear);
		this.inOut = inOut;
		this.envir = envir;
		this.coorX = coorX == "" ? null : Float.parseFloat(coorX);
		this.coorY = coorY == "" ? null : Float.parseFloat(coorY);
		this.workDt = workDt;
	}
	
	public String getManNum() {
		return manNum;
	}
	public void setManNum(String manNum) {
		this.manNum = manNum;
	}
	public float getDist() {
		return dist;
	}
	public void setDist(float dist) {
		this.dist = dist;
	}
	public String getLocGu() {
		return locGu;
	}
	public void setLocGu(String locGu) {
		this.locGu = locGu;
	}
	public String getWifiName() {
		return wifiName;
	}
	public void setWifiName(String wifiName) {
		this.wifiName = wifiName;
	}
	public String getLocAd() {
		return locAd;
	}
	public void setLocAd(String locAd) {
		this.locAd = locAd;
	}
	public String getLocAd2() {
		return locAd2;
	}
	public void setLocAd2(String locAd2) {
		this.locAd2 = locAd2;
	}
	public String getLocFloor() {
		return locFloor;
	}
	public void setLocFloor(String locFloor) {
		this.locFloor = locFloor;
	}
	public String getInstType() {
		return instType;
	}
	public void setInstType(String instType) {
		this.instType = instType;
	}
	public String getInstAd() {
		return instAd;
	}
	public void setInstAd(String instAd) {
		this.instAd = instAd;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getNetType() {
		return netType;
	}
	public void setNetType(String netType) {
		this.netType = netType;
	}
	public Integer getInstYear() {
		return instYear;
	}
	public void setInstYear(int instYear) {
		this.instYear = instYear;
	}
	public String getInOut() {
		return inOut;
	}
	public void setInOut(String inOut) {
		this.inOut = inOut;
	}
	public String getEnvir() {
		return envir;
	}
	public void setEnvir(String envir) {
		this.envir = envir;
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
	public String getWorkDt() {
		return workDt;
	}
	public void setWorkDt(String workDt) {
		this.workDt = workDt;
	}
	

}
