package com.example.conversor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.conversor.databinding.FragmentFirstBinding
import kotlin.text.Typography.euro

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener()
        listener2()
    }

    private fun listener() {
        binding.apply {
           buttonFour.setOnClickListener{
                setValueInDollarSpace(binding.edittextThird.text.toString().toDouble())
            }
        }
    }

    private fun setValueInDollarSpace(coin: Double) {
        val dollar: Double = 4.76
        binding.textviewFirst.text = "Dollar value: " + "R$" + "%.2f".format((coin*dollar))
    }

    private fun listener2() {
        binding.apply {
            buttonFifith.setOnClickListener{
                setValueInEuroSpace(binding.edittextThird.text.toString().toDouble())
            }
        }
    }

    private fun setValueInEuroSpace(coin: Double) {
        val euro: Double = 5.04
        binding.textviewSecond.text = "Euro value: " + "R$" + "%.2f".format((coin*euro))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}