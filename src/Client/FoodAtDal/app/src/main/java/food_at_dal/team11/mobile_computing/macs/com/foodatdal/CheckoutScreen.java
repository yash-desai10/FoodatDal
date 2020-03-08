package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class CheckoutScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private List<ListItem2> mList;
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_screen);

        Button btnPlaceOrder = (Button) findViewById(R.id.btnPlaceOrder);
        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutScreen.this, CurrentOrder.class);
                startActivity(intent);
                finish();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Checkout Screen");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//
        mList=new ArrayList<>();
        mList.add(new ListItem2("Burger","Quantity: 1","CAD: 3", "Sauce: Mustard, Extras: Onions, Cheese: Mozarella", R.drawable.burger));
        mList.add(new ListItem2("Pizza","Quantity: 2","CAD: 5","Sauce: Tomato, Extras: Pepperoni, Cheese: Parmesan cheese",R.drawable.pizza));
        mList.add(new ListItem2("Wraps","Quantity: 1","CAD: 4","Sauce: Tomato, Extras: Pepperoni, Cheese: Parmesan cheese",R.drawable.wrap)); //Image source:  https://pngtree.com/free-icon/wrap_1361480


        recyclerview=(RecyclerView)findViewById(R.id.recycler_view_checkout_screen);
        recyclerview.setHasFixedSize(true);
        LinearLayoutManager llm=new LinearLayoutManager(getApplicationContext());
//        DividerItemDecoration itemDecoration=new DividerItemDecoration(getActivity(),lm.getOrientation());

        CheckoutScreenAdapter oha=new CheckoutScreenAdapter(this,mList);

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

        if(id==R.id.nav_current_order)
        {
            Intent i=new Intent(getApplicationContext(),CurrentOrder.class);
            startActivity(i);
        }

        if(id==R.id.nav_order_history)
        {
            Intent i=new Intent(getApplicationContext(),OrderHistory.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
