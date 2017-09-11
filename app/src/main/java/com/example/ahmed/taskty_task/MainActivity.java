package com.example.ahmed.taskty_task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ServiceModel> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Service Price List");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new RecyclerAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        Button btn_next=(Button)findViewById(R.id.next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,SelectedService.class);
                intent.putIntegerArrayListExtra("selected", (ArrayList<Integer>) RecyclerAdapter.positionSelected);
                startActivity(intent);

                for (int i=0;i<RecyclerAdapter.positionSelected.size();i++){
                    Log.e("ppp",RecyclerAdapter.positionSelected.get(i)+"");
                }

            }
        });



        try {
            JSONArray m_jArry = new JSONArray(loadJSONFromAsset());
          //  JSONArray m_jArry = obj.getJSONArray("");
            ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> m_li;

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String formula_value = jo_inside.getString("servicename");
                String url_value = jo_inside.getString("pricefrom");
                String url_value_to = jo_inside.getString("priceto");

                //Add your values in your `ArrayList` as below:
                m_li = new HashMap<String, String>();
                m_li.put("servicename", formula_value);
                m_li.put("pricefrom", url_value);
                m_li.put("priceto",url_value_to);

                formList.add(m_li);
                System.out.println(formList.get(i).get("servicename")+"hello");
                Log.e("hello",formList.get(i).get("servicename"));

                ServiceModel serviceModel= new ServiceModel(formula_value,url_value,url_value_to);
                movieList.add(serviceModel);
                mAdapter.notifyDataSetChanged();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
