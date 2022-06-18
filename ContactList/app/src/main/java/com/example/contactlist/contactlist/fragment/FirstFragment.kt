package com.example.contactlist.contactlist.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactlist.contactlist.adapter.AdapterImages
import com.example.contactlist.databinding.FragmentFirstBinding
import java.util.*


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    private lateinit var adapterRecyclerView: AdapterImages

    // A List of names to just pretend we have a back-end:::

    val names: List<String> = listOf(
        "Caroline Christensen",
        "Enrique Stephens",
        "Owen Carpenter",
        "Nichole Stewart",
        "Alonzo Burton",
        "Diamond Holland",
        "Desiree Duran",
        "Crystal Flynn",
        "Nolan Bowman",
        "Stacey Wood"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startAdapter()
        setDataAdapter()
    }


    private fun startAdapter() {
        binding.rvContacts.apply {
            adapterRecyclerView = AdapterImages()
            layoutManager = LinearLayoutManager(context)
            adapter = adapterRecyclerView
        }
    }

    private fun setDataAdapter() {
        adapterRecyclerView.setData(myListUrls())
    }

    private fun myListUrls(): List<Triple<String, String, String>> = listOf(
        Triple(
            "https://picsum.photos/id/${rand(0, 100)}/200/300",
            names[rand(0, 10)],
            "(XX)-XXXX-XXXX"
        ),
        Triple(
            "https://picsum.photos/id/${rand(0, 100)}/200/300",
            names[rand(0, 10)],
            "(XX)-XXXX-XXXX"

        ),
        Triple(
            "https://picsum.photos/id/${rand(0, 100)}/200/300",
            names[rand(0, 10)],
            "(XX)-XXXX-XXXX"
        ),
        Triple(
            "https://picsum.photos/id/${rand(0, 100)}/200/300",
            names[rand(0, 10)],
            "(XX)-XXXX-XXXX"
        ),
        Triple(
            "https://picsum.photos/id/${rand(0, 100)}/200/300",
            names[rand(0, 10)],
            "(XX)-XXXX-XXXX"
        ),
        Triple(
            "https://picsum.photos/id/${rand(0, 100)}/200/300",
            names[rand(0, 10)],
            "(XX)-XXXX-XXXX"
        ),
        Triple(
            "https://picsum.photos/id/${rand(0, 100)}/200/300",
            names[rand(0, 10)],
            "(XX)-XXXX-XXXX"
        ),
        Triple(
            "https://picsum.photos/id/${rand(0, 100)}/200/300",
            names[rand(0, 10)],
            "(XX)-XXXX-XXXX"
        ),
        Triple(
            "https://picsum.photos/id/${rand(0, 100)}/200/300",
            names[rand(0, 10)],
            "(XX)-XXXX-XXXX"
        )
    )

    private fun rand(from: Int, to: Int): Int {
        val random = Random()
        return random.nextInt(to - from) + from
    }

    // It is used to "mock" this fragment in the MainActivity:::

    companion object {
        fun getInstance(): FirstFragment {
            return FirstFragment()
        }
    }
}