package com.nordsec.locationapp.locations.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class GenericViewHolder (view: View, listener: Listener) :
    RecyclerView.ViewHolder(view) {

   abstract fun bind(locationKey: String)

    interface Listener {
        fun itemSelected(locationKey: String)
    }

}

