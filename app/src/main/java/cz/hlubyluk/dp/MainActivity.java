package cz.hlubyluk.dp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.mdOpen, R.string.mdClose);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        LinearLayout navigation = (LinearLayout) findViewById(R.id.mdRL);
        for (int i = 0; i < navigation.getChildCount(); i++) {
            if (navigation.getChildAt(i) instanceof Button) {
                navigation.getChildAt(i).setOnClickListener(this);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Log.wtf("ma-onClick", ((Button) view).getText().toString());
        Intent intent = null;
        switch (view.getId()) {
            case R.id.mdBT1:
                intent = new Intent(this, OtherUI.class);
                intent.putExtra("text", ((Button) view).getText());
                break;
            case R.id.mdBT2:
                intent = new Intent(this, OtherUI.class);
                intent.putExtra("text", ((Button) view).getText());
                break;
        }
        startActivity(intent);
        drawerLayout.closeDrawers();
    }
}
