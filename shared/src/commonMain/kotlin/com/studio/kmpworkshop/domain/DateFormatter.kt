package com.studio.kmpworkshop.domain

internal expect object DateFormatter {
    fun getStringTime(timeInSeconds: Long): String
}