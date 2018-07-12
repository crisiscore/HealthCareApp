package xyz.imei.healthcare.data.vos

import com.google.gson.annotations.SerializedName

class AuthorVO(@SerializedName("author-id") val id: Int,
               @SerializedName("author-name") val name: String,
               @SerializedName("author-picture") val picture: String)