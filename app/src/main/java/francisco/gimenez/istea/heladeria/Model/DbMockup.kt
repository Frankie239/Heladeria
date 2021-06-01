package francisco.gimenez.istea.heladeria.Model

class DbMockup {

    companion object{

        var order:ArrayList<IceCream> = ArrayList<IceCream>()
        var checkedOut:ArrayList<IceCream> = ArrayList<IceCream>()
        var sellers:ArrayList<Seller> = AddSellers()

        fun AddSellers():ArrayList<Seller>{
            var sellers:ArrayList<Seller> = arrayListOf()
            sellers.add(Seller(
                    1,
                    "Lenni",
                    5
            ))
            sellers.add(Seller(
                    2,
                    "Carl",
                    10
            ))
            sellers.add(Seller(
                    3,
                    "Barney",
                    15
            ))
            return sellers

        }
    }

}