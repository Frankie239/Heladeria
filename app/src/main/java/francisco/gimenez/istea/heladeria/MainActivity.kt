package francisco.gimenez.istea.heladeria

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.constraintlayout.solver.state.State
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import francisco.gimenez.istea.heladeria.Model.IceCream
import francisco.gimenez.istea.heladeria.Model.IceCreamAdapter


class MainActivity : AppCompatActivity() {
    lateinit var recyclerIceCream: RecyclerView
    lateinit var listIceCream:ArrayList<IceCream>

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Initialize()
        recyclerIceCream = findViewById(R.id.recycler_iceCream)
        recyclerIceCream.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        //vinculate to the recycler
        recyclerIceCream.adapter = IceCreamAdapter(listIceCream)

    }
    private fun Initialize(){
        listIceCream = ArrayList<IceCream>()
        listIceCream.add(IceCream(100,"dos gustos","Cono",R.mipmap.cono))
        listIceCream.add(IceCream(300,"Tres gustos","Cuarto",R.mipmap.cuarto))
        listIceCream.add(IceCream(800,"hasta cuatro gustos","Kilo",R.mipmap.kilo))
    }
}