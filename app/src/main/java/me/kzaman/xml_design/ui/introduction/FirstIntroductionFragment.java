package me.kzaman.xml_design.ui.introduction;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
 * Use the {@link FirstIntroductionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstIntroductionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstIntroductionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstIntroductionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstIntroductionFragment newInstance(String param1, String param2) {
        FirstIntroductionFragment fragment = new FirstIntroductionFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_introduction, container, false);
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
                navController.navigate(R.id.action_find_your_doctor_to_storage_your_medical_records);
            }
        });

        // go to second fragment by clicking bottom dot button
        ImageButton ibSecondIntro = view.findViewById(R.id.ibSecondIntro);
        ibSecondIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.storage_your_medical_records);
            }
        });

        // go to second fragment by clicking bottom dot button
        ImageButton ibThirdIntro = view.findViewById(R.id.ibThirdIntro);
        ibThirdIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.discuss_in_the_forum);
            }
        });
    }
}