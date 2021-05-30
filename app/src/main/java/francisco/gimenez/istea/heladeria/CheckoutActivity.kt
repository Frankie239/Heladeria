package francisco.gimenez.istea.heladeria

import android.annotation.SuppressLint
import android.content.Intent
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
        sellers.add("Lenni")
        sellers.add("Carl")
        sellers.add("Barney")
        initialize()
        recyclerIceCream = findViewById(R.id.recycler_items)
        recyclerIceCream.layoutManager = LinearLayoutManager(this, ConstraintLayout.SCROLL_AXIS_HORIZONTAL,false)
        recyclerIceCream.adapter = CheckoutAdapter(listIceCream)


    }

    private fun initialize(){
        listIceCream = DbMockup.checkedOut
        buttonCheckout = findViewById(R.id.button_finish)
        spinner = findViewById(R.id.spinner_checkout)
        buttonCheckout.setOnClickListener(View.OnClickListener {
            DbMockup.order = ArrayList<IceCream>()
            DbMockup.checkedOut = ArrayList<IceCream>()
            GrabSeller()
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        })
        InitSpinner()
    }
    private fun InitSpinner(){
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,sellers)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapter
    }
    private fun GrabSeller(){
        DbMockup.sellers[spinner.selectedItem.toString()]
    }
    private fun validateSellers(){
        val first = DbMockup?.sellers["Lenni"]?.compareTo(5)
        val second = DbMockup?.sellers["Carl"]?.compareTo(10)
        val third = DbMockup?.sellers["Barney"]?.compareTo(15)
       if()
    }

}