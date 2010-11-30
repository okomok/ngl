

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


class ReplaceTest extends org.scalatest.junit.JUnit3Suite {

    def testReplaceIf1 {
        val v1 = new Array[Int](10)
        for (i <- 0 until 10) {
            v1(i) = i % 5
        }

        ngl.replace_if(v1, 0, 10)(42) { x => (x % 2) != 0 }

        expect(0)(v1(0))
        expect(42)(v1(1))
        expect(2)(v1(2))
        expect(42)(v1(3))
        expect(4)(v1(4))
        expect(0)(v1(5))
        expect(42)(v1(6))
        expect(2)(v1(7))
        expect(42)(v1(8))
        expect(4)(v1(9))
    }

    def testReplaceCopy1 {
        val numbers = Array(0, 1, 2, 0, 1, 2)
        val result = Array(0, 0, 0, 0, 0, 0)

        ngl.replace_copy(numbers, 0, 6)(result, 0)(2, 42)

        expect(0)(result(0))
        expect(1)(result(1))
        expect(42)(result(2))
        expect(0)(result(3))
        expect(1)(result(4))
        expect(42)(result(5))
    }


    def testReplace0 {
        val numbers = Array(0, 1, 2, 0, 1, 2)

        ngl.replace(numbers, 0, 6)(2, 42)

        expect(0)(numbers(0))
        expect(1)(numbers(1))
        expect(42)(numbers(2))
        expect(0)(numbers(3))
        expect(1)(numbers(4))
        expect(42)(numbers(5))
    }

    def testReplaceCopyIf1 {
        val v1 = new Array[Int](10)
        for (i <- 0 until 10) {
            v1(i) = i % 5
        }
        val v2 = new Array[Int](10)

        ngl.replace_copy_if(v1, 0, 10)(v2, 0)(42) { x => (x % 2) != 0 }

        expect(0)(v2(0))
        expect(42)(v2(1))
        expect(2)(v2(2))
        expect(42)(v2(3))
        expect(4)(v2(4))
        expect(0)(v2(5))
        expect(42)(v2(6))
        expect(2)(v2(7))
        expect(42)(v2(8))
        expect(4)(v2(9))
    }
}