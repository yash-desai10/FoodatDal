package com.yashdesai.foodapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Buildings.OnFragmentInteractionListener,Eateries.OnFragmentInteractionListener
{
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
//
//        Button eateriesDialog = (Button) findViewById(R.id.btnEateryDialog);
//        eateriesDialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                View mView = getLayoutInflater().inflate(R.layout.alert_dialog, null);
//                builder.setTitle("Choose Restaurant") ;
//                final Spinner eateriesSpinner = (Spinner) mView.findViewById(R.id.eateries_spinner);
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.eateries));
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//                eateriesSpinner.setAdapter(adapter);
//
//                builder.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        if(!eateriesSpinner.getSelectedItem().toString().equalsIgnoreCase("Choose a restaurant")){
//                            Toast.makeText(MainActivity.this, eateriesSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
//                            dialog.dismiss();
//                        }
//                    }
//                });
//
//                builder.setView(mView);
//                AlertDialog dialog = builder.create();
//                dialog.show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onEateriesFragmentInteraction(Uri uri) {
    }


    @Override
    public void onBuildingsFragmentInteraction(Uri uri) {

    }
    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_buildings, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if(position==0)
            {
                return new Buildings();
            }
            else
            {
                return new Eateries();
            }

        }

        @Override
        public int getCount()
        {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Buildings";
                case 1:
                    return "Eateries";

            }
            return null;
        }
    }
}
