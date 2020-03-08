package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CurrentOrder extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    private List<ListItem2> mList;
    RecyclerView recyclerview;
    TextView tv_status;
    int count =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Current Order");
        setSupportActionBar(toolbar);

        Thread t=new Thread()
        {
            public void run()
            {
                while(!isInterrupted())
                {
                    try
                    {
                        Thread.sleep(3000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                                tv_status.setText("Order prepared");
                                tv_status.setTextColor(Color.parseColor("#00FF00"));
                            }
                        });
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        tv_status=(TextView)findViewById(R.id.tv_status);
//
        mList=new ArrayList<>();
        mList.add(new ListItem2("Burger","Quantity: 1"," ",R.drawable.burger));
        mList.add(new ListItem2("Pizza","Quantity: 2"," ",R.drawable.pizza));
//        mList.add(new ListItem2("Fries","Quantity: 1","CAD: 4",R.drawable.french_fries));


        recyclerview=(RecyclerView)findViewById(R.id.recycler_view_currentorder);
        recyclerview.setHasFixedSize(true);
        LinearLayoutManager llm=new LinearLayoutManager(getApplicationContext());
//        DividerItemDecoration itemDecoration=new DividerItemDecoration(getActivity(),lm.getOrientation());

        CurrentOrderAdapter oha=new CurrentOrderAdapter(this,mList);

        recyclerview.setLayoutManager(llm);

        recyclerview.setAdapter(oha);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if(id==R.id.nav_logout)
        {
            Intent i=new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(i);
        }
        else if(id==R.id.nav_current_order)
        {
            Intent i=new Intent(getApplicationContext(),CurrentOrder.class);
            startActivity(i);
        }
        else if(id==R.id.nav_order_history)
        {
            Intent i=new Intent(getApplicationContext(),OrderHistory.class);
            startActivity(i);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
