package com.example.a4bb4g1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.a4bb4g1.R
import com.example.a4bb4g1.data.viewmodels.LoginViewModel
import com.example.a4bb4g1.databinding.FragmentSignUpBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModel()

    private var _binding: FragmentSignUpBinding? = null
    private val binding: FragmentSignUpBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.fragmentSignUpLabel2.setOnClickListener{
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }
        binding.fragmentSignUpButton.setOnClickListener {
            val id = binding.fragmentSignUpRadioGroup.checkedRadioButtonId
            val radioButton = requireActivity().findViewById<RadioButton>(id)
            loginViewModel.signUp(
                binding.signUpFragmentEmail.text.toString(),
                binding.signUpFragmentPassword.text.toString(),
                binding.signUpFragmentName.text.toString(),
                radioButton.text.toString()
            )
        }
        observeViewModel()
    }
    private fun observeViewModel(){
        loginViewModel.error.observe(viewLifecycleOwner, Observer {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        })
        loginViewModel.signUp.observe(viewLifecycleOwner, Observer{
            Snackbar.make(binding.root, "Usuario registrado", Snackbar.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        })

    }

}