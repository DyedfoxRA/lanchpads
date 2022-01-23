package com.example.launchpadx.domain.mapppers

interface ListMapper<From, To> : Mapper<From, To> {
    fun mapList(raw: List<From>): List<To>
}
