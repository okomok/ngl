

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


class PermutationTest extends org.scalatest.junit.JUnit3Suite {

    def testPrevPermutation0 {
        val v1 = Array(0, 1, 2)
        ngl.prev_permutation(v1, 0, 3)
        expect(2)(v1(0))
        expect(1)(v1(1))
        expect(0)(v1(2))
    }

    def testPrevPermutation1 {
        val v1 = Array(0, 1, 2)

        ngl.prev_permutation(v1, 0, 3)
        expect(2)(v1(0))
        expect(1)(v1(1))
        expect(0)(v1(2))

        ngl.prev_permutation(v1, 0, 3)
        expect(2)(v1(0))
        expect(0)(v1(1))
        expect(1)(v1(2))

        ngl.prev_permutation(v1, 0, 3)
        expect(1)(v1(0))
        expect(2)(v1(1))
        expect(0)(v1(2))

        ngl.prev_permutation(v1, 0, 3)
        expect(1)(v1(0))
        expect(0)(v1(1))
        expect(2)(v1(2))

        ngl.prev_permutation(v1, 0, 3)
        expect(0)(v1(0))
        expect(2)(v1(1))
        expect(1)(v1(2))

        ngl.prev_permutation(v1, 0, 3)
        expect(0)(v1(0))
        expect(1)(v1(1))
        expect(2)(v1(2))

        ngl.prev_permutation(v1, 0, 3)
        expect(2)(v1(0))
        expect(1)(v1(1))
        expect(0)(v1(2))

        ngl.prev_permutation(v1, 0, 3)
        expect(2)(v1(0))
        expect(0)(v1(1))
        expect(1)(v1(2))

        ngl.prev_permutation(v1, 0, 3)
        expect(1)(v1(0))
        expect(2)(v1(1))
        expect(0)(v1(2))
    }

    def testPrevPermutation2 {
        val v1 = Array(0, 1, 2)

        ngl.prev_permutation(v1, 0, 3)(Ordering.fromLessThan[Int](_ > _))
        expect(0)(v1(0))
        expect(2)(v1(1))
        expect(1)(v1(2))

        ngl.prev_permutation(v1, 0, 3)(Ordering.fromLessThan[Int](_ > _))
        expect(1)(v1(0))
        expect(0)(v1(1))
        expect(2)(v1(2))

        ngl.prev_permutation(v1, 0, 3)(Ordering.fromLessThan[Int](_ > _))
        expect(1)(v1(0))
        expect(2)(v1(1))
        expect(0)(v1(2))

        ngl.prev_permutation(v1, 0, 3)(Ordering.fromLessThan[Int](_ > _))
        expect(2)(v1(0))
        expect(0)(v1(1))
        expect(1)(v1(2))

        ngl.prev_permutation(v1, 0, 3)(Ordering.fromLessThan[Int](_ > _))
        expect(2)(v1(0))
        expect(1)(v1(1))
        expect(0)(v1(2))

        ngl.prev_permutation(v1, 0, 3)(Ordering.fromLessThan[Int](_ > _))
        expect(0)(v1(0))
        expect(1)(v1(1))
        expect(2)(v1(2))

        ngl.prev_permutation(v1, 0, 3)(Ordering.fromLessThan[Int](_ > _))
        expect(0)(v1(0))
        expect(2)(v1(1))
        expect(1)(v1(2))

        ngl.prev_permutation(v1, 0, 3)(Ordering.fromLessThan[Int](_ > _))
        expect(1)(v1(0))
        expect(0)(v1(1))
        expect(2)(v1(2))

        ngl.prev_permutation(v1, 0, 3)(Ordering.fromLessThan[Int](_ > _))
        expect(1)(v1(0))
        expect(2)(v1(1))
        expect(0)(v1(2))
    }


    def testNextPermutation0 {
        val v1 = Array(0, 1, 2)
        ngl.next_permutation(v1, 0, 3)
        expect(0)(v1(0))
        expect(2)(v1(1))
        expect(1)(v1(2))
    }

    def testNextPermutation1 {
        val v1 = Array(0, 1, 2)

        ngl.next_permutation(v1, 0, 3)
        expect(0)(v1(0))
        expect(2)(v1(1))
        expect(1)(v1(2))

        ngl.next_permutation(v1, 0, 3)
        expect(1)(v1(0))
        expect(0)(v1(1))
        expect(2)(v1(2))

        ngl.next_permutation(v1, 0, 3)
        expect(1)(v1(0))
        expect(2)(v1(1))
        expect(0)(v1(2))

        ngl.next_permutation(v1, 0, 3)
        expect(2)(v1(0))
        expect(0)(v1(1))
        expect(1)(v1(2))

        ngl.next_permutation(v1, 0, 3)
        expect(2)(v1(0))
        expect(1)(v1(1))
        expect(0)(v1(2))

        ngl.next_permutation(v1, 0, 3)
        expect(0)(v1(0))
        expect(1)(v1(1))
        expect(2)(v1(2))

        ngl.next_permutation(v1, 0, 3)
        expect(0)(v1(0))
        expect(2)(v1(1))
        expect(1)(v1(2))

        ngl.next_permutation(v1, 0, 3)
        expect(1)(v1(0))
        expect(0)(v1(1))
        expect(2)(v1(2))

        ngl.next_permutation(v1, 0, 3)
        expect(1)(v1(0))
        expect(2)(v1(1))
        expect(0)(v1(2))
    }

}