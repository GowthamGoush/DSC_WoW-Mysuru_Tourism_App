package com.example.mysurutourism.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mysurutourism.R;
import com.example.mysurutourism.newsData;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;

public class NotificationsFragment extends Fragment {

    private static final String ACCESS_TOKEN = "9e153bcedf7c432f9b6361bdae1ce8c6";
    private NotificationsViewModel notificationsViewModel;
    private CardView cardView1,cardView2,cardView3;
    private RequestQueue requestQueue,requestQueue1;
    private List<newsData> newsDataList;
    private TextView textView1,textView2,textView3,textView4,textView5;
    private TextView textView6,textView7,textView8,textView9,textView10,textView11;
    SliderLayout sliderLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        cardView1 = root.findViewById(R.id.Card_1);
        cardView2 = root.findViewById(R.id.Card_2);
        cardView3 = root.findViewById(R.id.Card_3);

        cardView1.animate().translationZ(50f).setDuration(1000).start();
        cardView2.animate().translationZ(50f).translationX(200f).setDuration(1000).start();
        cardView3.animate().translationZ(50f).translationX(-200f).setDuration(1000).start();

        textView1 = root.findViewById(R.id.casesIndian);
        textView2 = root.findViewById(R.id.casesForeign);
        textView3 = root.findViewById(R.id.casesTotal);
        textView4 = root.findViewById(R.id.discharged);
        textView5 = root.findViewById(R.id.dead);

        textView6 = root.findViewById(R.id.casesIndian2);
        textView7 = root.findViewById(R.id.casesForeign2);
        textView8 = root.findViewById(R.id.casesTotal2);
        textView9 = root.findViewById(R.id.discharged2);
        textView10 = root.findViewById(R.id.dead2);
        textView11 = root.findViewById(R.id.locUnknown);

        newsDataList = new ArrayList<>();

        sliderLayout = root.findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL);
        sliderLayout.setScrollTimeInSec(1);

        requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue1 = Volley.newRequestQueue(getActivity());

        jsonNewsFeedReq();
        jsonCovidFeedReq();

        setSliderViews();
        return root;
    }

    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            SliderView sliderView = new SliderView(getActivity());

            switch (i) {
                case 0:
                    sliderView.setImageUrl("https://i.ytimg.com/vi/uHOGt2yCzUI/maxresdefault.jpg");
                    sliderView.setDescription("Inside COVID-19 vaccine development process - ABC 10 News");
                    break;
                case 1:
                    sliderView.setImageUrl("https://images.moneycontrol.com/static-mcnews/2020/02/Kerala-Chief-Minister-Pinarayi-Vijayan-addresses-during-an-event-organised-by-Mumbai-Collective-at-YB-Chavan-Auditorium-in-Mumbai-Feb-2-2020-PTI-770x433.jpg");
                    sliderView.setDescription("COVID-19 vaccine will be provided free of cost in Kerala: CM Pinarayi Vijayan - Moneycontrol.com");
                    break;
                case 2:
                    sliderView.setImageUrl("https://c.ndtvimg.com/2020-12/18e24qv_coronavirus-vaccine-generic-reuters_625x300_10_December_20.jpg");
                    sliderView.setDescription("100 People May Be Vaccinated Per Session: Centre's New SOP On Covid - NDTV");
                    break;
                case 3:
                    sliderView.setImageUrl("https://akm-img-a-in.tosshub.com/indiatoday/images/story/202012/SII_vaccine_reuters-647x363.png?53RQSuQoQ.YwGEnXdn7TBnAiEWCwG9_y");
                    sliderView.setDescription("India readies for 600 million Covid vaccine doses, to use standard cold storage, electoral rolls for distribution - India Today");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);
        }
    }

    public void jsonNewsFeedReq(){

        String itemUrl = "http://newsapi.org/v2/top-headlines?"+"country=in"+"&q=covid&apiKey"+ACCESS_TOKEN;

        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, itemUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("articles");

                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String title = jsonObject.getString("title");
                                String imageUrl = jsonObject.getString("urlToImage");

                                newsDataList.add(new newsData(imageUrl,title));
                            }

                            setSliderViews();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(request);
    }

    public void jsonCovidFeedReq(){

        String itemUrl = "https://api.rootnet.in/covid19-in/stats/latest";

        final JsonObjectRequest request1 = new JsonObjectRequest(Request.Method.GET, itemUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObject = response.getJSONObject("data");
                            JSONArray jsonArray = jsonObject.getJSONArray("regional");
                            JSONObject covidData2 = jsonObject.getJSONObject("summary");

                            int casesIndian = 0,casesForeign = 0,discharged = 0,deaths = 0,casesTotal = 0;
                            int casesIndian2 = 0,casesForeign2 = 0,discharged2 = 0,deaths2 = 0,casesTotal2 = 0,locUnknown = 0;

                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject covidData = jsonArray.getJSONObject(i);
                                String loc = covidData.getString("loc");
                                if(loc.equals("Karnataka")){
                                    casesIndian = covidData.getInt("confirmedCasesIndian");
                                    casesForeign = covidData.getInt("confirmedCasesForeign");
                                    discharged = covidData.getInt("discharged");
                                    deaths = covidData.getInt("deaths");
                                    casesTotal = covidData.getInt("totalConfirmed");
                                    break;
                                }
                            }

                            textView1.setText("Confirmed cases - Indian : "+Integer.toString(casesIndian));
                            textView2.setText("Confirmed cases - Foreign : "+Integer.toString(casesForeign) );
                            textView3.setText("Confirmed cases - Total : "+Integer.toString(casesTotal) );
                            textView4.setText("Discharged cases : "+Integer.toString(discharged) );
                            textView5.setText("Total death : "+Integer.toString(deaths) );

                            casesIndian2 = covidData2.getInt("confirmedCasesIndian");
                            casesForeign2 = covidData2.getInt("confirmedCasesForeign");
                            discharged2 = covidData2.getInt("discharged");
                            deaths2 = covidData2.getInt("deaths");
                            casesTotal2 = covidData2.getInt("total");
                            locUnknown = covidData2.getInt("confirmedButLocationUnidentified");

                            textView6.setText("Confirmed cases - Indian : "+Integer.toString(casesIndian2));
                            textView7.setText("Confirmed cases - Foreign : "+Integer.toString(casesForeign2) );
                            textView8.setText("Confirmed cases - Total : "+Integer.toString(casesTotal2) );
                            textView9.setText("Discharged cases : "+Integer.toString(discharged2) );
                            textView10.setText("Total death : "+Integer.toString(deaths2) );
                            textView11.setText("Confirmed but location unknown : "+Integer.toString(locUnknown) );

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue1.add(request1);
    }
}