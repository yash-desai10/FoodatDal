package com.yashdesai.foodapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Eateries.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Eateries#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Eateries extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //This button is to be replaced with the list item
    private Button btnEatery;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<ListItem> mList;

    private OnFragmentInteractionListener mListener;
    Button eateriesDialog ;

    public Eateries() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Eateries.
     */
    // TODO: Rename and change types and number of parameters
    public static Eateries newInstance(String param1, String param2) {
        Eateries fragment = new Eateries();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        mList=new ArrayList<>();
        mList.add(new ListItem("Subway"));
        mList.add(new ListItem("Tim Hortons"));
        mList.add(new ListItem("Second Cup"));
        mList.add(new ListItem("Global Village"));
        mList.add(new ListItem("Killam Bistro"));
        mList.add(new ListItem("Mezza"));
        mList.add(new ListItem("Pizza Pizza"));
        mList.add(new ListItem("Graywood"));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_eateries,container,false );
        RecyclerView recyclerview=(RecyclerView)v.findViewById(R.id.recycler_view_eateries);
        GridLayoutManager gl=new GridLayoutManager(getActivity(),2);
//        DividerItemDecoration itemDecoration=new DividerItemDecoration(getActivity(),lm.getOrientation());

        MyAdapter myAdapter=new MyAdapter(getContext(),mList);

        recyclerview.setLayoutManager(gl);

        recyclerview.setAdapter(myAdapter);

//        Button eateriesDialog = (Button)v.findViewById(R.id.btnEateryDialog);
//
//        eateriesDialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                View mView = getLayoutInflater().inflate(R.layout.alert_dialog, null);
//                builder.setTitle("Choose Restaurant") ;
//                String restaurant[] = {"Subway", "Mezza", "Second Cup", "Pizza Pizza Pizza", "Timmy Hortons" }; //To be changed
//                int itemSelected = 0;
//                //----- Spinner code commented ----
////                final Spinner eateriesSpinner = (Spinner) mView.findViewById(R.id.eateries_spinner);
////                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.eateries));
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
//                builder.setView(mView);
//                AlertDialog dialog = builder.create();
//                dialog.show();
//            }
//        });

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onEateriesFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onEateriesFragmentInteraction(Uri uri);
    }
}
