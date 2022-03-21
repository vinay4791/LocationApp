package com.nordsec.locationapp.locations.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nordsec.locationapp.common.Constants
import com.nordsec.locationapp.common.LocationViewType
import com.nordsec.locationapp.databinding.EvenItemBinding
import com.nordsec.locationapp.databinding.OddItemBinding
import com.nordsec.locationapp.locations.domain.LocationDomainModel


class LocationsAdapter : RecyclerView.Adapter<GenericViewHolder>() {

    private lateinit var locationsList: List<LocationDomainModel>
    private var listener: Listener = Listener.NO_OP

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenericViewHolder {
        when (LocationViewType.RowType.from(viewType)) {
            LocationViewType.RowType.EVEN -> {
                val itemBinding =
                    EvenItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return GenericItemViewHolderEven(itemBinding, listener)
            }
            LocationViewType.RowType.ODD -> {
                val itemBinding =
                    OddItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return GenericViewHolderOdd(itemBinding, listener)
            }
        }
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        holder.bind(locationsList[position].cityName)
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    fun setItems(locationsList: List<LocationDomainModel>) {
        this.locationsList = locationsList
        notifyDataSetChanged()
    }

    override fun getItemCount() = locationsList.size

    override fun getItemViewType(position: Int): Int {
        return if (position % Constants.TWO_INT == Constants.EMPTY_INT) {
            LocationViewType.RowType.EVEN.ordinal
        } else {
            LocationViewType.RowType.ODD.ordinal
        }
    }

    interface Listener : GenericViewHolder.Listener {
        companion object {
            val NO_OP: Listener = object : Listener {
                override fun itemSelected(item: String) {
                    //NO_OP
                }

            }
        }
    }

}