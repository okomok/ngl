

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


class PartialSumTest extends org.scalatest.junit.JUnit3Suite {

    def testPartialSum0 {
        val numbers = Array(1, 2, 3, 4, 5, 6)
        val result = new Array[Int](6)

        ngl.partial_sum(numbers, 0, 6)(result, 0) { _ + _ }

        expect(1)(result(0))
        expect(3)(result(1))
        expect(6)(result(2))
        expect(10)(result(3))
        expect(15)(result(4))
        expect(21)(result(5))
    }

}