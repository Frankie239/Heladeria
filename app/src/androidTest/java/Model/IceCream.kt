package Model

import java.io.Serializable

data class IceCream(
        val price:Int,
        val description:String,
        val size:String,
        val flavors:ArrayList<String>,
        val photo:Int
):Serializable