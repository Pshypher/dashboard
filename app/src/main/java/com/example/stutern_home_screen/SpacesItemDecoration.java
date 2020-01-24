package com.example.stutern_home_screen;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int mVerticalSpace;
    private int mHorizontalSpace;

    public SpacesItemDecoration(int verticalSpace, int horizontalSpace) {
        mVerticalSpace = verticalSpace;
        mHorizontalSpace = horizontalSpace;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = mHorizontalSpace;
        outRect.right = mHorizontalSpace;
        outRect.bottom = mVerticalSpace;

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildLayoutPosition(view) == 0
            || parent.getChildLayoutPosition(view) == 1) {
            outRect.top = mVerticalSpace;
        } else {
            outRect.top = 0;
        }
    }
}