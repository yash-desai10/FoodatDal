package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<ListItem> mList;

    private OnFragmentInteractionListener mListener;

    public Eateries() {
        // Required empty public constructor
    }


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
        mList=new ArrayList<>();
        mList.add(new ListItem("Subway", R.drawable.subway)); //Image source: https://halifaxshoppingcentre.com/stores/halifaxcentre-subway
        mList.add(new ListItem("Tim Hortons", R.drawable.tim_hortons)); //Image source: https://locations.timhortons.com/ca/ns/halifax/1781-upper-water-st.html
        mList.add(new ListItem("Second Cup", R.drawable.second_cup)); //Image source: https://halifaxshoppingcentre.com/stores/halifaxcentre-second-cup
        mList.add(new ListItem("Global Village", R.drawable.global_village)); //Image source: https://www.yelp.ca/biz_photos/curry-village-indian-restaurant-halifax?select=ADIekuAcl-nFL3oGk9AsXQ
        mList.add(new ListItem("Killam Bistro", R.drawable.killam_bistro)); //Image source: https://www.facebook.com/pages/Killam-Bistro/518508778193787
        mList.add(new ListItem("Mezza", R.drawable.mezza)); //Image source: http://www.mezzalebanesekitchen.com/canada/
        mList.add(new ListItem("Pizza Pizza", R.drawable.pizza_pizza)); //Image source: https://www.newswire.ca/news-releases/pizza-pizza-brings-cauliflower-based-pizza-crust-to-menu-689094181.html
        mList.add(new ListItem("Grawood", R.drawable.grawood)); //Image source: https://www.facebook.com/Grawood/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_eateries,container,false );
        RecyclerView recyclerview=(RecyclerView)v.findViewById(R.id.recycler_view_eateries);
        GridLayoutManager gl=new GridLayoutManager(getActivity(),2);
//        DividerItemDecoration itemDecoration=new DividerItemDecoration(getActivity(),lm.getOrientation());

        BuildingsAlertDialogAdapter buildingsAdapter=new BuildingsAlertDialogAdapter(getContext(),mList);

        recyclerview.setLayoutManager(gl);

        recyclerview.setAdapter(buildingsAdapter);


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
