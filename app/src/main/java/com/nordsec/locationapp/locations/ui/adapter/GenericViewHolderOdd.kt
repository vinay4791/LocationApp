package com.nordsec.locationapp.locations.ui.adapter

import com.nordsec.locationapp.databinding.OddItemBinding


class GenericViewHolderOdd(
    private val itemBinding: OddItemBinding,
    private val listener: Listener
) : GenericViewHolder(itemBinding.root, listener) {

    override fun bind(locationKey: String) {
        itemBinding.itemTv.text = locationKey
        itemBinding.genericItemParentLayout.setOnClickListener {
            listener.itemSelected(locationKey)
        }
    }

}