package com.example.kulaginbottomnavigation.models.event

import java.time.LocalDate

data class Event(
    var title: String,
    var desc: String,
    var dateStart: LocalDate
)

