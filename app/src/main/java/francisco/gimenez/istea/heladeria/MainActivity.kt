package francisco.gimenez.istea.heladeria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import francisco.gimenez.istea.heladeria.Model.IceCream


class MainActivity : AppCompatActivity() {
    lateinit var recyclerIceCream: RecyclerView
    lateinit var listIceCream:ArrayList<IceCream>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    private fun Initialize(){
        listIceCream = ArrayList<IceCream>()
        
    }
}