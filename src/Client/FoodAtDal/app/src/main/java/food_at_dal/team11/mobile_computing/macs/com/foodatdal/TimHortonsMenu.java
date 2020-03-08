package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TimHortonsMenu extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<ListItem> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_hortons_menu);

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view_timhortons);
//        create array list
        mList=new ArrayList<>();
        mList.add(new ListItem("French Vanilla"));
        mList.add(new ListItem("Hot Chochlate"));
        mList.add(new ListItem("Chochlate Mocha"));
        mList.add(new ListItem("Plain Bagel"));
        mList.add(new ListItem("Hash Brown"));
        mList.add(new ListItem("Four cheese bagel"));
        mList.add(new ListItem("Caramel coffee"));
        mList.add(new ListItem("Turkey Burger"));

        GridLayoutManager gl=new GridLayoutManager(this,2);
        MyAdapter myAdapter=new MyAdapter(this,mList);

        recyclerView.setLayoutManager(gl);

        recyclerView.setAdapter(myAdapter);
    }
}
