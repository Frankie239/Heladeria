package francisco.gimenez.istea.heladeria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isGone
import androidx.core.view.isVisible
import francisco.gimenez.istea.heladeria.Model.DbMockup
import francisco.gimenez.istea.heladeria.Model.IceCream
import francisco.gimenez.istea.heladeria.Model.Seller

class IceCreamServer_activity : AppCompatActivity() {
    lateinit var textViewSize:TextView
    lateinit var flavor1:EditText
    lateinit var flavor2:EditText
    lateinit var flavor3:EditText
    lateinit var flavor4:EditText
    lateinit var extras: Spinner
    lateinit var checkout:Button
    lateinit var payButton:Button
    var itemsQuantity:Int =0
    var extraFlavors:ArrayList<String> = ArrayList<String>()
    var index:Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ice_cream_server_activity)
        extraFlavors.add("Chocolate fundido")
        extraFlavors.add("Salsa de frutilla")
        Initialize()
        itemsQuantity = DbMockup.order.size

        LoadView(index)

    }

    private fun Initialize(){
        textViewSize =findViewById(R.id.textV_iceCreamSize)
        flavor1=findViewById(R.id.eText_Flavor1)
        flavor2=findViewById(R.id.eText_Flavor2)
        flavor3=findViewById(R.id.eText_Flavor3)
        flavor4=findViewById(R.id.eText_Flavor4)
        extras=findViewById(R.id.sp_extra)
        checkout=findViewById(R.id.button_checkout)
        payButton=findViewById(R.id.button_pay)
        InitSpinner()

        checkout.setOnClickListener(View.OnClickListener {

            AddToCheckout(index);
            index++
            LoadView(index)

        })
        payButton.setOnClickListener(View.OnClickListener {

            AddToCheckout(index)
            val intent: Intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("items",DbMockup.checkedOut)
            startActivity(intent)
        })
    }

    private fun InitSpinner() {
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,extraFlavors)
        extras.adapter = adapter
    }

    fun LoadView(id:Int){

        textViewSize.text = DbMockup.order[id].size.toString()

        when(textViewSize.text){
            "Cono" ->{
                flavor3.isVisible = false
                flavor4.isVisible = false
                extras.isVisible = false
            }
            "Cuarto" ->{
                flavor3.isVisible = true
                flavor4.isVisible = false
                extras.isVisible = true
            }
            "Kilo" ->{
                flavor3.isVisible = true
                flavor4.isVisible = true
                extras.isVisible = true
            }


        }
         if (id == itemsQuantity-1){
            checkout.isGone = true

            payButton.isVisible = true
            payButton.isEnabled = true
        }

    }
    private fun AddToCheckout(id:Int){
        var flavors: ArrayList<String>  = ArrayList<String>()
        flavors.add(flavor1.text.toString())
        flavors.add(flavor2.text.toString())
        flavors.add(flavor3.text.toString())
        flavors.add(flavor4.text.toString())

        DbMockup.checkedOut.add(
            IceCream(
                DbMockup.order[id].price,
                DbMockup.order[id].description,
                DbMockup.order[id].size,
                DbMockup.order[id].photo,
                flavors
            )
        )
    }

}
