package com.myiss.nationalbankofpolandrestapi

data class BeansItem(
    val effectiveDate: String,
    val no: String,
    val rates: List<RateX>,
    val table: String
)