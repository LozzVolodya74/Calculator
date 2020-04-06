package services;

class Node {
	private String data = "";
	private int priority = 0;
	private boolean enable = true;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
