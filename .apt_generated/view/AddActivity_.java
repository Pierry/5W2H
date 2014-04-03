//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageButton;
import br.com.pierry.w2h.R.id;
import br.com.pierry.w2h.R.layout;
import com.googlecode.androidannotations.api.SdkVersionHelper;

public final class AddActivity_
    extends AddActivity
{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_add);
    }

    private void init_(Bundle savedInstanceState) {
    }

    private void afterSetContentView_() {
        etWhy = ((EditText) findViewById(id.etWhy));
        etWhen = ((EditText) findViewById(id.etWhen));
        etHow = ((EditText) findViewById(id.etHow));
        etWhere = ((EditText) findViewById(id.etWhere));
        btnAdd = ((ImageButton) findViewById(id.btnAdd));
        etWho = ((EditText) findViewById(id.etWho));
        etWhat = ((EditText) findViewById(id.etWhat));
        etHowMuch = ((EditText) findViewById(id.etHowMuch));
        {
            View view = findViewById(id.btnAdd);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        AddActivity_.this.btnAdd();
                    }

                }
                );
            }
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        afterSetContentView_();
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        afterSetContentView_();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        afterSetContentView_();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (((SdkVersionHelper.getSdkInt()< 5)&&(keyCode == KeyEvent.KEYCODE_BACK))&&(event.getRepeatCount() == 0)) {
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }

    public static AddActivity_.IntentBuilder_ intent(Context context) {
        return new AddActivity_.IntentBuilder_(context);
    }

    public static class IntentBuilder_ {

        private Context context_;
        private final Intent intent_;

        public IntentBuilder_(Context context) {
            context_ = context;
            intent_ = new Intent(context, AddActivity_.class);
        }

        public Intent get() {
            return intent_;
        }

        public AddActivity_.IntentBuilder_ flags(int flags) {
            intent_.setFlags(flags);
            return this;
        }

        public void start() {
            context_.startActivity(intent_);
        }

        public void startForResult(int requestCode) {
            if (context_ instanceof Activity) {
                ((Activity) context_).startActivityForResult(intent_, requestCode);
            } else {
                context_.startActivity(intent_);
            }
        }

    }

}
