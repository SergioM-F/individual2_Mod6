package cl.samf.individual2_mod6.data

import androidx.lifecycle.LiveData
import cl.samf.individual2_mod6.data.local.Item
import cl.samf.individual2_mod6.data.local.ItemDao

class Repositorio (private val itemDao: ItemDao) {
    suspend fun insertItem(item: Item){
        itemDao.insertItem(item)
    }

    fun obtenerItem(): LiveData<List<Item>> {
        return itemDao.obtenertodoItem() //obtener datos
    }


}