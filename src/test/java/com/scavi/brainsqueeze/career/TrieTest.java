package com.scavi.brainsqueeze.career;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class TrieTest {
    @Test
    public void test1() {

        Trie trie = new Trie();
        trie.insert("hallo");
        trie.insert("hugo");
        trie.insert("cookie");

        assertThat(trie.exists("hugo")).isTrue();
        assertThat(trie.exists("hugol")).isFalse();
        assertThat(trie.exists("foo")).isFalse();
    }


    @Test
    public void test2() {
        Trie trie = new Trie();
        trie.insert("hasfallo");
        trie.insert("huuugo");
        trie.insert("cookie");

        assertThat(trie.exists("h*llo")).isTrue();
        assertThat(trie.exists("h*go")).isTrue();
        assertThat(trie.exists("f*o")).isFalse();
    }


    @Test
    public void test3() {
        Trie trie = new Trie();
        trie.insert("hasfallo");
        trie.insert("huuugo");
        trie.insert("cookie");

        assertThat(trie.exists("*l*o")).isTrue();
        assertThat(trie.exists("h*l*")).isTrue();
    }


    @Test
    public void test4() {
        Trie trie = new Trie();
        trie.insert("hasfallo");

        assertThat(trie.exists("ha")).isFalse();
    }
}
