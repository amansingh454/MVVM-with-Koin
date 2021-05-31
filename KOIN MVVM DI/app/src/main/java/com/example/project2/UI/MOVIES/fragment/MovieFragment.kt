package com.example.project2.UI.MOVIES.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project2.*
import com.example.project2.UI.MOVIES.Adapter.Adapter
import com.example.project2.UI.MOVIES.ViewModel.MainViewModel
import com.example.project2.databinding.FragmentMovieBinding

import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.single_item.view.*
import org.koin.android.viewmodel.ext.android.viewModel


class MovieFragment : Fragment(R.layout.fragment_movie) {

    private  val  mainViewModel: MainViewModel by viewModel()
    private var _binding: FragmentMovieBinding?=null
    private val binding get()=_binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.getAllMovies()
        mainViewModel.movieList.observe(viewLifecycleOwner, Observer { movieList->recview.also {
            it.layoutManager=LinearLayoutManager(requireContext())
            it.adapter= Adapter(movieList)
        }})
            binding.root.button.setOnClickListener {
                val name=binding.root.name.text.toString()
                val desc=binding.root.desc.text.toString()
                val cat=binding.root.category.text.toString()
                val user= Movie(name,desc,cat)
                val bundle= bundleOf("user" to user)
                view.findNavController().navigate(R.id.secondFragment)
            }



    }}





