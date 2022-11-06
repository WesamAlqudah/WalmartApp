package com.cs473de.walmartapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cs473de.walmartapp.models.Category
import com.cs473de.walmartapp.models.Product

class Adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var item_type:Int?=null
    private lateinit var categories: List<Category>
    private lateinit var listenerCategoryItem:ListenerCategoryItem
    private lateinit var listenerProductItem:ListenerProductItem

    private lateinit var products: List<Product>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (item_type!=null && item_type== CATEGORY_TYPE){
            val inflater= LayoutInflater.from(parent.context)
            Item_Category_VM(
                inflater.inflate(R.layout.item_category,parent,false)
            )
        } else {
            val inflater=LayoutInflater.from(parent.context)
            return Item_Product_VM(
                inflater.inflate(R.layout.item_product,parent,false)
            )
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (item_type!=null ){
            if (item_type== CATEGORY_TYPE){
                (holder as Item_Category_VM).bind(categories[position])
            }
            if (item_type== PRODUCT_TYPE){
                (holder as Item_Product_VM).bind(products[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return if (this.item_type== CATEGORY_TYPE)
            categories.size
        else if (this.item_type== PRODUCT_TYPE)
            products.size
        else 0
    }

    fun setAdapterType(type:Int){
        this.item_type=type
    }
    fun setCategories(categories: List<Category>){
        this.categories=categories
        notifyDataSetChanged()
    }
    fun setListenerCategory(listenerCategoryItem: ListenerCategoryItem){
        this.listenerCategoryItem=listenerCategoryItem
    }
    fun setListenerProduct(listenerProductItem: ListenerProductItem){
        this.listenerProductItem=listenerProductItem
    }
    fun setProducts(products: List<Product>){
        this.products=products
        notifyDataSetChanged()
    }


    inner class Item_Category_VM(val item : View):RecyclerView.ViewHolder(item){
        fun bind(category: Category){
            val img=item.findViewById<ImageView>(R.id.imgv_cat)
            val name=item.findViewById<TextView>(R.id.tv_cat_name)
            img.setImageResource(category.imageUrl!!)
            name.text=category.name
            img.setOnClickListener {
                if (listenerCategoryItem!=null){
                    listenerCategoryItem.itemOnClick(category)
                }
            }
        }

    }
    interface ListenerCategoryItem{
        fun itemOnClick(category: Category)
    }

    inner class Item_Product_VM(val item : View):RecyclerView.ViewHolder(item){
        fun bind(product: Product){
            val img=item.findViewById<ImageView>(R.id.imgv_product)
            val name=item.findViewById<TextView>(R.id.tv_product_name)
            img.setImageResource(product.imageUrl!!)
            name.text=product.name
            img.setOnClickListener {
                if (listenerProductItem!=null){
                    listenerProductItem.itemOnClick(product)
                }
            }
        }

    }
    interface ListenerProductItem{
        fun itemOnClick(product: Product)
    }


    companion object{
        val CATEGORY_TYPE=0
        val PRODUCT_TYPE=1
    }

}