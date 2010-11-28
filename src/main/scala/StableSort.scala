

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


private object StableSort {
    def apply[A](* : Seq[A], __first: Int, __last: Int, __comp: Ordering[A]) {
        val __len = (__last - __first + 1) / 2
        val __middle = __first + __len

        val buf = Allocate[A](__len)
        MergeSortWithBuffer(*, __first, __middle, buf, buf.begin, __comp)
        MergeSortWithBuffer(*, __middle, __last, buf, buf.begin, __comp)

        val buf_end = Copy(*, __first, __middle, buf, buf.begin)
        Merge(buf, buf.begin, buf_end, *, __middle, __last, *, __first, __comp)
    }
}
