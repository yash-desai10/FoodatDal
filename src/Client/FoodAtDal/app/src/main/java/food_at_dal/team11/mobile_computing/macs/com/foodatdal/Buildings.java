package food_at_dal.team11.mobile_computing.macs.com.foodatdal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
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
 * {@link Buildings.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Buildings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Buildings extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<ListItem> mList;

    private OnFragmentInteractionListener mListener;

    public Buildings() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Buildings.
     */
    // TODO: Rename and change types and number of parameters
    public static Buildings newInstance(String param1, String param2) {
        Buildings fragment = new Buildings();
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
        mList.add(new ListItem("Killam Library", R.drawable.killam)); //Image source: https://www.yelp.ca/biz_photos/killam-memorial-library-halifax?select=1jucUPhybWld-teIk5FGew
        mList.add(new ListItem("DSU", R.drawable.dsu)); //Image source: https://www.dal.ca/campus-maps/building-directory/studley-campus/sub.html
        mList.add(new ListItem("Tupper Building", R.drawable.tupper)); //Image source: https://www.news957.com/local/2015/11/17/dalhousie-medical-school-closed-after-biohazardous-material-found/
        mList.add(new ListItem("Mona Campbell", R.drawable.mona_campbell)); //Image source: https://www.canadianconsultingengineer.com/features/mona-campbell-building/
        mList.add(new ListItem("Goldberg", R.drawable.goldberg)); //Image source: https://csgs.cs.dal.ca/events/dcsi/
        mList.add(new ListItem("LSC Common Area", R.drawable.lsc_common)); //Image source: https://www.dal.ca/dept/facilities/campus-development/projects/life-sciences-centre-retrofit-project.html
        mList.add(new ListItem("Dalplex", R.drawable.dalplex)); //Image source: https://www.dal.ca/campus-maps/building-directory/studley-campus/dalplex.html
        mList.add(new ListItem("Sexton House", R.drawable.sexton)); //Image source: https://www.dal.ca/campus-maps/building-directory/sexton-campus/sexton-house.html
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_buildings,container,false );
        RecyclerView recyclerview=(RecyclerView)v.findViewById(R.id.recycler_view_buildings);
        GridLayoutManager gl=new GridLayoutManager(getActivity(),2);
//        DividerItemDecoration itemDecoration=new DividerItemDecoration(getActivity(),lm.getOrientation());

        EateriesAlertDialogAdapter eateriesAdapter=new EateriesAlertDialogAdapter(getContext(),mList);

        recyclerview.setLayoutManager(gl);

        recyclerview.setAdapter(eateriesAdapter);




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
        void onFragmentInteraction(Uri uri);
    }
}
