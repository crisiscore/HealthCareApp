package xyz.imei.healthcare.data.vos

import com.google.gson.annotations.SerializedName

class HealthCareInfoVO(@SerializedName("id") val id: Int,
                       @SerializedName("title") val title: String,
                       @SerializedName("image") val image: String,
                       @SerializedName("author") val author: AuthorVO,
                       @SerializedName("short-description") val shorDescription: String,
                       @SerializedName("published-date") val publishedDate: String,
                       @SerializedName("complete-url") val completeUrl: String)