public interface List<T> {
	
	public int size();

	public void add(int index, T value);

	public Node<T> delete(int index);

	public T get(int index);
}
