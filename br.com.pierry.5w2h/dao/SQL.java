package dao;

import android.content.Context;

public class SQL extends DAO {
	
	// Script para fazer drop na tabela
	public static String droptable;
	
	private static final String SCRIPT_DATABASE_DELETE = "DROP TABLE IF EXISTS " + droptable;	
	
	// Cria a tabela com o "_id" sequencial
	private static final String[] SCRIPT_DATABASE_CREATE = new String[] {
			"create table ativ ( idativ integer primary key autoincrement, awhat text, awhy text, awhere text, awhen text, awho text, ahow text, ahowmuch text );"
		};

	// Classe utilitária para abrir, criar, e atualizar o banco de dados
	private SQLiteHelper dbHelper;

	// Cria o banco de dados com um script SQL
	public SQL(Context ctx) {
		// Criar utilizando um script SQL
		dbHelper = new SQLiteHelper(ctx, super.NOME_BANCO, super.VERSAO_BANCO, SCRIPT_DATABASE_CREATE, SCRIPT_DATABASE_DELETE);
		// abre o banco no modo escrita para poder alterar também
		db = dbHelper.getWritableDatabase();
	}

	// Fecha o banco
	@Override
	public void closeDB() {
		super.closeDB();
		if (dbHelper != null) {
			dbHelper.close();
		}
	}
}

