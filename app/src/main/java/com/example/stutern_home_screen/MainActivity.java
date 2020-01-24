package com.example.stutern_home_screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Person;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<BasicWidget> widgets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        widgets = new ArrayList<BasicWidget>();
        widgets.add(new Widget(R.drawable.calendar, "Calendar",
                "March, Wednesday", "3 Events"));
        widgets.add(new Widget(R.drawable.grocery, "Groceries",
                "Brocoli,Apple", "4 items"));
        widgets.add(new PersonalWidget(R.drawable.location, "Location",
                "Lucy Mao going to Office"));
        widgets.add(new PersonalWidget(R.drawable.activity, "Activity",
                "Rose favorited your post"));
        widgets.add(new Widget(R.drawable.list, "To do",
                "Homework, Design", "4 items"));
        widgets.add(new UtilityWidget(R.drawable.settings, "Settings", "4 items"));
        widgets.add(new PersonalWidget(R.drawable.flight, "Single Trip",
                "Taipei -> Beijing"));
        widgets.add(new Widget(R.drawable.rss, "RSS", "Business, Bloomberg",
                "148 new feeds"));
        widgets.add(new PersonalWidget(R.drawable.audio, "Discover", "Foster the People"));

        RecyclerView rv = findViewById(R.id.recycler_view);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        int hSpacingInPixels = getResources().getDimensionPixelSize(R.dimen.horizontal_spacing);
        int vSpacingInPixels = getResources().getDimensionPixelSize(R.dimen.vertical_spacing);
        rv.addItemDecoration(new SpacesItemDecoration(vSpacingInPixels, hSpacingInPixels));
        RecyclerView.Adapter adapter = new WidgetAdapter(widgets);
        rv.setAdapter(adapter);
    }
}
