package view;

import model.AtividadeModel;
import utils.TypeFace;
import android.os.Bundle;
import android.widget.TextView;
import br.com.pierry.w2h.R;

import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

import dao.DAOAtividade;

@EActivity(R.layout.activity_read)
public class ReadActivity extends UtilActionBarActivity {
	
	@ViewById
	TextView tvWhat;
	
	@ViewById
	TextView tvWhatTexto;
	
	@ViewById
	TextView tvWhy;
	
	@ViewById
	TextView tvWhyTexto;
	
	@ViewById
	TextView tvWhere;
	
	@ViewById
	TextView tvWhereTexto;
	
	@ViewById
	TextView tvWhen;
	
	@ViewById
	TextView tvWhenTexto;
	
	@ViewById
	TextView tvWho;
	
	@ViewById
	TextView tvWhoTexto;
		
	@ViewById
	TextView tvHow;
	
	@ViewById
	TextView tvHowTexto;
	
	@ViewById
	TextView tvHowMuch;
	
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
		
		this.alterarFontes();
		
		AtividadeModel ativ = dao.Select(bundle.getLong("id"));
		
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
	
	@UiThread
	public void alterarFontes(){
		TypeFace face = new TypeFace(this);
		tvWhat.setTypeface(face.getFace());
		tvWhatTexto.setTypeface(face.getFace());
		tvWhy.setTypeface(face.getFace());
		tvWhyTexto.setTypeface(face.getFace());
		tvWhere.setTypeface(face.getFace());
		tvWhereTexto.setTypeface(face.getFace());
		tvWhen.setTypeface(face.getFace());
		tvWhenTexto.setTypeface(face.getFace());
		tvWho.setTypeface(face.getFace());
		tvWhoTexto.setTypeface(face.getFace());
		tvHow.setTypeface(face.getFace());
		tvHowTexto.setTypeface(face.getFace());
		tvHowMuch.setTypeface(face.getFace());
		tvHowMuchTexto.setTypeface(face.getFace());
	}
	
	
		
}
