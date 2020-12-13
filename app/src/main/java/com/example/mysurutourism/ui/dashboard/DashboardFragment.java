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

        itemList.add(new ItemDetails("All India Arts and Crafts Museum","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/All%20India%20Arts%20and%20Crafts%20Museum.jpg?alt=media&token=e3b99547-e660-4df3-99d8-7cdf289d47c1","123"));
        itemList.add(new ItemDetails("Avadhoota datta peetham","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Avadhoota%20datta%20peetham.jpg?alt=media&token=d104a59b-7b05-4964-90ed-e5fa0890645a","14"));
        itemList.add(new ItemDetails("C V Rangacharlu memorial hall","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/C%20V%20Rangacharlu%20memorial%20hall.jpg?alt=media&token=19cbd5c5-dbb8-4698-9104-135008a25753","12"));
        itemList.add(new ItemDetails("Dasara exhibition ground","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Dasara%20exhibition%20ground.jpg?alt=media&token=235d6b7e-32ea-49bc-a603-8bb2d3f076c4","343"));
        itemList.add(new ItemDetails("Devaraja Market","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Devaraja%20Market.jpg?alt=media&token=1866a307-abde-4e95-ae0d-f68439c1a47f","23"));
        itemList.add(new ItemDetails("GRS Fantasy Park","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/GRS%20Fantasy%20Park.jpg?alt=media&token=d9b83bf4-1df7-46a0-abe4-4471fa937b43","123"));
        itemList.add(new ItemDetails("Dufferin clock tower","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Dufferin%20clock%20tower.jpg?alt=media&token=7463ef98-0321-49df-b99a-87a500ff9198","14"));
        itemList.add(new ItemDetails("Happy man park","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Happy%20man%20park.jpg?alt=media&token=87dd283e-ad06-4fb6-b6c3-580766859180","12"));
        itemList.add(new ItemDetails("Himad Gopalaswamy Temple","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Himad%20Gopalaswamy%20Temple.jpg?alt=media&token=a5078fa0-9930-4222-9067-94bdc1c07c08","12"));
        itemList.add(new ItemDetails("Indira Gandhi Rashtriya Manav Sangrahalaya","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Indira%20Gandhi%20Rashtriya%20Manav%20Sangrahalaya.jpg?alt=media&token=2082620e-c876-4312-b5b9-096596cdc7fc","12"));
        itemList.add(new ItemDetails("Jailakshmi vilas","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Jailakshmi%20vilas.jpg?alt=media&token=1a86a8ef-2596-4c79-bcf9-ee5e2f8368e7","12"));
        itemList.add(new ItemDetails("Jamia Masjid","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Jamia%20Masjid.jpg?alt=media&token=3d00fcfc-62e3-4099-b8c9-94f42bb9d9a7","12"));
        itemList.add(new ItemDetails("Karangi Lake","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Karangi%20Lake.jpg?alt=media&token=92afdd51-813c-4491-b163-331b2d1a3efe","12"));
        itemList.add(new ItemDetails("Krishna Rajendra circle","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Krishna%20Rajendra%20circle.jpg?alt=media&token=45b3c6cd-3eef-434a-8a37-345b9c287456","12"));
        itemList.add(new ItemDetails("Lakshmi Venkataramanaswamy temple","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Lakshmi%20Venkataramanaswamy%20temple.jpg?alt=media&token=cfd40345-8a7c-4e46-90b7-21e18252970b","12"));
        itemList.add(new ItemDetails("Lalitha Mahal","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Lalitha%20Mahal.jpg?alt=media&token=2b713685-b0d6-45c9-a907-6e2bcf4de39f","12"));
        itemList.add(new ItemDetails("Melody world wax museum","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Melody%20world%20wax%20museum.jpg?alt=media&token=69b31583-fb0a-44b2-bebc-c5217be83b7c","12"));
        itemList.add(new ItemDetails("Mysore Palace","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Mysore%20Palace.jpg?alt=media&token=4c01fa69-6ad4-44d0-8d6b-f6f2d058567b","12"));
        itemList.add(new ItemDetails("Mysore Zoo","https://firebasestorage.googleapis.com/v0/b/mysuru-tourism-5c576.appspot.com/o/Mysore%20Zoo.jpg?alt=media&token=89329fd3-9b02-4e46-9894-0598a926e8de","12"));

        adapterItem = new Recycler_Adapter(itemList,getContext(),getActivity());
        recyclerView.setAdapter(adapterItem);

        return root;
    }
}