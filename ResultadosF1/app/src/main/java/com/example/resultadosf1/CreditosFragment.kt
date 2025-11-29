package com.example.resultadosf1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.resultadosf1.databinding.CreditosBinding
import com.example.resultadosf1.databinding.FragmentFirstBinding


class CreditosFragment : Fragment() {

    private var _binding: CreditosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = CreditosBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Intent página web
        binding.web.setOnClickListener{
            val uri = Uri.parse("https://www.webdediego.es/")
            val intentWeb = Intent(Intent.ACTION_VIEW)
            intentWeb.data = uri
            startActivity(intentWeb)
        }

        //Intent marcar número de teléfono
        binding.telefono.setOnClickListener{
            val intentTelef = Intent(Intent.ACTION_DIAL)
            intentTelef.data = Uri.parse("tel:953636000")
            startActivity(intentTelef)
        }


        //Intent correo electrónico

        binding.email.setOnClickListener {
            val addresses = arrayOf("correoaleatorio@gmail.com",
                "diego.lijarcio@escuelaestech.es")
            val subject = "Asunto: Contacto"
            val text = "Texto"
            val intentEmail = Intent(Intent.ACTION_SEND)
            intentEmail.type = "*/*"
            intentEmail.putExtra(Intent.EXTRA_EMAIL, addresses)
            intentEmail.putExtra(Intent.EXTRA_SUBJECT, subject)
            intentEmail.putExtra(Intent.EXTRA_TEXT, text)
            startActivity(intentEmail)
        }

        //Intent mensaje WhatsApp

        binding.whatsapp.setOnClickListener{
            val waIntent = Intent(Intent.ACTION_SEND)
            waIntent.type = "text/plain"
            val textWh = "Mensaje de prueba"
            waIntent.setPackage("com.whatsapp")
            waIntent.putExtra(Intent.EXTRA_TEXT, textWh)
            try {
                startActivity(waIntent)
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "No tienes WhatsApp instalada",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}