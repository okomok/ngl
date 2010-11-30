

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


class RandomShuffleTest extends org.scalatest.junit.JUnit3Suite {

    def test0 {
        val numbers = Array(1,2,3,4,5,6)
        ngl.random_shuffle(numbers, 0, 6)
        for (i <- 1 until 7) {
            expect(1)(ngl.count(numbers, 0, 6)(i))
        }
    }


    class MyRandomGenerator extends (Int => Int) {
        private[this] val rnd = new java.util.Random
        override def apply(__n: Int) = rnd.nextInt(__n)
    }

    def test1 {
        val numbers = Array(1,2,3,4,5,6)
        ngl.random_shuffle_by(numbers, 0, 6)(new MyRandomGenerator)
        for (i <- 1 until 7) {
            expect(1)(ngl.count(numbers, 0, 6)(i))
        }
    }
}