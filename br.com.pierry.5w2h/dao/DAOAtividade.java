package dao;

import interfaces.IDAO;

import java.util.ArrayList;
import java.util.List;

import model.Atividade;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DAOAtividade extends DAO implements IDAO<Atividade>{
	
	public static DAO dao;
	public SQLiteDatabase db;
	
	public DAOAtividade (Context cntx){
		dao = new SQL(cntx);
		db = dao.db;
	}
	
	@Override
	public long Insert(Atividade item) {
		ContentValues values = new ContentValues();
		values.put(Atividade.WHAT, item.getWhat());
		values.put(Atividade.WHY, item.getWhy());
		values.put(Atividade.WHERE, item.getWhere());
		values.put(Atividade.WHEN, item.getWhen());
		values.put(Atividade.WHO, item.getWho());
		values.put(Atividade.HOW, item.getHow());
		values.put(Atividade.HOWMUCH, item.getHowmuch());		
		
		long id = db.insert(ATIVIDADE, "", values);
		return id;
	}

	@Override
	public long Update(Atividade item) {
		ContentValues values = new ContentValues();
		values.put(Atividade.WHAT, item.getWhat());
		values.put(Atividade.WHY, item.getWhy());
		values.put(Atividade.WHERE, item.getWhere());
		values.put(Atividade.WHEN, item.getWhen());
		values.put(Atividade.WHO, item.getWho());
		values.put(Atividade.HOW, item.getHow());
		values.put(Atividade.HOWMUCH, item.getHowmuch());
		
		String _id = String.valueOf(item.getIdAtiv());

		String where = Atividade.ID + "=?";
		String[] whereArgs = new String[] { _id };

		int count = db.update(ATIVIDADE, values, where, whereArgs);

		return count;
	}

	@Override
	public List<Atividade> Select() {
		Cursor c = getCursor();
		List<Atividade> comms = new ArrayList<Atividade>();
		if (c.moveToFirst()) {
			// Recupera os índices das colunas
			int idxId = c.getColumnIndex(Atividade.ID);			
			int idxWhat = c.getColumnIndex(Atividade.WHAT);
			int idxWhy = c.getColumnIndex(Atividade.WHY);
			int idxWhere = c.getColumnIndex(Atividade.WHERE);
			int idxWhen = c.getColumnIndex(Atividade.WHEN);
			int idxWho = c.getColumnIndex(Atividade.WHO);
			int idxHow = c.getColumnIndex(Atividade.HOW);
			int idxHowMuch = c.getColumnIndex(Atividade.HOWMUCH);
			
			
			// Loop até o final
			do {
				Atividade com = new Atividade();
				comms.add(com);
				// recupera os atributos
				com.setIdAtiv(c.getLong(idxId));													
				com.setWhat(c.getString(idxWhat));
				com.setWhy(c.getString(idxWhy));
				com.setWhere(c.getString(idxWhere));
				com.setWhen(c.getString(idxWhen));
				com.setWho(c.getString(idxWho));
				com.setHow(c.getString(idxHow));
				com.setHowmuch(c.getString(idxHowMuch));
			} while (c.moveToNext());
		}
		return comms;
	}
		
	@Override
	public Atividade Select(long id) {
		Cursor c = db.query(true, ATIVIDADE, Atividade.colunas, Atividade.ID + "=" + id, null, null, null, null, null);
		if (c.getCount() > 0) {
			// Posiciona no primeiro elemento do cursor
			c.moveToFirst();
			Atividade com = new Atividade();
			// Lê os dados
			com.setIdAtiv(c.getLong(0));			
			com.setWhat(c.getString(1));			
			com.setWhy(c.getString(2));	
			com.setWhere(c.getString(3));
			com.setWhen(c.getString(4));
			com.setWho(c.getString(5));
			com.setHow(c.getString(6));
			com.setHowmuch(c.getString(7));
			
			return com;
		}
		return null;
	}
	
	@Override
	public long Delete(long id) {
		String where = Atividade.ID + "=?";
		String _id = String.valueOf(id);
		String[] whereArgs = new String[] { _id };
		int count = db.delete(ATIVIDADE, where, whereArgs);
		return count;
	}
	
	@Override
	public Cursor getCursor() {
		try {
			// select * from 
			return db.query(ATIVIDADE, Atividade.colunas, null, null, null, null, null, null);
		} catch (SQLException e) {			
			return null;
		}
	}

}
