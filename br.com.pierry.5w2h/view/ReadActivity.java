package view;

import model.Atividade;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import br.com.pierry.w2h.R;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

import dao.DAOAtividade;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

@EActivity(R.layout.activity_read)
public class ReadActivity extends UtilActionBarActivity {
	

	@ViewById
	TextView tvWhatTexto;
	
	@ViewById
	TextView tvWhyTexto;
	
	@ViewById
	TextView tvWhereTexto;
	
	@ViewById
	TextView tvWhenTexto;
	
	@ViewById
	TextView tvWhoTexto;
		
	@ViewById
	TextView tvHowTexto;
	
	@ViewById
	TextView tvHowMuchTexto;
	
	private DAOAtividade dao;
	private Bundle bundle;
	
	@Override
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		getSupportActionBar().setTitle("5w2h");
		dao = new DAOAtividade(this);
		bundle = getIntent().getExtras();
		
		Atividade ativ = dao.Select(bundle.getLong("id"));
		
		iniciarTextos(ativ.getWhat(), ativ.getWhy(), ativ.getWhere(), ativ.getWhen(), ativ.getWho(), ativ.getHow(), ativ.getHowmuch());
	}
	

	@UiThread
	public void iniciarTextos(String what, String why, String where, String when, String who, String how, String howmuch){
		tvWhatTexto.setText(what);
		tvHowMuchTexto.setText(howmuch);
		tvHowTexto.setText(how);
		tvWhenTexto.setText(when);
		tvWhereTexto.setText(where);
		tvWhoTexto.setText(who);
		tvWhyTexto.setText(why);
	}
	
	
		
}
