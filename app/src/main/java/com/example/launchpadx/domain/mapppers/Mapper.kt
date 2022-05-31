package com.example.launchpadx.domain.mapppers

interface Mapper<From, To> {
    fun map(raw: From): To
}
