

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


class PartialSortTest extends org.scalatest.junit.JUnit3Suite {

    def testPartialSort0 {
        val numbers = Array(5, 2, 4, 3, 1, 6)

        ngl.partial_sort(numbers, 0, 3, 6)

        expect(1)(numbers(0))
        expect(2)(numbers(1))
        expect(3)(numbers(2))
        expect(5)(numbers(3))
        expect(4)(numbers(4))
        expect(6)(numbers(5))
    }

    def testPartialSort1 {
        val numbers = Array(8, 8, 5, 3, 7, 6, 5, 3, 2, 4)

        ngl.partial_sort(numbers, 0, 5, 10)

        expect(2)(numbers(0))
        expect(3)(numbers(1))
        expect(3)(numbers(2))
        expect(4)(numbers(3))
        expect(5)(numbers(4))
        expect(8)(numbers(5))
        expect(8)(numbers(6))
        expect(7)(numbers(7))
        expect(6)(numbers(8))
        expect(5)(numbers(9))
    }

}