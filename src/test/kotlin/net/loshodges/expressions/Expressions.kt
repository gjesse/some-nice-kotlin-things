package net.loshodges.expressions

import net.loshodges.expressions.SearchResult.Companion.searchNew
import net.loshodges.expressions.SearchResult.Companion.searchNewExceptional
import net.loshodges.expressions.SearchResult.Companion.searchOld
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class Expressions {

    @Test
    fun assignmentAsResultOfIf() {
        val newSearch = false
        val searchQuery = "leonardo && raphael"
        val res = if (newSearch) {
            searchNew(searchQuery)
        } else {
            searchOld(searchQuery)
        }
        assertThat(res.type).isEqualTo("old")
    }

    @Test
    fun assignmentAsResultOfTry() {
        val doThrow = false
        val searchQuery = "leonardo && raphael"
        val res = try {
            searchNewExceptional(searchQuery, doThrow)
        } catch (e: Exception) {
            searchOld(searchQuery)
        }
        assertThat(res.type).isEqualTo("new")
    }

    @Test
    fun assignmentAsResultOfWhen() {
        val type = 2
        val searchQuery = "leonardo && raphael"
        val res = when (type) {
            0 -> searchOld(searchQuery)
            1 -> searchNew(searchQuery)
            else -> searchNew(searchQuery)
        }
        assertThat(res.type).isEqualTo("new")
    }
}