package com.example.bottomnav.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.example.bottomnav.databinding.FragmentAddToCalendarBinding
import com.example.bottomnav.databinding.FragmentDashboardBinding
import androidx.navigation.fragment.findNavController
import com.example.bottomnav.ui.dashboard.DashboardViewModel

class AddEventFrag : Fragment() {
    private var _binding: FragmentAddToCalendarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddToCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cancelButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.saveButton.setOnClickListener {
            // Collect event data from UI elements
            // ... collect other event details ...

            binding.title.doOnTextChanged { _, start, _, count ->
                binding.saveButton.isEnabled = (start + count) > 3
            }

            // Create the event (using Calendar Provider or other methods)
            // ...

            // Navigate back (optional)
            findNavController().popBackStack()
        }
    }
}