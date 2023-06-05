package data;

public class GroupDTO {
	private int groupId;
	private String groupName;
	private int order;
	private String addDt;
	private String editDt;
	
	public GroupDTO() {}

	public GroupDTO(String groupName, int order) {
		super();
		this.groupName = groupName;
		this.order = order;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getAddDt() {
		return addDt;
	}

	public void setAddDt(String addDt) {
		this.addDt = addDt;
	}

	public String getEditDt() {
		return editDt;
	}

	public void setEditDt(String editDt) {
		this.editDt = editDt;
	}
	
	
}