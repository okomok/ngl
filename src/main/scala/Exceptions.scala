

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package gine


/**
 * Thrown if Seq is not readable.
 */
case class NotReadableException[A](_1: Seq[A]) extends UnsupportedOperationException("not readable")

/**
 * Thrown if Seq is not writable.
 */
case class NotWritableException[A](_1: Seq[A]) extends UnsupportedOperationException("not writable")
