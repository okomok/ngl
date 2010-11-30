

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


class ElementTest extends org.scalatest.junit.JUnit3Suite {

    def testMinElement1 {
        val numbers = Array(-10, 15, -100, 36, -242, 42)
        val _numbers = ngl.Seq.from(numbers)

        val r = ngl.min_element(_numbers, _numbers.begin, _numbers.end)

        expect(-242)(_numbers(r))
    }

    def testMinElement2 {
        val names = Array("Brett", "Graham", "Jack", "Mike", "Todd")
        val _names = ngl.Seq.from(names)

        val r = ngl.min_element(_names, _names.begin, _names.end)

        expect("Brett")(_names(r))
    }

    def testMaxElement1 {
        val numbers = Array(4, 10, 56, 11, -42, 19)
        val _numbers = ngl.Seq.from(numbers)

        val r = ngl.max_element(_numbers, _numbers.begin, _numbers.end)

        expect(56)(_numbers(r))
    }

    def testMaxElement2 {
        val names = Array("Brett", "Graham", "Jack", "Mike", "Todd")
        val _names = ngl.Seq.from(names)

        val r = ngl.max_element(_names, _names.begin, _names.end)

        expect("Todd")(_names(r))
    }
}