package view;

import model.Atividade;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import br.com.pierry.w2h.R;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

import dao.DAOAtividade;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

@EActivity(R.layout.activity_add)
public class AddActivity extends UtilActionBarActivity {
	
	@ViewById
	EditText etWhat;
	
	@ViewById
	EditText etWhy;
	
	@ViewById
	EditText etWhere;
	
	@ViewById
	EditText etWhen;
	
	@ViewById
	EditText etWho;
	
	@ViewById
	EditText etHow;
	
	@ViewById
	EditText etHowMuch;
	
	@ViewById
	ImageButton btnAdd;
	
	private DAOAtividade dao;
	
	@Override
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		getSupportActionBar().setTitle("Adicionar");
		dao = new DAOAtividade(this);
	}
	
	public void conferirCampos(){
		if (etWhat.getText().toString().equals("")){
			Crouton.makeText(this, "O campo WHAT está em branco", Style.ALERT).show();
		} else if (etWhy.getText().toString().equals("")){
			Crouton.makeText(this, "O campo WHY está em branco", Style.ALERT).show();
		} else if (etWhere.getText().toString().equals("")){
			Crouton.makeText(this, "O campo WHERE está em branco", Style.ALERT).show();
		} else if (etWhen.getText().toString().equals("")){
			Crouton.makeText(this, "O campo WHEN está em branco", Style.ALERT).show();
		} else if (etWho.getText().toString().equals("")){
			Crouton.makeText(this, "O campo WHO está em branco", Style.ALERT).show();
		} else if (etHow.getText().toString().equals("")){
			Crouton.makeText(this, "O campo HOW está em branco", Style.ALERT).show();
		} else if (etHowMuch.getText().toString().equals("")){
			Crouton.makeText(this, "O campo HOW MUCH está em branco", Style.ALERT).show();
		}
	}
	
	@Click
	public void btnAdd(){
		
		conferirCampos();
		
		Atividade ativ = new Atividade();
		
		ativ.setWhat(etWhat.getText().toString());
		ativ.setWhy(etWhy.getText().toString());
		ativ.setWhere(etWhere.getText().toString());
		ativ.setWhen(etWhen.getText().toString());
		ativ.setWho(etWho.getText().toString());
		ativ.setHow(etHow.getText().toString());
		ativ.setHowmuch(etHowMuch.getText().toString());
		
		long id = dao.Insert(ativ);
		if (id > 0){
			Crouton.makeText(this, "Adicionado com sucesso!", Style.CONFIRM).show();
			Intent main = new Intent(this, PrincipalActivity_.class);
			startActivity(main);
		}
		Crouton.makeText(this, "Erro ao adicionar!", Style.ALERT).show();
	}
	
		
}
