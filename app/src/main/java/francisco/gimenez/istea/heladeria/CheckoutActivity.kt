package francisco.gimenez.istea.heladeria

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import francisco.gimenez.istea.heladeria.Model.CheckoutAdapter
import francisco.gimenez.istea.heladeria.Model.DbMockup
import francisco.gimenez.istea.heladeria.Model.IceCream
import francisco.gimenez.istea.heladeria.Model.IceCreamAdapter

class CheckoutActivity : AppCompatActivity() {
    var sellers:ArrayList<String> = ArrayList<String>()
    lateinit var recyclerIceCream:RecyclerView
    lateinit var listIceCream:ArrayList<IceCream>
    lateinit var buttonCheckout:Button
    lateinit var addButton:Button
    lateinit var desc:TextView
    lateinit var spinner:Spinner

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        initialize()
        recyclerIceCream = findViewById(R.id.recycler_items)
        recyclerIceCream.layoutManager = LinearLayoutManager(this, ConstraintLayout.SCROLL_AXIS_HORIZONTAL,false)
        recyclerIceCream.adapter = CheckoutAdapter(listIceCream)
        sellers.add("Lenni")
        sellers.add("Carl")
        sellers.add("Barney")
    }

    private fun initialize(){
        listIceCream = DbMockup.checkedOut
        buttonCheckout = findViewById(R.id.button_finish)
        spinner = findViewById(R.id.spinner_checkout)
        buttonCheckout.setOnClickListener(View.OnClickListener {
            DbMockup.order = ArrayList<IceCream>()
            DbMockup.checkedOut = ArrayList<IceCream>()
            
        })
        InitSpinner()
    }
    private fun InitSpinner(){
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,sellers)
        spinner.adapter = adapter
    }

    private fun PrepareView(){
        //Todo: hacer que desaparezca los botones y la desc.


    }
}