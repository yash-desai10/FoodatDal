package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    private List<ListItem> mlist;
    Context ctx;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public LinearLayout ll;
        public ImageView image;


        public MyViewHolder(View view)
        {
            super(view);

            title =  view.findViewById(R.id.title);
            ll=view.findViewById(R.id.ll);
            image = view.findViewById(R.id.image);
        }
    }

    public MyAdapter(Context ctx, List<ListItem> mList) {
        this.mlist =mList;
        this.ctx=ctx;
    }
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
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
        myViewHolder.ll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ctx, CustomizeOrder.class);
                ctx.startActivity(i);
            }
//                    AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
//                    builder.setTitle("Choose Eatery");
//                    final String restaurant[] = {"Subway", "Tim Hortons", "Second Cup", "Killam Bistro", "Global Village"}; //To be changed
//                    final int itemSelected = 0;
//
//                    builder.setSingleChoiceItems(restaurant, itemSelected, new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//
//                        }
//                    });
////                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
////                eateriesSpinner.setAdapter(adapter);
//
//                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            if (itemSelected == 0) {
//                                Intent i = new Intent(ctx, CustomizeOrder.class);
//                                ctx.startActivity(i);
//                            } else if (itemSelected == 1) {
//                                Intent i = new Intent(ctx, TimHortonsMenu.class);
//                                ctx.startActivity(i);
//                            }
//
//                        }
//                    });
//// dismiss dialog box on "Cancel"
//                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//
//                    AlertDialog dialog = builder.create();
//                    dialog.show();


//            @Override
//            public void onClick(View view) {
////                Intent i=new Intent(ctx,Demo.class);
////                ctx.startActivity(i);
//                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
//                builder.setTitle("Choose Building") ;
//                String restaurant[] = {"Killam", "DSU", "LSC Commons", "Goldberg", "Tupper Building" }; //To be changed
//                int itemSelected = 0;
//                //----- Spinner code commented ----
////                final Spinner eateriesSpinner = (Spinner) mView.findViewById(R.id.eateries_spinner);
////                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.eateries));
//
//
//
//                builder.setSingleChoiceItems(restaurant, itemSelected, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                    }
//                });
////                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
////                eateriesSpinner.setAdapter(adapter);
//
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
////                        if(!eateriesSpinner.getSelectedItem().toString().equalsIgnoreCase("Choose a restaurant")){
////                            Toast.makeText(getActivity(), eateriesSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
////                            dialog.dismiss();
////                        }
//
//                        //------Insert logic to handle selected items here----------
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
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}

