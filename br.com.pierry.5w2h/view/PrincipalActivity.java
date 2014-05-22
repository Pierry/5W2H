package view;

import java.util.List;

import model.AtividadeModel;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import br.com.pierry.w2h.R;

import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ItemClick;
import com.googlecode.androidannotations.annotations.ItemLongClick;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.nhaarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;

import controller.GoogleCardsAdapter;
import dao.DAOAtividade;

@EActivity(R.layout.activity_principal)
public class PrincipalActivity extends UtilActionBarActivity {

	@ViewById
	ListView lvAtiv;

	private List<AtividadeModel> listAtividade;
	private DAOAtividade dao;
	private Bundle bundle;

	private GoogleCardsAdapter mGoogleCardsAdapter;

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		getSupportActionBar().setTitle("5w2h");

		dao = new DAOAtividade(this);

		ProgressDialog dialog = ProgressDialog.show(this, "", "Carregando...");
		dialog.setCancelable(true);
		getListView(dialog);
	}

	@Background
	public void getListView(ProgressDialog dialog) {
		listAtividade = populateList();
		if (listAtividade == null) {
			dialog.dismiss();
		} else if (listAtividade.size() == 0) {
			dialog.dismiss();
		} else {
			this.setAdapterList(listAtividade);
			dialog.dismiss();
		}
	}

	@ItemClick
	public void lvAtivItemClicked(int position) {
		long id = listAtividade.get(position).getIdAtiv();
		bundle = new Bundle();
		bundle.putLong("id", id);
		Intent main = new Intent(this, ReadActivity_.class);
		main.putExtras(bundle);
		startActivity(main);
	}

	@ItemLongClick(R.id.lvAtiv)
	public void lvAtivLongItemClicked(int position) {
		final int posicao = position;
		final Intent main = new Intent(this, PrincipalActivity_.class);
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle("Deseja realmente deletar o item selecionado?");
		alert.setPositiveButton("DELETAR", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				long i = dao.Delete(listAtividade.get(posicao).getIdAtiv());
				if (i > 0) {
					startActivity(main);
				}
			}
		});
		alert.setNegativeButton("CANCELAR", null);
		alert.show();
	}

	@UiThread
	public void setAdapterList(List<AtividadeModel> models) {
		mGoogleCardsAdapter = new GoogleCardsAdapter(this, models);
		SwingBottomInAnimationAdapter swing = new SwingBottomInAnimationAdapter(mGoogleCardsAdapter);
		swing.setAbsListView(lvAtiv);
		lvAtiv.setAdapter(swing);
	}

	public List<AtividadeModel> populateList() {
		listAtividade = dao.Select();
		if (listAtividade == null) {
			return null;
		}
		return listAtividade;
	}

}
