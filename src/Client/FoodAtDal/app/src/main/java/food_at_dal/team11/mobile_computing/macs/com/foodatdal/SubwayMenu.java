package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class SubwayMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerview;
    private List<ListItem> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Subway Menu");
        setSupportActionBar(toolbar);

        Button btnViewcart = (Button) findViewById(R.id.btnViewcart);
        btnViewcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubwayMenu.this, CheckoutScreen.class);
                startActivity(intent);
                finish();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//        create array list
        mList = new ArrayList<>();
        mList.add(new ListItem("Burger",R.drawable.burger));
        mList.add(new ListItem("Pizza",R.drawable.pizza));
        mList.add(new ListItem("Cookies",R.drawable.cookies));
        mList.add(new ListItem("Fountain Drink",R.drawable.drink));
        mList.add(new ListItem("Hotdog",R.drawable.hotdog));
        mList.add(new ListItem("Fries",R.drawable.french_fries));
//        mList.add(new ListItem("Cookie"));
//        mList.add(new ListItem("Fountain Drink"));
//        mList.add(new ListItem("Hash Brown"));
//        mList.add(new ListItem("Panini"));
//        mList.add(new ListItem("Egg and Cheese Sub"));
//        mList.add(new ListItem("Pizza"));

        GridLayoutManager gl = new GridLayoutManager(this, 2);

        recyclerview = (RecyclerView) findViewById(R.id.recycler_view_subway);
//        MyAdapter sma=new MyAdapter(this,mList);
        MyAdapter sub=new MyAdapter(this,mList);
        recyclerview.setLayoutManager(gl);
        recyclerview.setAdapter(sub);


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


