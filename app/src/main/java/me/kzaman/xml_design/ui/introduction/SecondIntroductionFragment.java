package me.kzaman.xml_design.ui.introduction;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import me.kzaman.xml_design.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondIntroductionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondIntroductionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondIntroductionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondIntroductionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondIntroductionFragment newInstance(String param1, String param2) {
        SecondIntroductionFragment fragment = new SecondIntroductionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second_introduction, container, false);

        // go to second fragment by clicking next button
        TextView tvNext = view.findViewById(R.id.tvNext);
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThirdIntroductionFragment thirdIntroductionFragment = new ThirdIntroductionFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flFragment, thirdIntroductionFragment);
                fragmentTransaction.commit();
            }
        });

        // go to first intro
        ImageButton ibFirstIntro = view.findViewById(R.id.ibFirstIntro);
        ibFirstIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstIntroductionFragment firstIntroductionFragment = new FirstIntroductionFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flFragment, firstIntroductionFragment);
                fragmentTransaction.commit();
            }
        });


        return view;
    }
    public void goToSecondIntroFragment(){
        SecondIntroductionFragment secondIntroductionFragment = new SecondIntroductionFragment();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, secondIntroductionFragment);
        fragmentTransaction.commit();
    }
}