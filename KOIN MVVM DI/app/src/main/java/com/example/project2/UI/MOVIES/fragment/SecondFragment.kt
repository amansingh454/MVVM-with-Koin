package com.example.project2.UI.MOVIES.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import com.example.project2.Movie
import com.example.project2.R
import com.example.project2.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private lateinit var user:Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            user=bundle.getParcelable("user")!!

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cattextView.setText(user.cat)
        binding.desctextView.setText(user.desc)
        binding.nametextView.setText(user.name)
        binding.button3.setOnClickListener {
            view.findNavController().navigate(R.id.movieFragment)
        }

    }


}