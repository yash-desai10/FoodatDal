package com.yashdesai.foodapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    private List<ListItem> mlist;
    Context ctx;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public RelativeLayout ll;


        public MyViewHolder(View view)
        {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            ll=(RelativeLayout)view.findViewById(R.id.ll);
        }
    }

    public MyAdapter(Context ctx, List<ListItem> mList) {
        this.mlist =mList;
        this.ctx=ctx;
    }





    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder( ViewGroup viewGroup, int i)
    {
        View itemView = LayoutInflater.from(ctx)
                .inflate(R.layout.list_item, viewGroup, false);
        MyViewHolder vHolder=new MyViewHolder(itemView);



        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i)
    {
        myViewHolder.title.setText(mlist.get(i).getTitle());

//        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
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
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}
