package com.example.a4bb4g1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a4bb4g1.interfaces.OnServiceClickListener
import com.example.a4bb4g1.R
import com.example.a4bb4g1.ui.adapters.ServiceAdapter
import com.example.a4bb4g1.data.models.ServiceItemModel
import com.example.a4bb4g1.data.viewmodels.HomeViewModel
import com.example.a4bb4g1.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private lateinit var serviceAdapter: ServiceAdapter
    private val homeViewModel: HomeViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        homeViewModel.services()
        serviceAdapter = ServiceAdapter(listOf())
        serviceAdapter.listener = object : OnServiceClickListener {
            override fun onClick(item: ServiceItemModel) {
                val direction =
                    HomeFragmentDirections.actionHomeFragmentToSpecialistFragment()
                direction.name = item.title
                direction.description = item.description
                direction.search = false
                findNavController().navigate(direction)
            }

        }
        binding.homeFragmentRecyclerRefresh.setOnRefreshListener {
            homeViewModel.services()
        }
        binding.homeFragmentRecycler.apply {
            adapter = serviceAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        observeViewModel()
    }
        private fun observeViewModel(){
            homeViewModel.services.observe(viewLifecycleOwner, Observer {
                binding.homeFragmentRecyclerRefresh.isRefreshing = false
                serviceAdapter.updateDataset(it)
            })
        }


}