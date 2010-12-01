

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


private object Rotate {
    def apply[A](* : Seq[A], first: Int, __middle: Int, __last: Int): Int = {
        var __first = first

        val __n = __last   - __first
        val __k = __middle - __first
        val __l = __n - __k
        val __result = __first + (__last - __middle)

        if (__k == 0) { /* __first == middle */
            return __last
        }

        if (__k == __l) {
            SwapRanges(*, __first, __middle, *, __middle)
            return __result
        }

        val __d = __gcd(__n, __k)

        var __i = 0
        while (__i < __d) {
            val __tmp = *(__first)
            var __p = __first

            if (__k < __l) {
                var __j = 0
                while ( __j < __l/__d) {
                    if (__p > __first + __l) {
                        *(__p) = *(__p - __l)
                        __p -= __l
                    }

                    *(__p) = *(__p + __k)
                    __p += __k
                    __j += 1
                }
            } else {
                var __j = 0
                while (__j < __k/__d - 1) {
                    if (__p < __last - __k) {
                        *(__p) = *(__p + __k)
                        __p += __k
                    }

                    *(__p) = *(__p - __l)
                    __p -= __l
                    __j += 1
                }
            }

            *(__p) = __tmp
            __first += 1
            __i += 1
        }

        __result
    }

    def __gcd(m: Int, n: Int): Int = {
        var __m = m
        var __n = n
        while (__n != 0) {
            val __t = __m % __n
            __m = __n
            __n = __t
        }
        __m
    }
}
