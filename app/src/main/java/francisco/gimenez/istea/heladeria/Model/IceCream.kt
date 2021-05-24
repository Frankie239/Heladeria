package francisco.gimenez.istea.heladeria.Model

import java.io.Serializable

data class IceCream(
        val price:Int,
        val description:String,
        val size:String,
        val photo:Int,
        val flavors:ArrayList<String> = ArrayList<String>(),
):Serializable