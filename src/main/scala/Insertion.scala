

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


object InsertionSort {
    def apply[A](* : Seq[A], __first: Int, __last: Int, __comp: Ordering[A]) {
        if (__first == __last) {
            return
        }
        var __i = __first + 1
        while (__i != __last) {
            LinearInsert(*, __first, __i, *(__i), __comp)
            __i += 1
        }
    }
}

object LinearInsert {
    def apply[A](* : Seq[A], __first: Int, __last: Int, __val: A, __comp: Ordering[A]) {
        if (__comp.lt(__val, *(__first))) {
            CopyBackward(*, __first, __last, *, __last + 1)
            *(__first) = __val
        } else {
            UnguardedLinearInsert(*, __last, __val, __comp)
        }
    }
}


object UnguardedInsertionSort {
    def apply[A](* : Seq[A], __first: Int, __last: Int, __comp: Ordering[A]) {
        var __i = __first
        while (__i != __last) {
            UnguardedLinearInsert(*, __i, *(__i), __comp)
            __i += 1
        }
    }
}

object UnguardedLinearInsert {
    def apply[A](* : Seq[A], last: Int, __val: A, __comp: Ordering[A]) {
        var __last = last
        var __next = __last

        __next -= 1
        while (__comp.lt(__val, *(__next))) {
            *(__last) = *(__next)
            __last = __next
            __next -= 1
        }
        *(__last) = __val
    }
}


object ChunkInsertionSort {
    def apply[A](* : Seq[A], first: Int, __last: Int, __chunk_size: Int, __comp: Ordering[A]) {
        var __first = first

        while (__last - __first >= __chunk_size) {
            InsertionSort(*, __first, __first + __chunk_size, __comp)
            __first += __chunk_size
        }
        InsertionSort(*, __first, __last, __comp)
    }
}
