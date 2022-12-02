package com.example.a4bb4g1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.a4bb4g1.R
import com.example.a4bb4g1.data.viewmodels.HomeViewModel
import com.example.a4bb4g1.databinding.FragmentSpecialistDetailBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [SpecialistDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpecialistDetailFragment : Fragment() {

    private var _binding: FragmentSpecialistDetailBinding? = null
    private val binding: FragmentSpecialistDetailBinding get() = _binding!!
    private val homeViewModel: HomeViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSpecialistDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        observeViewModels()
    }

    private fun observeViewModels(){
        homeViewModel.doctor.observe(viewLifecycleOwner, Observer {
            homeViewModel.details(it.id)
    //       binding.specialistDetailFragmentImage.setImageResource(it.image.toInt())
           Glide.with(binding.root).load(it.image).into(binding.specialistDetailFragmentImage)
           binding.specialistDetailFragmentName.text = it.name
           binding.specialistDetailFragmentSpeciality.text = it.speciality
           binding.specialistDetailFragmentRating.rating = it.star.toFloat()
           binding.specialistDetailFragmentDescription.text = it.description
        })
        homeViewModel.detail.observe(viewLifecycleOwner, Observer {
            if(it != null){
                binding.specialistDetailCardGroup.visibility = View.VISIBLE
                binding.specialistDetailFragmentCardPatientsValue.text = it.patients
                binding.specialistDetailFragmentCardGradeValue.text = it.star.toString()
                binding.specialistDetailFragmentCardGradeRating.rating = (it.star/5.0).toFloat()
                binding.specialistDetailFragmentCardExpValue.text = it.exp
            }else{
                binding.specialistDetailCardGroup.visibility = View.GONE
            }
        })
    }

}