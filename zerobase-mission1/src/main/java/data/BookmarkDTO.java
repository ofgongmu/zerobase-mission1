package data;

public class BookmarkDTO {
	private int bookmarkId;
	private String groupName;
	private String wifiName;
	private String addDt;
	
	public BookmarkDTO() {}

	public BookmarkDTO(String groupName, String wifiName) {
		super();
		this.groupName = groupName;
		this.wifiName = wifiName;
	}
	
	public int getBookmarkId() {
		return bookmarkId;
	}

	public void setBookmarkId(int bookmarkId) {
		this.bookmarkId = bookmarkId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getWifiName() {
		return wifiName;
	}

	public void setWifiName(String wifiName) {
		this.wifiName = wifiName;
	}

	public String getAddDt() {
		return addDt;
	}

	public void setAddDt(String addDt) {
		this.addDt = addDt;
	}

	
}