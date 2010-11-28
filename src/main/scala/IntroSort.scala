

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
package gine


private object IntroSort {
    def apply[A](* : Seq[A], __first: Int, __last: Int, __comp: Ordering[A]) {
        if (__first != __last) {
            loop(*, __first, __last, depthLimit(__first, __last), __comp)
            finalInsertionSort(*, __first, __last, __comp)
        }
    }

    def loop[A](* : Seq[A], __first: Int, last: Int, depth_limit: Int, __comp: Ordering[A]) {
        var __last = last
        var __depth_limit = depth_limit

        while (__last - __first > THRESHOLD) {
            if (__depth_limit == 0) {
                PartialSort(*, __first, __last, __last, __comp)
                return
            }
            __depth_limit -= 1
            val __cut = UnguardedPartition(*, __first, __last, Median(*(__first), *(__first + (__last - __first)/2), *(__last - 1), __comp), __comp)
            loop(*, __cut, __last, __depth_limit, __comp)
            __last = __cut
        }
    }

    def finalInsertionSort[A](* : Seq[A], __first: Int, __last: Int, __comp: Ordering[A]) {
        if (__last - __first > THRESHOLD) {
            InsertionSort(*, __first, __first + THRESHOLD, __comp)
            UnguardedInsertionSort(*, __first + THRESHOLD, __last, __comp)
        } else {
            InsertionSort(*, __first, __last, __comp)
        }
    }

    def depthLimit(first: Int, last: Int): Int = lg(last - first) * 2

    val THRESHOLD = 16

    def lg(n: Int): Int = {
        var __n = n
        var __k = 0
        while (__n != 1) {
            __k += 1
            __n >>= 1
        }
        __k
    }
}
