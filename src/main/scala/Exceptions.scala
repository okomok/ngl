

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package gine


/**
 * Thrown if Seq is not readable.
 */
class NotReadableException[A](from: Seq[A]) extends UnsupportedOperationException("not readable")

/**
 * Thrown if Seq is not writable.
 */
class NotWritableException[A](from: Seq[A]) extends UnsupportedOperationException("not writable")
