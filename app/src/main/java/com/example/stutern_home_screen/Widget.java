package com.example.stutern_home_screen;

public class Widget extends BasicWidget {

    private String mWidgetCaption;
    private String mWidgetNotification;

    public Widget(int imageResourceId, String title, String caption, String notification) {
        super(imageResourceId, title);
        mWidgetCaption = caption;
        mWidgetNotification = notification;
    }

    public String getWidgetSubtitle() {
        return mWidgetCaption;
    }

    public String getWidgetNotification() {
        return mWidgetNotification;
    }
}
