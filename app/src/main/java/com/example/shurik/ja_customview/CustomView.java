package com.example.shurik.ja_customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by shurik on 29.01.2018.
 */

public class CustomView extends View {

    private Context context;
    private Paint paintLine;
    private Paint paintText;

    private List<Point> pointList;

    private String text = "";

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.context = context;

        pointList = new ArrayList<>();

        paintLine   = new Paint();
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setColor(0xFF33B5E5);
        paintLine.setStrokeWidth(10);

        paintText = new Paint();
        paintText.setColor(Color.BLUE);
        paintText.setTextSize(45);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomView);

        text = attributes.getString(R.styleable.CustomView_test);

        if (text == null){
            text = "";
        } else {
            Log.v("Tag : ", text);
        }

    }


    public void setListPoint(List<Point> listPoints){
        pointList.clear();
        pointList.addAll(listPoints);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //drawLineOnCustomView(canvas);
        drawLinesOnCustomView(canvas);
        drawTextOnCustomView(canvas);
    }

    private void drawLineOnCustomView(Canvas canvas){

        int left = getPaddingLeft();
        int right = getPaddingRight();
        int top = getPaddingTop();
        int bottom = getPaddingBottom();

        canvas.drawLine(100, 100, 300, 350, paintLine);

    }

    private void drawLinesOnCustomView(Canvas canvas){

        //int count = pointList.size() - 1;

        for (int i = 0; i < pointList.size(); i++){
            if (i == 0){
                canvas.drawLine(pointList.get(i).getX(), pointList.get(i).getY(), pointList.get(i).getX(), pointList.get(i).getY(), paintLine);
            } else {
                canvas.drawLine(pointList.get(i-1).getX(), pointList.get(i-1).getY(), pointList.get(i).getX(), pointList.get(i).getY(), paintLine);
            }

        }

    }

    private void drawTextOnCustomView(Canvas canvas){

        canvas.drawText(text, 200, 200, paintText);
    }

}
