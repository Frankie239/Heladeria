package francisco.gimenez.istea.heladeria

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import francisco.gimenez.istea.heladeria.Model.*

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


    }


    private fun initialize(){
        listIceCream = DbMockup.checkedOut
        buttonCheckout = findViewById(R.id.button_finish)
        spinner = findViewById(R.id.spinner_checkout)

        convertToNameList()
        buttonCheckout.setOnClickListener(View.OnClickListener {
            DbMockup.order = ArrayList<IceCream>()
            DbMockup.checkedOut = ArrayList<IceCream>()
            var currentSeller: Seller = GrabSeller()
            Toast.makeText(this, currentSeller.currentSell.toString(), Toast.LENGTH_SHORT).show()
            if (CheckQuantity(currentSeller)) {
                val intent: Intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else
                Toast.makeText(this, "El seller" + currentSeller.name + "No puede tomar mas de" + currentSeller.maxSell, Toast.LENGTH_SHORT).show()


        })
        InitSpinner()

    }
    private fun InitSpinner(){
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,sellers)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapter
    }
    private fun GrabSeller():Seller{
        return DbMockup.sellers[spinner.selectedItemPosition]
    }
    private fun CheckQuantity(seller: Seller):Boolean{
        seller.currentSell++
        return seller.currentSell <= seller.maxSell
    }
    private fun AddSellers(){
        DbMockup.sellers.add(Seller(
                1,
                "Lenni",
                5
        ))
        DbMockup.sellers.add(Seller(
                2,
                "Carl",
                10
        ))
        DbMockup.sellers.add(Seller(
                3,
                "Barney",
                15
        ))


    }

    private fun convertToNameList(){
        for (seller in DbMockup.sellers)
        {
            sellers.add(seller.name)
        }
    }


}