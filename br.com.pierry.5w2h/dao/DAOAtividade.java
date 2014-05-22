package dao;

import interfaces.IDAO;

import java.util.ArrayList;
import java.util.List;

import model.AtividadeModel;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DAOAtividade extends DAO implements IDAO<AtividadeModel>{
	
	public static DAO dao;
	public SQLiteDatabase db;
	
	public DAOAtividade (Context cntx){
		dao = new SQL(cntx);
		db = dao.db;
	}
	
	@Override
	public long Insert(AtividadeModel item) {
		ContentValues values = new ContentValues();
		values.put(AtividadeModel.WHAT, item.getWhat());
		values.put(AtividadeModel.WHY, item.getWhy());
		values.put(AtividadeModel.WHERE, item.getWhere());
		values.put(AtividadeModel.WHEN, item.getWhen());
		values.put(AtividadeModel.WHO, item.getWho());
		values.put(AtividadeModel.HOW, item.getHow());
		values.put(AtividadeModel.HOWMUCH, item.getHowmuch());		
		
		long id = db.insert(ATIVIDADE, "", values);
		return id;
	}

	@Override
	public long Update(AtividadeModel item) {
		ContentValues values = new ContentValues();
		values.put(AtividadeModel.WHAT, item.getWhat());
		values.put(AtividadeModel.WHY, item.getWhy());
		values.put(AtividadeModel.WHERE, item.getWhere());
		values.put(AtividadeModel.WHEN, item.getWhen());
		values.put(AtividadeModel.WHO, item.getWho());
		values.put(AtividadeModel.HOW, item.getHow());
		values.put(AtividadeModel.HOWMUCH, item.getHowmuch());
		
		String _id = String.valueOf(item.getIdAtiv());

		String where = AtividadeModel.ID + "=?";
		String[] whereArgs = new String[] { _id };

		int count = db.update(ATIVIDADE, values, where, whereArgs);

		return count;
	}

	@Override
	public List<AtividadeModel> Select() {
		Cursor c = getCursor();
		List<AtividadeModel> comms = new ArrayList<AtividadeModel>();
		if (c.moveToFirst()) {
			// Recupera os índices das colunas
			int idxId = c.getColumnIndex(AtividadeModel.ID);			
			int idxWhat = c.getColumnIndex(AtividadeModel.WHAT);
			int idxWhy = c.getColumnIndex(AtividadeModel.WHY);
			int idxWhere = c.getColumnIndex(AtividadeModel.WHERE);
			int idxWhen = c.getColumnIndex(AtividadeModel.WHEN);
			int idxWho = c.getColumnIndex(AtividadeModel.WHO);
			int idxHow = c.getColumnIndex(AtividadeModel.HOW);
			int idxHowMuch = c.getColumnIndex(AtividadeModel.HOWMUCH);
			
			
			// Loop até o final
			do {
				AtividadeModel com = new AtividadeModel();
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
	public AtividadeModel Select(long id) {
		Cursor c = db.query(true, ATIVIDADE, AtividadeModel.colunas, AtividadeModel.ID + "=" + id, null, null, null, null, null);
		if (c.getCount() > 0) {
			// Posiciona no primeiro elemento do cursor
			c.moveToFirst();
			AtividadeModel com = new AtividadeModel();
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
		String where = AtividadeModel.ID + "=?";
		String _id = String.valueOf(id);
		String[] whereArgs = new String[] { _id };
		int count = db.delete(ATIVIDADE, where, whereArgs);
		return count;
	}
	
	@Override
	public Cursor getCursor() {
		try {
			// select * from 
			return db.query(ATIVIDADE, AtividadeModel.colunas, null, null, null, null, null, null);
		} catch (SQLException e) {			
			return null;
		}
	}

}
