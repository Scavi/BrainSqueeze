package com.scavi.brainsqueeze.career;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import static com.google.common.truth.Truth.*;

public class CompanyMergerTest {

    @Test
    public void test1() {
        Map<String, String> relationships = new HashMap<>();
        relationships.put("beidu", "ofo");
        relationships.put("mobike", "alibaba");
        relationships.put("alibaba", "somethingElse");
        relationships.put("cookies", "mobike");

        int result = new CompanyMerger().longestChain(relationships);
        assertThat(result).isEqualTo(3);
    }


    @Test
    public void test2() {
        Map<String, String> relationships = new HashMap<>();
        relationships.put("foo", "bar");
        relationships.put("bar", "abc");
        relationships.put("abc", "ooo");
        relationships.put("ooo", "xyz");
        relationships.put("xyz", "cookies");

        int result = new CompanyMerger().longestChain(relationships);
        assertThat(result).isEqualTo(5);
    }
}