package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class CheckoutScreenAdapter extends RecyclerView.Adapter<CheckoutScreenAdapter.MyViewHolder>
{

    private List<ListItem2> mlist;
    Context ctx;

    int itemSelected;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,title1,title2, title3;
        public LinearLayout ll;
        public ImageView image;

        public MyViewHolder(View view)
        {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            title1 = (TextView) view.findViewById(R.id.title1);
            title2=(TextView)view.findViewById(R.id.title2);
            title3 = (TextView) view.findViewById(R.id.title3);
            ll=(LinearLayout) view.findViewById(R.id.ll);
            image = view.findViewById(R.id.image);
        }
    }

    public CheckoutScreenAdapter(Context ctx, List<ListItem2> mList) {
        this.mlist =mList;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public CheckoutScreenAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(ctx)
                .inflate(R.layout.list_item_2,viewGroup,false);
        MyViewHolder vHolder=new MyViewHolder(itemView);



        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutScreenAdapter.MyViewHolder myViewHolder, int i)
    {
        ListItem2 item = mlist.get(i);
        myViewHolder.title.setText(mlist.get(i).getTitle());
        myViewHolder.title1.setText(mlist.get(i).getTitle1());
        myViewHolder.title2.setText(mlist.get(i).getTitle2());
        myViewHolder.title3.setText(mlist.get(i).getTitle3());
        myViewHolder.image.setImageDrawable(ctx.getResources().getDrawable(item.getImage()));

        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}

