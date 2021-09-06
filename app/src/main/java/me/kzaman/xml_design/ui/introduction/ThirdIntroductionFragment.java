package me.kzaman.xml_design.ui.introduction;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import me.kzaman.xml_design.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdIntroductionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdIntroductionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdIntroductionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThirdIntroductionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdIntroductionFragment newInstance(String param1, String param2) {
        ThirdIntroductionFragment fragment = new ThirdIntroductionFragment();
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
         return inflater.inflate(R.layout.fragment_third_introduction, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // nav controller
        NavController navController = Navigation.findNavController(view);

        // click skip button
        TextView tvSkip = view.findViewById(R.id.tvSkip);
        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_find_your_doctor_to_login_welcome);
            }
        });


        // go to second fragment by clicking next button
        TextView tvNext = view.findViewById(R.id.tvNext);
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_discuss_in_the_forum_to_login_welcome);
                Toast.makeText(getContext(), "Next Clicked", Toast.LENGTH_LONG).show();
            }
        });

        // go to second fragment by clicking bottom dot button
        ImageButton ibFirstIntro = view.findViewById(R.id.ibFirstIntro);
        ibFirstIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.find_your_doctor);
                Toast.makeText(getContext(), "Clicked First", Toast.LENGTH_LONG).show();
            }
        });

        // go to second fragment by clicking bottom dot button
        ImageButton ibSecondIntro = view.findViewById(R.id.ibSecondIntro);
        ibSecondIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.storage_your_medical_records);
                Toast.makeText(getContext(), "Clicked Second intro", Toast.LENGTH_LONG).show();
            }
        });

    }
}