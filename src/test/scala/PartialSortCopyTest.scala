

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


class PartialSortCopyTest extends org.scalatest.junit.JUnit3Suite {

    def testPartialSortCopy0 {
        val numbers = Array(5, 2, 4, 3, 1, 6)
        val result = Array(0, 0, 0)

        ngl.partial_sort_copy(numbers, 0, 6)(result, 0, 3)

        expect(1)(result(0))
        expect(2)(result(1))
        expect(3)(result(2))
    }

    def testPartialSortCopy1 {
        val numbers = Array(3, 0, 4, 3, 2, 8, 2, 7, 7, 5)
        val result = new Array[Int](5)

        ngl.partial_sort_copy(numbers, 0, numbers.length)(result, 0, 5)

        expect(0)(result(0))
        expect(2)(result(1))
        expect(2)(result(2))
        expect(3)(result(3))
        expect(3)(result(4))
    }

}