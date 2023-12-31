package cl.samf.individual2_mod6.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cl.samf.individual2_mod6.R
import cl.samf.individual2_mod6.data.local.Item
import cl.samf.individual2_mod6.databinding.FragmentAgregarBinding


class AgregarFragment : Fragment() {

    lateinit var binding: FragmentAgregarBinding
    private val itemViewModel : ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAgregarBinding.inflate(layoutInflater,container,false)
        setupEditText()
        obtenerResultado()
        initListener()

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageButtonVolver.setOnClickListener {
            findNavController().navigate(R.id.action_agregarFragment_to_recyclerFragment)
        }


    }



    private fun setupEditText() {
        binding.editTextCantidad.addTextChangedListener { obtenerResultado() }

        binding.editTextPrecio.addTextChangedListener { obtenerResultado() }
        }
    private fun obtenerResultado() {
        val number1 = binding.editTextCantidad.text.toString().toIntOrNull() ?: 0
        val number2 = binding.editTextPrecio.text.toString().toIntOrNull() ?: 0
        val result = number1 * number2
        binding.txtResultado.text = result.toString()
    }


    private fun initListener() {
        binding.btnGuardar.setOnClickListener {
            val nombre = binding.editTextNombre.text.toString()
            val precio = binding.editTextPrecio.text.toString().toInt()
            val cantidad = binding.editTextCantidad.text.toString().toInt()


            itemViewModel.insertarTareas(nombre,precio,cantidad)
            mensajeAgreagado()
            limpiarPantalla()

        }
    }

    private fun limpiarPantalla() {
        binding.editTextNombre.setText("")
        binding.editTextPrecio.setText("")
        binding.editTextCantidad.setText("")

    }

    private fun mensajeAgreagado() {
        Toast.makeText(requireContext(), R.string.msje,Toast.LENGTH_LONG).show()
    }

}