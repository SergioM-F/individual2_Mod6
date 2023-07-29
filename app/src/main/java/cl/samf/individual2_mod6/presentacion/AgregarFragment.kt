package cl.samf.individual2_mod6.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
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

        initListener()

        return binding.root

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