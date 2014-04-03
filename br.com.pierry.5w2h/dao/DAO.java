package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DAO {	
	// Nome do banco
	protected final String NOME_BANCO = "cwdh";
	
	// Controle de versão
	protected final int VERSAO_BANCO = 1;

	// Nome da tabela	
	public static final String ATIVIDADE = "ativ";
	
	protected SQLiteDatabase db;

	public DAO(Context ctx) {
		// Abre o banco de dados já existente
		db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
	}

	protected DAO() {
		// Apenas para criar uma subclasse...
	}
	
	// Fecha o banco
	public void closeDB() {
		// fecha o banco de dados
		if (db != null) {
			db.close();
		}
	}

}
