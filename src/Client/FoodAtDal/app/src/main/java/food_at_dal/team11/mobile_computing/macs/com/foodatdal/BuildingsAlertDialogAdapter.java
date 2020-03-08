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

public class BuildingsAlertDialogAdapter extends RecyclerView.Adapter<BuildingsAlertDialogAdapter.MyViewHolder>
{
    private List<ListItem> mlist;
    Context ctx;
    public String building[] = {"Killam", "DSU", "Tupper Building", "Mona Campbell", "Goldberg", "LSC Common Area" };
    public String buildingsHavingSubway[] = {"Killam Library"};
    public String buildingsHavingTimHortons[] = {"DSU", "LSC Commons Area"};
    public String buildingsHavingSecondCup[] = {"Killam Library", "Goldberg"};
    public String buildingsHavingGlobalvillage[] = {"DSU"};
    public String buildingsHavingKillamBistro[] = {"Killam Library"};
    public String buildingsHavingMezza[] = {"DSU"};
    public String buildingsHavingPizzaPizza[] = {"LSC Commons"};
    public String buildingsHavingGrawood[] = {"DSU"};
    public String buildingsHavingTopios[] = {"Mona Campbell"};
    public String buildingsHavingStarbucks[] = {"Tupper Building"};

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

    public BuildingsAlertDialogAdapter(Context ctx, List<ListItem> mList) {
        this.mlist =mList;
        this.ctx=ctx;
    }


    @Override
    public BuildingsAlertDialogAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
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
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Choose Buildings");
                final int itemSelected = 0;
                switch(mlist.get(i).getTitle()) {
                    case "Subway": {
                        builder.setSingleChoiceItems(buildingsHavingSubway, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (itemSelected == 0) {
                                    Intent i = new Intent(ctx, SubwayMenu.class);
                                    ctx.startActivity(i);
                                } else if (itemSelected == 1) {
                                    Intent i = new Intent(ctx, TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
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
                    case "Tim Hortons": {
                        builder.setSingleChoiceItems(buildingsHavingTimHortons, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (itemSelected == 0) {
                                    Intent i = new Intent(ctx, SubwayMenu.class);
                                    ctx.startActivity(i);
                                } else if (itemSelected == 1) {
                                    Intent i = new Intent(ctx, TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
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
                    case "Second Cup": {
                        builder.setSingleChoiceItems(buildingsHavingSecondCup, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (itemSelected == 0) {
                                    Intent i = new Intent(ctx, SubwayMenu.class);
                                    ctx.startActivity(i);
                                } else if (itemSelected == 1) {
                                    Intent i = new Intent(ctx, TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
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
                    case "Global Village": {
                        builder.setSingleChoiceItems(buildingsHavingGlobalvillage, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (itemSelected == 0) {
                                    Intent i = new Intent(ctx, SubwayMenu.class);
                                    ctx.startActivity(i);
                                } else if (itemSelected == 1) {
                                    Intent i = new Intent(ctx, TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
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
                    case "Killam Bistro": {
                        builder.setSingleChoiceItems(buildingsHavingKillamBistro, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (itemSelected == 0) {
                                    Intent i = new Intent(ctx, SubwayMenu.class);
                                    ctx.startActivity(i);
                                } else if (itemSelected == 1) {
                                    Intent i = new Intent(ctx, TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
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
                    case "Mezza": {
                        builder.setSingleChoiceItems(buildingsHavingMezza, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (itemSelected == 0) {
                                    Intent i = new Intent(ctx, SubwayMenu.class);
                                    ctx.startActivity(i);
                                } else if (itemSelected == 1) {
                                    Intent i = new Intent(ctx, TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
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
                    case "Pizza Pizza": {
                        builder.setSingleChoiceItems(buildingsHavingPizzaPizza, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (itemSelected == 0) {
                                    Intent i = new Intent(ctx, SubwayMenu.class);
                                    ctx.startActivity(i);
                                } else if (itemSelected == 1) {
                                    Intent i = new Intent(ctx, TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
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
                    case "Grawood": {
                        builder.setSingleChoiceItems(buildingsHavingGrawood, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (itemSelected == 0) {
                                    Intent i = new Intent(ctx, SubwayMenu.class);
                                    ctx.startActivity(i);
                                } else if (itemSelected == 1) {
                                    Intent i = new Intent(ctx, TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
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
                    case "Topio's": {
                        builder.setSingleChoiceItems(buildingsHavingTopios, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (itemSelected == 0) {
                                    Intent i = new Intent(ctx, SubwayMenu.class);
                                    ctx.startActivity(i);
                                } else if (itemSelected == 1) {
                                    Intent i = new Intent(ctx, TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
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
                    case "Starbucks": {
                        builder.setSingleChoiceItems(buildingsHavingStarbucks, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (itemSelected == 0) {
                                    Intent i = new Intent(ctx, SubwayMenu.class);
                                    ctx.startActivity(i);
                                } else if (itemSelected == 1) {
                                    Intent i = new Intent(ctx, TimHortonsMenu.class);
                                    ctx.startActivity(i);
                                }

                            }
                        });
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
                     default: {
                             builder.setSingleChoiceItems(building, itemSelected, new DialogInterface.OnClickListener() {
                                 @Override
                                 public void onClick(DialogInterface dialog, int which) {

                                 }
                             });

                             builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                 @Override
                                 public void onClick(DialogInterface dialog, int which) {
                                     if (itemSelected == 0) {
                                         Intent i = new Intent(ctx, SubwayMenu.class);
                                         ctx.startActivity(i);
                                     } else if (itemSelected == 1) {
                                         Intent i = new Intent(ctx, TimHortonsMenu.class);
                                         ctx.startActivity(i);
                                     }

                                 }
                             });
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


