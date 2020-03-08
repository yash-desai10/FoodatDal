package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class SubwayMenuAdapter extends RecyclerView.Adapter<SubwayMenuAdapter.MyViewHolder>
{
    private List<ListItem> mlist;
    Context ctx;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title;
        public LinearLayout ll;
        public ImageView image;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            title =itemView.findViewById(R.id.title);
            ll=itemView.findViewById(R.id.ll);
            image =itemView.findViewById(R.id.image);

        }
    }

    public SubwayMenuAdapter(Context ctx, List<ListItem> mList) {
        this.mlist =mList;
        this.ctx=ctx;
    }

    @Override
    public SubwayMenuAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View itemView = LayoutInflater.from(ctx)
                .inflate(R.layout.list_item, viewGroup, false);
        MyViewHolder vHolder=new MyViewHolder(itemView);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i)
    {
        ListItem item = mlist.get(i);
        myViewHolder.title.setText(mlist.get(i).getTitle());
        myViewHolder.image.setImageDrawable(ctx.getResources().getDrawable(item.getImage()));
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
