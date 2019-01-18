package com.example.jngu.prototype;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoActivity extends Activity {
    private RecyclerView ComponentListView;
    boolean expandFlag = false;
    private TextView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        ComponentListView = findViewById(R.id.product_info_component_list_view);
        ComponentListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        btn = findViewById(R.id.product_info_component_list_btn);


        ArrayList<ExpandableComponentListAdaptor.Item> ComponentList = new ArrayList<>();
        ComponentList.add(new ExpandableComponentListAdaptor.Item("a", 30));
        ComponentList.add(new ExpandableComponentListAdaptor.Item("b", 50));
        ComponentList.add(new ExpandableComponentListAdaptor.Item("c", 80));

        final ExpandableComponentListAdaptor ecla = new ExpandableComponentListAdaptor(ComponentList);
        ComponentListView.setAdapter(ecla);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!expandFlag) {
                    ecla.expand();
                    expandFlag = true;
                } else {
                    ecla.close();
                    expandFlag = false;
                }
            }
        });

    }
}
