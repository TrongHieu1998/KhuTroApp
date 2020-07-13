package com.example.khutroapp.ui.screenchutro.fragment_home_ct;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import com.example.khutroapp.R;
import com.example.khutroapp.ui.screens.activity_contract.ActivityContract;
import com.example.khutroapp.ui.screens.activity_indexwater.ActivityIndexWater;
import com.example.khutroapp.ui.screens.activity_infringe.ActivityInfringe;
import com.example.khutroapp.ui.screens.activity_invoice.ActivityInvoice;
import com.example.khutroapp.ui.screens.activity_roommate.ActivityRoommate;
import com.example.khutroapp.ui.screens.activity_tabernacle.ActivityTabernacle;
import com.example.khutroapp.ui.screens.fragment_home.HomeFragment;


public class FragmentHomeCT extends Fragment {

    public FragmentHomeCT() {
        // Required empty public constructor
    }

    private static FragmentHomeCT instance;

    public static FragmentHomeCT getInstance() {
        if (instance == null) {
            synchronized (FragmentHomeCT.class) {
                if (instance == null) {
                    instance = new FragmentHomeCT();
                }
            }
        }
        return instance;
    }
    View viewRoot;
    private View createView(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_home_ct, null, false);
        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        viewRoot = createView(savedInstanceState);
        super.onCreate(savedInstanceState);
        mapping(viewRoot);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return viewRoot;
    }
    String users;
    RelativeLayout invoice,tabernacle,contract,roommate,infringe,indexwater;
    void mapping(View view){

        Intent intent =getActivity().getIntent();
        users = intent.getStringExtra("Username");
        Log.d("jame", "h:"+users);
        int img[]={R.drawable.phongtro1,R.drawable.phongtro2,R.drawable.phongtro3,R.drawable.phongtro4};
        viewFlipper=(ViewFlipper) view.findViewById(R.id.viewfliper);
        for(int i=0;i<img.length;i++)
        {
            fliperImage(img[i]);
        }
        for(int imgs:img)
        {
            fliperImage(imgs);
        }
        // chuyển qua màn hình hợp đồng
        contract=view.findViewById(R.id.contract);
        contract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), ActivityContract.class);
                intent.putExtra("Username", users);
                startActivity(intent);
            }
        });
        // chuyển qua màn hình hóa đơn
        invoice=view.findViewById(R.id.invoice);
        invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), ActivityInvoice.class);
                intent.putExtra("Username", users);
                startActivity(intent);
            }
        });
        // chuyển qua màn hình tạm trú
        tabernacle=view.findViewById(R.id.tabernacle);
        tabernacle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), ActivityTabernacle.class);
                intent.putExtra("Username", users);
                startActivity(intent);
            }
        });
        // chuyển qua màn hình bạn cùng phòng
        roommate=view.findViewById(R.id.roommate);
        roommate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), ActivityRoommate.class);
                intent.putExtra("Username", users);
                startActivity(intent);
            }
        });
        // chuyển qua màn hình vi phạm
        infringe=view.findViewById(R.id.infringe);
        infringe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), ActivityInfringe.class);
                intent.putExtra("Username", users);
                startActivity(intent);
            }
        });
        // chuyển qua màn hình tạm trú
        indexwater=view.findViewById(R.id.indexwater);
        indexwater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), ActivityIndexWater.class);
                intent.putExtra("Username", users);
                startActivity(intent);
            }
        });
    }
    ViewFlipper viewFlipper;
    public void fliperImage(int imgview)
    {
        ImageView imageView=new ImageView(getContext());
        imageView.setBackgroundResource(imgview);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(getContext(),android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getContext(),android.R.anim.slide_out_right);
    }

}