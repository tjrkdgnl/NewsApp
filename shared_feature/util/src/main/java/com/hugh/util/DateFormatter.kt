package com.hugh.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object DateFormatter {
    val format = "yyyy-MM-dd'T'HH:mm:ss'Z'"

    private val formatter = DateTimeFormatter.ofPattern(format)
    private val current = LocalDateTime.now()

    private val cYear = current.year
    private val cMonth = current.monthValue
    private val cDay = current.dayOfMonth
    private val cHour = current.hour
    private val cMinute = current.minute
    private val cSecond = current.second

    fun getDifferentDate(publishAt: String): String {
        val prev = LocalDateTime.parse(publishAt, formatter)

        val pYear = prev.year
        val pMonth = prev.monthValue
        val pDay = prev.dayOfMonth
        val pHour = prev.hour
        val pMinute = prev.minute
        val pSecond = prev.second

        return if (cYear > pYear) {
            (cYear - pYear).toString() + "년 전"
        } else {
            if (cMonth > pMonth) {
                (cMonth - pMonth).toString() + "달 전"
            } else {
                if (cDay > pDay) {
                    (cDay - pDay).toString() + "일 전"
                } else {
                    if (cHour > pHour) {
                        (cHour - pHour).toString() + "시간 전"
                    } else {
                        if (cMinute > pMinute) {
                            (cMinute - pMinute).toString() + "분 전"
                        } else {
                            if (cSecond > pSecond) {
                                (cSecond - pSecond).toString() + "초 전"
                            } else {
                                ""
                            }
                        }
                    }
                }
            }
        }
    }
}