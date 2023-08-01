package cl.samf.individual2_mod6.presentacion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.samf.individual2_mod6.data.local.Item
import cl.samf.individual2_mod6.databinding.ItemLayoutBinding

class AdaptadorItem : RecyclerView.Adapter<AdaptadorItem.ViewHolder>() {

    private val itemsList = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    fun setData(item: List<Item>){
        this.itemsList.clear()
        this.itemsList.addAll(item)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]
        holder.bind(item)
    }

    class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.textviewItemNombre.text = item.nombre
            binding.textViewItemCantidad.text = "Cantidad : " + item.cantidad.toString()
            binding.textViewPrecio.text = "V unitario : $" + item.precio.toString()
            binding.textviewTotal.text = "Total $" + (item.precio * item.cantidad).toString()

        }

    }
}