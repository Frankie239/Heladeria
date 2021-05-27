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

class IceCreamAdapter(private val dataset:ArrayList<IceCream>):RecyclerView.Adapter<IceCreamAdapter.ViewHolder>()
{
    //Inner class
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val description:TextView
        val size:TextView
        val price:TextView
        val image:ImageView
        val add:Button

        init {
            price = view.findViewById(R.id.textV_price)
            description = view.findViewById(R.id.textV_description)
            size = view.findViewById(R.id.textV_size)
            image = view.findViewById(R.id.image_Item)
            add = view.findViewById(R.id.button_add)
        }
    }

    //On the creation of the viewholder, method herited from RecyclerView.
    //
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //We select which view to inflate
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ice_cream_item,parent,false)
        return ViewHolder(view)

    }


    //Hook: When binding the data to the layout.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.price.text = dataset[position].price.toString()
        holder.description.text = dataset[position].description
        holder.size.text = dataset[position].size
        holder.image.setImageResource(dataset[position].photo)
        holder.add.setOnClickListener(View.OnClickListener {
            Toast.makeText(holder.itemView.context,"compraste un"+dataset[position].size.toString(),Toast.LENGTH_LONG).show()
            DbMockup.order.add(dataset[position])
        })


    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}