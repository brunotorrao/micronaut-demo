package com.example.model

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.bson.types.ObjectId
import java.math.BigDecimal


data class Product(
    @BsonId @BsonProperty("_id") @JsonSerialize(using = ObjectIdSerializer::class)  var id: ObjectId? = null,
    var name: String,
    var price: BigDecimal,
    var color: String,
    var size: Int
) {
    constructor() : this(name = "", price = 0.0.toBigDecimal(), color = "", size = 0)
}

private class ObjectIdSerializer : StdSerializer<ObjectId>(ObjectId::class.java) {
    
    override fun serialize(p0: ObjectId?, p1: JsonGenerator?, p2: SerializerProvider?) {
        p1?.writeString(p0.toString())
    }
    
}