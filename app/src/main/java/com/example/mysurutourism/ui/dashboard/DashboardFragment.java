package com.example.mysurutourism.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.mysurutourism.ItemDetails;
import com.example.mysurutourism.MainActivity;
import com.example.mysurutourism.R;
import com.example.mysurutourism.Recycler_Adapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private CardView cardView;
    private RecyclerView recyclerView;
    private Recycler_Adapter adapterItem;
    private ArrayList<ItemDetails> itemList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        cardView = root.findViewById(R.id.spotTitle);

        cardView.animate().translationZ(50f).start();

        recyclerView = root.findViewById(R.id.spotsRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        itemList = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("Popular Tourist Spots").addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                            itemList.add(new ItemDetails(dataSnapshot.child("url").getValue().toString(),dataSnapshot.child("place").getValue().toString(),"1"));
                        }
                        adapterItem = new Recycler_Adapter(itemList,getContext(),getActivity());
                        recyclerView.setAdapter(adapterItem);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );

        return root;
    }
}