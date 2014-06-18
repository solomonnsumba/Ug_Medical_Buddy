package com.ugmedicalbuddy.orange;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;




public class NextButtonClass implements OnClickListener {
    private int mRegionColor;
    private String text;
    private Inspiration mMainActivity;
    smss StorageObj = new smss();

    private static int count=PreviousButtonClass.getCount();

    public NextButtonClass(int regionColor, Inspiration mainActivity) {
        this.mRegionColor = regionColor;
        this.mMainActivity = mainActivity;
    }

    @Override
    public void onClick(View clickedButton) {
        count++;
        setRegionText(StorageObj.getArray(), mMainActivity.getTxtView());
        PreviousButtonClass.setCount(count);

    }
    public void setRegionText(String[] array, TextView txV) {
        if(count>StorageObj.getArray().length -1) count = 0;
        txV.setText(array[count]);
        //Toast.makeText(mMainActivity,(array[count]),Toast.LENGTH_SHORT).show();


    }

    public static int getCount(){
        return count;
    }

    public static void setCount(int countVal){
        count= countVal;
    }

}
