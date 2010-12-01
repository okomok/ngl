

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


class PartitionTest extends org.scalatest.junit.JUnit3Suite {

    def testPartition0 {
        val numbers = Array(6, 12, 3, 10, 1, 20)

        var c = 0
        ngl.partition(numbers, 0, 6) { x =>
            c += 1
            x < 10
        }

        expect(6)(numbers(0))
        expect(1)(numbers(1))
        expect(3)(numbers(2))
        expect(10)(numbers(3))
        expect(12)(numbers(4))
        expect(20)(numbers(5))
        expect(6)(c)
    }

    def testPartition1 {
        val numbers = Array(19, 3, 11, 14, 10, 19, 8, 17, 9, 6)

        var c = 0
        ngl.partition(numbers, 0, 10) { x =>
            c += 1
            x < 11
        }

        expect(6)(numbers(0))
        expect(3)(numbers(1))
        expect(9)(numbers(2))
        expect(8)(numbers(3))
        expect(10)(numbers(4))
        expect(19)(numbers(5))
        expect(14)(numbers(6))
        expect(17)(numbers(7))
        expect(11)(numbers(8))
        expect(19)(numbers(9))
        expect(10)(c)
    }


    def testStablePartition0 {
        val numbers = Array(10, 5, 11, 20, 6, -2)

        var c = 0
        ngl.stable_partition(numbers, 0, 6) { x =>
            c += 1
            x < 10
        }

        expect(5)(numbers(0))
        expect(6)(numbers(1))
        expect(-2)(numbers(2))
        expect(10)(numbers(3))
        expect(11)(numbers(4))
        expect(20)(numbers(5))
        expect(6)(c)
    }

    def testStablePartition1 {
        val numbers = Array(5, 5, 2, 10, 0, 12, 5, 0, 0, 19)

        var c = 0
        ngl.stable_partition(numbers, 0, 10) { x =>
            c += 1
            x < 11
        }

        expect(5)(numbers(0))
        expect(5)(numbers(1))
        expect(2)(numbers(2))
        expect(10)(numbers(3))
        expect(0)(numbers(4))
        expect(5)(numbers(5))
        expect(0)(numbers(6))
        expect(0)(numbers(7))
        expect(12)(numbers(8))
        expect(19)(numbers(9))
        expect(10)(c)
    }
}