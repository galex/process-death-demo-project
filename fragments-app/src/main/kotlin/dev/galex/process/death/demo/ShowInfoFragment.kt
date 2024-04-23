package dev.galex.process.death.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.galex.process.death.demo.databinding.FragmentShowInfoBinding

class ShowInfoFragment : Fragment() {

    private var _binding: FragmentShowInfoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Getting the name from our Singleton
        binding.showName.text = getString(R.string.show_name, DataHolder.name ?: "null")
        // Button to navigate back to enter name
        binding.backToEnterName.setOnClickListener {
            findNavController().navigate(R.id.action_show_info_to_enter_name)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}