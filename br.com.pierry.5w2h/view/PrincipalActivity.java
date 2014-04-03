package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Atividade;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import br.com.pierry.w2h.R;

import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ItemClick;
import com.googlecode.androidannotations.annotations.ItemLongClick;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

import dao.DAOAtividade;

@EActivity(R.layout.activity_principal)
public class PrincipalActivity extends UtilActionBarActivity {

	@ViewById
	ListView lvAtiv;

	private List<Atividade> listAtividade;
	private DAOAtividade dao;
	private Bundle bundle;

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
	public void getListView(final ProgressDialog dialog) {
		List<Map<String, String>> events = new ArrayList<Map<String, String>>();
		events = populateList();
		dialog.dismiss();
		if (events == null) {

		} else {
			int[] to = { R.id.tvWhatText, R.id.tvWhereText };
			String[] from = { "What", "Where" };

			SimpleAdapter adapter = new SimpleAdapter(this, events,
					R.layout.list_celula_ativ, from, to);
			this.setAdapterList(adapter);
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
	public void setAdapterList(final SimpleAdapter adapter) {
		lvAtiv.setAdapter(adapter);
	}

	public List<Map<String, String>> populateList() {
		listAtividade = dao.Select();
		if (listAtividade == null) {
			return null;
		}
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (int i = 0; i < 10; i++) {
			try {
				Map<String, String> m = new HashMap<String, String>();
				m.put("What", listAtividade.get(i).getWhat());
				m.put("Where", listAtividade.get(i).getWhere());
				list.add(m);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
