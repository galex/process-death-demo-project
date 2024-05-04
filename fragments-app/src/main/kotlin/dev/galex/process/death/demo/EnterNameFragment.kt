package dev.galex.process.death.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.galex.process.death.demo.databinding.FragmentEnterNameBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class EnterNameFragment : Fragment() {

    private var _binding: FragmentEnterNameBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnterNameBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Gets the name from the Singleton in case it was previously set
        DataHolder.name?.let { binding.enterName.setText(it) }
        binding.next.setOnClickListener {
            // Setting the value entered in the editText into a Singleton
            val text = binding.enterName.text.toString()
            if (text.isNotBlank()) {
                DataHolder.name = text
            }
            // Navigating to the show Info Fragment
            findNavController().navigate(R.id.action_enter_name_to_show_info)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}