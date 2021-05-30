package francisco.gimenez.istea.heladeria.Model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import francisco.gimenez.istea.heladeria.R

class CheckoutAdapter(private val dataset:ArrayList<IceCream>):RecyclerView.Adapter<CheckoutAdapter.TableItem>()
{
    class TableItem (view: View):RecyclerView.ViewHolder(view){
        val size:TextView
        val price:TextView


        init {
            price = view.findViewById(R.id.textV_item_price)
            size = view.findViewById(R.id.textV_item_size)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableItem {
        //We select which view to inflate
        val view = LayoutInflater.from(parent.context).inflate(R.layout.checkout_item,parent,false)
        return TableItem(view)
    }

    override fun onBindViewHolder(holder: TableItem, position: Int) {
        holder.price.text = dataset[position].price.toString()
        holder.size.text = dataset[position].size

    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}