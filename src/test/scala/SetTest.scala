

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


class SetTest extends org.scalatest.junit.JUnit3Suite {

    def testSetUnion0 {
        val v1 = Array(13, 18, 23)
        val v2 = Array(10, 13, 17, 23)
        val result = Array(0, 0, 0, 0, 0, 0, 0)

        ngl.set_union(v1, 0, 3)(v2, 0, 4)(result, 0)

        expect(10)(result(0))
        expect(13)(result(1))
        expect(17)(result(2))
        expect(18)(result(3))
        expect(23)(result(4))
        expect(0)(result(5))
        expect(0)(result(6))
    }

    def testSetIntersection0 {
        val v1 = Array(13, 18, 23)
        val v2 = Array(10, 13, 17, 23)
        val result = Array(0, 0, 0, 0)

        ngl.set_intersection(v1, 0, 3)(v2, 0, 4)(result, 0)

        expect(13)(result(0))
        expect(23)(result(1))
        expect(0)(result(2))
        expect(0)(result(3))
    }

    def testSetSymmetricDifference0 {
        val v1 = Array(13, 18, 23)
        val v2 = Array(10, 13, 17, 23)
        val result = Array(0, 0, 0, 0)

        ngl.set_symmetric_difference(v1, 0, 3)(v2, 0, 4)(result, 0)

        expect(10)(result(0))
        expect(17)(result(1))
        expect(18)(result(2))
        expect(0)(result(3))
    }

    def testDifference0 {
        val v1 = Array(13, 18, 23)
        val v2 = Array(10, 13, 17, 23)
        val result = Array(0, 0, 0, 0)

        ngl.set_difference(v1, 0, 3)(v2, 0, 4)(result, 0)

        expect(18)(result(0))
        expect(0)(result(1))
        expect(0)(result(2))
        expect(0)(result(3))

        ngl.set_difference(v2, 0, 4)(v1, 0, 2)(result, 0)

        expect(10)(result(0))
        expect(17)(result(1))
        expect(23)(result(2))
        expect(0)(result(3))
    }
}