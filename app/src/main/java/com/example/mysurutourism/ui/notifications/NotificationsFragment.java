package com.example.mysurutourism.ui.notifications;

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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.mysurutourism.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private CardView cardView1,cardView2,cardView3;
    private RequestQueue requestQueue;
    private ImageSlider imageSlider1;
    private List<SlideModel> newsData;
    private TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        cardView1 = root.findViewById(R.id.Card_1);
        cardView2 = root.findViewById(R.id.Card_2);
        cardView3 = root.findViewById(R.id.Card_3);

        textView = root.findViewById(R.id.sampletext);

        imageSlider1 = root.findViewById(R.id.newsCovid);

        newsData = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(getContext());

        jsonItemReq();

        newsData.add(new SlideModel("https://i.ytimg.com/vi/GP1j7oBWT90/hqdefault.jpg","demo", ScaleTypes.FIT));
        //imageSlider1.setImageList(newsData,ScaleTypes.FIT);

        return root;
    }

    public void jsonItemReq(){

        String itemUrl = "https://newsapi.org/v2/top-headlines?country=in&q=covid&apiKey=9e153bcedf7c432f9b6361bdae1ce8c6";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, itemUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("articles");

                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject datas = jsonArray.getJSONObject(i);

                        String title = datas.getString("title");
                        //String name = datas.getString("name");
                        String imageUrl = datas.getString("urlToImage");

                        newsData.add(new SlideModel(imageUrl,title, ScaleTypes.FIT));
                        if(i==0){
                            textView.setText(title);
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        jsonObjectRequest.setTag("REQ");
        requestQueue.add(jsonObjectRequest);
    }
}