package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class EateriesAlertDialogAdapter extends RecyclerView.Adapter<EateriesAlertDialogAdapter.MyViewHolder>
{
    private List<ListItem> mlist;
    public String restaurant[] = {"Subway", "Tim Hortons", "Second Cup", "Killam Bistro", "Global Village", "Mezza" };
    public String eateriesInkillam[] = {"Subway", "Second Cup", "Killam Bistro"};
    public String eateriesIndsu[] = {"Tim Hortons", "Grawood", "Mezza"};
    public String eateriesIntupper[] = {"Starbucks"};
    public String eateriesInmonaCampbell[] = {"Topio's"};
    public String eateriesInGoldberg[] = {"Second Cup"};
    public String eateriesInlscCommons[] = {"Pizza Pizza", "Tim Hortons"};
    Context ctx;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public LinearLayout ll;
        public ImageView image;


        public MyViewHolder(View view)
        {
            super(view);

            title = view.findViewById(R.id.title);
            image = view.findViewById(R.id.image);
            ll = view.findViewById(R.id.ll);
        }
    }

    public EateriesAlertDialogAdapter(Context ctx, List<ListItem> mList) {
        this.mlist =mList;
        this.ctx=ctx;
    }


    @Override
    public EateriesAlertDialogAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View itemView = LayoutInflater.from(ctx)
                .inflate(R.layout.list_item, viewGroup, false);
        MyViewHolder vHolder=new MyViewHolder(itemView);



        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int i)
    {
        ListItem item = mlist.get(i);
        myViewHolder.title.setText(mlist.get(i).getTitle());
        myViewHolder.image.setImageDrawable(ctx.getResources().getDrawable(item.getImage()));

        myViewHolder.ll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Choose Eatery") ;
                final int itemSelected = 0;
                switch(mlist.get(i).getTitle()){
                    case "Killam Library":
                    {
                        builder.setSingleChoiceItems(eateriesInkillam, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {

                            }
                        });
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//                eateriesSpinner.setAdapter(adapter);

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                if(itemSelected==0)
                                {
                                    Intent i=new Intent(ctx,SubwayMenu.class);
                                    ctx.startActivity(i);
                                }
                                else if (itemSelected==1)
                                {
                                    Intent i=new Intent(ctx,TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
// dismiss dialog box on "Cancel"
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                        break;
                    }
                    case "DSU":
                    {
                        builder.setSingleChoiceItems(eateriesIndsu, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {

                            }
                        });
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//                eateriesSpinner.setAdapter(adapter);

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                if(itemSelected==0)
                                {
                                    Intent i=new Intent(ctx,SubwayMenu.class);
                                    ctx.startActivity(i);
                                }
                                else if (itemSelected==1)
                                {
                                    Intent i=new Intent(ctx,TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
// dismiss dialog box on "Cancel"
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                        break;
                    }
                    case "Tupper Building":
                    {
                        builder.setSingleChoiceItems(eateriesIntupper, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {

                            }
                        });
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//                eateriesSpinner.setAdapter(adapter);

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                if(itemSelected==0)
                                {
                                    Intent i=new Intent(ctx,SubwayMenu.class);
                                    ctx.startActivity(i);
                                }
                                else if (itemSelected==1)
                                {
                                    Intent i=new Intent(ctx,TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
// dismiss dialog box on "Cancel"
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                        break;
                    }
                    case "Mona Campbell":
                    {
                        builder.setSingleChoiceItems(eateriesInmonaCampbell, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {

                            }
                        });
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//                eateriesSpinner.setAdapter(adapter);

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                if(itemSelected==0)
                                {
                                    Intent i=new Intent(ctx,SubwayMenu.class);
                                    ctx.startActivity(i);
                                }
                                else if (itemSelected==1)
                                {
                                    Intent i=new Intent(ctx,TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
// dismiss dialog box on "Cancel"
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                        break;
                    }
                    case "Goldberg":
                    {
                        builder.setSingleChoiceItems(eateriesInGoldberg, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {

                            }
                        });
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//                eateriesSpinner.setAdapter(adapter);

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                if(itemSelected==0)
                                {
                                    Intent i=new Intent(ctx,SubwayMenu.class);
                                    ctx.startActivity(i);
                                }
                                else if (itemSelected==1)
                                {
                                    Intent i=new Intent(ctx,TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
// dismiss dialog box on "Cancel"
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                        break;
                    }
                    case "LSC Common Area":
                    {
                        builder.setSingleChoiceItems(eateriesInlscCommons, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {

                            }
                        });
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//                eateriesSpinner.setAdapter(adapter);

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                if(itemSelected==0)
                                {
                                    Intent i=new Intent(ctx,SubwayMenu.class);
                                    ctx.startActivity(i);
                                }
                                else if (itemSelected==1)
                                {
                                    Intent i=new Intent(ctx,TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
// dismiss dialog box on "Cancel"
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                        break;
                    }
                    default:
                    {
                            builder.setSingleChoiceItems(restaurant, itemSelected, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {

                                }
                            });
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//                eateriesSpinner.setAdapter(adapter);

                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    if(itemSelected==0)
                                    {
                                        Intent i=new Intent(ctx,SubwayMenu.class);
                                        ctx.startActivity(i);
                                    }
                                    else if (itemSelected==1)
                                    {
                                        Intent i=new Intent(ctx,TimHortonsMenu.class);
                                        ctx.startActivity(i);
                                    }

                                }
                            });
// dismiss dialog box on "Cancel"
                            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

                            AlertDialog dialog = builder.create();
                            dialog.show();
                            break;
                        }
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}

