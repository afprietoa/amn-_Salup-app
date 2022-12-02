package com.example.a4bb4g1.data.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a4bb4g1.data.models.CompanyModel
import com.example.a4bb4g1.data.models.DoctorDetailModel
import com.example.a4bb4g1.data.models.DoctorItemModel
import com.example.a4bb4g1.data.models.ServiceItemModel
import com.example.a4bb4g1.data.repositories.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repo: HomeRepository): ViewModel() {

    private var _services: MutableLiveData<List<ServiceItemModel>> = MutableLiveData()
    val services: LiveData<List<ServiceItemModel>> get() = _services

    private var _company: MutableLiveData<CompanyModel> = MutableLiveData()
    val company: LiveData<CompanyModel> get() = _company

    private var _doctors: MutableLiveData<List<DoctorItemModel>> = MutableLiveData()
    val doctors: LiveData<List<DoctorItemModel>> get() = _doctors

    private var _doctor: MutableLiveData<DoctorItemModel> = MutableLiveData()
    val doctor: LiveData<DoctorItemModel> get() = _doctor

    private var _detail: MutableLiveData<DoctorDetailModel?> = MutableLiveData()
    val detail: LiveData<DoctorDetailModel?> get() = _detail

    fun services(){
        viewModelScope.launch {
            val services = repo.services()
            _services.postValue(services)
        }
    }

    fun company(){
        viewModelScope.launch {
            val company = repo.company()
            _company.postValue(company)
        }
    }

    fun doctors(category: String?){
        viewModelScope.launch {
            val doctors = repo.doctors(category)
            _doctors.postValue(doctors)
        }
    }

    fun selected(item: DoctorItemModel){
        _doctor.postValue(item)
    }

    fun details(id: String){
        viewModelScope.launch {
            _detail.postValue(repo.details(id))
        }
    }
}