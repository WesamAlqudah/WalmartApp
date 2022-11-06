package com.cs473de.walmartapp

import android.content.Intent
import android.icu.util.ULocale
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cs473de.walmartapp.models.Category
import com.cs473de.walmartapp.models.Product

class MainActivity : AppCompatActivity(),Adapter.ListenerCategoryItem {
    private val catsList=ArrayList<Category>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUserName()
        getCategories()
        initCatRecycler()
    }

    private fun initCatRecycler() {
        val rv=findViewById<RecyclerView>(R.id.rv_categories)
        val catsAdapter=Adapter()
        catsAdapter.setAdapterType(Adapter.CATEGORY_TYPE)
        catsAdapter.setCategories(this.catsList.toList())
        catsAdapter.setListenerCategory(this)
        rv.adapter=catsAdapter
    }

    fun getUserName(){
        val fullName=intent.extras?.getString("fullName")
        if (fullName!=null)
            findViewById<TextView>(R.id.tv_welcome).text= "Welcome $fullName"
    }

    fun getCategories(){
        val product1= Product(1,"T-shirt",50.0,1,R.drawable.walmart_logo,"red")
        val product2=Product(2,"Jacket",250.0,1,R.drawable.walmart_logo,"red")
        val product3=Product(3,"Jeans",34.0,1,R.drawable.walmart_logo,"red")
        val product4=Product(4,"shoos",77.0,1,R.drawable.walmart_logo,"red")
        catsList.add(
            Category(1,"Clothes",R.drawable.clothes_image, arrayListOf(product1,product2,product3,product4))
        )
        catsList.add(
            Category(2,"Sport",
                R.drawable.sport, arrayListOf(product1,product2,product3,product4))
        )
        catsList.add(
            Category(3,"Games",R.drawable.games_image, arrayListOf(product1,product2,product3,product4))
        )
        catsList.add(
            Category(4,"Electric",
                R.drawable.elec, arrayListOf(product1,product2,product3,product4))
        )
        catsList.add(
            Category(5,"Laptops",
                R.drawable.laptop_image, arrayListOf(product1,product2,product3,product4))
        )
    }

    override fun itemOnClick(category: Category) {
        getToCategoryParoductsActivity(category)
    }

    private fun getToCategoryParoductsActivity(category: Category) {
        val intent= Intent(this,CategoryProductsActivity::class.java)
        intent.putExtra("categoryJson",category)
        startActivity(intent)
    }
}