package com.ba.bahfsecurityapi.Data.Core

import com.ba.bahfsecurityapi.Models.Security.BAHFAsymmetricKeysResponse
import com.ba.bahfsecurityapi.Models.Security.BAHFSymmetricKeysResponse
import com.ba.bahfsecurityapi.Models.Spei.Body.BAHFUpdateTransferBody
import com.ba.bahfsecurityapi.Models.Spei.Models.BAHFTransferResponse
import com.ba.bahfsecurityapi.Models.Spei.Models.BAHFUpdateResponse
import com.example.example.BAHFTransferInfo
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface BAHFSecurityApiClient {
    @GET("/v0.0.6/apps/keys/{x-fapi-auth-date}/{x-fapi-customer-ip-address}/{x-fapi-interaction-id}/{x-fapi-track-id}")
    suspend fun getAsymmetricKeys(
        @Path("x-fapi-auth-date") authDate: String,
        @Path("x-fapi-customer-ip-address") customerIpAddress: String,
        @Path("x-fapi-interaction-id") interactionId: String,
        @Path("x-fapi-track-id") trackId: String
    ): Response<BAHFAsymmetricKeysResponse>

    @GET("/apps/symmetric-keys/{x-fapi-auth-date}/{x-fapi-customer-ip-address}/{x-fapi-interaction-id}/{x-fapi-track-id}/{x-fapi-access-id}")
    suspend fun getSymmetrickeys(
        @Path("x-fapi-auth-date") authDate: String,
        @Path("x-fapi-customer-ip-address") customerIpAddress: String,
        @Path("x-fapi-interaction-id") interactionId: String,
        @Path("x-fapi-track-id") trackId: String,
        @Path("x-fapi-access-id") accesId: String
    ): Response<BAHFSymmetricKeysResponse>

    @Headers(
        "Content-Type:application/json",
        "{x-fapi-auth-date}/{x-fapi-customer-ip-address}/{x-fapi-interaction-id}/{x-fapi-access-id}/{x-fapi-channel-id}/{x-fapi-latitude}/{x-fapi-longitude}"
    )
    @POST("/cash-out/transfers")
    suspend fun createSpeiTransfer(@Body requestBody: BAHFTransferInfo): Call<BAHFTransferResponse>

    @PUT("/cash-out/transfers")
    suspend fun updateTransferSpei(@Body requestBody: BAHFUpdateTransferBody): Response<BAHFUpdateResponse>
}