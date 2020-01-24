package com.example.stutern_home_screen;

public class BasicWidget {

    private int mImageResourceId;
    private String mWidgetTitle;


    public BasicWidget(int imageResourceId, String title) {
        mImageResourceId = imageResourceId;
        mWidgetTitle = title;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getWidgetTitle() {
        return mWidgetTitle;
    }


}
