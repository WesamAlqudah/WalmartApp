package com.cs473de.walmartapp.models

import java.io.Serializable

class Product : Serializable {
    var id:Long?=null
    var name:String?=null
    var des:String?=""
    var price:Double?=0.0
    var catId:Long?=0
    var imageUrl:Int?=null
    var color:String?=null

    constructor()
    constructor(id: Long?, name: String?, price: Double?, catId: Long?, imageUrl: Int?,color:String?) {
        this.id = id
        this.name = name
        this.price = price
        this.catId = catId
        this.imageUrl = imageUrl
        this.color=color
    }

}