package francisco.gimenez.istea.heladeria

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import francisco.gimenez.istea.heladeria.Model.DbMockup
import francisco.gimenez.istea.heladeria.Model.IceCream
import francisco.gimenez.istea.heladeria.Model.IceCreamAdapter

class CheckoutActivity : AppCompatActivity() {
    lateinit var recyclerIceCream:RecyclerView
    lateinit var listIceCream:ArrayList<IceCream>
    lateinit var buttonCheckout:Button

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        initialize()
        recyclerIceCream = findViewById(R.id.recycler_items)
        recyclerIceCream.layoutManager = LinearLayoutManager(this, ConstraintLayout.SCROLL_AXIS_HORIZONTAL,false)
        recyclerIceCream.adapter = IceCreamAdapter(listIceCream)
    }

    private fun initialize(){
        listIceCream = DbMockup.checkedOut
        buttonCheckout = findViewById(R.id.button_finish)

        buttonCheckout.setOnClickListener(View.OnClickListener {
            //Todo: hacer que se limpien las listas y volver al main.
        })
    }
}