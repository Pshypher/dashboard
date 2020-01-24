package com.example.stutern_home_screen;

public class UtilityWidget extends BasicWidget {

    private String mWidgetNotification;

    public UtilityWidget(int imageResourceId, String title, String notification) {
        super(imageResourceId, title);
        mWidgetNotification = notification;
    }

    public String getWidgetNotification() {
        return mWidgetNotification;
    }
}
