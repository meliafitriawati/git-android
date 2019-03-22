package id.co.energeek.apihandling


data class ApiResp(val meta: Meta, val data: List<Data>, val links: Links)

data class Data(val type: String?, val id: Int?, val attributes: Attributes)

data class Attributes(val title: String, val body: String, val created: String, val updated: String, val isAvailable: Boolean?)

data class Links(val self: String, val first: String, val prev: String, val next: String, val last: String)

data class Meta(val totalPages: Int)