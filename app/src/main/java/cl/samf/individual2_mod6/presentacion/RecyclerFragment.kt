package cl.samf.individual2_mod6.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cl.samf.individual2_mod6.R
import cl.samf.individual2_mod6.data.local.Item
import cl.samf.individual2_mod6.databinding.FragmentRecyclerBinding

/* Pasos para crear un recycler view
[x ] item layout
[x] agregar constraints
[x] cambiar altura de constraints layout de item layout a wrap content
[X] definir ID
[x ] layout con recycler view
[X ] asignar layout manager
[x ] implementar clase Adapter
[x]  heredar RecyclerView.Adapter
[x] creaciones de los métodos: onCreateViewHolder, getItemCount y onBindViewHolder
[x ] crear clase anidada ViewHolder, que hereda de la clase ViewHolder
[x] Agregar constructor
[x] crear objeto, data class
[x] Crear lista
[x] asignar tamaño de la lista en getItemCount
[x] definir Binding Class del Item
[x] cambiar view por el binding
[x] declarar variable item en onBindViewHolder
[x] implementar binding en clase viewHolder
[x] Adapter+ view holder
[ x] obtener los datos
*/


class RecyclerFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerBinding
    val itemViewModel: ItemViewModel by activityViewModels()
    private lateinit var adapter: AdaptadorItem
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        initLista()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButtonAgregar.setOnClickListener {
            findNavController().navigate(R.id.action_recyclerFragment_to_agregarFragment)
        }


    }

    private fun initLista() {
        adapter = AdaptadorItem()
        itemViewModel.obtenerTareas().observe(viewLifecycleOwner) {
            adapter.setData(it)

        }
        binding.recyclerView.adapter = adapter
    }


}