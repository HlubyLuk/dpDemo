package cz.hlubyluk.dp;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements IClickedButton {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.flContent, FragmentHome.NewInstance());
            fragmentTransaction.replace(R.id.flNavigation, FragmentNavigation.newInstance());
            fragmentTransaction.commit();
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.md);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.mdOpen, R.string.mdClose);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void clicked(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.mdBT1:
                fragmentTransaction.replace(R.id.flContent, FragmentOtherUI.newInstanc(((Button) view).getText()));
                break;
            case R.id.mdBT2:
                fragmentTransaction.replace(R.id.flContent, FragmentOtherUI.newInstanc(((Button) view).getText()));
                break;
        }
        fragmentTransaction.addToBackStack(null).commit();
        drawerLayout.closeDrawers();
    }
}
