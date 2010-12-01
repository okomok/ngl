

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
package ngl


private object EqualRange {
    def apply[A](* : Seq[A], first: Int, __last: Int, __val: A, __comp: Ordering[A]): (Int, Int) = {
        var __first = first

        var __len = __last - __first
        var __half = 0

        while (__len > 0) {
            __half = __len >> 1
            var __middle = __first
            __middle += __half
            val way = __comp.compare(*(__middle), __val)
            if (way < 0) {
                __first = __middle
                __first += 1
                __len = __len - __half - 1
            } else if (way > 0) {
                __len = __half
            } else {
                val __left = LowerBound(*, __first, __middle, __val, __comp)
                //Small optim: If lower_bound haven't found an equivalent value
                //there is no need to call upper_bound.
                if (__comp.lt(*(__left), __val)) {
                    return (__left, __left)
                }
                __first += __len
                __middle += 1
                val __right = UpperBound(*, __middle, __first, __val, __comp)
                return (__left, __right)
            }
        }
        (__first, __first)
    }
}
