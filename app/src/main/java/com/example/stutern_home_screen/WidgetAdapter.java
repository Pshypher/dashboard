package com.example.stutern_home_screen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WidgetAdapter extends RecyclerView.Adapter<WidgetAdapter.ViewHolder> {

    private ArrayList<BasicWidget> mUserWidgets;

    private static final int STANDARD_WIDGET = 0;
    private static final int PERSONAL_WIDGET = 1;
    private static final int UTILITY_WIDGET = 2;

    public WidgetAdapter(ArrayList<BasicWidget> widgets) {
        mUserWidgets = widgets;
    }

    @Override
    public int getItemCount() {
        return mUserWidgets.size();
    }

    @Override
    public int getItemViewType(int position) {
        int type;

        BasicWidget widget = mUserWidgets.get(position);
        if (widget instanceof Widget) {
            type = STANDARD_WIDGET;
        }
        else if (widget instanceof PersonalWidget) {
            type = PERSONAL_WIDGET;
        }
        else {
            type = UTILITY_WIDGET;
        }

        return type;
    }

    @Override
    public void onBindViewHolder(@NonNull WidgetAdapter.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {
            case STANDARD_WIDGET:
                WidgetViewHolder viewHolder = (WidgetViewHolder) holder;
                Widget widget = (Widget) mUserWidgets.get(position);
                viewHolder.setImage(widget.getImageResourceId());
                viewHolder.setTitle(widget.getWidgetTitle());
                viewHolder.setSubtitle(widget.getWidgetSubtitle());
                viewHolder.setNotification(widget.getWidgetNotification());
                break;
            case PERSONAL_WIDGET:
                PersonalWidgetViewHolder viewHolderOne = (PersonalWidgetViewHolder) holder;
                PersonalWidget widgetOne = (PersonalWidget) mUserWidgets.get(position);
                viewHolderOne.setImage(widgetOne.getImageResourceId());
                viewHolderOne.setTitle(widgetOne.getWidgetTitle());
                viewHolderOne.setSubtitle(widgetOne.getWidgetSubtitle());
                break;
            default:
                UtilityWidgetViewHolder viewHolderTwo = (UtilityWidgetViewHolder) holder;
                UtilityWidget widgetTwo = (UtilityWidget) mUserWidgets.get(position);
                viewHolderTwo.setImage(widgetTwo.getImageResourceId());
                viewHolderTwo.setTitle(widgetTwo.getWidgetTitle());
                viewHolderTwo.setNotification(widgetTwo.getWidgetNotification());
                break;
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder;
        View cardView;

        Context context = parent.getContext();
        switch (viewType) {

            case STANDARD_WIDGET:
                cardView = LayoutInflater.from(context).inflate(R.layout.widget,
                        parent, false);
                holder = new WidgetViewHolder(cardView);
                break;
            case PERSONAL_WIDGET:
                cardView = LayoutInflater.from(context).inflate(R.layout.personal_widget,
                        parent, false);
                holder = new PersonalWidgetViewHolder(cardView);
                break;
            default:
                cardView = LayoutInflater.from(context).inflate(R.layout.utility_widget,
                    parent, false);
                holder = new UtilityWidgetViewHolder(cardView);
                break;
        }

        return holder;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView title;


        public ViewHolder(View cardView) {
            super(cardView);

            image = cardView.findViewById(R.id.widget_icon);
            title = cardView.findViewById(R.id.title);

        }

        public void setImage(int imageResourceId) {
            image.setImageResource(imageResourceId);
        }

        public void setTitle(String text) {
            title.setText(text);
        }


    }

    static class WidgetViewHolder extends ViewHolder {

        private TextView subtitle;
        private TextView notification;

        public WidgetViewHolder(View cardView) {
            super(cardView);
            subtitle = cardView.findViewById(R.id.subtitle);
            notification = cardView.findViewById(R.id.notification);
        }

        public void setSubtitle(String text) {
            subtitle.setText(text);
        }

        public void setNotification(String text) {
            notification.setText(text);
        }


    }

    static class PersonalWidgetViewHolder extends ViewHolder {

        private TextView subtitle;

        public PersonalWidgetViewHolder(View cardView) {
            super(cardView);
            subtitle = cardView.findViewById(R.id.subtitle);
        }

        public void setSubtitle(String text) {
            subtitle.setText(text);
        }
    }

    static class UtilityWidgetViewHolder extends ViewHolder {

        private TextView notification;

        public UtilityWidgetViewHolder(View cardView) {
            super(cardView);
            notification = cardView.findViewById(R.id.notification);
        }

        public void setNotification(String text) {
            notification.setText(text);
        }
    }
}
