

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


private object PartialSort {
    def apply[A](* : Seq[A], __first: Int, __middle: Int, __last: Int, __comp: Ordering[A]) {
        MakeHeap(*, __first, __middle, __comp)
        var __i = __middle
        while (__i < __last) {
            if (__comp.lt(*(__i), *(__first))) {
                PopHeap.__apply(*, __first, __middle, __i, *(__i), __comp)
            }
            __i += 1
        }
        SortHeap(*, __first, __middle, __comp)
    }
}
