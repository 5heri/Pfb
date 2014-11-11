import java.lang.StringBuilder;

public class HashMap {
	
	private final double loadfactor = 0.75;

	private int elemCount;
	private Entry[] table; 


	public HashMap(int initialCap) {
		this.elemCount = 0;
		this.table = new Entry[initialCap];
	}

	public int hash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		h = h ^ (h >>> 7) ^ ( h >>> 4);
		return h < 0 ? h * -1 : h;
	}

	public void put(String key, Integer value) {
		if (elemCount > table.length*0.75) {
			System.out.println("Resized " + elemCount);
			resize();
		}

		int index = hash(key.hashCode()) % table.length;

		if (table[index] == null) {
			table[index] = new Entry(key, value);
			elemCount++;
		} else {
			
			Entry curr = table[index];
			while (curr != null) {
				if (curr.getKey().equals(key)) {
					curr.setValue(value);
				}

				if (curr.getNext() == null) {
					break;
				}
				curr = curr.getNext();
			}
			curr.setNext(new Entry(key, value));
		}
	}

	public Integer remove(String key) {
		int index = hash(key.hashCode()) % table.length;

		if (table[index] == null) {
			return null;
		} else {

			Entry curr = table[index];
			if (curr.getKey().equals(key)) {
				Entry removed = curr;
				curr = curr.getNext();
				table[index] = curr;   
				return removed.getValue();
			}
			while (curr != null && !curr.getNext().getKey().equals(key)) {
				curr = curr.getNext();
			}
			if (curr == null) {
				return null;
			} else {
				Entry removed = curr.getNext();
				curr.setNext(curr.getNext().getNext());
				return removed.getValue();
			}
		}
	}

	public Integer get(String key) {
		int index = hash(key.hashCode()) % table.length;

		if (table[index] == null) {
			return null;
		} else {

			Entry curr = table[index];
			while (curr != null) {
				if (curr.getKey().equals(key)) {
					return curr.getValue();
				}
				curr = curr.getNext();
			}
			return null;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				sb.append(i + ": ");
				Entry curr = table[i];
				while (curr != null) {
					sb.append("(" + curr.getKey() + ", " + curr.getValue() + ") ");
					curr = curr.getNext();
				}
				sb.append('\n');
			}
			
		}
		return sb.toString();
	}

	private void resize() {
		Entry[] newTable = new Entry[table.length*2];

		for (int i = 0; i < table.length; i++) {
			newTable[i] = table[i];
		}
		table = newTable;
	}

}
