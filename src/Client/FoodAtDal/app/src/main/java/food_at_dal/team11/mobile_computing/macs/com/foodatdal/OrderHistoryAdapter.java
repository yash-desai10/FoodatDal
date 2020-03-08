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

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.MyViewHolder>
{

    private List<ListItem2> mlist;
    Context ctx;

    int itemSelected;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,title1,title2;
        public LinearLayout ll;
        public ImageView image;

        public MyViewHolder(View view)
        {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            title1 = (TextView) view.findViewById(R.id.title1);
            title2=(TextView)view.findViewById(R.id.title2);
            ll=(LinearLayout) view.findViewById(R.id.ll);
            image = view.findViewById(R.id.image);
        }
    }

    public OrderHistoryAdapter(Context ctx, List<ListItem2> mList) {
        this.mlist =mList;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public OrderHistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(ctx)
                .inflate(R.layout.list_item_2,viewGroup,false);
        MyViewHolder vHolder=new MyViewHolder(itemView);



        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryAdapter.MyViewHolder myViewHolder, int i)
    {
        ListItem2 item = mlist.get(i);
        myViewHolder.title.setText(mlist.get(i).getTitle());
        myViewHolder.title1.setText(mlist.get(i).getTitle1());
        myViewHolder.title2.setText(mlist.get(i).getTitle2());
        myViewHolder.image.setImageDrawable(ctx.getResources().getDrawable(item.getImage()));
//
//        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////                ctx.startActivity(i);
//                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
//                builder.setTitle("Choose Eatery") ;
//                final String restaurant[] = {"Subway", "Tim Hortons", "Second Cup", "Killam Bistro", "Global Village" }; //To be changed
////                final int itemSelected = 0;
//                //----- Spinner code commented ----
////                final Spinner eateriesSpinner = (Spinner) mView.findViewById(R.id.eateries_spinner);
////                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.eateries));
//
//
//
//                builder.setSingleChoiceItems(restaurant, itemSelected, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which)
//                    {
//
//                    }
//                });
////                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
////                eateriesSpinner.setAdapter(adapter);
//
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which)
//                    {
//                        ListView lw = ((AlertDialog)dialog).getListView();
//                        Object checkedItem = lw.getAdapter().getItem(lw.getCheckedItemPosition());
//                        if(checkedItem.equals("Subway"))
//                        {
//                            Intent i=new Intent(ctx,SubwayMenu.class);
//                            ctx.startActivity(i);
//                        }
//                        else if(checkedItem.equals("Tim Hortons"))
//                        {
//                            Intent i=new Intent(ctx,TimHortonsMenu.class);
//                            ctx.startActivity(i);
//                        }
//
//                    }
//                });
//
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//
//                AlertDialog dialog = builder.create();
//                dialog.show();
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}
