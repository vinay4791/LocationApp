package com.nordsec.locationapp.common

interface LocationViewType {
    fun type(): RowType

    enum class RowType {
        ODD,
        EVEN;

        companion object {
            fun from(value: Int): RowType = values()[value]
        }

        fun value(): Int = ordinal
    }
}