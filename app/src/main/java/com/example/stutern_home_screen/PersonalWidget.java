package com.example.stutern_home_screen;

public class PersonalWidget extends BasicWidget {

    private String mWidgetCaption;

    public PersonalWidget(int imageResourceId, String title, String caption) {
        super(imageResourceId, title);
        mWidgetCaption = caption;
    }

    public String getWidgetSubtitle() {
        return mWidgetCaption;
    }
}
