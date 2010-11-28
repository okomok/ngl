

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


private object Median {
    def apply[A](__a: A, __b: A, __c: A, __comp: Ordering[A]): A = {
        if (__comp.lt(__a, __b)) {
            if (__comp.lt(__b, __c)) {
                __b
            } else if (__comp.lt(__a, __c)) {
                __c
            } else {
                __a
            }
        } else if (__comp.lt(__a, __c)) {
            __a
        } else if (__comp.lt(__b, __c)) {
            __c
        } else {
            __b
        }
    }
}
