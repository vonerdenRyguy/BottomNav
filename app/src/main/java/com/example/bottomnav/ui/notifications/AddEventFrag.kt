package com.example.bottomnav.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.example.bottomnav.databinding.FragmentAddToCalendarBinding
import com.example.bottomnav.databinding.FragmentDashboardBinding
import androidx.navigation.fragment.findNavController
import com.example.bottomnav.R
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

    private lateinit var titleEditText: EditText
    private lateinit var typeEditText: EditText
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        titleEditText = binding.title
        typeEditText = binding.type

        binding.cancelButton.setOnClickListener {

        }

        binding.saveButton.setOnClickListener {
            if (validateInput()) {
                binding.saveButton.isEnabled = true
            }

            findNavController().popBackStack()
        }
    }

    private fun validateInput(): Boolean {
        val title = titleEditText.text.toString()
        val type = typeEditText.text.toString()
        return title.isNotEmpty() && type.isNotEmpty()
    }
}