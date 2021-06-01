package francisco.gimenez.istea.heladeria.Model

import java.io.Serializable

data class Seller(
        var id:Int,
        var name:String,
        var maxSell:Int,
        var currentSell:Int = 1
):Serializable