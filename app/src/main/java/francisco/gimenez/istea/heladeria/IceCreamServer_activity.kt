package francisco.gimenez.istea.heladeria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class IceCreamServer_activity : AppCompatActivity() {
    lateinit var textViewSize:TextView
    lateinit var flavor1:EditText
    lateinit var flavor2:EditText
    lateinit var flavor3:EditText
    lateinit var flavor4:EditText
    lateinit var extras: Spinner
    lateinit var checkout:Button
    var extraFlavors:ArrayList<String> = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ice_cream_server_activity)
        Initialize()
        extraFlavors.add("Chocolate fundido")
        extraFlavors.add("Salsa de frutilla")
    }

    fun Initialize(){
        textViewSize =findViewById(R.id.textV_iceCreamSize)
        flavor1=findViewById(R.id.eText_Flavor1)
        flavor2=findViewById(R.id.eText_Flavor2)
        flavor3=findViewById(R.id.eText_Flavor3)
        flavor4=findViewById(R.id.eText_Flavor4)
        extras=findViewById(R.id.sp_extra)
        checkout=findViewById(R.id.button_checkout)
        InitSpinner()
    }

    private fun InitSpinner() {
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,extraFlavors)
        extras.adapter = adapter
    }


}
