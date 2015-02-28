package cz.hlubyluk.dp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by HlubyLuk on 28.02.15.
 */
public class OtherUI extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_ui);
        String text = getIntent().getStringExtra("text");
        TextView textView = (TextView) findViewById(R.id.ouiTV);
        textView.setText(text);
    }
}
