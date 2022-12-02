package com.example.a4bb4g1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a4bb4g1.ui.adapters.DoctorAdapter
import com.example.a4bb4g1.data.models.DoctorItemModel
import com.example.a4bb4g1.R
import com.example.a4bb4g1.data.models.ServiceItemModel
import com.example.a4bb4g1.data.viewmodels.HomeViewModel
import com.example.a4bb4g1.databinding.FragmentSpecialistBinding
import com.example.a4bb4g1.interfaces.OnDoctorClickListener
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [SpecialistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpecialistFragment : Fragment() {

    private val args: SpecialistFragmentArgs by navArgs()
    private val homeViewModel: HomeViewModel by sharedViewModel()
    private var _binding: FragmentSpecialistBinding? = null
    private val binding: FragmentSpecialistBinding get() = _binding!!
    private lateinit var  doctorAdapter: DoctorAdapter
    private lateinit var categories:MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSpecialistBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()





        doctorAdapter = DoctorAdapter(listOf())

        doctorAdapter.listener = object : OnDoctorClickListener{
            override fun onClick(item: DoctorItemModel) {
                homeViewModel.selected(item)
                findNavController().navigate(R.id.action_specialistFragment_to_specialistDetailFragment)
            }

        }

        binding.specialistFragmentRecycler.apply {
            adapter = doctorAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }


        if(args.search){
            homeViewModel.doctors(null)
            binding.specialistFragmentRecyclerSearchLayout.visibility = View.VISIBLE
            binding.specialistFragmentRecyclerTitle.visibility = View.GONE
            binding.specialistFragmentTitle.text = getString(R.string.specialist_title)
            binding.specialistFragmentSubtitle.text = getString(R.string.specialist_subtitle)
        //    doctorAdapter.updateDataset(specialists)

        } else{
            homeViewModel.doctors(args.name)
            binding.specialistFragmentTitle.text = args.name
            binding.specialistFragmentSubtitle.text = args.description
            binding.specialistFragmentRecyclerSearch.visibility = View.GONE
            binding.specialistFragmentRecyclerTitle.visibility = View.VISIBLE
        //    doctorAdapter.updateDataset(specialists.filter{it -> it.speciality == args.name})
        }

        observeViewModels()
    }

    private fun observeViewModels(){
        homeViewModel.services.observe(viewLifecycleOwner, Observer {
            categories = it.map{ it.title }.toMutableList()
            categories.add(0, "Todos")

            binding.specialistFragmentRecyclerSearch.setAdapter(ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line, categories))
            binding.specialistFragmentRecyclerSearch.setOnItemClickListener { parent, view, position, id ->

                if(position == 0){
                    //     doctorAdapter.updateDataset(specialists)
                    homeViewModel.doctors(null)
                }else{
                    val category = categories[position]
                    //    doctorAdapter.updateDataset(specialists.filter{it -> it.speciality == category})
                    homeViewModel.doctors(category)
                }

            }
        })
        homeViewModel.doctors.observe(viewLifecycleOwner, Observer {
            doctorAdapter.updateDataset(it)
        })
    }

}