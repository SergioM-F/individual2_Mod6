package cl.samf.individual2_mod6.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.samf.individual2_mod6.data.Repositorio
import cl.samf.individual2_mod6.data.local.Item
import cl.samf.individual2_mod6.data.local.ItemDataBase
import kotlinx.coroutines.launch

class ItemViewModel (aplicacion : Application): AndroidViewModel(aplicacion) {
    private val repositorio: Repositorio
    init {
        repositorio = Repositorio(ItemDataBase.obtenerItemDatabase(aplicacion).obtenerItemDao())

    }

    fun obtenerTareas(): LiveData<List<Item>> {
        return repositorio.obtenerItem()

    }

    fun insertarTareas(tarea: Item)=viewModelScope.launch{
        repositorio.insertItem(tarea)
    }

}