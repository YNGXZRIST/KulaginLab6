package com.example.kulaginbottomnavigation.models.event

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.util.*


@RequiresApi(Build.VERSION_CODES.O)
object EventDataObject {
    private var eventsList = mutableListOf<Event>(
        Event("1 января", "новый год", LocalDate.of(2021,1, 1)),
        Event("Рождество Христово", "рождество", LocalDate.of(2021, 1, 7)),
        Event("День защитника отечества", "не служил-не мужик", LocalDate.of(2021, 2, 23)),
        Event("Межденородный женский день", "не забудь поздравить", LocalDate.of(2021, 3, 8)),
        Event("Праздник Весны и Труда", "выходной", LocalDate.of(2021, 5, 1)),
        Event("День Победы", "выходной", LocalDate.of(2021, 5, 9)),
        Event("Весенняя балткоса", "Главный праздник в году", LocalDate.of(2021, 5, 12)),

        Event("Летняя коса", "второй главный праздник в году", LocalDate.of(2021, 7, 4))
    )
    fun getEvents() = eventsList
    fun addEvent(event: Event) {
        eventsList.add(event)
       sortEvents()
    }

    private fun sortEvents() {
        eventsList.sortWith(Comparator { x: Event, y: Event ->
            x.dateStart.compareTo(
                y.dateStart
            )
        })//сортировать тут - не лучшее решение с точки зрения архитектуры, полага, но в viewModel пока не получилось
    }
}