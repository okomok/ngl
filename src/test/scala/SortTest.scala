

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


/*
 *
 * Copyright (c) 1994
 * Hewlett-Packard Company
 *
 * Copyright (c) 1996,1997
 * Silicon Graphics Computer Systems, Inc.
 *
 * Copyright (c) 1997
 * Moscow Center for SPARC Technology
 *
 * Copyright (c) 1999
 * Boris Fomitchev
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 * Permission to use or copy this software for any purpose is hereby granted
 * without fee, provided the above notices are retained on all copies.
 * Permission to modify the code and to distribute modified code is granted,
 * provided the above notices are retained, and a notice that the code was
 * modified is included with the above copyright notice.
 *
 */


package com.github.okomok
package ngltest


import com.github.okomok.ngl


class SortTest extends org.scalatest.junit.JUnit3Suite {

    def testStableSort0 {
        val a = Array(1, 50, -10, 11, 42, 19)
        val xs = ngl.Seq.from(a)
        ngl.stable_sort(xs, xs.begin, xs.end)
        expect(-10)(a(0))
        expect(1)(a(1))
        expect(11)(a(2))
        expect(19)(a(3))
        expect(42)(a(4))
        expect(50)(a(5))

        val letters = Array("bb", "aa", "ll", "dd", "qq", "cc")
        val ys = ngl.Seq.from(letters)
        ngl.stable_sort(ys, ys.begin, ys.end)
        expect("aa")(letters(0))
        expect("bb")(letters(1))
        expect("cc")(letters(2))
        expect("dd")(letters(3))
        expect("ll")(letters(4))
        expect("qq")(letters(5))
    }

    def testStableSort2 {
        val datas = Array(
            Pair(0, 10),
            Pair(1, 8),
            Pair(2, 6),
            Pair(3, 6),
            Pair(4, 6),
            Pair(5, 4),
            Pair(6, 9)
        )

        val xs = ngl.Seq.from(datas)
        ngl.stable_sort(xs, xs.begin, xs.end)(Ordering.fromLessThan[Pair[Int, Int]](_._2 < _._2))

        expect(Pair(5, 4))(datas(0))
        expect(Pair(2, 6))(datas(1))
        expect(Pair(3, 6))(datas(2))
        expect(Pair(4, 6))(datas(3))
        expect(Pair(1, 8))(datas(4))
        expect(Pair(6, 9))(datas(5))
        expect(Pair(0, 10))(datas(6))
    }

    def testSort1 {
        val numbers = Array(1, 50, -10, 11, 42, 19)
        val xs = ngl.Seq.from(numbers)
        ngl.sort(xs, xs.begin, xs.end)
        expect(-10)(numbers(0))
        expect(1)(numbers(1))
        expect(11)(numbers(2))
        expect(19)(numbers(3))
        expect(42)(numbers(4))
        expect(50)(numbers(5))
    }

    def testSort2 {
        val numbers = Array(1, 50, -10, 11, 42, 19)
        val xs = ngl.Seq.from(numbers)
        ngl.sort(xs, xs.begin, xs.end)(Ordering.fromLessThan[Int](_ > _))
        expect(-10)(numbers(5))
        expect(1)(numbers(4))
        expect(11)(numbers(3))
        expect(19)(numbers(2))
        expect(42)(numbers(1))
        expect(50)(numbers(0))
    }

    def testIsSorted1 {
        val numbers = Array(1, 50, -10, 11, 42, 19)
        val xs = ngl.Seq.from(numbers)
        expect(false)(ngl.is_sorted(xs, xs.begin, xs.end))
        ngl.sort(xs, xs.begin, xs.end)
        expect(true)(ngl.is_sorted(xs, xs.begin, xs.end))
    }

}