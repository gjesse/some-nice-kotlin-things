package net.loshodges.expressions

import java.lang.Exception


data class SearchResult(val type: String, val query: String) {

    companion object {
        @JvmStatic
        fun searchOld(searchQuery: String): SearchResult {
            return SearchResult("old", searchQuery)
        }

        @JvmStatic
        fun searchNew(searchQuery: String): SearchResult {
            return SearchResult("new", searchQuery)
        }

        @JvmStatic
        @Throws(Exception::class)
        fun searchNewExceptional(searchQuery: String, doThrow: Boolean): SearchResult {
            if (doThrow) {
                throw Exception("uh-oh")
            } else {
                return searchNew(searchQuery)
            }
        }
    }
}



