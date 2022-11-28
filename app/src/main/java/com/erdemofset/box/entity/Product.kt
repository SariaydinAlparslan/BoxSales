package com.erdemofset.box.entity

import java.io.Serializable

class Product(
    val name : String,
    val length: Double,
    val width : Double,
    val height : Double,
    val price : Double,
    val productName : String,
    val productInfo : String,
    val productCode: String,
    val rawMaterial : String,
    val productNot : String,
    val internalDimensions : String,
    val image : String,
    val image2 : String

) : Serializable {
}