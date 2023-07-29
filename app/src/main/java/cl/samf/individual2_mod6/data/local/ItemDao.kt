package cl.samf.individual2_mod6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {
    @Insert
    suspend fun insertItem(item: Item)

    @Query("select * from tabla_item order by id ASC")
    fun obtenertodoItem(): LiveData<List<Item>>


}