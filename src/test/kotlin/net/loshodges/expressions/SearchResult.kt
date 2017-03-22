package net.loshodges.expressions

import java.lang.Exception


data class SearchResult(val type: String, val query: String)

fun searchOld(searchQuery: String): SearchResult {
    return SearchResult("old", searchQuery)
}

fun searchNew(searchQuery: String): SearchResult {
    return SearchResult("new", searchQuery)
}

@Throws(Exception::class)
fun searchNewExceptional(searchQuery: String, doThrow: Boolean): SearchResult {
    if (doThrow) {
        throw Exception("uh-oh")
    } else {
        return searchNew(searchQuery)
    }
}

