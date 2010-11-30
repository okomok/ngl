

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


class FindTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val xs: ngl.Seq[Int] = ngl.Seq.from(Array(1,2,3,4,5))
        val i = ngl.find(xs, xs.begin, xs.end)(3)
        expect(xs.begin + 2)(i)
    }

    def testNotFound {
        val xs: ngl.Seq[Int] = ngl.Seq.from(Array(1,2,3,4))
        val i = ngl.find(xs, xs.begin, xs.end)(9)
        expect(xs.begin + 4)(i)
    }

    def testEmptyNotFound {
        val xs: ngl.Seq[Int] = ngl.Seq.from(Array[Int]())
        val i = ngl.find(xs, xs.begin, xs.end)(9)
        expect(xs.begin)(i)
    }

}


class FindIfTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val xs: ngl.Seq[Int] = ngl.Seq.from(Array(1,2,3,4,5))
        val i = ngl.find_if(xs, xs.begin, xs.end)(_ == 3)
        expect(xs.begin + 2)(i)
    }

    def testNotFound {
        val xs: ngl.Seq[Int] = ngl.Seq.from(Array(1,2,3,4))
        val i = ngl.find_if(xs, xs.begin, xs.end)(_ == 9)
        expect(xs.begin + 4)(i)
    }

    def testEmptyNotFound {
        val xs: ngl.Seq[Int] = ngl.Seq.from(Array[Int]())
        val i = ngl.find_if(xs, xs.begin, xs.end)(_ == 9)
        expect(xs.begin)(i)
    }

}