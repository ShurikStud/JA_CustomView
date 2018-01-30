package com.example.shurik.ja_customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CustomView customView;
    private List<Point>  pointList;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customView  = (CustomView) findViewById(R.id.activity_main_custom_view);
        button = (Button) findViewById(R.id.activity_main_button);

        button.setOnClickListener(this);

        customView.setListPoint(createList());


    }

    @Override
    public void onClick(View v) {
        customView.setListPoint(changeList());
        customView.invalidate();

    }

    private List<Point> createList(){

        pointList   = new ArrayList<>();
        pointList.add(new Point(1, 25));
        pointList.add(new Point(100, 50));
        pointList.add(new Point(200, 118));
        pointList.add(new Point(300, 33));
        pointList.add(new Point(400, 66));
        pointList.add(new Point(500, 85));
        pointList.add(new Point(600, 16));
        pointList.add(new Point(700, 48));

        return pointList;
    }
    private List<Point> changeList(){

        pointList   = new ArrayList<>();
        pointList.add(new Point(1, 400));
        pointList.add(new Point(100, 250));
        pointList.add(new Point(200, 118));
        pointList.add(new Point(300, 200));
        pointList.add(new Point(400, 200));
        pointList.add(new Point(500, 200));
        pointList.add(new Point(600, 200));
        pointList.add(new Point(700, 200));

        return pointList;
    }
}
