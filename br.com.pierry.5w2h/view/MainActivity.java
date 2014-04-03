package view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import br.com.pierry.w2h.R;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.Fullscreen;
import com.googlecode.androidannotations.annotations.NoTitle;
import com.googlecode.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
@Fullscreen
@NoTitle
public class MainActivity extends Activity {

	@ViewById
	ImageButton btnLogin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Click
	public void btnLogin(){
		Intent intent = new Intent(this, PrincipalActivity_.class);
		startActivity(intent);
	}

}
