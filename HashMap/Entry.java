public class Entry {
	
	private String key;
	private Integer value;

	private Entry next;

	public Entry(String key, Integer value) {
		this.key = key;
		this.value = value;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public void setNext(Entry next) {
		this.next = next;
	}

	public String getKey() {
		return key;
	}

	public Integer getValue() {
		return value;
	}

	public Entry getNext() {
		return next;
	}

}
