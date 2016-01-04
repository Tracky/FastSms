package com.example.fastsms.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.example.fastsms.app.fragments.ContactsFragment;


public class MainActivity extends AppCompatActivity implements ContactsFragment.Callbacks{
    private String FRAGMENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = createFragment();
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private Fragment createFragment() {
        if (FRAGMENT == null) {
            return ContactsFragment.newInstance(null);
        } else if (FRAGMENT.equals("ConcreteFragment")) {

        }
        return null;
    }
    //---------Callback-------------
    @Override
    public void onFragmentSelected(String strFragment) {
        FRAGMENT = strFragment;
        Fragment fragment = createFragment();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).
                replace(R.id.fragmentContainer, fragment).addToBackStack(null).commit();
    }

    @Override
    public void onFragmentSelected(String strFragment, Bundle args) {
        FRAGMENT = strFragment;
        Fragment fragment = createFragment();
        fragment.setArguments(args);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).
                replace(R.id.fragmentContainer, fragment).addToBackStack(null).commit();
    }

}
