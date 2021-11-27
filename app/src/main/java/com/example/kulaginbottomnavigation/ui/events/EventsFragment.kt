package com.example.kulaginbottomnavigation.ui.events

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavAction
import androidx.navigation.fragment.FragmentNavigatorDestinationBuilder
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kulaginbottomnavigation.R
import com.example.kulaginbottomnavigation.databinding.FragmentEventsBinding

class EventsFragment : Fragment() {

    private lateinit var binding: FragmentEventsBinding
    private val viewModel: EventsViewModel by lazy { ViewModelProvider(this).get(EventsViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val adapter = EventAdapter()
        binding = FragmentEventsBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.rvEvents.layoutManager = LinearLayoutManager(context)
        binding.rvEvents.adapter = adapter
        binding.fabAddEvent.setOnClickListener {
            findNavController().navigate(R.id.action_events_to_add_event)
        }
        viewModel.eventsList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.refreshEvents(it)
            }
        })

        return binding.root
    }


}