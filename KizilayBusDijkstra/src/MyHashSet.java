// Author: Arda Baran
import java.util.ArrayList;

public class MyHashSet<T> {
     ArrayList<T> list = new ArrayList<>();

    public void add(T value) {
        if (!list.contains(value)) {
            list.add(value);
        }
    }

    public ArrayList<T> getList() {
		return list;
	}

	public void setList(ArrayList<T> list) {
		this.list = list;
	}

	public boolean contains(T value) {
        return list.contains(value);
    }

    public void remove(T value) {
        list.remove(value);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
