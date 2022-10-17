package com.example.example

import com.google.gson.annotations.SerializedName


data class BAHFSymKeysConnInfoModel(
  @SerializedName("auth_date"           ) var authDate          : String? = null,
  @SerializedName("customer_ip_address" ) var customerIpAddress : String? = null,
  @SerializedName("interaction_id"      ) var interactionId     : String? = null,
  @SerializedName("track_id"            ) var trackId           : String? = null
)