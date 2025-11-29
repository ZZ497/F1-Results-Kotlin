package com.example.resultadosf1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.resultadosf1.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pilotos.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Comprobación")
            builder.setMessage("¿Estás seguro que quieres ir a ver los pilotos?")

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(requireContext(),
                    android.R.string.yes, Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_SecondFragment_to_pilotosFragment)
            }
            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(requireContext(), android.R.string.no, Toast.LENGTH_SHORT).show()
            }

            builder.create().show()

        }
        binding.constructores.setOnClickListener{
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Comprobación")
            builder.setMessage("¿Estás seguro que quieres ir a ver los constructores?")

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(requireContext(),
                    android.R.string.yes, Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_SecondFragment_to_constructoresFragment)
            }
            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(requireContext(), android.R.string.no, Toast.LENGTH_SHORT).show()
            }
            builder.create().show()
        }

        binding.contacto2.setOnClickListener{
            findNavController().navigate(R.id.action_SecondFragment_to_creditosFragment)
        }

        val valor1 = requireArguments().getString("email")
        val valor2 = requireArguments().getString("contrasenia")

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}