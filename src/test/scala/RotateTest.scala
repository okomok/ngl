

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


class RotateTest extends org.scalatest.junit.JUnit3Suite {

    def testRotate0 {
        val v1 = Array(0, 1, 2, 3, 4, 5)
        ngl.rotate(v1, 0, 3, 6)
        expect(3)(v1(0))
        expect(4)(v1(1))
        expect(5)(v1(2))
        expect(0)(v1(3))
        expect(1)(v1(4))
        expect(2)(v1(5))
    }

    def testRotate1 {
        val v1 = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

        ngl.rotate(v1, 0, 1, 10)
        expect(1)(v1(0))
        expect(2)(v1(1))
        expect(3)(v1(2))
        expect(4)(v1(3))
        expect(5)(v1(4))
        expect(6)(v1(5))
        expect(7)(v1(6))
        expect(8)(v1(7))
        expect(9)(v1(8))
        expect(0)(v1(9))

        ngl.rotate(v1, 0, 2, 10)
        expect(3)(v1(0))
        expect(4)(v1(1))
        expect(5)(v1(2))
        expect(6)(v1(3))
        expect(7)(v1(4))
        expect(8)(v1(5))
        expect(9)(v1(6))
        expect(0)(v1(7))
        expect(1)(v1(8))
        expect(2)(v1(9))

        ngl.rotate(v1, 0, 7, 10)
        expect(0)(v1(0))
        expect(1)(v1(1))
        expect(2)(v1(2))
        expect(3)(v1(3))
        expect(4)(v1(4))
        expect(5)(v1(5))
        expect(6)(v1(6))
        expect(7)(v1(7))
        expect(8)(v1(8))
        expect(9)(v1(9))
    }

    def testRotateCopy0 {
        val w1 = Array(0, 1, 2, 3, 4, 5)
        val v1 = Array(0, 0, 0, 0, 0, 0)
        ngl.rotate_copy(w1, 0, 3, 6)(v1, 0)
        expect(3)(v1(0))
        expect(4)(v1(1))
        expect(5)(v1(2))
        expect(0)(v1(3))
        expect(1)(v1(4))
        expect(2)(v1(5))
    }

    def testRotateCopy1 {
        val w1 = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val v1 = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

        ngl.rotate_copy(w1, 0, 1, 10)(v1, 0)
        expect(1)(v1(0))
        expect(2)(v1(1))
        expect(3)(v1(2))
        expect(4)(v1(3))
        expect(5)(v1(4))
        expect(6)(v1(5))
        expect(7)(v1(6))
        expect(8)(v1(7))
        expect(9)(v1(8))
        expect(0)(v1(9))

        ngl.rotate_copy(w1, 0, 3, 10)(v1, 0)
        expect(3)(v1(0))
        expect(4)(v1(1))
        expect(5)(v1(2))
        expect(6)(v1(3))
        expect(7)(v1(4))
        expect(8)(v1(5))
        expect(9)(v1(6))
        expect(0)(v1(7))
        expect(1)(v1(8))
        expect(2)(v1(9))
    }
}