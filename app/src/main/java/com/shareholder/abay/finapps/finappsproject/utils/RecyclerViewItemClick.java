package com.shareholder.abay.finapps.finappsproject.utils;

import android.view.View;

/**
 * Created by abay on 10/26/16.
 */
public class RecyclerViewItemClick {

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View v, int position);
    }
}
