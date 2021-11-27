package com.example.kulaginbottomnavigation.ui.events.add

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kulaginbottomnavigation.databinding.FragmentAddEventBinding
import com.example.kulaginbottomnavigation.models.event.Event
import com.example.kulaginbottomnavigation.models.event.EventDataObject
import java.time.LocalDate
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
class AddEventFragment : Fragment() {

    private lateinit var binding: FragmentAddEventBinding
    private var event: Event = Event(
        "", "",
        LocalDate.of(
            Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH),
            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddEventBinding.inflate(inflater)

        val today = Calendar.getInstance()
        binding.dpEventStartDate.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            event.dateStart = LocalDate.of(year, month, day)//я не знаю почему, но у него
            // месяц почему-то нумеруется неправильно, номер на 1 меньше реального
            if (event.title != "" && event.desc != "") {
                binding.btnSave.visibility = View.VISIBLE
            }
        }

        binding.etEventTitle.addTextChangedListener {
            event.title = binding.etEventTitle.text.toString()
            if (event.desc != ""
            ) {
                binding.btnSave.visibility = View.VISIBLE
            }
        }

        binding.etEventDescription.addTextChangedListener {
            event.desc = binding.etEventTitle.text.toString()
            if (event.title != "") {
                binding.btnSave.visibility = View.VISIBLE
            }
        }

        binding.btnSave.setOnClickListener {
            EventDataObject.addEvent(event)//возможно правильнее с точки зрения архитектуры было бы передавать
            // просто объект event в наш фргмент со списком, а там уже распоряжаться им, или что-то еще
            // это решение не лучшее, но в пивком потянет
            findNavController().popBackStack()
        }
        return binding.root
    }


}