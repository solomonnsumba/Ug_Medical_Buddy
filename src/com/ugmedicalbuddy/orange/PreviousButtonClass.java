package com.ugmedicalbuddy.orange;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class PreviousButtonClass implements OnClickListener{
    private int mRegionColor;
    private String text;
    private Inspiration mMainActivity;
    smss storageObj =new smss();

   private static int count=NextButtonClass.getCount();

    public PreviousButtonClass(int regionColor, Inspiration mainActivity) {
        this.mRegionColor = regionColor;
        this.mMainActivity = mainActivity;
    }
    @Override
    public void onClick(View clickedButton) {
        count--;
        setRegionText(storageObj.getArray(), mMainActivity.getTxtView());
    }
    public void setRegionText(String[] array, TextView txV) {
        if(count<0) count = storageObj.getArray().length - 1;
        System.out.println("Count at previous: "+count);
        txV.setText(array[count]);
        //Toast.makeText(mMainActivity,(array[count]),Toast.LENGTH_SHORT).show();

    }
    public static int getCount(){
        return count;
    }

    public static void setCount(int countVal){
        count = countVal;
    }

}