package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CurrentOrderAdapter extends RecyclerView.Adapter<CurrentOrderAdapter.MyViewHolder> {
    private List<ListItem2> mlist;
    Context ctx;


//    int itemSelected;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, title1;
        public LinearLayout ll;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            title1 = (TextView) view.findViewById(R.id.title1);

            ll = (LinearLayout) view.findViewById(R.id.ll);
            image = view.findViewById(R.id.image);
        }
    }


    public CurrentOrderAdapter(Context ctx, List<ListItem2> mList) {
        this.mlist = mList;
        this.ctx = ctx;
    }


    @Override
    public CurrentOrderAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(ctx)
                .inflate(R.layout.list_item_current_order, viewGroup, false);
        CurrentOrderAdapter.MyViewHolder vHolder = new CurrentOrderAdapter.MyViewHolder(itemView);


        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentOrderAdapter.MyViewHolder myViewHolder, int i) {
        ListItem2 item = mlist.get(i);
        myViewHolder.title.setText(mlist.get(i).getTitle());
        myViewHolder.title1.setText(mlist.get(i).getTitle1());

        myViewHolder.image.setImageDrawable(ctx.getResources().getDrawable(item.getImage()));

        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ctx, "Clicked", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}


