package com.example.mysurutourism.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysurutourism.ItemDetails;
import com.example.mysurutourism.MainActivity;
import com.example.mysurutourism.R;
import com.example.mysurutourism.Recycler_Adapter;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private RecyclerView recyclerView;
    private Recycler_Adapter adapterItem;
    private ArrayList<ItemDetails> itemList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerView = root.findViewById(R.id.spotsRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        itemList = new ArrayList<>();

        itemList.add(new ItemDetails("TITLE : Sample1","https://bit.ly/2YoJ77H","123"));
        itemList.add(new ItemDetails("TITLE : Sample2","https://bit.ly/2YoJ77H","14"));
        itemList.add(new ItemDetails("TITLE : Sample3","https://bit.ly/2YoJ77H","12"));
        itemList.add(new ItemDetails("TITLE : Sample4","https://bit.ly/2YoJ77H","343"));
        itemList.add(new ItemDetails("TITLE : Sample5","https://bit.ly/2YoJ77H","23"));


        adapterItem = new Recycler_Adapter(itemList,getContext(),getActivity());
        recyclerView.setAdapter(adapterItem);

        return root;
    }
}