package com.example.a4bb4g1.data.repositories

import android.util.Log
import com.example.a4bb4g1.COMPANY_COLLECTION
import com.example.a4bb4g1.DETAIL_COLLECTION
import com.example.a4bb4g1.DOCTOR_COLLECTION
import com.example.a4bb4g1.SERVICE_COLLECTION
import com.example.a4bb4g1.data.datasource.MemoryDataSource
import com.example.a4bb4g1.data.db.dao.DoctorDao
import com.example.a4bb4g1.data.db.dao.ServiceDao
import com.example.a4bb4g1.data.models.CompanyModel
import com.example.a4bb4g1.data.models.DoctorDetailModel
import com.example.a4bb4g1.data.models.DoctorItemModel
import com.example.a4bb4g1.data.models.ServiceItemModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await

class HomeRepository(private val memoryDataSource: MemoryDataSource, private val serviceDao: ServiceDao, private val doctorDao: DoctorDao,
                     private val db: FirebaseFirestore, private val storage: FirebaseStorage){

    suspend fun  services(): List<ServiceItemModel>{
    //    delay(1000)
    //    return memoryDataSource.services()
    //    return serviceDao.getAll()
        val results = (db.collection(SERVICE_COLLECTION).get().await()).toObjects<ServiceItemModel>()
        val transformed = results.map{
            val ref = storage.reference
            val imageRef = ref.child(it.icon)
            it.icon = (imageRef.downloadUrl.await()).toString()
            return@map it
        }
        return transformed
    }

    suspend fun company(): CompanyModel?{
        val result = db.collection(COMPANY_COLLECTION).get().await()
        return result.documents.first().toObject<CompanyModel>()
    }

    suspend fun doctors(category: String?): List<DoctorItemModel>{
    //    val doctors = memoryDataSource.doctors()
    //    if(category != null){
    //        return doctors.filter { it -> it.speciality == category }
    //    }
    //    return doctors
        val result: List<DoctorItemModel>
        if(category != null) {
            result = (db.collection(DOCTOR_COLLECTION).whereEqualTo("speciality", category).get().await()).toObjects()
        }else{
            result = (db.collection(DOCTOR_COLLECTION).get().await()).toObjects()
        }

        val transformed = result.map{
            val ref = storage.reference
            val imageRef = ref.child(it.image)
            it.image = (imageRef.downloadUrl.await()).toString()
            return@map it
        }
        return transformed
    }

    suspend fun details(id: String): DoctorDetailModel?{
        return (db.collection(DETAIL_COLLECTION).document(id).get().await()).toObject()
    }
}