

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


class NthElementTest extends org.scalatest.junit.JUnit3Suite {

    def testNthElement0 {
        val numbers = Array(5, 2, 4, 1, 0, 3 ,77)

        ngl.nth_element(numbers, 0, 3, 6)

        expect(1)(numbers(0))
        expect(0)(numbers(1))
        expect(2)(numbers(2))
        expect(3)(numbers(3))
        expect(4)(numbers(4))
        expect(5)(numbers(5))
    }

    def testNthElement1 {
        val numbers = Array(6, 8, 5, 1, 7, 4, 1, 5, 2, 6)

        ngl.nth_element(numbers, 0, 5, 10)

        expect(1)(numbers(0))
        expect(1)(numbers(1))
        expect(4)(numbers(2))
        expect(2)(numbers(3))
        expect(5)(numbers(4))
        expect(5)(numbers(5))
        expect(6)(numbers(6))
        expect(7)(numbers(7))
        expect(8)(numbers(8))
        expect(6)(numbers(9))
    }

    def testNthElement2 {
        val numbers = Array(4, 5, 4, 2, 1, 7, 4, 3, 1, 6)

        ngl.nth_element(numbers, 0, 5, 10)(Ordering.fromLessThan(_ > _))

        expect(6)(numbers(0))
        expect(7)(numbers(1))
        expect(4)(numbers(2))
        expect(4)(numbers(3))
        expect(5)(numbers(4))
        expect(4)(numbers(5))
        expect(3)(numbers(6))
        expect(2)(numbers(7))
        expect(1)(numbers(8))
        expect(1)(numbers(9))
    }
}