package com.cs473de.walmartapp.models

import java.io.Serializable

class Category : Serializable {
    var id:Long?=0
    var name:String?=null
    var description:String?=null
    var imageUrl:Int?=null
    var products:List<Product>?=ArrayList()

    constructor()
    constructor(id: Long?, name: String?, imageUrl: Int?) {
        this.id = id
        this.name = name
        this.imageUrl = imageUrl
    }

    constructor(id: Long?, name: String?, imageUrl: Int?, products: List<Product>?) {
        this.id = id
        this.name = name
        this.imageUrl = imageUrl
        this.products = products
    }


}