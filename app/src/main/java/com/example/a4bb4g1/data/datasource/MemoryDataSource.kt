package com.example.a4bb4g1.data.datasource

import com.example.a4bb4g1.R
import com.example.a4bb4g1.data.models.CompanyModel
import com.example.a4bb4g1.data.models.DoctorItemModel
import com.example.a4bb4g1.data.models.ServiceItemModel

class MemoryDataSource {

    fun services(): List<ServiceItemModel>{
        return listOf(
            ServiceItemModel(
                "1", "General", "Los mejores especialistas en medicina general.",
                R.drawable.ico_general.toString()
            ),
            ServiceItemModel(
                "2", "Especialista", "Los mejores medicos especialistas.",
                R.drawable.ico_especialidad.toString()
            ),
            ServiceItemModel(
                "3", "Odontologia", "Los mejores especialistas en odontologia.",
                R.drawable.ico_odontologia.toString()
            ),
            ServiceItemModel(
                "4", "Cardiologia", "Los mejores especialistas en cardiologia.",
                R.drawable.ico_cardiologia.toString()
            ),
            ServiceItemModel(
                "5", "Dermatologia", "Los mejores especialistas en dermatologia.",
                R.drawable.ico_dermatologia.toString()
            ),
            ServiceItemModel(
                "6", "Pediatria", "Los mejores especialistas en pediatria.",
                R.drawable.ico_pediatria.toString()
            ),
            ServiceItemModel(
                "7", "Cirugia", "Los mejores especialistas en cirugia.",
                R.drawable.ico_cirugia.toString()
            )
        )
    }

    fun company(): CompanyModel{
        return CompanyModel(
            "1", "HealthApp", 4.647607124418357, -74.1019189
        )
    }

    fun doctors(): List<DoctorItemModel>{
        return listOf(
            DoctorItemModel(
                "1", "Dr. Tristen Scriver", "General", "350 + Pacientes",
                R.drawable.doc1.toString(), 5.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "2", "Dr. Emily Orendorff", "Odontologia", "1000 + Pacientes",
                R.drawable.doc2.toString(), 4.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "3", "Dr. Gabriella Jumalon", "Dermatologia", "200 + Pacientes",
                R.drawable.doc3.toString(), 3.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "4", "Dr. Ralph Mede", "Pediatria", "300 + Pacientes",
                R.drawable.doc4.toString(), 3.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "5", "Dr. Jeremy Rozelle", "Cardiologia", "350 + Pacientes",
                R.drawable.doc5.toString(), 3.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "6", "Dr. Carmen Podlas", "Cirugia", "100 + Pacientes",
                R.drawable.doc6.toString(), 4.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "7", "Dr. Victor Bueter", "Odontologia", "200 + Pacientes",
                R.drawable.doc7.toString(), 5.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "8", "Dr. Elise Duntz", "Cardiologia", "250 + Pacientes",
                R.drawable.doc8.toString(), 3.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "9", "Dr. Russell Chernich", "Cirugia", "250 + Pacientes",
                R.drawable.doc9.toString(), 3.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "10", "Dr. Lily Wigdor", "Cardiologia", "350 + Pacientes",
                R.drawable.doc10.toString(), 4.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "11", "Dr. Albert Maull", "Pediatria", "150 + Pacientes",
                R.drawable.doc11.toString(), 5.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "12", "Dr. Adan Maune", "Dermatologia", "150 + Pacientes",
                R.drawable.doc12.toString(), 5.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "13", "Dr. Malia Urik", "Odontologia", "450 + Pacientes",
                R.drawable.doc13.toString(), 3.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "14", "Dr. Leo Withfield", "General", "400 + Pacientes",
                R.drawable.doc14.toString(), 4.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "15", "Dr. Julie Huneycutt", "Odontologia", "300 + Pacientes",
                R.drawable.doc15.toString(), 5.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "16", "Dr. Luis Luke", "Dermatologia", "300 + Pacientes",
                R.drawable.doc16.toString(), 5.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "17", "Dr. Christine Rinde", "Cardiologia", "350 + Pacientes",
                R.drawable.doc17.toString(), 4.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "18", "Dr. Richard Glowacki", "Cirugia", "550 + Pacientes",
                R.drawable.doc18.toString(), 5.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "19", "Dr. Kate Dewinter", "Especialista", "450 + Pacientes",
                R.drawable.doc19.toString(), 5.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "20", "Dr. Sam Wenke", "Especialista", "300 + Pacientes",
                R.drawable.doc20.toString(), 4.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "21", "Dr. Juan Portley", "Especialista", "250 + Pacientes",
                R.drawable.doc21.toString(), 3.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "22", "Dr. Johnny Terzo", "Especialista", "100 + Pacientes",
                R.drawable.doc22.toString(), 4.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            ),
            DoctorItemModel(
                "23", "Dr. Owen Heredia", "Especialista", "400 + Pacientes",
                R.drawable.doc23.toString(), 5.0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
            )
        )
    }
}