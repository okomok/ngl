

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


class UniqueTest extends org.scalatest.junit.JUnit3Suite {

    def testUnique1 {
        val numbers = Array(0, 1, 1, 2, 2, 2, 3, 4)

        ngl.unique(numbers, 0, 8)

        expect(0)(numbers(0))
        expect(1)(numbers(1))
        expect(2)(numbers(2))
        expect(3)(numbers(3))
        expect(4)(numbers(4))
        expect(2)(numbers(5))
        expect(3)(numbers(6))
        expect(4)(numbers(7))
    }

     def testUniqueCopy1 {
        val numbers = Array(0, 1, 1, 2, 2, 2, 3, 4)
        val result = Array(0, 0, 0, 0, 0, 0, 0, 0)

        ngl.unique_copy(numbers, 0, 8)(result, 0)

        expect(0)(result(0))
        expect(1)(result(1))
        expect(2)(result(2))
        expect(3)(result(3))
        expect(4)(result(4))
        expect(0)(result(5))
        expect(0)(result(6))
        expect(0)(result(7))
    }

}