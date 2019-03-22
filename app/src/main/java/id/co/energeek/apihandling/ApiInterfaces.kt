package id.co.energeek.apihandling

import io.reactivex.Observable
import retrofit2.http.*

interface ApiInterfaces {
    @GET("ql6ou")
    fun noNullResp() : Observable<ApiResp>

    @GET("fvdsu")
    fun nullResp() : Observable<ApiResp>

    @GET("y3gmm")
    fun mixResp() : Observable<ApiResp>
}