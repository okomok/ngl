

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


class GenerateTest extends org.scalatest.junit.JUnit3Suite {

    class Fibonacci(var v1: Int = 0, var v2: Int = 1) extends Function0[Int] {
        override def apply() = {
            val r = v1 + v2
            v1 = v2
            v2 = r
            v1
        }
    }

    def testGenerate2 {
        val v1 = new Array[Int](10)
        val generator = new Fibonacci
        ngl.generate(v1, 0, 10)(generator)

        expect(1)(v1(0))
        expect(1)(v1(1))
        expect(2)(v1(2))
        expect(3)(v1(3))
        expect(5)(v1(4))
        expect(8)(v1(5))
        expect(13)(v1(6))
        expect(21)(v1(7))
        expect(34)(v1(8))
        expect(55)(v1(9))
    }

    def testGenerateN2 {
        val v1 = new Array[Int](10)
        val generator = new Fibonacci
        ngl.generate_n(v1, 0)(10)(generator)

        expect(1)(v1(0))
        expect(1)(v1(1))
        expect(2)(v1(2))
        expect(3)(v1(3))
        expect(5)(v1(4))
        expect(8)(v1(5))
        expect(13)(v1(6))
        expect(21)(v1(7))
        expect(34)(v1(8))
        expect(55)(v1(9))
    }

}