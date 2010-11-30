

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


class LexicographicalCompareTest extends org.scalatest.junit.JUnit3Suite {

    def test1 {
        val n1 = "shoe"
        val n2 = "shine"
        val before = ngl.lexicographical_compare(n1, 0, 6)(n2, 0, 6)
        assert(!before)
    }

    def test2 {
        val n1 = "shoe"
        val n2 = "shine"
        val before = ngl.lexicographical_compare(n1, 0, 6)(n2, 0, 6)(Ordering.fromLessThan[Char](_ > _))
        assert(before)
    }


    def testThreeWay0 {
        val n1 = "shoe"
        val n2 = "shoe"
        val before = ngl.lexicographical_compare_3way(n1, 0, 4)(n2, 0, 4)
        expect(0)(before)
    }

    def testThreeWay1 {
        val n1 = "shoe"
        val n2 = "shine"
        val before = ngl.lexicographical_compare_3way(n1, 0, 4)(n2, 0, 6)
        assert(before > 0)
    }

    def testThreeWay2 {
        val n1 = "shoe"
        val n2 = "shine"
        val before = ngl.lexicographical_compare_3way(n1, 0, 4)(n2, 0, 6)(Ordering.fromLessThan[Char](_ > _))
        assert(before < 0)
    }
}