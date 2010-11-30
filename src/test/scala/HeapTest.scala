

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


class HeapTest extends org.scalatest.junit.JUnit3Suite {

    def testMakeHeap0 {
        val xs = ngl.Seq.from(Array(5, 10, 4, 13, 11, 19))

        ngl.make_heap(xs, xs.begin, xs.begin + 6)
        assert(ngl.is_heap(xs, xs.begin, xs.end))
        expect(19)(xs(xs.begin))

        ngl.pop_heap(xs, xs.begin, xs.begin + 6)
        expect(13)(xs(xs.begin))

        ngl.pop_heap(xs, xs.begin, xs.begin + 5)
        expect(11)(xs(xs.begin))

        ngl.pop_heap(xs, xs.begin, xs.begin + 4)
        expect(10)(xs(xs.begin))

        ngl.pop_heap(xs, xs.begin, xs.begin + 3)
        expect(5)(xs(xs.begin))

        ngl.pop_heap(xs, xs.begin, xs.begin + 2)
        expect(4)(xs(xs.begin))

        ngl.pop_heap(xs, xs.begin, xs.begin + 1)
    }

    def testMakeHeap1 {
        val xs = ngl.Seq.from(Array(5, 10, 4, 13, 11, 19))

        ngl.make_heap(xs, xs.begin, xs.begin + 6)(Ordering.fromLessThan[Int](_ > _))
        assert(ngl.is_heap(xs, xs.begin, xs.end)(Ordering.fromLessThan[Int](_ > _)))
        expect(4)(xs(xs.begin))

        ngl.pop_heap(xs, xs.begin, xs.begin + 6)(Ordering.fromLessThan[Int](_ > _))
        expect(5)(xs(xs.begin))

        ngl.pop_heap(xs, xs.begin, xs.begin + 5)(Ordering.fromLessThan[Int](_ > _))
        expect(10)(xs(xs.begin))

        ngl.pop_heap(xs, xs.begin, xs.begin + 4)(Ordering.fromLessThan[Int](_ > _))
        expect(11)(xs(xs.begin))

        ngl.pop_heap(xs, xs.begin, xs.begin + 3)(Ordering.fromLessThan[Int](_ > _))
        expect(13)(xs(xs.begin))

        ngl.pop_heap(xs, xs.begin, xs.begin + 2)(Ordering.fromLessThan[Int](_ > _))
        expect(19)(xs(xs.begin))
    }

    def testPopHeap0 {
        val a = new java.util.ArrayList[Int]
        a.add(1)
        a.add(20)
        a.add(4)
        var xs = ngl.Seq.from(a)

        ngl.make_heap(xs, xs.begin, xs.end)
        assert(ngl.is_heap(xs, xs.begin, xs.end))

        a.add(7)
        xs = ngl.Seq.from(a)

        ngl.push_heap(xs, xs.begin, xs.end)
        ngl.sort_heap(xs, xs.begin, xs.end)

        expect(1)(a.get(0))
        expect(4)(a.get(1))
        expect(7)(a.get(2))
        expect(20)(a.get(3))
    }

    def testPopHeap1 {
        val a = new java.util.ArrayList[Int]
        a.add(1)
        a.add(20)
        a.add(4)
        var xs = ngl.Seq.from(a)

        ngl.make_heap(xs, xs.begin, xs.end)(Ordering.fromLessThan[Int](_ > _))
        assert(ngl.is_heap(xs, xs.begin, xs.end)(Ordering.fromLessThan[Int](_ > _)))

        a.add(7)
        xs = ngl.Seq.from(a)

        ngl.push_heap(xs, xs.begin, xs.end)(Ordering.fromLessThan[Int](_ > _))
        ngl.sort_heap(xs, xs.begin, xs.end)(Ordering.fromLessThan[Int](_ > _))

        expect(20)(a.get(0))
        expect(7)(a.get(1))
        expect(4)(a.get(2))
        expect(1)(a.get(3))
    }
}