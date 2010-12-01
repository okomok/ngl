

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


private object InplaceMerge {
    def apply[A](* : Seq[A], __first: Int, __middle: Int, __last: Int, __comp: Ordering[A]) {
        if (__first == __middle || __middle == __last) {
            return
        }
        aux(*, __first, __middle, __last, __comp)
    }

    def aux[A](* : Seq[A], __first: Int, __middle: Int, __last: Int, __comp: Ordering[A]) {
        val __len1 = __middle - __first
        val __len2 = __last - __middle
        without_buffer(*, __first, __middle, __last, __len1, __len2, __comp)
    }

    def without_buffer[A](* : Seq[A], __first: Int, __middle: Int, __last: Int, __len1: Int, __len2: Int, __comp: Ordering[A]) {
        if (__len1 == 0 || __len2 == 0) {
            return
        }
        if (__len1 + __len2 == 2) {
            if (__comp.lt(*(__middle), *(__first))) {
                IterSwap(*, __first, *, __middle)
            }
            return
        }
        var __first_cut = __first
        var __second_cut = __middle
        var __len11 = 0
        var __len22 = 0
        if (__len1 > __len2) {
            __len11 = __len1 / 2
            __first_cut += __len11
            __second_cut = LowerBound(*, __middle, __last, *(__first_cut), __comp)
            __len22 += __second_cut - __middle
        }
        else {
            __len22 = __len2 / 2
            __second_cut += __len22
            __first_cut = UpperBound(*, __first, __middle, *(__second_cut), __comp)
            __len11 += __first_cut - __first
        }
        val __new_middle = Rotate(*, __first_cut, __middle, __second_cut)
        without_buffer(*, __first, __first_cut, __new_middle, __len11, __len22, __comp)
        without_buffer(*, __new_middle, __second_cut, __last, __len1 - __len11, __len2 - __len22, __comp)
    }
}
