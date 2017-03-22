package net.loshodges.expressions;


import org.junit.Test;

import static net.loshodges.expressions.SearchResultKt.searchNew;
import static net.loshodges.expressions.SearchResultKt.searchNewExceptional;
import static net.loshodges.expressions.SearchResultKt.searchOld;
import static org.assertj.core.api.Assertions.assertThat;

public class JavaExpressions {

    @Test
    public void assignmentAsResultOfIf(){
        boolean newSearch = false;
        String searchQuery = "leonardo && raphael";

        final SearchResult res;
        if (newSearch) {
            res = searchNew(searchQuery);
        } else {
            res = searchOld(searchQuery);
        }
        assertThat(res.getType()).isEqualTo("old");
    }


    @Test
    public void assignmentAsResultOfTry(){
        boolean doThrow = false;
        String searchQuery = "leonardo && raphael";

        SearchResult res;
        try {
            res = searchNewExceptional(searchQuery, doThrow);
        } catch (Exception e) {
            res = searchOld(searchQuery);
        }
        assertThat(res.getType()).isEqualTo("new");
    }


    @Test
    public void assignmentAsResultOfSwitch(){
        int type = 2;
        String searchQuery = "leonardo && raphael";
        final SearchResult res;
        switch (type) {
            case 0:
                res = searchOld(searchQuery);
                break;
            case 1:
                res = searchNew(searchQuery);
                break;
            default:
                res = searchNew(searchQuery);

        }
        assertThat(res.getType()).isEqualTo("new");
    }



}
