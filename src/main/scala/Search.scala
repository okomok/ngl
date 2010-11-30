

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


private object Search {
    def apply[A](v1: Seq[A], first1: Int, __last1: Int, v2: Seq[A], __first2: Int, __last2: Int, __pred: (A, A) => Boolean = EqualTo): Int = {
        var __first1 = first1

        // Test for empty ranges
        if (__first1 == __last1 || __first2 == __last2) {
            return __first1
        }

        // Test for a pattern of length 1.
        var __p1 = __first2

        __p1 += 1
        if (__p1 == __last2) {
            while (__first1 != __last1 && !__pred(v1(__first1), v2(__first2))) {
                __first1 += 1
            }
            return __first1
        }

        // General case.

        while (true) { // __first1 != __last1 will be checked below
            while (__first1 != __last1 && !__pred(v1(__first1), v2(__first2))) {
                __first1 += 1
            }
            if (__first1 == __last1) {
                return __last1
            }
            var __p = __p1
            var __current = __first1
            __current += 1
            if (__current == __last1) {
                return __last1
            }

            while (__pred(v1(__current), v2(__p))) {
                __p += 1
                if (__p == __last2) {
                    return __first1
                }
                __current += 1
                if (__current == __last1) {
                    return __last1
                }
            }
            __first1 += 1
        }
        __first1
    }
}


private object SearchN {
    def apply[A](* : Seq[A], first: Int, __last: Int, __count: Int, __val: A, __pred: (A, A) => Boolean = EqualTo): Int = {
        var __first = first

        if (__count <= 0) {
            return __first
        }

        while ((__first != __last) && !__pred(*(__first), __val)) {
            __first += 1
        }

        while (__first != __last) {
            var __n = __count - 1
            var __i = __first
            __i += 1
            while (__i != __last && __n != 0 && __pred(*(__i), __val)) {
                __i += 1
                __n -= 1
            }
            if (__n == 0) {
                return __first
            } else if (__i != __last) {
                __i += 1
                __first = __i
                while ((__first != __last) && !__pred(*(__first), __val)) {
                    __first += 1
                }
            }
            else {
                return __last
            }
        }
        return __last
    }
}

