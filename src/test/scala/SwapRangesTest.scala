

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


class SwapRangesTest extends org.scalatest.junit.JUnit3Suite {

    def testSwapRanges1 {
        val word1 = Array('W', 'o', 'r', 'l', 'd')
        val word2 = Array('H', 'e', 'l', 'l', 'o')

        ngl.swap_ranges(word1, 0, 5)(word2, 0)

        expect('H')(word1(0))
        expect('e')(word1(1))
        expect('l')(word1(2))
        expect('l')(word1(3))
        expect('o')(word1(4))

        expect('W')(word2(0))
        expect('o')(word2(1))
        expect('r')(word2(2))
        expect('l')(word2(3))
        expect('d')(word2(4))
    }
}