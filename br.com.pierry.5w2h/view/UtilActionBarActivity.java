package view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import br.com.pierry.w2h.R;

import com.googlecode.androidannotations.annotations.EActivity;

@EActivity
public class UtilActionBarActivity extends ActionBarActivity {

	private ActionBar actionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionBar = getSupportActionBar();
		actionBar.setIcon(R.drawable.logotopo);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(false);
	}

	public Dialog onCreateDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		LayoutInflater inflater = this.getLayoutInflater();
		View view = inflater.inflate(R.layout.dialog_oquee, null);
		builder.setPositiveButton("Ok", null);		
		builder.setView(view);
		return builder.create();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();

		inflater.inflate(R.menu.mapa_menu, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_add:
			Intent add = new Intent(this, AddActivity_.class);
			startActivity(add);
			return true;
		case R.id.action_help:
			Dialog dialog = onCreateDialog();
			dialog.setCancelable(true);
			dialog.show();			
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
