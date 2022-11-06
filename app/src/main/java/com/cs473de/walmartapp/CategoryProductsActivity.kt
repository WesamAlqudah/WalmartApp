package com.cs473de.walmartapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.cs473de.walmartapp.models.Category
import com.cs473de.walmartapp.models.Product

class CategoryProductsActivity : AppCompatActivity(),Adapter.ListenerProductItem {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catrgoty_products)
        getProducts()
    }

    private fun getProducts() {
        val category=intent.getSerializableExtra("categoryJson") as Category
        initProductsRecycler(category.products!!)

    }
    private fun initProductsRecycler(products:List<Product>) {
        val rv=findViewById<RecyclerView>(R.id.rv_products)
        val productsAdapter=Adapter()
        productsAdapter.setAdapterType(Adapter.PRODUCT_TYPE)
        productsAdapter.setProducts(products)
        productsAdapter.setListenerProduct(this)
        rv.adapter=productsAdapter
    }

    override fun itemOnClick(product: Product) {
        TODO("Not yet implemented")
    }
}