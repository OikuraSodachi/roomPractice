package com.todokanai.roompractice.fragment

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.todokanai.roompractice.R
import com.todokanai.roompractice.databinding.FragmentMainBinding
import com.todokanai.roompractice.viewmodel.MainViewModel

class MainFragment : Fragment() {

    lateinit var binding : FragmentMainBinding
    private lateinit var viewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val insertBtn = binding.insertBtn
        val getBtn = binding.getBtn
        val inputText = binding.inputTest.text


        insertBtn.setOnClickListener { viewModel.insert(inputText.toString().toLong()) }
        getBtn.setOnClickListener { viewModel.getUserSize() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, MainViewModel.Factory(Application()))[MainViewModel::class.java]

    }
}