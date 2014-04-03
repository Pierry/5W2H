package interfaces;

import java.util.List;

import android.database.Cursor;

public interface IDAO<T> {

	public long Insert(T item);
	
	public long Update(T item);
	
	public List<T> Select();
	
	public T Select(long id);
	
	public long Delete(long id);
	
	public Cursor getCursor();
	
}
