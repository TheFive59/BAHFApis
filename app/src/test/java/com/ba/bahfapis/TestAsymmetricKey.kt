package com.ba.bahfapis

import com.ba.bahfsecurityapi.Utils.BAHFTools
import com.ba.bahfsecurityapi.services.BAHFPaymentApiConnection
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class TestApi {
    @Test
    fun getAsymmetricKeys() = runBlocking {
        val connection = BAHFPaymentApiConnection
        val accessToken = connection.getAsymmetricKeys(
            "Sun, 10 Sep 2022 19:43:31 UTC",
            "200.38.123.143",
            "123e4567-e89b-12d3-a456-426655440000",
            "Q685828920200407191603"
        ).results.toString()

        println("TEST ASYMMETRIC KEY" + accessToken)
        assertEquals(
            accessToken,
            "{\n" + "  \"message\": \"OK.\",\n" + "  \"id\": \"17920190617173411592\",\n" + "  \"advice\": \"The proper use of the app is recommended, any improper use will be sanctioned.\",\n" + "  \"data\": {\n" + "    \"accessId\": \"5f6371398e8604438e81059c\",\n" + "    \"accessPrivate\": \"MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCDYso/o8hGZsPchvLS+I7T2vfp2SQeYSrn+jWvzrKmEkcli4J8GZKG8867BOjbUo6TPEBCLFaznTqsgp+RHPizvEGZRx8j1c4Mb8PkHrHCTKKKGXtdZdcda8fbdJ44/lwbRPWUwAJtQcl+a3oHShnSFErnQ+Qov6zxicGOzRHy8neqMJZRChuS8w+tawwgD/bxDi0g+jwb1mvfzp1rWRiA7ZYI4eAMgPtTSn1voWoVQ4g2G00EvH2qzewYU51k9NLwTzX4+2szoQYbkhOYzfzVotJtSSfp1lU7gVcSWxDjMxNLlI7fZBQvU0WHNRLAVH4nrpNybx4sYMi809UgwywxAgMBAAECggEAI84UV+uGdMkkr0CHhD8AjXOrBCuM0Eqiqr1hTBwES4XHpc+zK6a8a9KdkBHyc3K4MB/HU0FKD4DVsJWYbq96h2DSb7cWIWnu0SzUMaK7xrujwAbZu8Y5LWdl+8R4KggHidbtJjB9eNDo3G7lvn7PMpUdJJE36HLz6o8kFIqGTbKqJyibxDvOra0oFMLhSBH/3H9HkrSqFyNhzFLD74eDgs+7VilXKqqWS1uUq4MBGQ7TuefCx5fDkJzy62+Qzf1A5BNEs1MzG+RjBYnDi3SuHwuua0AYhd3X9at8YasIzk1VBQdKCYxS6zve15N3hngkcgSV1F3uqCeyt2GpRMmgkQKBgQC+93YhBWVDCDSIxaF0oCbFj8Zj7+j48tksseyiZhsx6JAiIC+LVSY0ZraMwrc2GEtIq2o6IaXMj4db2rnkCys2vyEkcTX3l6KlzqalT/h4FxS9b92BCmnuUR3v+a3GmtjP3K5vRU4+Xr6iB0ZzCl6xW/N9rrB3Krhp41sgBhiP/wKBgQCwIQ7tg7k3H4fN6nCUMHSEes6FkMF/iVkVcZZLfFWJVd4U0hjTmR0viEW8K3Ud2ySr5OMAqfJahoqvFMy/oqFvOPmnQHK9aYvWNerI2yY5LlUDSe0sqgLD3MAkHN7oGzMOXVmb8vpOzC7lnV5/O0S1UJ4/bvMvYEijNK+RSslDzwKBgH2OVEO3uXFOJsQ6NEJqvbMtKYIxjZqIiNODFBNeUMkKoCFfygKw9FKFqcZ4i17ssCrSUSBxWQJa5+Mztv7BfSMcnRzJtnLYZt7fNOAB6VqDymYW86rQ/v7qpGVQYrnuu1hHPwT3q08EmhAL+nzOt52i2D+tKGbhVqiADDzM5T9fAoGAXqBELuNYPP9ZrQ3JkjQ+RXbdQfE1pFmcXOL7xm50Xiad/D2sTPK0NXdXT/NhJrs4BoogU5j6thwWol3gawzrAqBvsKX1f0IXeOzayTLEZHA6CFxNanOkrKoLKNvB/p2uXodUv25ZgMA+aeqUfHLRRUCc5KOtT8TBAb4qnTq6yw0CgYAdlNKHE86KBfSZMn/mutcMggrvY3N2u38uCVwLFxP4WY9gI613nEienXcptL+zv4W9GVdxCRkPzPgvUIm4zj6fUFPlpG7N1xdOiOjsEdlGpROsAFKgLhSegl2z4MtkeN8mc9qmKGVsWDlets2QoEOCgFDvJ7ARyUtJg6dX6pgGWA==\"\n" + "  }\n" + "}"
        )
    }


}